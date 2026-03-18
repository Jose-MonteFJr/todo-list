/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Todo_TaskAttachment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachment
 * @generated
 */
public class TaskAttachmentTable extends BaseTable<TaskAttachmentTable> {

	public static final TaskAttachmentTable INSTANCE =
		new TaskAttachmentTable();

	public final Column<TaskAttachmentTable, Long> taskAttachmentId =
		createColumn(
			"taskAttachmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TaskAttachmentTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskAttachmentTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskAttachmentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskAttachmentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskAttachmentTable, Boolean> deleted = createColumn(
		"deleted", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private TaskAttachmentTable() {
		super("Todo_TaskAttachment", TaskAttachmentTable::new);
	}

}