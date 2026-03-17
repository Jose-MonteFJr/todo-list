/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.todo.list.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTaskAttachmentException extends NoSuchModelException {

	public NoSuchTaskAttachmentException() {
	}

	public NoSuchTaskAttachmentException(String msg) {
		super(msg);
	}

	public NoSuchTaskAttachmentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchTaskAttachmentException(Throwable throwable) {
		super(throwable);
	}

}