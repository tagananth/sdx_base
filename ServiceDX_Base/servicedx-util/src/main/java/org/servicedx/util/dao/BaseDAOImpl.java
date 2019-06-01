package org.servicedx.util.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.servicedx.util.ClassAndAlias;
import org.servicedx.util.CommonHibernateSessionFactorySupport;
import org.servicedx.util.CommonValidator;
import org.servicedx.util.CustomException;
import org.servicedx.util.DataTableParam;
import org.servicedx.util.ICRUDBean;
import org.servicedx.util.IParam;
import org.springframework.stereotype.Component;

@Component
public class BaseDAOImpl extends CommonHibernateSessionFactorySupport implements IBaseDAO
{

	private static final long serialVersionUID = -4146239461295369929L;

	@Override
	public IParam getDataList(IParam param)
	{
		Session session = getSessionFactory().openSession();
		try
		{
			param = getDataListByExternalSession(param, session);
		}
		catch (Exception excep)
		{
		}
		finally
		{
			if (session != null)
			{
				session.clear();
				session.close();
			}
		}
		return param;
	}

	@Override
	public IParam deleteData(IParam param)
	{
		Transaction _Txn = null;
		Session session = null;
		try
		{
			session = getSessionFactory().openSession();
			_Txn = session.beginTransaction();
			param = deleteDataByExternalSession(param, session);
			_Txn.commit();

		}
		catch (Exception excep)
		{
			if (_Txn != null && _Txn.isActive())
			{
				try
				{
					_Txn.rollback();
				}
				catch (HibernateException hibExcep)
				{
				}
			}
		}
		finally
		{
			if (session != null)
			{
				session.clear();
				session.close();
			}
		}
		return param;
	}

	@Override
	public IParam deleteDataByExternalSession(IParam param, Session transationSession) throws Exception
	{
		Query<?> query = null;

		StringBuffer sbSelectQry = new StringBuffer();

		sbSelectQry.append(DELETE);
		sbSelectQry.append(getSearchBean(param));

		for (String condKey : param.getSearchCondtionMap().keySet())
		{
			sbSelectQry.append(param.getSearchCondtionMap().get(condKey));
		}

		query = transationSession.createQuery(sbSelectQry.toString());

		_SetNamedParameterValueFromSearchValueMap(param, query);

		param.setDataListCount(query.executeUpdate());

		return param;
	}

	public IParam getDataListByExternalSession(IParam param, Session transationSession) throws Exception
	{
		Query<?> query = null;

		StringBuffer sbSelectQry = new StringBuffer();

		if (CommonValidator.isNotNullNotEmpty(param.getSearchColumns()))
		{
			sbSelectQry.append(SELECT + param.getSearchColumns());
		}

		if (CommonValidator.isNotNullNotEmpty(param.getSearchDistinctColumns()))
		{
			sbSelectQry.append(SELECT_DISTINCT + param.getSearchDistinctColumns());
		}

		sbSelectQry.append(getSearchBean(param));

		for (String condKey : param.getSearchCondtionMap().keySet())
		{
			sbSelectQry.append(param.getSearchCondtionMap().get(condKey));
		}
		sbSelectQry.append(param.get_OrderBy());

		if (param.getMaxResults() != 0)
		{
			query = transationSession.createQuery(sbSelectQry.toString()).setMaxResults(param.getMaxResults()).setFirstResult(param.getMinResults());
		}
		else
		{
			query = transationSession.createQuery(sbSelectQry.toString());
		}

		_SetNamedParameterValueFromSearchValueMap(param, query);

		param.setDataList(query.list());

		return param;
	}

	public String getSearchBean(IParam param)
	{
		StringBuffer sbSelectQry = new StringBuffer();

		for (ClassAndAlias _CA : param.getSearchBeanClass())
		{
			sbSelectQry.append(_CA.getClazz().getCanonicalName() + SPACE + _CA.getAlias() + COMMA_SPACE);
		}

		String classNames = sbSelectQry.toString().trim();

		if (classNames.endsWith(COMMA_SPACE.trim()))
		{
			classNames = classNames.substring(0, classNames.lastIndexOf(COMMA_SPACE.trim()));
		}

		sbSelectQry = new StringBuffer(FROM + classNames);

		for (String fetcher : param.getSearchFetchSet())
		{
			sbSelectQry.append(fetcher);
		}

		sbSelectQry.append(WHERE_1_1);

		for (String joiner : param.getSearchJoinSet())
		{
			sbSelectQry.append(joiner);
		}

		return sbSelectQry.toString();
	}

