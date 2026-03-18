/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.todo.list.model.SubTask;
import com.todo.list.service.base.SubTaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.todo.list.exception.SubTaskTitleException;

/**
 * @author Brian Wing Shun Chan
 */

public class SubTaskLocalServiceImpl extends SubTaskLocalServiceBaseImpl {

    // CRIAR: Adiciona uma nova sub-tarefa vinculada a uma Tarefa Pai
    public SubTask addSubTask(long taskId, String title, int position) throws PortalException {
        validate(title);

        long subTaskId = counterLocalService.increment(SubTask.class.getName());
        SubTask subTask = super.createSubTask(subTaskId);

        subTask.setTaskId(taskId); // O vínculo com a tarefa principal
        subTask.setTitle(title);
        subTask.setPosition(position); // Para ordenação na tela

        subTask.setCreateDate(new Date());
        subTask.setModifiedDate(new Date());

        subTask.setCompleted(false);
        subTask.setDeleted(false);

        return super.addSubTask(subTask);
    }

    // ALTERAR STATUS: Concluir ou Reabrir a sub-tarefa
    public SubTask toggleSubTaskStatus(long subTaskId) throws PortalException {
        SubTask subTask = super.getSubTask(subTaskId);
        subTask.setCompleted(!subTask.getCompleted());
        subTask.setModifiedDate(new Date());

        return super.updateSubTask(subTask);
    }

    // EDITAR: Atualiza o título da sub-tarefa
    public SubTask updateSubTask(long subTaskId, String title) throws PortalException {
        validate(title);

        SubTask subTask = super.getSubTask(subTaskId);

        subTask.setTitle(title);
        subTask.setModifiedDate(new Date());

        return super.updateSubTask(subTask);
    }

    // LISTAR: Busca as sub-tarefas de uma Tarefa Pai (ignorando as deletadas)
    public List<SubTask> getActiveSubTasks(long taskId) {
        // Usa o finder T_D (TaskId + Deleted)
        return subTaskPersistence.findByT_D(taskId, false);
    }

    // Soft delete
    @Override
    public SubTask deleteSubTask(long subTaskId) throws PortalException {
        SubTask subTask = super.getSubTask(subTaskId);
        return deleteSubTask(subTask);
    }

    // Intercepta a exclusão pelo Objeto
    @Override
    public SubTask deleteSubTask(SubTask subTask) {
        subTask.setDeleted(true);
        subTask.setModifiedDate(new Date());

        return super.updateSubTask(subTask);
    }

    protected void validate(String title) throws PortalException {
        if (Validator.isNull(title) || Validator.isBlank(title)) {
            throw new SubTaskTitleException();
        }
    }
}