/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.todo.list.model.Task;
import com.todo.list.service.base.TaskLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

    /**
     * Adiciona uma nova tarefa garantindo a injeção correta de IDs e datas.
     */
    public Task addCustomTask(long groupId, long companyId, long userId, String userName, String title, String description) {

        // O Liferay gera um ID único e seguro para a nova tarefa
        long taskId = counterLocalService.increment(Task.class.getName());

        // Cria a instância da tarefa
        Task task = super.createTask(taskId);

        // Preenche os dados de auditoria e relacionamento
        task.setGroupId(groupId);
        task.setCompanyId(companyId);
        task.setUserId(userId);
        task.setUserName(userName);
        task.setCreateDate(new Date());
        task.setModifiedDate(new Date());

        // Preenche os dados da tarefa enviados pela tela
        task.setTitle(title);
        task.setDescription(description);

        // Define os status iniciais (Toda tarefa nova nasce pendente e não deletada)
        task.setCompleted(false);
        task.setDeleted(false);

        // Salva no banco de dados
        return super.addTask(task);
    }

    /**
     * Alterna o status da tarefa entre Concluída (true) e Pendente (false)
     */
    public Task toggleTaskStatus(long taskId) throws PortalException {
        // Busca a tarefa existente no banco
        Task task = super.getTask(taskId);

        // Inverte o valor booleano atual
        task.setCompleted(!task.getCompleted());
        task.setModifiedDate(new Date());

        // Atualiza no banco
        return super.updateTask(task);
    }

    /**
     * Busca as tarefas de um usuário filtrando pelo status de conclusão
     */
    public java.util.List<Task> getTasksByStatus(long groupId, long userId, boolean completed) {
        // O taskPersistence é gerado automaticamente pelo Liferay e acessa os finders do banco
        return taskPersistence.findByG_U_C(groupId, userId, completed);
    }
}