package com.todo.list.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.todo.list.model.Task;
import com.todo.list.service.TaskLocalService;

import com.todo.list.model.SubTask;
import com.todo.list.service.SubTaskLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.todo",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false", // Mantém uma única instância do app na página
                "javax.portlet.display-name=Gerenciador de Tarefas",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=com_todo_list_web_TodoListPortlet",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class TodoListPortlet extends MVCPortlet {

    // ==========================================
    // AÇÕES DA TASK (PRINCIPAL)
    // ==========================================

    // AÇÃO: Adicionar uma nova tarefa

    public void addTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // ParamUtil protege contra SQL Injection e pega os dados do JSP
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");

        // Envia os dados limpos para a camada de serviço
        _taskLocalService.addCustomTask(
                themeDisplay.getScopeGroupId(),
                themeDisplay.getCompanyId(),
                themeDisplay.getUserId(),
                themeDisplay.getUser().getFullName(),
                title,
                description
        );
    }

    // AÇÃO: Excluir uma tarefa

    public void deleteTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        _taskLocalService.deleteTask(taskId);
    }

    // AÇÃO: Editar uma tarefa existente
    public void updateTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        // Pega os parâmetros do formulário de edição
        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");

        _taskLocalService.updateCustomTask(taskId, title, description);
    }

    // AÇÃO: Alternar entre Concluída e Pendente

    public void toggleTaskStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        _taskLocalService.toggleTaskStatus(taskId);
    }

    // ==========================================
    // AÇÕES DE SUBTASK (CHECKLIST)
    // ==========================================

    // AÇÃO: Adicionar uma nova SubTask
    public void addSubTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        String title = ParamUtil.getString(actionRequest, "title");

        // Vamos passar a posição como 0 por padrão para simplificar os testes iniciais
        _subTaskLocalService.addSubTask(taskId, title, 0);
    }

    // AÇÃO: Excluir uma SubTask (Soft Delete)
    public void deleteSubTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long subTaskId = ParamUtil.getLong(actionRequest, "subTaskId");
        _subTaskLocalService.deleteSubTask(subTaskId);
    }

    // AÇÃO: Alternar entre Concluída e Pendente (SubTask)
    public void toggleSubTaskStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long subTaskId = ParamUtil.getLong(actionRequest, "subTaskId");
        _subTaskLocalService.toggleSubTaskStatus(subTaskId);
    }

    // AÇÃO: Editar o título de uma SubTask
    public void updateSubTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long subTaskId = ParamUtil.getLong(actionRequest, "subTaskId");
        String title = ParamUtil.getString(actionRequest, "title");

        _subTaskLocalService.updateSubTask(subTaskId, title);
    }

    // ==========================================
    // AÇÕES TASKATTACHMENT (ANEXAMENTO)
    // ==========================================

    // 1. ADICIONAR IMAGEM
    public void addTaskAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // Transforma o request para conseguir ler arquivos
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        long taskId = ParamUtil.getLong(uploadRequest, "taskId");

        // Extrai o arquivo que virá do JSP (com o name "attachmentFile")
        File file = uploadRequest.getFile("attachmentFile");
        String fileName = uploadRequest.getFileName("attachmentFile");
        String mimeType = uploadRequest.getContentType("attachmentFile");

        if (file != null && file.exists() && file.length() > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

            // Salva na biblioteca nativa do Liferay (pasta raiz do site = 0)
            FileEntry fileEntry = _dlAppLocalService.addFileEntry(
                    themeDisplay.getUserId(),
                    themeDisplay.getScopeGroupId(),
                    0,
                    fileName,
                    mimeType,
                    fileName,
                    "Anexo da Tarefa " + taskId,
                    "",
                    file,
                    serviceContext
            );

            // Salva o ID na nossa tabela
            _taskAttachmentLocalService.addTaskAttachment(taskId, fileEntry.getFileEntryId());
        }
    }

    // 2. ATUALIZAR IMAGEM (Trocar por outra)
    public void updateTaskAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        long taskAttachmentId = ParamUtil.getLong(uploadRequest, "taskAttachmentId");

        File file = uploadRequest.getFile("attachmentFile");
        String fileName = uploadRequest.getFileName("attachmentFile");
        String mimeType = uploadRequest.getContentType("attachmentFile");

        if (file != null && file.exists() && file.length() > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

            FileEntry fileEntry = _dlAppLocalService.addFileEntry(
                    themeDisplay.getUserId(),
                    themeDisplay.getScopeGroupId(),
                    0,
                    fileName,
                    mimeType,
                    fileName,
                    "Anexo Atualizado",
                    "",
                    file,
                    serviceContext
            );

            _taskAttachmentLocalService.updateTaskAttachment(taskAttachmentId, fileEntry.getFileEntryId());
        }
    }

    // 3. DELETAR IMAGEM (Soft Delete)
    public void deleteTaskAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        // Para exclusão, não recebemos arquivo, então o ParamUtil normal funciona
        long taskAttachmentId = ParamUtil.getLong(actionRequest, "taskAttachmentId");

        _taskAttachmentLocalService.deleteTaskAttachment(taskAttachmentId);
    }

    // ==========================================
    // INJECTS
    // ==========================================

    @Reference
    private TaskLocalService _taskLocalService;

    @Reference
    private SubTaskLocalService _subTaskLocalService;

    @Reference
    private com.liferay.document.library.kernel.service.DLAppLocalService _dlAppLocalService;

    @Reference
    private com.todo.list.service.TaskAttachmentLocalService _taskAttachmentLocalService;
}