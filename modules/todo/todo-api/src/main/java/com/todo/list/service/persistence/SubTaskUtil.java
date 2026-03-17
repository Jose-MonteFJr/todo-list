/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.todo.list.model.SubTask;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sub task service. This utility wraps <code>com.todo.list.service.persistence.impl.SubTaskPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubTaskPersistence
 * @generated
 */
public class SubTaskUtil {

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
	public static void clearCache(SubTask subTask) {
		getPersistence().clearCache(subTask);
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
	public static Map<Serializable, SubTask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubTask> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubTask update(SubTask subTask) {
		return getPersistence().update(subTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubTask update(
		SubTask subTask, ServiceContext serviceContext) {

		return getPersistence().update(subTask, serviceContext);
	}

	/**
	 * Returns all the sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching sub tasks
	 */
	public static List<SubTask> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	 * Returns a range of all the sub tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @return the range of matching sub tasks
	 */
	public static List<SubTask> findByTaskId(long taskId, int start, int end) {
		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	 * Returns an ordered range of all the sub tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub tasks
	 */
	public static List<SubTask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<SubTask> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sub tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub tasks
	 */
	public static List<SubTask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<SubTask> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public static SubTask findByTaskId_First(
			long taskId, OrderByComparator<SubTask> orderByComparator)
		throws com.todo.list.exception.NoSuchSubTaskException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public static SubTask fetchByTaskId_First(
		long taskId, OrderByComparator<SubTask> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public static SubTask findByTaskId_Last(
			long taskId, OrderByComparator<SubTask> orderByComparator)
		throws com.todo.list.exception.NoSuchSubTaskException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public static SubTask fetchByTaskId_Last(
		long taskId, OrderByComparator<SubTask> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the sub tasks before and after the current sub task in the ordered set where taskId = &#63;.
	 *
	 * @param subTaskId the primary key of the current sub task
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public static SubTask[] findByTaskId_PrevAndNext(
			long subTaskId, long taskId,
			OrderByComparator<SubTask> orderByComparator)
		throws com.todo.list.exception.NoSuchSubTaskException {

		return getPersistence().findByTaskId_PrevAndNext(
			subTaskId, taskId, orderByComparator);
	}

	/**
	 * Removes all the sub tasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching sub tasks
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Caches the sub task in the entity cache if it is enabled.
	 *
	 * @param subTask the sub task
	 */
	public static void cacheResult(SubTask subTask) {
		getPersistence().cacheResult(subTask);
	}

	/**
	 * Caches the sub tasks in the entity cache if it is enabled.
	 *
	 * @param subTasks the sub tasks
	 */
	public static void cacheResult(List<SubTask> subTasks) {
		getPersistence().cacheResult(subTasks);
	}

	/**
	 * Creates a new sub task with the primary key. Does not add the sub task to the database.
	 *
	 * @param subTaskId the primary key for the new sub task
	 * @return the new sub task
	 */
	public static SubTask create(long subTaskId) {
		return getPersistence().create(subTaskId);
	}

	/**
	 * Removes the sub task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task that was removed
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public static SubTask remove(long subTaskId)
		throws com.todo.list.exception.NoSuchSubTaskException {

		return getPersistence().remove(subTaskId);
	}

	public static SubTask updateImpl(SubTask subTask) {
		return getPersistence().updateImpl(subTask);
	}

	/**
	 * Returns the sub task with the primary key or throws a <code>NoSuchSubTaskException</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public static SubTask findByPrimaryKey(long subTaskId)
		throws com.todo.list.exception.NoSuchSubTaskException {

		return getPersistence().findByPrimaryKey(subTaskId);
	}

	/**
	 * Returns the sub task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task, or <code>null</code> if a sub task with the primary key could not be found
	 */
	public static SubTask fetchByPrimaryKey(long subTaskId) {
		return getPersistence().fetchByPrimaryKey(subTaskId);
	}

	/**
	 * Returns all the sub tasks.
	 *
	 * @return the sub tasks
	 */
	public static List<SubTask> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sub tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @return the range of sub tasks
	 */
	public static List<SubTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sub tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub tasks
	 */
	public static List<SubTask> findAll(
		int start, int end, OrderByComparator<SubTask> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sub tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub tasks
	 */
	public static List<SubTask> findAll(
		int start, int end, OrderByComparator<SubTask> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sub tasks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sub tasks.
	 *
	 * @return the number of sub tasks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubTaskPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SubTaskPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SubTaskPersistence _persistence;

}