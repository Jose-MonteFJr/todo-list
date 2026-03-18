/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.todo.list.model.TaskAttachment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the task attachment service. This utility wraps <code>com.todo.list.service.persistence.impl.TaskAttachmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachmentPersistence
 * @generated
 */
public class TaskAttachmentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TaskAttachment taskAttachment) {
		getPersistence().clearCache(taskAttachment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TaskAttachment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskAttachment update(TaskAttachment taskAttachment) {
		return getPersistence().update(taskAttachment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskAttachment update(
		TaskAttachment taskAttachment, ServiceContext serviceContext) {

		return getPersistence().update(taskAttachment, serviceContext);
	}

	/**
	 * Returns all the task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task attachments
	 */
	public static List<TaskAttachment> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	 * Returns a range of all the task attachments where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @return the range of matching task attachments
	 */
	public static List<TaskAttachment> findByTaskId(
		long taskId, int start, int end) {

		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	 * Returns an ordered range of all the task attachments where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task attachments
	 */
	public static List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task attachments where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task attachments
	 */
	public static List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public static TaskAttachment findByTaskId_First(
			long taskId, OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public static TaskAttachment fetchByTaskId_First(
		long taskId, OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public static TaskAttachment findByTaskId_Last(
			long taskId, OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public static TaskAttachment fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the task attachments before and after the current task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskAttachmentId the primary key of the current task attachment
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment[] findByTaskId_PrevAndNext(
			long taskAttachmentId, long taskId,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByTaskId_PrevAndNext(
			taskAttachmentId, taskId, orderByComparator);
	}

	/**
	 * Removes all the task attachments where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task attachments
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Returns all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the matching task attachments
	 */
	public static List<TaskAttachment> findByT_D(long taskId, boolean deleted) {
		return getPersistence().findByT_D(taskId, deleted);
	}

	/**
	 * Returns a range of all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @return the range of matching task attachments
	 */
	public static List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end) {

		return getPersistence().findByT_D(taskId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task attachments
	 */
	public static List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().findByT_D(
			taskId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task attachments
	 */
	public static List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByT_D(
			taskId, deleted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public static TaskAttachment findByT_D_First(
			long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByT_D_First(
			taskId, deleted, orderByComparator);
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public static TaskAttachment fetchByT_D_First(
		long taskId, boolean deleted,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().fetchByT_D_First(
			taskId, deleted, orderByComparator);
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public static TaskAttachment findByT_D_Last(
			long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByT_D_Last(
			taskId, deleted, orderByComparator);
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public static TaskAttachment fetchByT_D_Last(
		long taskId, boolean deleted,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().fetchByT_D_Last(
			taskId, deleted, orderByComparator);
	}

	/**
	 * Returns the task attachments before and after the current task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskAttachmentId the primary key of the current task attachment
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment[] findByT_D_PrevAndNext(
			long taskAttachmentId, long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByT_D_PrevAndNext(
			taskAttachmentId, taskId, deleted, orderByComparator);
	}

	/**
	 * Removes all the task attachments where taskId = &#63; and deleted = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 */
	public static void removeByT_D(long taskId, boolean deleted) {
		getPersistence().removeByT_D(taskId, deleted);
	}

	/**
	 * Returns the number of task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the number of matching task attachments
	 */
	public static int countByT_D(long taskId, boolean deleted) {
		return getPersistence().countByT_D(taskId, deleted);
	}

	/**
	 * Caches the task attachment in the entity cache if it is enabled.
	 *
	 * @param taskAttachment the task attachment
	 */
	public static void cacheResult(TaskAttachment taskAttachment) {
		getPersistence().cacheResult(taskAttachment);
	}

	/**
	 * Caches the task attachments in the entity cache if it is enabled.
	 *
	 * @param taskAttachments the task attachments
	 */
	public static void cacheResult(List<TaskAttachment> taskAttachments) {
		getPersistence().cacheResult(taskAttachments);
	}

	/**
	 * Creates a new task attachment with the primary key. Does not add the task attachment to the database.
	 *
	 * @param taskAttachmentId the primary key for the new task attachment
	 * @return the new task attachment
	 */
	public static TaskAttachment create(long taskAttachmentId) {
		return getPersistence().create(taskAttachmentId);
	}

	/**
	 * Removes the task attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment that was removed
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment remove(long taskAttachmentId)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().remove(taskAttachmentId);
	}

	public static TaskAttachment updateImpl(TaskAttachment taskAttachment) {
		return getPersistence().updateImpl(taskAttachment);
	}

	/**
	 * Returns the task attachment with the primary key or throws a <code>NoSuchTaskAttachmentException</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment findByPrimaryKey(long taskAttachmentId)
		throws com.todo.list.exception.NoSuchTaskAttachmentException {

		return getPersistence().findByPrimaryKey(taskAttachmentId);
	}

	/**
	 * Returns the task attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment, or <code>null</code> if a task attachment with the primary key could not be found
	 */
	public static TaskAttachment fetchByPrimaryKey(long taskAttachmentId) {
		return getPersistence().fetchByPrimaryKey(taskAttachmentId);
	}

	/**
	 * Returns all the task attachments.
	 *
	 * @return the task attachments
	 */
	public static List<TaskAttachment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the task attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @return the range of task attachments
	 */
	public static List<TaskAttachment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the task attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task attachments
	 */
	public static List<TaskAttachment> findAll(
		int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task attachments
	 * @param end the upper bound of the range of task attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task attachments
	 */
	public static List<TaskAttachment> findAll(
		int start, int end, OrderByComparator<TaskAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the task attachments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of task attachments.
	 *
	 * @return the number of task attachments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskAttachmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TaskAttachmentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TaskAttachmentPersistence _persistence;

}