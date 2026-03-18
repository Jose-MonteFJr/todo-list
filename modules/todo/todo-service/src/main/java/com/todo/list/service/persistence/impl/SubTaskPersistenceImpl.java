/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.todo.list.exception.NoSuchSubTaskException;
import com.todo.list.model.SubTask;
import com.todo.list.model.SubTaskTable;
import com.todo.list.model.impl.SubTaskImpl;
import com.todo.list.model.impl.SubTaskModelImpl;
import com.todo.list.service.persistence.SubTaskPersistence;
import com.todo.list.service.persistence.SubTaskUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sub task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubTaskPersistenceImpl
	extends BasePersistenceImpl<SubTask> implements SubTaskPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubTaskUtil</code> to access the sub task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubTaskImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching sub tasks
	 */
	@Override
	public List<SubTask> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SubTask> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
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
	@Override
	public List<SubTask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<SubTask> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
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
	@Override
	public List<SubTask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<SubTask> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskId;
				finderArgs = new Object[] {taskId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskId;
			finderArgs = new Object[] {taskId, start, end, orderByComparator};
		}

		List<SubTask> list = null;

		if (useFinderCache) {
			list = (List<SubTask>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubTask subTask : list) {
					if (taskId != subTask.getTaskId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<SubTask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	@Override
	public SubTask findByTaskId_First(
			long taskId, OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = fetchByTaskId_First(taskId, orderByComparator);

		if (subTask != null) {
			return subTask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchSubTaskException(sb.toString());
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	@Override
	public SubTask fetchByTaskId_First(
		long taskId, OrderByComparator<SubTask> orderByComparator) {

		List<SubTask> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	@Override
	public SubTask findByTaskId_Last(
			long taskId, OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = fetchByTaskId_Last(taskId, orderByComparator);

		if (subTask != null) {
			return subTask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchSubTaskException(sb.toString());
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	@Override
	public SubTask fetchByTaskId_Last(
		long taskId, OrderByComparator<SubTask> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<SubTask> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SubTask[] findByTaskId_PrevAndNext(
			long subTaskId, long taskId,
			OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = findByPrimaryKey(subTaskId);

		Session session = null;

		try {
			session = openSession();

			SubTask[] array = new SubTaskImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, subTask, taskId, orderByComparator, true);

			array[1] = subTask;

			array[2] = getByTaskId_PrevAndNext(
				session, subTask, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubTask getByTaskId_PrevAndNext(
		Session session, SubTask subTask, long taskId,
		OrderByComparator<SubTask> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBTASK_WHERE);

		sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subTask)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SubTask> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sub tasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (SubTask subTask :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subTask);
		}
	}

	/**
	 * Returns the number of sub tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching sub tasks
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 =
		"subTask.taskId = ?";

	private FinderPath _finderPathWithPaginationFindByT_D;
	private FinderPath _finderPathWithoutPaginationFindByT_D;
	private FinderPath _finderPathCountByT_D;

	/**
	 * Returns all the sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the matching sub tasks
	 */
	@Override
	public List<SubTask> findByT_D(long taskId, boolean deleted) {
		return findByT_D(
			taskId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end) {

		return findByT_D(taskId, deleted, start, end, null);
	}

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
	@Override
	public List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<SubTask> orderByComparator) {

		return findByT_D(taskId, deleted, start, end, orderByComparator, true);
	}

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
	@Override
	public List<SubTask> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<SubTask> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByT_D;
				finderArgs = new Object[] {taskId, deleted};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByT_D;
			finderArgs = new Object[] {
				taskId, deleted, start, end, orderByComparator
			};
		}

		List<SubTask> list = null;

		if (useFinderCache) {
			list = (List<SubTask>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubTask subTask : list) {
					if ((taskId != subTask.getTaskId()) ||
						(deleted != subTask.isDeleted())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_T_D_TASKID_2);

			sb.append(_FINDER_COLUMN_T_D_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				queryPos.add(deleted);

				list = (List<SubTask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	@Override
	public SubTask findByT_D_First(
			long taskId, boolean deleted,
			OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = fetchByT_D_First(taskId, deleted, orderByComparator);

		if (subTask != null) {
			return subTask;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchSubTaskException(sb.toString());
	}

	/**
	 * Returns the first sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	@Override
	public SubTask fetchByT_D_First(
		long taskId, boolean deleted,
		OrderByComparator<SubTask> orderByComparator) {

		List<SubTask> list = findByT_D(
			taskId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task
	 * @throws NoSuchSubTaskException if a matching sub task could not be found
	 */
	@Override
	public SubTask findByT_D_Last(
			long taskId, boolean deleted,
			OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = fetchByT_D_Last(taskId, deleted, orderByComparator);

		if (subTask != null) {
			return subTask;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchSubTaskException(sb.toString());
	}

	/**
	 * Returns the last sub task in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub task, or <code>null</code> if a matching sub task could not be found
	 */
	@Override
	public SubTask fetchByT_D_Last(
		long taskId, boolean deleted,
		OrderByComparator<SubTask> orderByComparator) {

		int count = countByT_D(taskId, deleted);

		if (count == 0) {
			return null;
		}

		List<SubTask> list = findByT_D(
			taskId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SubTask[] findByT_D_PrevAndNext(
			long subTaskId, long taskId, boolean deleted,
			OrderByComparator<SubTask> orderByComparator)
		throws NoSuchSubTaskException {

		SubTask subTask = findByPrimaryKey(subTaskId);

		Session session = null;

		try {
			session = openSession();

			SubTask[] array = new SubTaskImpl[3];

			array[0] = getByT_D_PrevAndNext(
				session, subTask, taskId, deleted, orderByComparator, true);

			array[1] = subTask;

			array[2] = getByT_D_PrevAndNext(
				session, subTask, taskId, deleted, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubTask getByT_D_PrevAndNext(
		Session session, SubTask subTask, long taskId, boolean deleted,
		OrderByComparator<SubTask> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SUBTASK_WHERE);

		sb.append(_FINDER_COLUMN_T_D_TASKID_2);

		sb.append(_FINDER_COLUMN_T_D_DELETED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		queryPos.add(deleted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subTask)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SubTask> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sub tasks where taskId = &#63; and deleted = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByT_D(long taskId, boolean deleted) {
		for (SubTask subTask :
				findByT_D(
					taskId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(subTask);
		}
	}

	/**
	 * Returns the number of sub tasks where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the number of matching sub tasks
	 */
	@Override
	public int countByT_D(long taskId, boolean deleted) {
		FinderPath finderPath = _finderPathCountByT_D;

		Object[] finderArgs = new Object[] {taskId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_T_D_TASKID_2);

			sb.append(_FINDER_COLUMN_T_D_DELETED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				queryPos.add(deleted);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_D_TASKID_2 =
		"subTask.taskId = ? AND ";

	private static final String _FINDER_COLUMN_T_D_DELETED_2 =
		"subTask.deleted = ?";

	public SubTaskPersistenceImpl() {
		setModelClass(SubTask.class);

		setModelImplClass(SubTaskImpl.class);
		setModelPKClass(long.class);

		setTable(SubTaskTable.INSTANCE);
	}

	/**
	 * Caches the sub task in the entity cache if it is enabled.
	 *
	 * @param subTask the sub task
	 */
	@Override
	public void cacheResult(SubTask subTask) {
		entityCache.putResult(
			SubTaskImpl.class, subTask.getPrimaryKey(), subTask);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sub tasks in the entity cache if it is enabled.
	 *
	 * @param subTasks the sub tasks
	 */
	@Override
	public void cacheResult(List<SubTask> subTasks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subTasks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SubTask subTask : subTasks) {
			if (entityCache.getResult(
					SubTaskImpl.class, subTask.getPrimaryKey()) == null) {

				cacheResult(subTask);
			}
		}
	}

	/**
	 * Clears the cache for all sub tasks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubTaskImpl.class);

		finderCache.clearCache(SubTaskImpl.class);
	}

	/**
	 * Clears the cache for the sub task.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubTask subTask) {
		entityCache.removeResult(SubTaskImpl.class, subTask);
	}

	@Override
	public void clearCache(List<SubTask> subTasks) {
		for (SubTask subTask : subTasks) {
			entityCache.removeResult(SubTaskImpl.class, subTask);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubTaskImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubTaskImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sub task with the primary key. Does not add the sub task to the database.
	 *
	 * @param subTaskId the primary key for the new sub task
	 * @return the new sub task
	 */
	@Override
	public SubTask create(long subTaskId) {
		SubTask subTask = new SubTaskImpl();

		subTask.setNew(true);
		subTask.setPrimaryKey(subTaskId);

		return subTask;
	}

	/**
	 * Removes the sub task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task that was removed
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	@Override
	public SubTask remove(long subTaskId) throws NoSuchSubTaskException {
		return remove((Serializable)subTaskId);
	}

	/**
	 * Removes the sub task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sub task
	 * @return the sub task that was removed
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	@Override
	public SubTask remove(Serializable primaryKey)
		throws NoSuchSubTaskException {

		Session session = null;

		try {
			session = openSession();

			SubTask subTask = (SubTask)session.get(
				SubTaskImpl.class, primaryKey);

			if (subTask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubTaskException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subTask);
		}
		catch (NoSuchSubTaskException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SubTask removeImpl(SubTask subTask) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subTask)) {
				subTask = (SubTask)session.get(
					SubTaskImpl.class, subTask.getPrimaryKeyObj());
			}

			if (subTask != null) {
				session.delete(subTask);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subTask != null) {
			clearCache(subTask);
		}

		return subTask;
	}

	@Override
	public SubTask updateImpl(SubTask subTask) {
		boolean isNew = subTask.isNew();

		if (!(subTask instanceof SubTaskModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subTask.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subTask);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subTask proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubTask implementation " +
					subTask.getClass());
		}

		SubTaskModelImpl subTaskModelImpl = (SubTaskModelImpl)subTask;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (subTask.getCreateDate() == null)) {
			if (serviceContext == null) {
				subTask.setCreateDate(date);
			}
			else {
				subTask.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!subTaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subTask.setModifiedDate(date);
			}
			else {
				subTask.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subTask);
			}
			else {
				subTask = (SubTask)session.merge(subTask);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SubTaskImpl.class, subTaskModelImpl, false, true);

		if (isNew) {
			subTask.setNew(false);
		}

		subTask.resetOriginalValues();

		return subTask;
	}

	/**
	 * Returns the sub task with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub task
	 * @return the sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	@Override
	public SubTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubTaskException {

		SubTask subTask = fetchByPrimaryKey(primaryKey);

		if (subTask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubTaskException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subTask;
	}

	/**
	 * Returns the sub task with the primary key or throws a <code>NoSuchSubTaskException</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task
	 * @throws NoSuchSubTaskException if a sub task with the primary key could not be found
	 */
	@Override
	public SubTask findByPrimaryKey(long subTaskId)
		throws NoSuchSubTaskException {

		return findByPrimaryKey((Serializable)subTaskId);
	}

	/**
	 * Returns the sub task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task, or <code>null</code> if a sub task with the primary key could not be found
	 */
	@Override
	public SubTask fetchByPrimaryKey(long subTaskId) {
		return fetchByPrimaryKey((Serializable)subTaskId);
	}

	/**
	 * Returns all the sub tasks.
	 *
	 * @return the sub tasks
	 */
	@Override
	public List<SubTask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SubTask> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SubTask> findAll(
		int start, int end, OrderByComparator<SubTask> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SubTask> findAll(
		int start, int end, OrderByComparator<SubTask> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SubTask> list = null;

		if (useFinderCache) {
			list = (List<SubTask>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBTASK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBTASK;

				sql = sql.concat(SubTaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubTask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sub tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubTask subTask : findAll()) {
			remove(subTask);
		}
	}

	/**
	 * Returns the number of sub tasks.
	 *
	 * @return the number of sub tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBTASK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "subTaskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBTASK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubTaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sub task persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"taskId"}, true);

		_finderPathWithoutPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"}, true);

		_finderPathCountByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"},
			false);

		_finderPathWithPaginationFindByT_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"taskId", "deleted"}, true);

		_finderPathWithoutPaginationFindByT_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_D",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"taskId", "deleted"}, true);

		_finderPathCountByT_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_D",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"taskId", "deleted"}, false);

		SubTaskUtil.setPersistence(this);
	}

	public void destroy() {
		SubTaskUtil.setPersistence(null);

		entityCache.removeCache(SubTaskImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUBTASK =
		"SELECT subTask FROM SubTask subTask";

	private static final String _SQL_SELECT_SUBTASK_WHERE =
		"SELECT subTask FROM SubTask subTask WHERE ";

	private static final String _SQL_COUNT_SUBTASK =
		"SELECT COUNT(subTask) FROM SubTask subTask";

	private static final String _SQL_COUNT_SUBTASK_WHERE =
		"SELECT COUNT(subTask) FROM SubTask subTask WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subTask.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubTask exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SubTask exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SubTaskPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}