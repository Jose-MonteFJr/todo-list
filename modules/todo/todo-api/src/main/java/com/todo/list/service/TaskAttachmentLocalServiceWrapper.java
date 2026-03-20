/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TaskAttachmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachmentLocalService
 * @generated
 */
public class TaskAttachmentLocalServiceWrapper
	implements ServiceWrapper<TaskAttachmentLocalService>,
			   TaskAttachmentLocalService {

	public TaskAttachmentLocalServiceWrapper() {
		this(null);
	}

	public TaskAttachmentLocalServiceWrapper(
		TaskAttachmentLocalService taskAttachmentLocalService) {

		_taskAttachmentLocalService = taskAttachmentLocalService;
	}

	@Override
	public com.todo.list.model.TaskAttachment addTaskAttachment(
		long taskId, long fileEntryId) {

		return _taskAttachmentLocalService.addTaskAttachment(
			taskId, fileEntryId);
	}

	/**
	 * Adds the task attachment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskAttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskAttachment the task attachment
	 * @return the task attachment that was added
	 */
	@Override
	public com.todo.list.model.TaskAttachment addTaskAttachment(
		com.todo.list.model.TaskAttachment taskAttachment) {

		return _taskAttachmentLocalService.addTaskAttachment(taskAttachment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new task attachment with the primary key. Does not add the task attachment to the database.
	 *
	 * @param taskAttachmentId the primary key for the new task attachment
	 * @return the new task attachment
	 */
	@Override
	public com.todo.list.model.TaskAttachment createTaskAttachment(
		long taskAttachmentId) {

		return _taskAttachmentLocalService.createTaskAttachment(
			taskAttachmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskAttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment that was removed
	 * @throws PortalException if a task attachment with the primary key could not be found
	 */
	@Override
	public com.todo.list.model.TaskAttachment deleteTaskAttachment(
			long taskAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.deleteTaskAttachment(
			taskAttachmentId);
	}

	/**
	 * Deletes the task attachment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskAttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskAttachment the task attachment
	 * @return the task attachment that was removed
	 */
	@Override
	public com.todo.list.model.TaskAttachment deleteTaskAttachment(
		com.todo.list.model.TaskAttachment taskAttachment) {

		return _taskAttachmentLocalService.deleteTaskAttachment(taskAttachment);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _taskAttachmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _taskAttachmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskAttachmentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskAttachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _taskAttachmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _taskAttachmentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskAttachmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _taskAttachmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.todo.list.model.TaskAttachment fetchTaskAttachment(
		long taskAttachmentId) {

		return _taskAttachmentLocalService.fetchTaskAttachment(
			taskAttachmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskAttachmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.todo.list.model.TaskAttachment>
		getActiveAttachments(long taskId) {

		return _taskAttachmentLocalService.getActiveAttachments(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskAttachmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskAttachmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task attachment with the primary key.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment
	 * @throws PortalException if a task attachment with the primary key could not be found
	 */
	@Override
	public com.todo.list.model.TaskAttachment getTaskAttachment(
			long taskAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.getTaskAttachment(taskAttachmentId);
	}

	/**
	 * Returns a range of all the task attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @return the range of task attachments
	 */
	@Override
	public java.util.List<com.todo.list.model.TaskAttachment>
		getTaskAttachments(int start, int end) {

		return _taskAttachmentLocalService.getTaskAttachments(start, end);
	}

	/**
	 * Returns the number of task attachments.
	 *
	 * @return the number of task attachments
	 */
	@Override
	public int getTaskAttachmentsCount() {
		return _taskAttachmentLocalService.getTaskAttachmentsCount();
	}

	@Override
	public com.todo.list.model.TaskAttachment updateTaskAttachment(
			long taskAttachmentId, long newFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskAttachmentLocalService.updateTaskAttachment(
			taskAttachmentId, newFileEntryId);
	}

	/**
	 * Updates the task attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskAttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskAttachment the task attachment
	 * @return the task attachment that was updated
	 */
	@Override
	public com.todo.list.model.TaskAttachment updateTaskAttachment(
		com.todo.list.model.TaskAttachment taskAttachment) {

		return _taskAttachmentLocalService.updateTaskAttachment(taskAttachment);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _taskAttachmentLocalService.getBasePersistence();
	}

	@Override
	public TaskAttachmentLocalService getWrappedService() {
		return _taskAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		TaskAttachmentLocalService taskAttachmentLocalService) {

		_taskAttachmentLocalService = taskAttachmentLocalService;
	}

	private TaskAttachmentLocalService _taskAttachmentLocalService;

}