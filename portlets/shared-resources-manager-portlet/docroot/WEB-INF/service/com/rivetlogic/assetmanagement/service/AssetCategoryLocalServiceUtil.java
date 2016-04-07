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

package com.rivetlogic.assetmanagement.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AssetCategory. This utility wraps
 * {@link com.rivetlogic.assetmanagement.service.impl.AssetCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Manrique Varela
 * @see AssetCategoryLocalService
 * @see com.rivetlogic.assetmanagement.service.base.AssetCategoryLocalServiceBaseImpl
 * @see com.rivetlogic.assetmanagement.service.impl.AssetCategoryLocalServiceImpl
 * @generated
 */
public class AssetCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.assetmanagement.service.impl.AssetCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the asset category to the database. Also notifies the appropriate model listeners.
	*
	* @param assetCategory the asset category
	* @return the asset category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory addAssetCategory(
		com.rivetlogic.assetmanagement.model.AssetCategory assetCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAssetCategory(assetCategory);
	}

	/**
	* Creates a new asset category with the primary key. Does not add the asset category to the database.
	*
	* @param assetCategoryId the primary key for the new asset category
	* @return the new asset category
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory createAssetCategory(
		long assetCategoryId) {
		return getService().createAssetCategory(assetCategoryId);
	}

	/**
	* Deletes the asset category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetCategoryId the primary key of the asset category
	* @return the asset category that was removed
	* @throws PortalException if a asset category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory deleteAssetCategory(
		long assetCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAssetCategory(assetCategoryId);
	}

	/**
	* Deletes the asset category from the database. Also notifies the appropriate model listeners.
	*
	* @param assetCategory the asset category
	* @return the asset category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory deleteAssetCategory(
		com.rivetlogic.assetmanagement.model.AssetCategory assetCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAssetCategory(assetCategory);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.assetmanagement.model.AssetCategory fetchAssetCategory(
		long assetCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssetCategory(assetCategoryId);
	}

	/**
	* Returns the asset category with the matching UUID and company.
	*
	* @param uuid the asset category's UUID
	* @param companyId the primary key of the company
	* @return the matching asset category, or <code>null</code> if a matching asset category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory fetchAssetCategoryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssetCategoryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the asset category matching the UUID and group.
	*
	* @param uuid the asset category's UUID
	* @param groupId the primary key of the group
	* @return the matching asset category, or <code>null</code> if a matching asset category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory fetchAssetCategoryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAssetCategoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the asset category with the primary key.
	*
	* @param assetCategoryId the primary key of the asset category
	* @return the asset category
	* @throws PortalException if a asset category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory getAssetCategory(
		long assetCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategory(assetCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the asset category with the matching UUID and company.
	*
	* @param uuid the asset category's UUID
	* @param companyId the primary key of the company
	* @return the matching asset category
	* @throws PortalException if a matching asset category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory getAssetCategoryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategoryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the asset category matching the UUID and group.
	*
	* @param uuid the asset category's UUID
	* @param groupId the primary key of the group
	* @return the matching asset category
	* @throws PortalException if a matching asset category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory getAssetCategoryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the asset categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.assetmanagement.model.impl.AssetCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset categories
	* @param end the upper bound of the range of asset categories (not inclusive)
	* @return the range of asset categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.assetmanagement.model.AssetCategory> getAssetCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategories(start, end);
	}

	/**
	* Returns the number of asset categories.
	*
	* @return the number of asset categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getAssetCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategoriesCount();
	}

	/**
	* Updates the asset category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assetCategory the asset category
	* @return the asset category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.assetmanagement.model.AssetCategory updateAssetCategory(
		com.rivetlogic.assetmanagement.model.AssetCategory assetCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAssetCategory(assetCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rivetlogic.assetmanagement.model.AssetCategory addAssetCategory(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.rivetlogic.assetmanagement.model.AssetCategory assetCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAssetCategory(themeDisplay, serviceContext, assetCategory);
	}

	public static java.util.List<com.rivetlogic.assetmanagement.model.AssetCategory> getAssetCategories(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategories(groupId, companyId, start, end);
	}

	public static int getAssetCategoriesCount(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetCategoriesCount(groupId, companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AssetCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AssetCategoryLocalService.class.getName());

			if (invokableLocalService instanceof AssetCategoryLocalService) {
				_service = (AssetCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new AssetCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AssetCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AssetCategoryLocalService service) {
	}

	private static AssetCategoryLocalService _service;
}