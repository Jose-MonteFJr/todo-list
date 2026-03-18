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

import com.todo.list.exception.NoSuchTaskAttachmentException;
import com.todo.list.model.TaskAttachment;
import com.todo.list.model.TaskAttachmentTable;
import com.todo.list.model.impl.TaskAttachmentImpl;
import com.todo.list.model.impl.TaskAttachmentModelImpl;
import com.todo.list.service.persistence.TaskAttachmentPersistence;
import com.todo.list.service.persistence.TaskAttachmentUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the task attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskAttachmentPersistenceImpl
	extends BasePersistenceImpl<TaskAttachment>
	implements TaskAttachmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskAttachmentUtil</code> to access the task attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskAttachmentImpl.class.getName();

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
	 * Returns all the task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task attachments
	 */
	@Override
	public List<TaskAttachment> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskAttachment> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
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
	@Override
	public List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
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
	@Override
	public List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator,
		boolean useFinderCache) {

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

		List<TaskAttachment> list = null;

		if (useFinderCache) {
			list = (List<TaskAttachment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskAttachment taskAttachment : list) {
					if (taskId != taskAttachment.getTaskId()) {
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

			sb.append(_SQL_SELECT_TASKATTACHMENT_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<TaskAttachment>)QueryUtil.list(
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
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment findByTaskId_First(
			long taskId, OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = fetchByTaskId_First(
			taskId, orderByComparator);

		if (taskAttachment != null) {
			return taskAttachment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskAttachmentException(sb.toString());
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment fetchByTaskId_First(
		long taskId, OrderByComparator<TaskAttachment> orderByComparator) {

		List<TaskAttachment> list = findByTaskId(
			taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment findByTaskId_Last(
			long taskId, OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = fetchByTaskId_Last(
			taskId, orderByComparator);

		if (taskAttachment != null) {
			return taskAttachment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskAttachmentException(sb.toString());
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskAttachment> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<TaskAttachment> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskAttachment[] findByTaskId_PrevAndNext(
			long taskAttachmentId, long taskId,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = findByPrimaryKey(taskAttachmentId);

		Session session = null;

		try {
			session = openSession();

			TaskAttachment[] array = new TaskAttachmentImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, taskAttachment, taskId, orderByComparator, true);

			array[1] = taskAttachment;

			array[2] = getByTaskId_PrevAndNext(
				session, taskAttachment, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskAttachment getByTaskId_PrevAndNext(
		Session session, TaskAttachment taskAttachment, long taskId,
		OrderByComparator<TaskAttachment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKATTACHMENT_WHERE);

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
			sb.append(TaskAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						taskAttachment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskAttachment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task attachments where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (TaskAttachment taskAttachment :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskAttachment);
		}
	}

	/**
	 * Returns the number of task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task attachments
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKATTACHMENT_WHERE);

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
		"taskAttachment.taskId = ?";

	private FinderPath _finderPathWithPaginationFindByT_D;
	private FinderPath _finderPathWithoutPaginationFindByT_D;
	private FinderPath _finderPathCountByT_D;

	/**
	 * Returns all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the matching task attachments
	 */
	@Override
	public List<TaskAttachment> findByT_D(long taskId, boolean deleted) {
		return findByT_D(
			taskId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end) {

		return findByT_D(taskId, deleted, start, end, null);
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
	@Override
	public List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return findByT_D(taskId, deleted, start, end, orderByComparator, true);
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
	@Override
	public List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator,
		boolean useFinderCache) {

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

		List<TaskAttachment> list = null;

		if (useFinderCache) {
			list = (List<TaskAttachment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskAttachment taskAttachment : list) {
					if ((taskId != taskAttachment.getTaskId()) ||
						(deleted != taskAttachment.isDeleted())) {

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

			sb.append(_SQL_SELECT_TASKATTACHMENT_WHERE);

			sb.append(_FINDER_COLUMN_T_D_TASKID_2);

			sb.append(_FINDER_COLUMN_T_D_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				queryPos.add(deleted);

				list = (List<TaskAttachment>)QueryUtil.list(
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
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment findByT_D_First(
			long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = fetchByT_D_First(
			taskId, deleted, orderByComparator);

		if (taskAttachment != null) {
			return taskAttachment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchTaskAttachmentException(sb.toString());
	}

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment fetchByT_D_First(
		long taskId, boolean deleted,
		OrderByComparator<TaskAttachment> orderByComparator) {

		List<TaskAttachment> list = findByT_D(
			taskId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskAttachment findByT_D_Last(
			long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = fetchByT_D_Last(
			taskId, deleted, orderByComparator);

		if (taskAttachment != null) {
			return taskAttachment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchTaskAttachmentException(sb.toString());
	}

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	@Override
	public TaskAttachment fetchByT_D_Last(
		long taskId, boolean deleted,
		OrderByComparator<TaskAttachment> orderByComparator) {

		int count = countByT_D(taskId, deleted);

		if (count == 0) {
			return null;
		}

		List<TaskAttachment> list = findByT_D(
			taskId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskAttachment[] findByT_D_PrevAndNext(
			long taskAttachmentId, long taskId, boolean deleted,
			OrderByComparator<TaskAttachment> orderByComparator)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = findByPrimaryKey(taskAttachmentId);

		Session session = null;

		try {
			session = openSession();

			TaskAttachment[] array = new TaskAttachmentImpl[3];

			array[0] = getByT_D_PrevAndNext(
				session, taskAttachment, taskId, deleted, orderByComparator,
				true);

			array[1] = taskAttachment;

			array[2] = getByT_D_PrevAndNext(
				session, taskAttachment, taskId, deleted, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskAttachment getByT_D_PrevAndNext(
		Session session, TaskAttachment taskAttachment, long taskId,
		boolean deleted, OrderByComparator<TaskAttachment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASKATTACHMENT_WHERE);

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
			sb.append(TaskAttachmentModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						taskAttachment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskAttachment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task attachments where taskId = &#63; and deleted = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByT_D(long taskId, boolean deleted) {
		for (TaskAttachment taskAttachment :
				findByT_D(
					taskId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskAttachment);
		}
	}

	/**
	 * Returns the number of task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the number of matching task attachments
	 */
	@Override
	public int countByT_D(long taskId, boolean deleted) {
		FinderPath finderPath = _finderPathCountByT_D;

		Object[] finderArgs = new Object[] {taskId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKATTACHMENT_WHERE);

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
		"taskAttachment.taskId = ? AND ";

	private static final String _FINDER_COLUMN_T_D_DELETED_2 =
		"taskAttachment.deleted = ?";

	public TaskAttachmentPersistenceImpl() {
		setModelClass(TaskAttachment.class);

		setModelImplClass(TaskAttachmentImpl.class);
		setModelPKClass(long.class);

		setTable(TaskAttachmentTable.INSTANCE);
	}

	/**
	 * Caches the task attachment in the entity cache if it is enabled.
	 *
	 * @param taskAttachment the task attachment
	 */
	@Override
	public void cacheResult(TaskAttachment taskAttachment) {
		entityCache.putResult(
			TaskAttachmentImpl.class, taskAttachment.getPrimaryKey(),
			taskAttachment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the task attachments in the entity cache if it is enabled.
	 *
	 * @param taskAttachments the task attachments
	 */
	@Override
	public void cacheResult(List<TaskAttachment> taskAttachments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (taskAttachments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TaskAttachment taskAttachment : taskAttachments) {
			if (entityCache.getResult(
					TaskAttachmentImpl.class, taskAttachment.getPrimaryKey()) ==
						null) {

				cacheResult(taskAttachment);
			}
		}
	}

	/**
	 * Clears the cache for all task attachments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskAttachmentImpl.class);

		finderCache.clearCache(TaskAttachmentImpl.class);
	}

	/**
	 * Clears the cache for the task attachment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskAttachment taskAttachment) {
		entityCache.removeResult(TaskAttachmentImpl.class, taskAttachment);
	}

	@Override
	public void clearCache(List<TaskAttachment> taskAttachments) {
		for (TaskAttachment taskAttachment : taskAttachments) {
			entityCache.removeResult(TaskAttachmentImpl.class, taskAttachment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TaskAttachmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TaskAttachmentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new task attachment with the primary key. Does not add the task attachment to the database.
	 *
	 * @param taskAttachmentId the primary key for the new task attachment
	 * @return the new task attachment
	 */
	@Override
	public TaskAttachment create(long taskAttachmentId) {
		TaskAttachment taskAttachment = new TaskAttachmentImpl();

		taskAttachment.setNew(true);
		taskAttachment.setPrimaryKey(taskAttachmentId);

		return taskAttachment;
	}

	/**
	 * Removes the task attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment that was removed
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	@Override
	public TaskAttachment remove(long taskAttachmentId)
		throws NoSuchTaskAttachmentException {

		return remove((Serializable)taskAttachmentId);
	}

	/**
	 * Removes the task attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task attachment
	 * @return the task attachment that was removed
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	@Override
	public TaskAttachment remove(Serializable primaryKey)
		throws NoSuchTaskAttachmentException {

		Session session = null;

		try {
			session = openSession();

			TaskAttachment taskAttachment = (TaskAttachment)session.get(
				TaskAttachmentImpl.class, primaryKey);

			if (taskAttachment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskAttachmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taskAttachment);
		}
		catch (NoSuchTaskAttachmentException noSuchEntityException) {
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
	protected TaskAttachment removeImpl(TaskAttachment taskAttachment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskAttachment)) {
				taskAttachment = (TaskAttachment)session.get(
					TaskAttachmentImpl.class,
					taskAttachment.getPrimaryKeyObj());
			}

			if (taskAttachment != null) {
				session.delete(taskAttachment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (taskAttachment != null) {
			clearCache(taskAttachment);
		}

		return taskAttachment;
	}

	@Override
	public TaskAttachment updateImpl(TaskAttachment taskAttachment) {
		boolean isNew = taskAttachment.isNew();

		if (!(taskAttachment instanceof TaskAttachmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taskAttachment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					taskAttachment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taskAttachment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaskAttachment implementation " +
					taskAttachment.getClass());
		}

		TaskAttachmentModelImpl taskAttachmentModelImpl =
			(TaskAttachmentModelImpl)taskAttachment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (taskAttachment.getCreateDate() == null)) {
			if (serviceContext == null) {
				taskAttachment.setCreateDate(date);
			}
			else {
				taskAttachment.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!taskAttachmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taskAttachment.setModifiedDate(date);
			}
			else {
				taskAttachment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(taskAttachment);
			}
			else {
				taskAttachment = (TaskAttachment)session.merge(taskAttachment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TaskAttachmentImpl.class, taskAttachmentModelImpl, false, true);

		if (isNew) {
			taskAttachment.setNew(false);
		}

		taskAttachment.resetOriginalValues();

		return taskAttachment;
	}

	/**
	 * Returns the task attachment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task attachment
	 * @return the task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	@Override
	public TaskAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskAttachmentException {

		TaskAttachment taskAttachment = fetchByPrimaryKey(primaryKey);

		if (taskAttachment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskAttachmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taskAttachment;
	}

	/**
	 * Returns the task attachment with the primary key or throws a <code>NoSuchTaskAttachmentException</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	@Override
	public TaskAttachment findByPrimaryKey(long taskAttachmentId)
		throws NoSuchTaskAttachmentException {

		return findByPrimaryKey((Serializable)taskAttachmentId);
	}

	/**
	 * Returns the task attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment, or <code>null</code> if a task attachment with the primary key could not be found
	 */
	@Override
	public TaskAttachment fetchByPrimaryKey(long taskAttachmentId) {
		return fetchByPrimaryKey((Serializable)taskAttachmentId);
	}

	/**
	 * Returns all the task attachments.
	 *
	 * @return the task attachments
	 */
	@Override
	public List<TaskAttachment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskAttachment> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TaskAttachment> findAll(
		int start, int end,
		OrderByComparator<TaskAttachment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TaskAttachment> findAll(
		int start, int end, OrderByComparator<TaskAttachment> orderByComparator,
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

		List<TaskAttachment> list = null;

		if (useFinderCache) {
			list = (List<TaskAttachment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASKATTACHMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASKATTACHMENT;

				sql = sql.concat(TaskAttachmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TaskAttachment>)QueryUtil.list(
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
	 * Removes all the task attachments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskAttachment taskAttachment : findAll()) {
			remove(taskAttachment);
		}
	}

	/**
	 * Returns the number of task attachments.
	 *
	 * @return the number of task attachments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASKATTACHMENT);

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
		return "taskAttachmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKATTACHMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskAttachmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task attachment persistence.
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

		TaskAttachmentUtil.setPersistence(this);
	}

	public void destroy() {
		TaskAttachmentUtil.setPersistence(null);

		entityCache.removeCache(TaskAttachmentImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TASKATTACHMENT =
		"SELECT taskAttachment FROM TaskAttachment taskAttachment";

	private static final String _SQL_SELECT_TASKATTACHMENT_WHERE =
		"SELECT taskAttachment FROM TaskAttachment taskAttachment WHERE ";

	private static final String _SQL_COUNT_TASKATTACHMENT =
		"SELECT COUNT(taskAttachment) FROM TaskAttachment taskAttachment";

	private static final String _SQL_COUNT_TASKATTACHMENT_WHERE =
		"SELECT COUNT(taskAttachment) FROM TaskAttachment taskAttachment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taskAttachment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaskAttachment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaskAttachment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskAttachmentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}