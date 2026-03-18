/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.todo.list.exception.NoSuchSubTaskException;
import com.todo.list.model.SubTask;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sub task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubTaskUtil
 * @generated
 */
@ProviderType
public interface SubTaskPersistence extends BasePersistence<SubTask> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubTaskUtil} to access the sub task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching sub tasks
	 */
	public java.util.List<SubTask> findByTaskId(long taskId);

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
	public java.util.List<SubTask> findByTaskId(
		long taskId, int start, int end);

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
	public java.util.List<SubTask> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

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
	public java.util.List<SubTask> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public SubTask findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public SubTask fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public SubTask findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public SubTask fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

	/**
	 * Returns the sub tasks before and after the current sub task in the ordered set where taskId = &#63;.
	 *
	 * @param subTaskId the primary key of the current sub task
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public SubTask[] findByTaskId_PrevAndNext(
			long subTaskId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Removes all the sub tasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching sub tasks
	 */
	public int countByTaskId(long taskId);

	/**
	 * Returns all the sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the matching sub tasks
	 */
	public java.util.List<SubTask> findByT_D(long taskId, boolean deleted);

	/**
	 * Returns a range of all the sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @return the range of matching sub tasks
	 */
	public java.util.List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub tasks
	 */
	public java.util.List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub tasks
	 */
	public java.util.List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public SubTask findByT_D_First(
			long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public SubTask fetchByT_D_First(
		long taskId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	public SubTask findByT_D_Last(
			long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	public SubTask fetchByT_D_Last(
		long taskId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

	/**
	 * Returns the sub tasks before and after the current sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param subTaskId the primary key of the current sub task
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public SubTask[] findByT_D_PrevAndNext(
			long subTaskId, long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<SubTask>
				orderByComparator)
		throws NoSuchSubTaskException;

	/**
	 * Removes all the sub tasks where taskId = &#63; and deleted = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 */
	public void removeByT_D(long taskId, boolean deleted);

	/**
	 * Returns the number of sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the number of matching sub tasks
	 */
	public int countByT_D(long taskId, boolean deleted);

	/**
	 * Caches the sub task in the entity cache if it is enabled.
	 *
	 * @param subTask the sub task
	 */
	public void cacheResult(SubTask subTask);

	/**
	 * Caches the sub tasks in the entity cache if it is enabled.
	 *
	 * @param subTasks the sub tasks
	 */
	public void cacheResult(java.util.List<SubTask> subTasks);

	/**
	 * Creates a new sub task with the primary key. Does not add the sub task to the database.
	 *
	 * @param subTaskId the primary key for the new sub task
	 * @return the new sub task
	 */
	public SubTask create(long subTaskId);

	/**
	 * Removes the sub task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task that was removed
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public SubTask remove(long subTaskId) throws NoSuchSubTaskException;

	public SubTask updateImpl(SubTask subTask);

	/**
	 * Returns the sub task with the primary key or throws a <code>NoSuchSubTaskException</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	public SubTask findByPrimaryKey(long subTaskId)
		throws NoSuchSubTaskException;

	/**
	 * Returns the sub task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task, or <code>null</code> if a sub task with the primary key could not be found
	 */
	public SubTask fetchByPrimaryKey(long subTaskId);

	/**
	 * Returns all the sub tasks.
	 *
	 * @return the sub tasks
	 */
	public java.util.List<SubTask> findAll();

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
	public java.util.List<SubTask> findAll(int start, int end);

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
	public java.util.List<SubTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator);

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
	public java.util.List<SubTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubTask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sub tasks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sub tasks.
	 *
	 * @return the number of sub tasks
	 */
	public int countAll();

}