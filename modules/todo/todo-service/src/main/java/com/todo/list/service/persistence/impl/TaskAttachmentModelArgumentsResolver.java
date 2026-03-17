/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import com.todo.list.model.TaskAttachmentTable;
import com.todo.list.model.impl.TaskAttachmentImpl;
import com.todo.list.model.impl.TaskAttachmentModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from TaskAttachment.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=com.todo.list.model.impl.TaskAttachmentImpl",
		"table.name=Todo_TaskAttachment"
	},
	service = ArgumentsResolver.class
)
public class TaskAttachmentModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		TaskAttachmentModelImpl taskAttachmentModelImpl =
			(TaskAttachmentModelImpl)baseModel;

		long columnBitmask = taskAttachmentModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(taskAttachmentModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					taskAttachmentModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(taskAttachmentModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return TaskAttachmentImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return TaskAttachmentTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		TaskAttachmentModelImpl taskAttachmentModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = taskAttachmentModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = taskAttachmentModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}