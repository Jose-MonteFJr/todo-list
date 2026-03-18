/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.todo.list.model.Task;
import com.todo.list.service.base.TaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.todo.list.exception.TaskTitleException;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
    // Adiciona uma nova tarefa garantindo a injeção correta de IDs e datas.

    public Task addCustomTask(long groupId, long companyId, long userId, String userName, String title, String description) throws PortalException {
        validate(title);

        long taskId = counterLocalService.increment(Task.class.getName());
        Task task = super.createTask(taskId);

        task.setGroupId(groupId);
        task.setCompanyId(companyId);
        task.setUserId(userId);
        task.setUserName(userName);
        task.setCreateDate(new Date());
        task.setModifiedDate(new Date());

        task.setTitle(title);
        task.setDescription(description);

        task.setCompleted(false);
        task.setDeleted(false);

        return super.addTask(task); // Atualiza no banco
    }

    // Alterna o status da tarefa entre Concluída (true) e Pendente (false)

    public Task toggleTaskStatus(long taskId) throws PortalException {
        Task task = super.getTask(taskId);
        task.setCompleted(!task.getCompleted());
        task.setModifiedDate(new Date());

        return super.updateTask(task);
    }

    // Edita as tarefas criadas
    public Task updateCustomTask(long taskId, String title, String description) throws PortalException {
        validate(title);

        Task task = super.getTask(taskId);

        task.setTitle(title);
        task.setDescription(description);
        task.setModifiedDate(new Date());

        return super.updateTask(task);
    }

    // Busca as tarefas de um usuário filtrando pelo status de conclusão e deleted para soft delete

    public List<Task> getTasksByStatus(long groupId, long userId, boolean completed) {
        return taskPersistence.findByG_U_C_D(groupId, userId, completed, false);
    }

    // Soft delete

    @Override
    public Task deleteTask(long taskId) throws PortalException {
        Task task = super.getTask(taskId);
        return deleteTask(task); // Redireciona para o método abaixo
    }

    // Intercepta a exclusão pelo Objeto
    @Override
    public Task deleteTask(Task task) {
        // Em vez de excluir do banco, apenas marcamos como deletado
        task.setDeleted(true);
        task.setModifiedDate(new Date());

        return super.updateTask(task);
    }

    // Validação
    protected void validate(String title) throws PortalException {
        if (Validator.isNull(title) || Validator.isBlank(title)) {
            throw new TaskTitleException();
        }
    }
}