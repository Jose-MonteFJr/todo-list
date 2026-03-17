package com.todo.list.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.todo.list.model.Task;
import com.todo.list.service.TaskLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

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

	// Injeta a comunicação com o banco de dados que geramos no Service Builder
	@Reference
	private TaskLocalService _taskLocalService;

	/**
	 * AÇÃO: Adicionar uma nova tarefa
	 */
	public void addTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		// O ThemeDisplay é a ferramenta de segurança do Liferay. Ele garante
		// que estamos pegando o ID real do usuário logado, evitando fraudes no form.
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// ParamUtil protege contra SQL Injection e pega os dados do JSP
		String title = ParamUtil.getString(actionRequest, "title");
		String description = ParamUtil.getString(actionRequest, "description");

		// Envia os dados limpos para a nossa camada de serviço (que vamos criar a seguir)
		_taskLocalService.addCustomTask(
				themeDisplay.getScopeGroupId(),
				themeDisplay.getCompanyId(),
				themeDisplay.getUserId(),
				themeDisplay.getUser().getFullName(),
				title,
				description
		);
	}

	/**
	 * AÇÃO: Excluir uma tarefa
	 */
	public void deleteTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		_taskLocalService.deleteTask(taskId);
	}

	/**
	 * AÇÃO: Alternar entre Concluída e Pendente
	 */
	public void toggleTaskStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		_taskLocalService.toggleTaskStatus(taskId);
	}
}