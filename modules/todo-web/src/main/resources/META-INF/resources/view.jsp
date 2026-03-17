<%@ include file="init.jsp" %>

<%
	List<Task> pendingTasks = TaskLocalServiceUtil.getTasksByStatus(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), false);
	List<Task> completedTasks = TaskLocalServiceUtil.getTasksByStatus(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), true);
%>

<div class="container-fluid container-fluid-max-xl mt-4">
	<h2>Gerenciador de Tarefas</h2>

	<portlet:actionURL name="addTask" var="addTaskURL" />

	<div class="card p-3 mb-4">
		<aui:form action="<%= addTaskURL %>" method="post">
			<aui:input name="title" label="Título da Tarefa" required="true" cssClass="form-control" />
			<aui:input name="description" label="Descrição" type="textarea" cssClass="form-control" />
			<aui:button type="submit" value="Adicionar Tarefa" cssClass="btn btn-primary mt-2" />
		</aui:form>
	</div>

	<liferay-ui:tabs names="Pendentes,Concluídas" refresh="false">

		<liferay-ui:section>
			<p class="mt-3"><strong>Total de tarefas pendentes: <%= pendingTasks.size() %></strong></p>

			<ul class="list-group">
				<% for(Task task : pendingTasks) { %>
				<li class="list-group-item d-flex justify-content-between align-items-center">
					<div>
						<h5><%= task.getTitle() %></h5>
						<small><%= task.getDescription() %></small>
					</div>
					<div>
						<portlet:actionURL name="toggleTaskStatus" var="completeTaskURL">
							<portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>" />
						</portlet:actionURL>
						<a href="<%= completeTaskURL %>" class="btn btn-sm btn-success">Concluir</a>

						<portlet:actionURL name="deleteTask" var="deleteTaskURL">
							<portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>" />
						</portlet:actionURL>
						<a href="<%= deleteTaskURL %>" class="btn btn-sm btn-danger">Excluir</a>
					</div>
				</li>
				<% } %>
			</ul>
		</liferay-ui:section>

		<liferay-ui:section>
			<p class="mt-3"><strong>Total de tarefas concluídas: <%= completedTasks.size() %></strong></p>

			<ul class="list-group">
				<% for(Task task : completedTasks) { %>
				<li class="list-group-item d-flex justify-content-between align-items-center bg-light">
					<div>
						<h5><del><%= task.getTitle() %></del></h5>
						<small><%= task.getDescription() %></small>
					</div>
					<div>
						<portlet:actionURL name="toggleTaskStatus" var="reopenTaskURL">
							<portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>" />
						</portlet:actionURL>
						<a href="<%= reopenTaskURL %>" class="btn btn-sm btn-warning">Reabrir</a>

						<portlet:actionURL name="deleteTask" var="deleteTaskURL">
							<portlet:param name="taskId" value="<%= String.valueOf(task.getTaskId()) %>" />
						</portlet:actionURL>
						<a href="<%= deleteTaskURL %>" class="btn btn-sm btn-danger">Excluir</a>
					</div>
				</li>
				<% } %>
			</ul>
		</liferay-ui:section>

	</liferay-ui:tabs>
</div>