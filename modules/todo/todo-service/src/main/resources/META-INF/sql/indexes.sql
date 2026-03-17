create index IX_A16278A6 on Todo_SubTask (taskId);

create index IX_C72039FB on Todo_Task (groupId, userId, completed);

create index IX_BDC88B1B on Todo_TaskAttachment (taskId);