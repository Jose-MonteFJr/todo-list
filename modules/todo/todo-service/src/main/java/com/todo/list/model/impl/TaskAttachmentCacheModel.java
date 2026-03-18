/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.todo.list.model.TaskAttachment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskAttachment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskAttachmentCacheModel
	implements CacheModel<TaskAttachment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskAttachmentCacheModel)) {
			return false;
		}

		TaskAttachmentCacheModel taskAttachmentCacheModel =
			(TaskAttachmentCacheModel)object;

		if (taskAttachmentId == taskAttachmentCacheModel.taskAttachmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskAttachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{taskAttachmentId=");
		sb.append(taskAttachmentId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskAttachment toEntityModel() {
		TaskAttachmentImpl taskAttachmentImpl = new TaskAttachmentImpl();

		taskAttachmentImpl.setTaskAttachmentId(taskAttachmentId);
		taskAttachmentImpl.setTaskId(taskId);
		taskAttachmentImpl.setFileEntryId(fileEntryId);

		if (createDate == Long.MIN_VALUE) {
			taskAttachmentImpl.setCreateDate(null);
		}
		else {
			taskAttachmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskAttachmentImpl.setModifiedDate(null);
		}
		else {
			taskAttachmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskAttachmentImpl.setDeleted(deleted);

		taskAttachmentImpl.resetOriginalValues();

		return taskAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskAttachmentId = objectInput.readLong();

		taskId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskAttachmentId);

		objectOutput.writeLong(taskId);

		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(deleted);
	}

	public long taskAttachmentId;
	public long taskId;
	public long fileEntryId;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;

}