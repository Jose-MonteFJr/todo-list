create index IX_87119F23 on Todo_SubTask (taskId, deleted);

create index IX_9F8D6E on Todo_Task (groupId, userId, completed, deleted);
create index IX_64466FC9 on Todo_Task (groupId, userId, deleted);

create index IX_CCF0804E on Todo_TaskAttachment (taskId, deleted);