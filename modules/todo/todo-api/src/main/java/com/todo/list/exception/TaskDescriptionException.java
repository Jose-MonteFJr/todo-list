/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.todo.list.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskDescriptionException extends PortalException {

	public TaskDescriptionException() {
	}

	public TaskDescriptionException(String msg) {
		super(msg);
	}

	public TaskDescriptionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public TaskDescriptionException(Throwable throwable) {
		super(throwable);
	}

}