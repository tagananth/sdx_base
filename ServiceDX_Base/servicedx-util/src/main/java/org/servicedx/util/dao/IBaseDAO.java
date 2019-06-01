package org.servicedx.util.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.servicedx.util.CustomException;
import org.servicedx.util.DataTableParam;
import org.servicedx.util.ICRUDBean;
import org.servicedx.util.IParam;

public interface IBaseDAO extends Serializable
{
	public IParam deleteData(IParam param);

	public IParam deleteDataByExternalSession(IParam param, Session session) throws Exception;

	public IParam getDataList(IParam param);

	public List<Map<String, String>> getDataListByColumns(DataTableParam dtParam) throws CustomException;

	public IParam getDataListByExternalSession(IParam param, Session session) throws Exception;

	public DataTableParam getDataTableList(DataTableParam dtParam, boolean isCount);

	public boolean saveOrUpdate(ICRUDBean... beans);

	public boolean saveOrUpdate(Session session, ICRUDBean... beans);

	public boolean saveOrUpdate(Session session, Set<? extends ICRUDBean> beans);

	public boolean saveOrUpdate(Set<? extends ICRUDBean> beans);

	public boolean saveOrUpdate(String beanName, ICRUDBean... beans);

	public boolean saveOrUpdate(String beanName, Set<? extends ICRUDBean> beans);

}