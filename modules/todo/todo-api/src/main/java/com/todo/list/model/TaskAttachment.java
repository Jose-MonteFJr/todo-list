/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TaskAttachment service. Represents a row in the &quot;Todo_TaskAttachment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachmentModel
 * @generated
 */
@ImplementationClassName("com.todo.list.model.impl.TaskAttachmentImpl")
@ProviderType
public interface TaskAttachment extends PersistedModel, TaskAttachmentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.todo.list.model.impl.TaskAttachmentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TaskAttachment, Long>
		TASK_ATTACHMENT_ID_ACCESSOR = new Accessor<TaskAttachment, Long>() {

			@Override
			public Long get(TaskAttachment taskAttachment) {
				return taskAttachment.getTaskAttachmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TaskAttachment> getTypeClass() {
				return TaskAttachment.class;
			}

		};

}