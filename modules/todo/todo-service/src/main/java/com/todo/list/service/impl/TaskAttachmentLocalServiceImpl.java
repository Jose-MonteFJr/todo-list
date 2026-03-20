package com.todo.list.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.todo.list.model.TaskAttachment;
import com.todo.list.service.base.TaskAttachmentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

public class TaskAttachmentLocalServiceImpl extends TaskAttachmentLocalServiceBaseImpl {

    // 1. ADICIONAR: Cria a ligação entre a Tarefa e a Imagem do Liferay
    public TaskAttachment addTaskAttachment(long taskId, long fileEntryId) {
        long taskAttachmentId = counterLocalService.increment(TaskAttachment.class.getName());
        TaskAttachment attachment = super.createTaskAttachment(taskAttachmentId);

        attachment.setTaskId(taskId);
        attachment.setFileEntryId(fileEntryId); // O ID gerado pela biblioteca nativa

        attachment.setCreateDate(new Date());
        attachment.setModifiedDate(new Date());
        attachment.setDeleted(false);

        return super.addTaskAttachment(attachment);
    }

    // 2. LISTAR: Busca todas as imagens vinculadas a uma tarefa (ignorando as deletadas)
    public List<TaskAttachment> getActiveAttachments(long taskId) {
        // Usa o finder T_D (TaskId + Deleted) que criamos no XML
        return taskAttachmentPersistence.findByT_D(taskId, false);
    }

    // 3. ATUALIZAR: Troca o arquivo da imagem por um novo
    public TaskAttachment updateTaskAttachment(long taskAttachmentId, long newFileEntryId) throws PortalException {
        TaskAttachment attachment = super.getTaskAttachment(taskAttachmentId);

        attachment.setFileEntryId(newFileEntryId);
        attachment.setModifiedDate(new Date());

        return super.updateTaskAttachment(attachment);
    }

    // 4. DELETAR: Soft Delete (apenas oculta do sistema)
    public TaskAttachment deleteTaskAttachment(long taskAttachmentId) throws PortalException {
        TaskAttachment attachment = super.getTaskAttachment(taskAttachmentId);

        attachment.setDeleted(true); // Oculta a imagem da lista
        attachment.setModifiedDate(new Date());

        return super.updateTaskAttachment(attachment);
    }
}