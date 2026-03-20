/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.todo.list.model.TaskAttachment;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TaskAttachment. This utility wraps
 * <code>com.todo.list.service.impl.TaskAttachmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachmentLocalService
 * @generated
 */
public class TaskAttachmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.todo.list.service.impl.TaskAttachmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TaskAttachment addTaskAttachment(
		long taskId, long fileEntryId) {

		return getService().addTaskAttachment(taskId, fileEntryId);
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
	public static TaskAttachment addTaskAttachment(
		TaskAttachment taskAttachment) {

		return getService().addTaskAttachment(taskAttachment);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new task attachment with the primary key. Does not add the task attachment to the database.
	 *
	 * @param taskAttachmentId the primary key for the new task attachment
	 * @return the new task attachment
	 */
	public static TaskAttachment createTaskAttachment(long taskAttachmentId) {
		return getService().createTaskAttachment(taskAttachmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static TaskAttachment deleteTaskAttachment(long taskAttachmentId)
		throws PortalException {

		return getService().deleteTaskAttachment(taskAttachmentId);
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
	public static TaskAttachment deleteTaskAttachment(
		TaskAttachment taskAttachment) {

		return getService().deleteTaskAttachment(taskAttachment);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TaskAttachment fetchTaskAttachment(long taskAttachmentId) {
		return getService().fetchTaskAttachment(taskAttachmentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<TaskAttachment> getActiveAttachments(long taskId) {
		return getService().getActiveAttachments(taskId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task attachment with the primary key.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment
	 * @throws PortalException if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment getTaskAttachment(long taskAttachmentId)
		throws PortalException {

		return getService().getTaskAttachment(taskAttachmentId);
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
	public static List<TaskAttachment> getTaskAttachments(int start, int end) {
		return getService().getTaskAttachments(start, end);
	}

	/**
	 * Returns the number of task attachments.
	 *
	 * @return the number of task attachments
	 */
	public static int getTaskAttachmentsCount() {
		return getService().getTaskAttachmentsCount();
	}

	public static TaskAttachment updateTaskAttachment(
			long taskAttachmentId, long newFileEntryId)
		throws PortalException {

		return getService().updateTaskAttachment(
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
	public static TaskAttachment updateTaskAttachment(
		TaskAttachment taskAttachment) {

		return getService().updateTaskAttachment(taskAttachment);
	}

	public static TaskAttachmentLocalService getService() {
		return _service;
	}

	public static void setService(TaskAttachmentLocalService service) {
		_service = service;
	}

	private static volatile TaskAttachmentLocalService _service;

}