	@Override
	public DataTableParam getDataTableList(DataTableParam dtParam, boolean isCount)
	{
		Session session = getSessionFactory().openSession();
		try
		{
			Query<?> query = null;

			StringBuffer sbSelectQry = new StringBuffer();

			if (CommonValidator.isNotNullNotEmpty(dtParam.searchCountColumns))
				sbSelectQry.append(isCount ? "Select Count(" + dtParam.searchCountColumns + ")" : "");
			else
				sbSelectQry.append(isCount ? "Select Count(*)" : "");

			if (CommonValidator.isNotNullNotEmpty(dtParam.getSearchColumns()) && isCount == false)
			{
				sbSelectQry.append(SELECT + dtParam.getSearchColumns());
			}

			sbSelectQry.append(getSearchBean(dtParam));

			for (String condKey : dtParam.searchCondtionMap.keySet())
			{
				sbSelectQry.append(dtParam.searchCondtionMap.get(condKey));
			}
			if (isCount)
			{
				query = session.createQuery((sbSelectQry.toString()));
			}
			else
			{
				sbSelectQry.append(dtParam._OrderBy);
				if (dtParam.iDisplayLength != 0)
				{
					query = session.createQuery((sbSelectQry.toString())).setMaxResults(dtParam.iDisplayLength).setFirstResult(dtParam.iDisplayStart);
				}
				else
				{
					query = session.createQuery((sbSelectQry.toString()));
				}
			}

			_SetNamedParameterValueFromSearchValueMap(dtParam, query);

			if (isCount)
			{
				dtParam.dataListCount = ((Long) query.uniqueResult()).longValue();
			}
			else
				dtParam.dataList = query.list();
		}
		catch (Exception excep)
		{
		}
		finally
		{
			if (session != null)
			{
				session.clear();
				session.close();
			}
		}
		return dtParam;
	}

	@Override
	public boolean saveOrUpdate(String beanName, ICRUDBean... beans)
	{
		Transaction _Txn = null;
		Session session = null;
		try
		{
			session = getSessionFactory().openSession();
			_Txn = session.beginTransaction();
			if (CommonValidator.isNotNullNotEmpty(beanName))
			{
				for (ICRUDBean bean : beans)
				{
					session.saveOrUpdate(beanName, bean);
				}
			}
			else
			{
				for (ICRUDBean bean : beans)
				{
					session.saveOrUpdate(bean);
				}
			}
			session.flush();
			_Txn.commit();

			return true;
		}
		catch (Exception excep)
		{
			if (_Txn != null && _Txn.isActive())
			{
				try
				{
					_Txn.rollback();
				}
				catch (HibernateException hibExcep)
				{
				}
			}
		}
		finally
		{
			if (session != null)
			{
				session.clear();
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean saveOrUpdate(ICRUDBean... beans)
	{
		Transaction _Txn = null;
		Session session = null;
		try
		{
			session = getSessionFactory().openSession();
			_Txn = session.beginTransaction();
			for (ICRUDBean bean : beans)
			{
				session.saveOrUpdate(bean.getClass().getSimpleName(), bean);
			}

			_Txn.commit();

			return true;
		}
		catch (Exception excep)
		{
			if (_Txn != null && _Txn.isActive())
			{
				try
				{
					_Txn.rollback();
				}
				catch (HibernateException hibExcep)
				{
				}
			}
		}
		finally
		{
			if (session != null)
			{
				session.clear();
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean saveOrUpdate(Session session, ICRUDBean... beans)
	{
		try
		{
			for (ICRUDBean bean : beans)
			{
				session.saveOrUpdate(bean.getClass().getSimpleName(), bean);
			}

			return true;
		}
		catch (Exception excep)
		{
		}
		return false;
	}

	@Override
	public boolean saveOrUpdate(String beanName, Set<? extends ICRUDBean> beans)
	{
		return saveOrUpdate(beanName, beans.toArray(new ICRUDBean[beans.size()]));
	}

	@Override
	public boolean saveOrUpdate(Set<? extends ICRUDBean> beans)
	{
		return saveOrUpdate(beans.toArray(new ICRUDBean[beans.size()]));
	}

	@Override
	public boolean saveOrUpdate(Session session, Set<? extends ICRUDBean> beans)
	{
		return saveOrUpdate(session, beans.toArray(new ICRUDBean[beans.size()]));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, String>> getDataListByColumns(DataTableParam dtParam) throws CustomException
	{
		if (CommonValidator.isNotNullNotEmpty(dtParam.searchColumns))
		{
			List<Object[]> datatList = (List<Object[]>) getDataList(dtParam).getDataList();

			String[] columns = dtParam.searchColumns.split(COMMA_SPACE.trim());

			List<Map<String, String>> objectMapList = new ArrayList<Map<String, String>>(datatList.size());

			Map<String, String> row = null;

			for (Object[] object : datatList)
			{
				row = new LinkedHashMap<String, String>();
				for (int idx = 0; idx < columns.length; idx++)
				{
					String key = columns[idx].trim().substring(columns[idx].trim().indexOf(DOT) + 1);
					row.put(key, CommonValidator.isNotNullNotEmpty(object[idx]) ? object[idx].toString().trim() : "");
				}
				objectMapList.add(row);
			}

			return objectMapList;
		}
		else
			throw new CustomException("Search Columns should NOT be empty");

	}

}
