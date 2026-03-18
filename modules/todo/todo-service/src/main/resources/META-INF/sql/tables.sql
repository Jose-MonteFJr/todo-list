create table Todo_SubTask (
	subTaskId LONG not null primary key,
	taskId LONG,
	title VARCHAR(75) null,
	completed BOOLEAN,
	deleted BOOLEAN,
	position INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table Todo_Task (
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	completed BOOLEAN,
	deleted BOOLEAN
);

create table Todo_TaskAttachment (
	taskAttachmentId LONG not null primary key,
	taskId LONG,
	fileEntryId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);