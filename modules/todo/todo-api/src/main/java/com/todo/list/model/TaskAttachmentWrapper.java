/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaskAttachment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachment
 * @generated
 */
public class TaskAttachmentWrapper
	extends BaseModelWrapper<TaskAttachment>
	implements ModelWrapper<TaskAttachment>, TaskAttachment {

	public TaskAttachmentWrapper(TaskAttachment taskAttachment) {
		super(taskAttachment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskAttachmentId", getTaskAttachmentId());
		attributes.put("taskId", getTaskId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskAttachmentId = (Long)attributes.get("taskAttachmentId");

		if (taskAttachmentId != null) {
			setTaskAttachmentId(taskAttachmentId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public TaskAttachment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this task attachment.
	 *
	 * @return the create date of this task attachment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file entry ID of this task attachment.
	 *
	 * @return the file entry ID of this task attachment
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the primary key of this task attachment.
	 *
	 * @return the primary key of this task attachment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the task attachment ID of this task attachment.
	 *
	 * @return the task attachment ID of this task attachment
	 */
	@Override
	public long getTaskAttachmentId() {
		return model.getTaskAttachmentId();
	}

	/**
	 * Returns the task ID of this task attachment.
	 *
	 * @return the task ID of this task attachment
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this task attachment.
	 *
	 * @param createDate the create date of this task attachment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file entry ID of this task attachment.
	 *
	 * @param fileEntryId the file entry ID of this task attachment
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the primary key of this task attachment.
	 *
	 * @param primaryKey the primary key of this task attachment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the task attachment ID of this task attachment.
	 *
	 * @param taskAttachmentId the task attachment ID of this task attachment
	 */
	@Override
	public void setTaskAttachmentId(long taskAttachmentId) {
		model.setTaskAttachmentId(taskAttachmentId);
	}

	/**
	 * Sets the task ID of this task attachment.
	 *
	 * @param taskId the task ID of this task attachment
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TaskAttachmentWrapper wrap(TaskAttachment taskAttachment) {
		return new TaskAttachmentWrapper(taskAttachment);
	}

}