/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.todo.list.model.SubTask;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubTaskCacheModel implements CacheModel<SubTask>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubTaskCacheModel)) {
			return false;
		}

		SubTaskCacheModel subTaskCacheModel = (SubTaskCacheModel)object;

		if (subTaskId == subTaskCacheModel.subTaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{subTaskId=");
		sb.append(subTaskId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", completed=");
		sb.append(completed);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", position=");
		sb.append(position);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubTask toEntityModel() {
		SubTaskImpl subTaskImpl = new SubTaskImpl();

		subTaskImpl.setSubTaskId(subTaskId);
		subTaskImpl.setTaskId(taskId);

		if (title == null) {
			subTaskImpl.setTitle("");
		}
		else {
			subTaskImpl.setTitle(title);
		}

		subTaskImpl.setCompleted(completed);
		subTaskImpl.setDeleted(deleted);
		subTaskImpl.setPosition(position);

		if (createDate == Long.MIN_VALUE) {
			subTaskImpl.setCreateDate(null);
		}
		else {
			subTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subTaskImpl.setModifiedDate(null);
		}
		else {
			subTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		subTaskImpl.resetOriginalValues();

		return subTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subTaskId = objectInput.readLong();

		taskId = objectInput.readLong();
		title = objectInput.readUTF();

		completed = objectInput.readBoolean();

		deleted = objectInput.readBoolean();

		position = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(subTaskId);

		objectOutput.writeLong(taskId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeBoolean(completed);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(position);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long subTaskId;
	public long taskId;
	public String title;
	public boolean completed;
	public boolean deleted;
	public int position;
	public long createDate;
	public long modifiedDate;

}