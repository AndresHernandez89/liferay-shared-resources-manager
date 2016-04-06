/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.rivetlogic.assetmanagement.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rivetlogic.assetmanagement.model.AssetMessage;
import com.rivetlogic.assetmanagement.service.AssetMessageLocalService;
import com.rivetlogic.assetmanagement.service.persistence.AssetCategoryPersistence;
import com.rivetlogic.assetmanagement.service.persistence.AssetLocationPersistence;
import com.rivetlogic.assetmanagement.service.persistence.AssetMessagePersistence;
import com.rivetlogic.assetmanagement.service.persistence.AssetPersistence;
import com.rivetlogic.assetmanagement.service.persistence.AssetRequestPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the asset message local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.assetmanagement.service.impl.AssetMessageLocalServiceImpl}.
 * </p>
 *
 * @author Manrique Varela
 * @see com.rivetlogic.assetmanagement.service.impl.AssetMessageLocalServiceImpl
 * @see com.rivetlogic.assetmanagement.service.AssetMessageLocalServiceUtil
 * @generated
 */
public abstract class AssetMessageLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AssetMessageLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.assetmanagement.service.AssetMessageLocalServiceUtil} to access the asset message local service.
	 */

	/**
	 * Adds the asset message to the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetMessage the asset message
	 * @return the asset message that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssetMessage addAssetMessage(AssetMessage assetMessage)
		throws SystemException {
		assetMessage.setNew(true);

		return assetMessagePersistence.update(assetMessage);
	}

	/**
	 * Creates a new asset message with the primary key. Does not add the asset message to the database.
	 *
	 * @param assetMessageId the primary key for the new asset message
	 * @return the new asset message
	 */
	@Override
	public AssetMessage createAssetMessage(long assetMessageId) {
		return assetMessagePersistence.create(assetMessageId);
	}

	/**
	 * Deletes the asset message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetMessageId the primary key of the asset message
	 * @return the asset message that was removed
	 * @throws PortalException if a asset message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssetMessage deleteAssetMessage(long assetMessageId)
		throws PortalException, SystemException {
		return assetMessagePersistence.remove(assetMessageId);
	}

	/**
	 * Deletes the asset message from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetMessage the asset message
	 * @return the asset message that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssetMessage deleteAssetMessage(AssetMessage assetMessage)
		throws SystemException {
		return assetMessagePersistence.remove(assetMessage);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AssetMessage.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return assetMessagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return assetMessagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return assetMessagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return assetMessagePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return assetMessagePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AssetMessage fetchAssetMessage(long assetMessageId)
		throws SystemException {
		return assetMessagePersistence.fetchByPrimaryKey(assetMessageId);
	}

	/**
	 * Returns the asset message with the matching UUID and company.
	 *
	 * @param uuid the asset message's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching asset message, or <code>null</code> if a matching asset message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AssetMessage fetchAssetMessageByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return assetMessagePersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the asset message matching the UUID and group.
	 *
	 * @param uuid the asset message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching asset message, or <code>null</code> if a matching asset message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AssetMessage fetchAssetMessageByUuidAndGroupId(String uuid,
		long groupId) throws SystemException {
		return assetMessagePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the asset message with the primary key.
	 *
	 * @param assetMessageId the primary key of the asset message
	 * @return the asset message
	 * @throws PortalException if a asset message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AssetMessage getAssetMessage(long assetMessageId)
		throws PortalException, SystemException {
		return assetMessagePersistence.findByPrimaryKey(assetMessageId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return assetMessagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the asset message with the matching UUID and company.
	 *
	 * @param uuid the asset message's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching asset message
	 * @throws PortalException if a matching asset message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AssetMessage getAssetMessageByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return assetMessagePersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the asset message matching the UUID and group.
	 *
	 * @param uuid the asset message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching asset message
	 * @throws PortalException if a matching asset message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AssetMessage getAssetMessageByUuidAndGroupId(String uuid,
		long groupId) throws PortalException, SystemException {
		return assetMessagePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the asset messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of asset messages
	 * @param end the upper bound of the range of asset messages (not inclusive)
	 * @return the range of asset messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AssetMessage> getAssetMessages(int start, int end)
		throws SystemException {
		return assetMessagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of asset messages.
	 *
	 * @return the number of asset messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getAssetMessagesCount() throws SystemException {
		return assetMessagePersistence.countAll();
	}

	/**
	 * Updates the asset message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param assetMessage the asset message
	 * @return the asset message that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssetMessage updateAssetMessage(AssetMessage assetMessage)
		throws SystemException {
		return assetMessagePersistence.update(assetMessage);
	}

	/**
	 * Returns the asset local service.
	 *
	 * @return the asset local service
	 */
	public com.rivetlogic.assetmanagement.service.AssetLocalService getAssetLocalService() {
		return assetLocalService;
	}

	/**
	 * Sets the asset local service.
	 *
	 * @param assetLocalService the asset local service
	 */
	public void setAssetLocalService(
		com.rivetlogic.assetmanagement.service.AssetLocalService assetLocalService) {
		this.assetLocalService = assetLocalService;
	}

	/**
	 * Returns the asset persistence.
	 *
	 * @return the asset persistence
	 */
	public AssetPersistence getAssetPersistence() {
		return assetPersistence;
	}

	/**
	 * Sets the asset persistence.
	 *
	 * @param assetPersistence the asset persistence
	 */
	public void setAssetPersistence(AssetPersistence assetPersistence) {
		this.assetPersistence = assetPersistence;
	}

	/**
	 * Returns the asset category local service.
	 *
	 * @return the asset category local service
	 */
	public com.rivetlogic.assetmanagement.service.AssetCategoryLocalService getAssetCategoryLocalService() {
		return assetCategoryLocalService;
	}

	/**
	 * Sets the asset category local service.
	 *
	 * @param assetCategoryLocalService the asset category local service
	 */
	public void setAssetCategoryLocalService(
		com.rivetlogic.assetmanagement.service.AssetCategoryLocalService assetCategoryLocalService) {
		this.assetCategoryLocalService = assetCategoryLocalService;
	}

	/**
	 * Returns the asset category persistence.
	 *
	 * @return the asset category persistence
	 */
	public AssetCategoryPersistence getAssetCategoryPersistence() {
		return assetCategoryPersistence;
	}

	/**
	 * Sets the asset category persistence.
	 *
	 * @param assetCategoryPersistence the asset category persistence
	 */
	public void setAssetCategoryPersistence(
		AssetCategoryPersistence assetCategoryPersistence) {
		this.assetCategoryPersistence = assetCategoryPersistence;
	}

	/**
	 * Returns the asset location local service.
	 *
	 * @return the asset location local service
	 */
	public com.rivetlogic.assetmanagement.service.AssetLocationLocalService getAssetLocationLocalService() {
		return assetLocationLocalService;
	}

	/**
	 * Sets the asset location local service.
	 *
	 * @param assetLocationLocalService the asset location local service
	 */
	public void setAssetLocationLocalService(
		com.rivetlogic.assetmanagement.service.AssetLocationLocalService assetLocationLocalService) {
		this.assetLocationLocalService = assetLocationLocalService;
	}

	/**
	 * Returns the asset location persistence.
	 *
	 * @return the asset location persistence
	 */
	public AssetLocationPersistence getAssetLocationPersistence() {
		return assetLocationPersistence;
	}

	/**
	 * Sets the asset location persistence.
	 *
	 * @param assetLocationPersistence the asset location persistence
	 */
	public void setAssetLocationPersistence(
		AssetLocationPersistence assetLocationPersistence) {
		this.assetLocationPersistence = assetLocationPersistence;
	}

	/**
	 * Returns the asset message local service.
	 *
	 * @return the asset message local service
	 */
	public com.rivetlogic.assetmanagement.service.AssetMessageLocalService getAssetMessageLocalService() {
		return assetMessageLocalService;
	}

	/**
	 * Sets the asset message local service.
	 *
	 * @param assetMessageLocalService the asset message local service
	 */
	public void setAssetMessageLocalService(
		com.rivetlogic.assetmanagement.service.AssetMessageLocalService assetMessageLocalService) {
		this.assetMessageLocalService = assetMessageLocalService;
	}

	/**
	 * Returns the asset message persistence.
	 *
	 * @return the asset message persistence
	 */
	public AssetMessagePersistence getAssetMessagePersistence() {
		return assetMessagePersistence;
	}

	/**
	 * Sets the asset message persistence.
	 *
	 * @param assetMessagePersistence the asset message persistence
	 */
	public void setAssetMessagePersistence(
		AssetMessagePersistence assetMessagePersistence) {
		this.assetMessagePersistence = assetMessagePersistence;
	}

	/**
	 * Returns the asset request local service.
	 *
	 * @return the asset request local service
	 */
	public com.rivetlogic.assetmanagement.service.AssetRequestLocalService getAssetRequestLocalService() {
		return assetRequestLocalService;
	}

	/**
	 * Sets the asset request local service.
	 *
	 * @param assetRequestLocalService the asset request local service
	 */
	public void setAssetRequestLocalService(
		com.rivetlogic.assetmanagement.service.AssetRequestLocalService assetRequestLocalService) {
		this.assetRequestLocalService = assetRequestLocalService;
	}

	/**
	 * Returns the asset request persistence.
	 *
	 * @return the asset request persistence
	 */
	public AssetRequestPersistence getAssetRequestPersistence() {
		return assetRequestPersistence;
	}

	/**
	 * Sets the asset request persistence.
	 *
	 * @param assetRequestPersistence the asset request persistence
	 */
	public void setAssetRequestPersistence(
		AssetRequestPersistence assetRequestPersistence) {
		this.assetRequestPersistence = assetRequestPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rivetlogic.assetmanagement.model.AssetMessage",
			assetMessageLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rivetlogic.assetmanagement.model.AssetMessage");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return AssetMessage.class;
	}

	protected String getModelClassName() {
		return AssetMessage.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = assetMessagePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.assetmanagement.service.AssetLocalService.class)
	protected com.rivetlogic.assetmanagement.service.AssetLocalService assetLocalService;
	@BeanReference(type = AssetPersistence.class)
	protected AssetPersistence assetPersistence;
	@BeanReference(type = com.rivetlogic.assetmanagement.service.AssetCategoryLocalService.class)
	protected com.rivetlogic.assetmanagement.service.AssetCategoryLocalService assetCategoryLocalService;
	@BeanReference(type = AssetCategoryPersistence.class)
	protected AssetCategoryPersistence assetCategoryPersistence;
	@BeanReference(type = com.rivetlogic.assetmanagement.service.AssetLocationLocalService.class)
	protected com.rivetlogic.assetmanagement.service.AssetLocationLocalService assetLocationLocalService;
	@BeanReference(type = AssetLocationPersistence.class)
	protected AssetLocationPersistence assetLocationPersistence;
	@BeanReference(type = com.rivetlogic.assetmanagement.service.AssetMessageLocalService.class)
	protected com.rivetlogic.assetmanagement.service.AssetMessageLocalService assetMessageLocalService;
	@BeanReference(type = AssetMessagePersistence.class)
	protected AssetMessagePersistence assetMessagePersistence;
	@BeanReference(type = com.rivetlogic.assetmanagement.service.AssetRequestLocalService.class)
	protected com.rivetlogic.assetmanagement.service.AssetRequestLocalService assetRequestLocalService;
	@BeanReference(type = AssetRequestPersistence.class)
	protected AssetRequestPersistence assetRequestPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AssetMessageLocalServiceClpInvoker _clpInvoker = new AssetMessageLocalServiceClpInvoker();
}