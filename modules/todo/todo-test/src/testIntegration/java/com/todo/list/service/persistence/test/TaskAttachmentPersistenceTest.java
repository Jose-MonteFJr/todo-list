/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.todo.list.exception.NoSuchTaskAttachmentException;
import com.todo.list.model.TaskAttachment;
import com.todo.list.service.TaskAttachmentLocalServiceUtil;
import com.todo.list.service.persistence.TaskAttachmentPersistence;
import com.todo.list.service.persistence.TaskAttachmentUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class TaskAttachmentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.todo.list.service"));

	@Before
	public void setUp() {
		_persistence = TaskAttachmentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TaskAttachment> iterator = _taskAttachments.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskAttachment taskAttachment = _persistence.create(pk);

		Assert.assertNotNull(taskAttachment);

		Assert.assertEquals(taskAttachment.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		_persistence.remove(newTaskAttachment);

		TaskAttachment existingTaskAttachment = _persistence.fetchByPrimaryKey(
			newTaskAttachment.getPrimaryKey());

		Assert.assertNull(existingTaskAttachment);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTaskAttachment();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskAttachment newTaskAttachment = _persistence.create(pk);

		newTaskAttachment.setTaskId(RandomTestUtil.nextLong());

		newTaskAttachment.setFileEntryId(RandomTestUtil.nextLong());

		newTaskAttachment.setCreateDate(RandomTestUtil.nextDate());

		newTaskAttachment.setModifiedDate(RandomTestUtil.nextDate());

		newTaskAttachment.setDeleted(RandomTestUtil.randomBoolean());

		_taskAttachments.add(_persistence.update(newTaskAttachment));

		TaskAttachment existingTaskAttachment = _persistence.findByPrimaryKey(
			newTaskAttachment.getPrimaryKey());

		Assert.assertEquals(
			existingTaskAttachment.getTaskAttachmentId(),
			newTaskAttachment.getTaskAttachmentId());
		Assert.assertEquals(
			existingTaskAttachment.getTaskId(), newTaskAttachment.getTaskId());
		Assert.assertEquals(
			existingTaskAttachment.getFileEntryId(),
			newTaskAttachment.getFileEntryId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTaskAttachment.getCreateDate()),
			Time.getShortTimestamp(newTaskAttachment.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTaskAttachment.getModifiedDate()),
			Time.getShortTimestamp(newTaskAttachment.getModifiedDate()));
		Assert.assertEquals(
			existingTaskAttachment.isDeleted(), newTaskAttachment.isDeleted());
	}

	@Test
	public void testCountByTaskId() throws Exception {
		_persistence.countByTaskId(RandomTestUtil.nextLong());

		_persistence.countByTaskId(0L);
	}

	@Test
	public void testCountByT_D() throws Exception {
		_persistence.countByT_D(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByT_D(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		TaskAttachment existingTaskAttachment = _persistence.findByPrimaryKey(
			newTaskAttachment.getPrimaryKey());

		Assert.assertEquals(existingTaskAttachment, newTaskAttachment);
	}

	@Test(expected = NoSuchTaskAttachmentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<TaskAttachment> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Todo_TaskAttachment", "taskAttachmentId", true, "taskId", true,
			"fileEntryId", true, "createDate", true, "modifiedDate", true,
			"deleted", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		TaskAttachment existingTaskAttachment = _persistence.fetchByPrimaryKey(
			newTaskAttachment.getPrimaryKey());

		Assert.assertEquals(existingTaskAttachment, newTaskAttachment);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskAttachment missingTaskAttachment = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingTaskAttachment);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TaskAttachment newTaskAttachment1 = addTaskAttachment();
		TaskAttachment newTaskAttachment2 = addTaskAttachment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskAttachment1.getPrimaryKey());
		primaryKeys.add(newTaskAttachment2.getPrimaryKey());

		Map<Serializable, TaskAttachment> taskAttachments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, taskAttachments.size());
		Assert.assertEquals(
			newTaskAttachment1,
			taskAttachments.get(newTaskAttachment1.getPrimaryKey()));
		Assert.assertEquals(
			newTaskAttachment2,
			taskAttachments.get(newTaskAttachment2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TaskAttachment> taskAttachments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(taskAttachments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TaskAttachment newTaskAttachment = addTaskAttachment();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskAttachment.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TaskAttachment> taskAttachments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, taskAttachments.size());
		Assert.assertEquals(
			newTaskAttachment,
			taskAttachments.get(newTaskAttachment.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TaskAttachment> taskAttachments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(taskAttachments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskAttachment.getPrimaryKey());

		Map<Serializable, TaskAttachment> taskAttachments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, taskAttachments.size());
		Assert.assertEquals(
			newTaskAttachment,
			taskAttachments.get(newTaskAttachment.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TaskAttachmentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TaskAttachment>() {

				@Override
				public void performAction(TaskAttachment taskAttachment) {
					Assert.assertNotNull(taskAttachment);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TaskAttachment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"taskAttachmentId", newTaskAttachment.getTaskAttachmentId()));

		List<TaskAttachment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		TaskAttachment existingTaskAttachment = result.get(0);

		Assert.assertEquals(existingTaskAttachment, newTaskAttachment);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TaskAttachment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"taskAttachmentId", RandomTestUtil.nextLong()));

		List<TaskAttachment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TaskAttachment newTaskAttachment = addTaskAttachment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TaskAttachment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("taskAttachmentId"));

		Object newTaskAttachmentId = newTaskAttachment.getTaskAttachmentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"taskAttachmentId", new Object[] {newTaskAttachmentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTaskAttachmentId = result.get(0);

		Assert.assertEquals(existingTaskAttachmentId, newTaskAttachmentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TaskAttachment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("taskAttachmentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"taskAttachmentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected TaskAttachment addTaskAttachment() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskAttachment taskAttachment = _persistence.create(pk);

		taskAttachment.setTaskId(RandomTestUtil.nextLong());

		taskAttachment.setFileEntryId(RandomTestUtil.nextLong());

		taskAttachment.setCreateDate(RandomTestUtil.nextDate());

		taskAttachment.setModifiedDate(RandomTestUtil.nextDate());

		taskAttachment.setDeleted(RandomTestUtil.randomBoolean());

		_taskAttachments.add(_persistence.update(taskAttachment));

		return taskAttachment;
	}

	private List<TaskAttachment> _taskAttachments =
		new ArrayList<TaskAttachment>();
	private TaskAttachmentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}