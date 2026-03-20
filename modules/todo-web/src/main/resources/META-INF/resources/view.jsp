<%@ include file="init.jsp" %>
<%@ page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil" %>

<%
    List<Task> pendingTasks = TaskLocalServiceUtil.getTasksByStatus(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), false);
    List<Task> completedTasks = TaskLocalServiceUtil.getTasksByStatus(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), true);
%>

<div class="container-fluid container-fluid-max-xl mt-4">
    <h2>Gerenciador de Tarefas</h2>

    <portlet:actionURL name="addTask" var="addTaskURL"/>

    <div class="card p-3 mb-4">
        <aui:form action="<%= addTaskURL %>" method="post">
            <input type="hidden" name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
            <aui:input name="title" label="Título da tarefa" required="true" cssClass="form-control"/>
            <aui:input name="description" label="Descrição" type="textarea" cssClass="form-control"/>
            <aui:button type="submit" value="Adicionar Tarefa" cssClass="btn btn-primary mt-2"/>
        </aui:form>
    </div>

    <liferay-ui:tabs names="Pendentes,Concluídas" refresh="false">

        <liferay-ui:section>
            <p class="mt-3"><strong>Total de tarefas pendentes: <%= pendingTasks.size() %>
            </strong></p>

            <ul class="list-group">
                <% for (Task task : pendingTasks) {
                    // 1. BUSCA AS SUBTASKS DA TAREFA ATUAL
                    List<SubTask> subTasks = SubTaskLocalServiceUtil.getActiveSubTasks(task.getTaskId());
                %>
                <li class="list-group-item flex-column align-items-start mb-3 border">
                    <div class="d-flex justify-content-between w-100">
                        <div>
                            <h4><%= task.getTitle() %>
                            </h4>
                            <p class="text-muted"><%= task.getDescription() %>
                            </p>
                        </div>
                        <div>
                            <portlet:actionURL name="toggleTaskStatus" var="completeTaskURL">
                                <portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>"/>
                                <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                            </portlet:actionURL>
                            <a href="<%= completeTaskURL %>" class="btn btn-sm btn-success">Concluir Tarefa</a>

                            <portlet:actionURL name="deleteTask" var="deleteTaskURL">
                                <portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>"/>
                                <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                            </portlet:actionURL>
                            <a href="<%= deleteTaskURL %>" class="btn btn-sm btn-danger">Excluir</a>
                        </div>
                    </div>

                    <hr>

                    <div class="ml-4">
                        <h6>Checklist:</h6>
                        <ul class="list-unstyled">
                            <% for (SubTask sub : subTasks) { %>
                            <li class="mb-2">
                                <div class="d-flex align-items-center">
                                    <portlet:actionURL name="toggleSubTaskStatus" var="toggleSubURL">
                                        <portlet:param name="subTaskId"
                                                       value="<%= String.valueOf(sub.getSubTaskId()) %>"/>
                                        <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                                    </portlet:actionURL>

                                    <a href="<%= toggleSubURL %>" class="mr-2">
                                        <%= sub.getCompleted() ? "Concluida" : "A fazer" %>
                                    </a>

                                    <span style="<%= sub.getCompleted() ? "text-decoration: line-through; color: gray;" : "" %>">
                                      <%= sub.getTitle() %>
                                  </span>

                                    <portlet:actionURL name="deleteSubTask" var="delSubURL">
                                        <portlet:param name="subTaskId"
                                                       value="<%= String.valueOf(sub.getSubTaskId()) %>"/>
                                        <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                                    </portlet:actionURL>
                                    <a href="<%= delSubURL %>" class="ml-2 text-danger" style="font-size: 0.8rem;">(excluir)</a>
                                </div>

                                <details class="ml-4 mt-1">
                                    <summary class="text-info" style="cursor: pointer; font-size: 0.75rem;">Editar
                                        nome
                                    </summary>

                                    <portlet:actionURL name="updateSubTask" var="updateSubTaskURL">
                                        <portlet:param name="subTaskId"
                                                       value="<%= String.valueOf(sub.getSubTaskId()) %>"/>
                                    </portlet:actionURL>

                                    <aui:form action="<%= updateSubTaskURL %>" method="post"
                                              cssClass="form-inline mt-1">
                                        <input type="hidden" name="p_auth"
                                               value="<%= AuthTokenUtil.getToken(request) %>"/>
                                        <aui:input name="title" label="" value="<%= sub.getTitle() %>"
                                                   cssClass="form-control form-control-sm" inlineField="<%= true %>"/>
                                        <aui:button type="submit" value="Salvar"
                                                    cssClass="btn btn-sm btn-outline-info ml-1"/>
                                    </aui:form>
                                </details>
                            </li>
                            <% } %>
                        </ul>

                        <portlet:actionURL name="addSubTask" var="addSubTaskURL"/>
                        <aui:form action="<%= addSubTaskURL %>" method="post" cssClass="form-inline mt-2">
                            <input type="hidden" name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                            <aui:input name="taskId" type="hidden" value="<%= task.getTaskId() %>"/>
                            <aui:input name="title" label="" placeholder="Nova sub-tarefa..."
                                       cssClass="form-control form-control-sm" inlineField="<%= true %>"/>
                            <aui:button type="submit" value="+" cssClass="btn btn-sm btn-secondary ml-1"/>
                        </aui:form>
                    </div>
                    <div class="mt-4 ml-4 p-3 border rounded bg-light">
                        <h6 class="text-primary mb-3">Imagem Anexada:</h6>
                        <%
                            // Busca os anexos ativos da tarefa
                            List<TaskAttachment> attachments = TaskAttachmentLocalServiceUtil.getActiveAttachments(task.getTaskId());

                            if (attachments == null || attachments.isEmpty()) {
                        %>
                        <portlet:actionURL name="addTaskAttachment" var="addAttachmentURL"/>
                        <aui:form action="<%= addAttachmentURL %>" method="post" enctype="multipart/form-data"
                                  cssClass="d-flex align-items-center">
                            <input type="hidden" name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                            <aui:input name="taskId" type="hidden" value="<%= task.getTaskId() %>"/>
                            <aui:input type="file" name="attachmentFile" label="" required="true" cssClass="mr-2"/>
                            <aui:button type="submit" value="Enviar Imagem" cssClass="btn btn-sm btn-info"/>
                        </aui:form>
                        <%
                        } else {
                            // SE TEM IMAGEM: Mostra a imagem e botões de controle
                            for (TaskAttachment attachment : attachments) {
                                FileEntry fileEntry = null;
                                String imageUrl = "";
                                try {
                                    // Recupera o arquivo nativo e monta a URL para exibi-lo
                                    fileEntry = DLAppLocalServiceUtil.getFileEntry(attachment.getFileEntryId());
                                    imageUrl = themeDisplay.getPathContext() + "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + java.net.URLEncoder.encode(fileEntry.getTitle(), "UTF-8") + "/" + fileEntry.getUuid();
                                } catch (Exception e) {
                                }

                                if (fileEntry != null) {
                        %>
                        <div class="d-flex align-items-start mb-2">
                            <img src="<%= imageUrl %>" alt="Anexo" class="img-thumbnail mr-3 shadow-sm"
                                 style="max-width: 200px; max-height: 200px; object-fit: cover;"/>

                            <div>
                                <portlet:actionURL name="deleteTaskAttachment" var="deleteAttachmentURL">
                                    <portlet:param name="taskAttachmentId"
                                                   value="<%= String.valueOf(attachment.getTaskAttachmentId()) %>"/>
                                    <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                                </portlet:actionURL>
                                <a href="<%= deleteAttachmentURL %>" class="btn btn-sm btn-outline-danger d-block mb-2">Remover
                                    Imagem</a>

                                <details>
                                    <summary class="btn btn-sm btn-outline-warning" style="cursor: pointer;">Trocar
                                        Imagem
                                    </summary>
                                    <div class="mt-2 p-2 border bg-white rounded">
                                        <portlet:actionURL name="updateTaskAttachment" var="updateAttachmentURL"/>
                                        <aui:form action="<%= updateAttachmentURL %>" method="post"
                                                  enctype="multipart/form-data" cssClass="d-flex flex-column">
                                            <input type="hidden" name="p_auth"
                                                   value="<%= AuthTokenUtil.getToken(request) %>"/>
                                            <aui:input name="taskAttachmentId" type="hidden"
                                                       value="<%= attachment.getTaskAttachmentId() %>"/>
                                            <aui:input type="file" name="attachmentFile" label="" required="true"
                                                       cssClass="mb-2"/>
                                            <aui:button type="submit" value="Salvar Substituição"
                                                        cssClass="btn btn-sm btn-success"/>
                                        </aui:form>
                                    </div>
                                </details>
                            </div>
                        </div>
                        <% }
                        }
                        }
                        %>
                    </div>
                    <details class="mt-4 p-2 border bg-light">
                        <summary class="text-primary" style="cursor: pointer; font-size: 0.8rem;">Editar Detalhes da
                            Tarefa
                        </summary>
                        <portlet:actionURL name="updateTask" var="updateTaskURL">
                            <portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>"/>
                        </portlet:actionURL>
                        <aui:form action="<%= updateTaskURL %>" method="post" cssClass="mt-2">
                            <input type="hidden" name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                            <aui:input name="title" label="Título" value="<%= task.getTitle() %>"/>
                            <aui:input name="description" label="Descrição" type="textarea"
                                       value="<%= task.getDescription() %>"/>
                            <aui:button type="submit" value="Salvar" cssClass="btn btn-sm btn-primary"/>
                        </aui:form>
                    </details>
                </li>
                <% } %>
            </ul>
        </liferay-ui:section>

        <liferay-ui:section>
            <p class="mt-3"><strong>Total de tarefas concluídas: <%= completedTasks.size() %>
            </strong></p>

            <ul class="list-group">
                <% for (Task task : completedTasks) { %>
                <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                    <div>
                        <h5>
                            <del><%= task.getTitle() %>
                            </del>
                        </h5>
                        <small><%= task.getDescription() %>
                        </small>
                    </div>
                    <div>
                        <portlet:actionURL name="toggleTaskStatus" var="reopenTaskURL">
                            <portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>"/>
                            <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                        </portlet:actionURL>
                        <a href="<%= reopenTaskURL %>" class="btn btn-sm btn-warning">Reabrir</a>

                        <portlet:actionURL name="deleteTask" var="deleteTaskURL">
                            <portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>"/>
                            <portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
                        </portlet:actionURL>
                        <a href="<%= deleteTaskURL %>" class="btn btn-sm btn-danger">Excluir</a>
                    </div>
                </li>
                <% } %>
            </ul>
        </liferay-ui:section>

    </liferay-ui:tabs>
</div>