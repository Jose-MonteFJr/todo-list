/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.todo.list.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SubTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubTaskLocalService
 * @generated
 */
public class SubTaskLocalServiceWrapper
	implements ServiceWrapper<SubTaskLocalService>, SubTaskLocalService {

	public SubTaskLocalServiceWrapper() {
		this(null);
	}

	public SubTaskLocalServiceWrapper(SubTaskLocalService subTaskLocalService) {
		_subTaskLocalService = subTaskLocalService;
	}

	@Override
	public com.todo.list.model.SubTask addSubTask(
		long taskId, String title, int position) {

		return _subTaskLocalService.addSubTask(taskId, title, position);
	}

	/**
	 * Adds the sub task to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subTask the sub task
	 * @return the sub task that was added
	 */
	@Override
	public com.todo.list.model.SubTask addSubTask(
		com.todo.list.model.SubTask subTask) {

		return _subTaskLocalService.addSubTask(subTask);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sub task with the primary key. Does not add the sub task to the database.
	 *
	 * @param subTaskId the primary key for the new sub task
	 * @return the new sub task
	 */
	@Override
	public com.todo.list.model.SubTask createSubTask(long subTaskId) {
		return _subTaskLocalService.createSubTask(subTaskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sub task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task that was removed
	 * @throws PortalException if a sub task with the primary key could not be found
	 */
	@Override
	public com.todo.list.model.SubTask deleteSubTask(long subTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.deleteSubTask(subTaskId);
	}

	/**
	 * Deletes the sub task from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subTask the sub task
	 * @return the sub task that was removed
	 */
	@Override
	public com.todo.list.model.SubTask deleteSubTask(
		com.todo.list.model.SubTask subTask) {

		return _subTaskLocalService.deleteSubTask(subTask);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subTaskLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subTaskLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subTaskLocalService.dynamicQuery();
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

		return _subTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.SubTaskModelImpl</code>.
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

		return _subTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.SubTaskModelImpl</code>.
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

		return _subTaskLocalService.dynamicQuery(
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

		return _subTaskLocalService.dynamicQueryCount(dynamicQuery);
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

		return _subTaskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.todo.list.model.SubTask fetchSubTask(long subTaskId) {
		return _subTaskLocalService.fetchSubTask(subTaskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.todo.list.model.SubTask> getActiveSubTasks(
		long taskId) {

		return _subTaskLocalService.getActiveSubTasks(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subTaskLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sub task with the primary key.
	 *
	 * @param subTaskId the primary key of the sub task
	 * @return the sub task
	 * @throws PortalException if a sub task with the primary key could not be found
	 */
	@Override
	public com.todo.list.model.SubTask getSubTask(long subTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.getSubTask(subTaskId);
	}

	/**
	 * Returns a range of all the sub tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.todo.list.model.impl.SubTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub tasks
	 * @param end the upper bound of the range of sub tasks (not inclusive)
	 * @return the range of sub tasks
	 */
	@Override
	public java.util.List<com.todo.list.model.SubTask> getSubTasks(
		int start, int end) {

		return _subTaskLocalService.getSubTasks(start, end);
	}

	/**
	 * Returns the number of sub tasks.
	 *
	 * @return the number of sub tasks
	 */
	@Override
	public int getSubTasksCount() {
		return _subTaskLocalService.getSubTasksCount();
	}

	@Override
	public com.todo.list.model.SubTask toggleSubTaskStatus(long subTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.toggleSubTaskStatus(subTaskId);
	}

	@Override
	public com.todo.list.model.SubTask updateSubTask(
			long subTaskId, String title)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subTaskLocalService.updateSubTask(subTaskId, title);
	}

	/**
	 * Updates the sub task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subTask the sub task
	 * @return the sub task that was updated
	 */
	@Override
	public com.todo.list.model.SubTask updateSubTask(
		com.todo.list.model.SubTask subTask) {

		return _subTaskLocalService.updateSubTask(subTask);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _subTaskLocalService.getBasePersistence();
	}

	@Override
	public SubTaskLocalService getWrappedService() {
		return _subTaskLocalService;
	}

	@Override
	public void setWrappedService(SubTaskLocalService subTaskLocalService) {
		_subTaskLocalService = subTaskLocalService;
	}

	private SubTaskLocalService _subTaskLocalService;

}