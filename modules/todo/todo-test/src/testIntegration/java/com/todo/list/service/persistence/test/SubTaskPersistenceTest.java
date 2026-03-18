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

import com.todo.list.exception.NoSuchSubTaskException;
import com.todo.list.model.SubTask;
import com.todo.list.service.SubTaskLocalServiceUtil;
import com.todo.list.service.persistence.SubTaskPersistence;
import com.todo.list.service.persistence.SubTaskUtil;

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
public class SubTaskPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.todo.list.service"));

	@Before
	public void setUp() {
		_persistence = SubTaskUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SubTask> iterator = _subTasks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubTask subTask = _persistence.create(pk);

		Assert.assertNotNull(subTask);

		Assert.assertEquals(subTask.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SubTask newSubTask = addSubTask();

		_persistence.remove(newSubTask);

		SubTask existingSubTask = _persistence.fetchByPrimaryKey(
			newSubTask.getPrimaryKey());

		Assert.assertNull(existingSubTask);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubTask();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubTask newSubTask = _persistence.create(pk);

		newSubTask.setTaskId(RandomTestUtil.nextLong());

		newSubTask.setTitle(RandomTestUtil.randomString());

		newSubTask.setCompleted(RandomTestUtil.randomBoolean());

		newSubTask.setDeleted(RandomTestUtil.randomBoolean());

		newSubTask.setPosition(RandomTestUtil.nextInt());

		newSubTask.setCreateDate(RandomTestUtil.nextDate());

		newSubTask.setModifiedDate(RandomTestUtil.nextDate());

		_subTasks.add(_persistence.update(newSubTask));

		SubTask existingSubTask = _persistence.findByPrimaryKey(
			newSubTask.getPrimaryKey());

		Assert.assertEquals(
			existingSubTask.getSubTaskId(), newSubTask.getSubTaskId());
		Assert.assertEquals(
			existingSubTask.getTaskId(), newSubTask.getTaskId());
		Assert.assertEquals(existingSubTask.getTitle(), newSubTask.getTitle());
		Assert.assertEquals(
			existingSubTask.isCompleted(), newSubTask.isCompleted());
		Assert.assertEquals(
			existingSubTask.isDeleted(), newSubTask.isDeleted());
		Assert.assertEquals(
			existingSubTask.getPosition(), newSubTask.getPosition());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubTask.getCreateDate()),
			Time.getShortTimestamp(newSubTask.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubTask.getModifiedDate()),
			Time.getShortTimestamp(newSubTask.getModifiedDate()));
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
		SubTask newSubTask = addSubTask();

		SubTask existingSubTask = _persistence.findByPrimaryKey(
			newSubTask.getPrimaryKey());

		Assert.assertEquals(existingSubTask, newSubTask);
	}

	@Test(expected = NoSuchSubTaskException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SubTask> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Todo_SubTask", "subTaskId", true, "taskId", true, "title", true,
			"completed", true, "deleted", true, "position", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SubTask newSubTask = addSubTask();

		SubTask existingSubTask = _persistence.fetchByPrimaryKey(
			newSubTask.getPrimaryKey());

		Assert.assertEquals(existingSubTask, newSubTask);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubTask missingSubTask = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubTask);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SubTask newSubTask1 = addSubTask();
		SubTask newSubTask2 = addSubTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubTask1.getPrimaryKey());
		primaryKeys.add(newSubTask2.getPrimaryKey());

		Map<Serializable, SubTask> subTasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, subTasks.size());
		Assert.assertEquals(
			newSubTask1, subTasks.get(newSubTask1.getPrimaryKey()));
		Assert.assertEquals(
			newSubTask2, subTasks.get(newSubTask2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SubTask> subTasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subTasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SubTask newSubTask = addSubTask();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubTask.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SubTask> subTasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subTasks.size());
		Assert.assertEquals(
			newSubTask, subTasks.get(newSubTask.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SubTask> subTasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subTasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SubTask newSubTask = addSubTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubTask.getPrimaryKey());

		Map<Serializable, SubTask> subTasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subTasks.size());
		Assert.assertEquals(
			newSubTask, subTasks.get(newSubTask.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SubTaskLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SubTask>() {

				@Override
				public void performAction(SubTask subTask) {
					Assert.assertNotNull(subTask);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SubTask newSubTask = addSubTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubTask.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("subTaskId", newSubTask.getSubTaskId()));

		List<SubTask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		SubTask existingSubTask = result.get(0);

		Assert.assertEquals(existingSubTask, newSubTask);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubTask.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("subTaskId", RandomTestUtil.nextLong()));

		List<SubTask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SubTask newSubTask = addSubTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubTask.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("subTaskId"));

		Object newSubTaskId = newSubTask.getSubTaskId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subTaskId", new Object[] {newSubTaskId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSubTaskId = result.get(0);

		Assert.assertEquals(existingSubTaskId, newSubTaskId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubTask.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("subTaskId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subTaskId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SubTask addSubTask() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubTask subTask = _persistence.create(pk);

		subTask.setTaskId(RandomTestUtil.nextLong());

		subTask.setTitle(RandomTestUtil.randomString());

		subTask.setCompleted(RandomTestUtil.randomBoolean());

		subTask.setDeleted(RandomTestUtil.randomBoolean());

		subTask.setPosition(RandomTestUtil.nextInt());

		subTask.setCreateDate(RandomTestUtil.nextDate());

		subTask.setModifiedDate(RandomTestUtil.nextDate());

		_subTasks.add(_persistence.update(subTask));

		return subTask;
	}

	private List<SubTask> _subTasks = new ArrayList<SubTask>();
	private SubTaskPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}