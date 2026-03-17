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
 * This class is a wrapper for {@link SubTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubTask
 * @generated
 */
public class SubTaskWrapper
	extends BaseModelWrapper<SubTask>
	implements ModelWrapper<SubTask>, SubTask {

	public SubTaskWrapper(SubTask subTask) {
		super(subTask);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subTaskId", getSubTaskId());
		attributes.put("taskId", getTaskId());
		attributes.put("title", getTitle());
		attributes.put("completed", isCompleted());
		attributes.put("deleted", isDeleted());
		attributes.put("position", getPosition());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subTaskId = (Long)attributes.get("subTaskId");

		if (subTaskId != null) {
			setSubTaskId(subTaskId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public SubTask cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the completed of this sub task.
	 *
	 * @return the completed of this sub task
	 */
	@Override
	public boolean getCompleted() {
		return model.getCompleted();
	}

	/**
	 * Returns the create date of this sub task.
	 *
	 * @return the create date of this sub task
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this sub task.
	 *
	 * @return the deleted of this sub task
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the modified date of this sub task.
	 *
	 * @return the modified date of this sub task
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the position of this sub task.
	 *
	 * @return the position of this sub task
	 */
	@Override
	public int getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this sub task.
	 *
	 * @return the primary key of this sub task
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sub task ID of this sub task.
	 *
	 * @return the sub task ID of this sub task
	 */
	@Override
	public long getSubTaskId() {
		return model.getSubTaskId();
	}

	/**
	 * Returns the task ID of this sub task.
	 *
	 * @return the task ID of this sub task
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the title of this sub task.
	 *
	 * @return the title of this sub task
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns <code>true</code> if this sub task is completed.
	 *
	 * @return <code>true</code> if this sub task is completed; <code>false</code> otherwise
	 */
	@Override
	public boolean isCompleted() {
		return model.isCompleted();
	}

	/**
	 * Returns <code>true</code> if this sub task is deleted.
	 *
	 * @return <code>true</code> if this sub task is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this sub task is completed.
	 *
	 * @param completed the completed of this sub task
	 */
	@Override
	public void setCompleted(boolean completed) {
		model.setCompleted(completed);
	}

	/**
	 * Sets the create date of this sub task.
	 *
	 * @param createDate the create date of this sub task
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this sub task is deleted.
	 *
	 * @param deleted the deleted of this sub task
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the modified date of this sub task.
	 *
	 * @param modifiedDate the modified date of this sub task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the position of this sub task.
	 *
	 * @param position the position of this sub task
	 */
	@Override
	public void setPosition(int position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this sub task.
	 *
	 * @param primaryKey the primary key of this sub task
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sub task ID of this sub task.
	 *
	 * @param subTaskId the sub task ID of this sub task
	 */
	@Override
	public void setSubTaskId(long subTaskId) {
		model.setSubTaskId(subTaskId);
	}

	/**
	 * Sets the task ID of this sub task.
	 *
	 * @param taskId the task ID of this sub task
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the title of this sub task.
	 *
	 * @param title the title of this sub task
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SubTaskWrapper wrap(SubTask subTask) {
		return new SubTaskWrapper(subTask);
	}

}