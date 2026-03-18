/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.todo.list.exception.NoSuchTaskAttachmentException;
import com.todo.list.model.TaskAttachment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskAttachmentUtil
 * @generated
 */
@ProviderType
public interface TaskAttachmentPersistence
	extends BasePersistence<TaskAttachment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskAttachmentUtil} to access the task attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task attachments
	 */
	public java.util.List<TaskAttachment> findByTaskId(long taskId);

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
	public java.util.List<TaskAttachment> findByTaskId(
		long taskId, int start, int end);

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
	public java.util.List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

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
	public java.util.List<TaskAttachment> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public TaskAttachment findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public TaskAttachment fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public TaskAttachment findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public TaskAttachment fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

	/**
	 * Returns the task attachments before and after the current task attachment in the ordered set where taskId = &#63;.
	 *
	 * @param taskAttachmentId the primary key of the current task attachment
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public TaskAttachment[] findByTaskId_PrevAndNext(
			long taskAttachmentId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Removes all the task attachments where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of task attachments where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task attachments
	 */
	public int countByTaskId(long taskId);

	/**
	 * Returns all the task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the matching task attachments
	 */
	public java.util.List<TaskAttachment> findByT_D(
		long taskId, boolean deleted);

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
	public java.util.List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end);

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
	public java.util.List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

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
	public java.util.List<TaskAttachment> findByT_D(
		long taskId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public TaskAttachment findByT_D_First(
			long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Returns the first task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public TaskAttachment fetchByT_D_First(
		long taskId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment
	 * @throws NoSuchTaskAttachmentException if a matching task attachment could not be found
	 */
	public TaskAttachment findByT_D_Last(
			long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Returns the last task attachment in the ordered set where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task attachment, or <code>null</code> if a matching task attachment could not be found
	 */
	public TaskAttachment fetchByT_D_Last(
		long taskId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

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
	public TaskAttachment[] findByT_D_PrevAndNext(
			long taskAttachmentId, long taskId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
				orderByComparator)
		throws NoSuchTaskAttachmentException;

	/**
	 * Removes all the task attachments where taskId = &#63; and deleted = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 */
	public void removeByT_D(long taskId, boolean deleted);

	/**
	 * Returns the number of task attachments where taskId = &#63; and deleted = &#63;.
	 *
	 * @param taskId the task ID
	 * @param deleted the deleted
	 * @return the number of matching task attachments
	 */
	public int countByT_D(long taskId, boolean deleted);

	/**
	 * Caches the task attachment in the entity cache if it is enabled.
	 *
	 * @param taskAttachment the task attachment
	 */
	public void cacheResult(TaskAttachment taskAttachment);

	/**
	 * Caches the task attachments in the entity cache if it is enabled.
	 *
	 * @param taskAttachments the task attachments
	 */
	public void cacheResult(java.util.List<TaskAttachment> taskAttachments);

	/**
	 * Creates a new task attachment with the primary key. Does not add the task attachment to the database.
	 *
	 * @param taskAttachmentId the primary key for the new task attachment
	 * @return the new task attachment
	 */
	public TaskAttachment create(long taskAttachmentId);

	/**
	 * Removes the task attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment that was removed
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public TaskAttachment remove(long taskAttachmentId)
		throws NoSuchTaskAttachmentException;

	public TaskAttachment updateImpl(TaskAttachment taskAttachment);

	/**
	 * Returns the task attachment with the primary key or throws a <code>NoSuchTaskAttachmentException</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment
	 * @throws NoSuchTaskAttachmentException if a task attachment with the primary key could not be found
	 */
	public TaskAttachment findByPrimaryKey(long taskAttachmentId)
		throws NoSuchTaskAttachmentException;

	/**
	 * Returns the task attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskAttachmentId the primary key of the task attachment
	 * @return the task attachment, or <code>null</code> if a task attachment with the primary key could not be found
	 */
	public TaskAttachment fetchByPrimaryKey(long taskAttachmentId);

	/**
	 * Returns all the task attachments.
	 *
	 * @return the task attachments
	 */
	public java.util.List<TaskAttachment> findAll();

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
	public java.util.List<TaskAttachment> findAll(int start, int end);

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
	public java.util.List<TaskAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator);

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
	public java.util.List<TaskAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskAttachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the task attachments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task attachments.
	 *
	 * @return the number of task attachments
	 */
	public int countAll();

}