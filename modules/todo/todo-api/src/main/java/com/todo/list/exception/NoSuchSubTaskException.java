/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.todo.list.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSubTaskException extends NoSuchModelException {

	public NoSuchSubTaskException() {
	}

	public NoSuchSubTaskException(String msg) {
		super(msg);
	}

	public NoSuchSubTaskException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSubTaskException(Throwable throwable) {
		super(throwable);
	}

}