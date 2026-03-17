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
 * The table class for the &quot;Todo_SubTask&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SubTask
 * @generated
 */
public class SubTaskTable extends BaseTable<SubTaskTable> {

	public static final SubTaskTable INSTANCE = new SubTaskTable();

	public final Column<SubTaskTable, Long> subTaskId = createColumn(
		"subTaskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SubTaskTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, Boolean> completed = createColumn(
		"completed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, Boolean> deleted = createColumn(
		"deleted", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, Integer> position = createColumn(
		"position", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubTaskTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SubTaskTable() {
		super("Todo_SubTask", SubTaskTable::new);
	}

}