package org.servicedx.util;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public interface IParam
{
	public enum ENamed implements EnumInterface
	{
		Between(" Between "), EqualTo(" = :"), GreaterThan(" > :"), GreaterThanEqualTo(" >= :"), In(" In "), Is_Null(""), LessThan(" < :"), LessThanEqualTo(" <= :"), Like(" Like :"), LikePost(
				" Like :"), LikePrepend(" Like :"), NotEqualTo(" <> :"), NotIn(" Not In ");

		public static String create(String param)
		{
			return param.replaceAll("\\.", "").trim();
		}

		public static void remove(IParam param, String key)
		{
			param.getSearchCondtionMap().remove(key);
			param.getSearchValueMap().remove(key);
		}

		private String eWrap;

		private ENamed(String eWrap)
		{
			this.eWrap = eWrap;
		}

		private LabelValueBean create(IParam param, String property)
		{
			String key = property;

			while ( param.getSearchCondtionMap().containsKey(key) )
			{
				key = key + new Random().nextInt(10) + 1;
			}

			return new LabelValueBean(create(key), key);
		}

		public String param(String property)
		{
			String condition = paramCreator(property);
			if (CommonValidator.isNotNullNotEmpty(condition))
			{
				return condition;
			}
			return "";
		}

		public void param_AND(IParam param, String condition, Object value)
		{
			param_AND(param, condition, value, null);
		}

		public void param_AND(IParam param, String condition, Object value, IWrap iWrap)
		{
			updateConditionValueMap(param, condition, value, IWrap.AND, iWrap);
		}

		public String param_AND(String property)
		{
			String condition = paramCreator(property);
			if (CommonValidator.isNotNullNotEmpty(condition))
			{
				return IWrap.AND.prepend(condition);
			}
			return "";
		}

		public void param_OR(IParam param, String condition, Object value)
		{
			param_OR(param, condition, value, null);
		}

		public void param_OR(IParam param, String condition, Object value, IWrap iWrap)
		{
			updateConditionValueMap(param, condition, value, IWrap.OR, iWrap);
		}

		public String param_OR(String property)
		{
			String condition = paramCreator(property);
			if (CommonValidator.isNotNullNotEmpty(condition))
			{
				return IWrap.OR.prepend(condition);
			}
			return "";
		}

		public String paramCode()
		{
			return eWrap;
		}

		private LabelValueBean paramCreator(IParam param, String property)
		{
			if (CommonValidator.isNotNullNotEmpty(property))
			{
				LabelValueBean lbBean = create(param, property);

				if (eWrap.equals(Between.paramCode()))
				{
					String conQuery = property + eWrap + ":From_" + lbBean.getValue() + " AND :To_" + lbBean.getValue();
					return new LabelValueBean(conQuery, lbBean.getLabel());
				}
				else if (eWrap.equals(In.paramCode()) || eWrap.equals(NotIn.paramCode()))
				{
					String conQuery = property + eWrap + "( :" + lbBean.getValue() + " )";
					return new LabelValueBean(conQuery, lbBean.getLabel());
				}
				else
				{
					return new LabelValueBean(property + eWrap + lbBean.getValue(), lbBean.getLabel());
				}
			}
			return null;
		}

		private String paramCreator(String property)
		{
			if (CommonValidator.isNotNullNotEmpty(property))
			{
				String encData = create(property);
				if (eWrap.equals(Between.paramCode()))
				{
					return property + eWrap + ":From_" + encData + " AND :To_" + encData;
				}
				else if (eWrap.equals(In.paramCode()) || eWrap.trim().equals(NotIn.paramCode()))
				{
					return property + eWrap + "( :" + encData + " )";
				}
				else
				{
					return property + eWrap + encData.trim();
				}
			}
			return "";
		}

		private void updateConditionValueMap(IParam param, String property, Object value, IWrap _AndOr, IWrap iWrap)// usersusEmployeeId
		{
			LabelValueBean lbParam = paramCreator(param, property);
			if (CommonValidator.isNotNullNotEmpty(lbParam))
			{
				if (CommonValidator.isNotNullNotEmpty(iWrap))
				{
					switch ( iWrap )
					{
						case ST_BRACE1 :
						case ST_BRACE2 :
						case ST_BRACE3 :
						case ST_BRACE4 :
						case ST_BRACE5 :
						{
							String qCondition = _AndOr.prepend(iWrap.prepend(lbParam.getValue()));
							param.getSearchCondtionMap().put(lbParam.getLabel(), qCondition);
							param.getSearchValueMap().put(lbParam.getLabel(), value);
							break;
						}
						case ED_BRACE1 :
						case ED_BRACE2 :
						case ED_BRACE3 :
						case ED_BRACE4 :
						case ED_BRACE5 :
						{
							String qCondition = _AndOr.prepend(iWrap.append(lbParam.getValue()));
							param.getSearchCondtionMap().put(lbParam.getLabel(), qCondition);
							param.getSearchValueMap().put(lbParam.getLabel(), value);
							break;
						}
						default :
							break;
					}
				}
				else
				{
					String qCondition = _AndOr.prepend(lbParam.getValue());
					param.getSearchCondtionMap().put(lbParam.getLabel(), qCondition);
					param.getSearchValueMap().put(lbParam.getLabel(), value);
				}
			}
		}
	}

	public enum IWrap implements EnumInterface
	{
		AND(" AND "), ED_BRACE1(" ) "), ED_BRACE2(" )) "), ED_BRACE3(" ))) "), ED_BRACE4(" )))) "), ED_BRACE5(" ))))) "), FETCH(" JOIN FETCH "), JOIN(" JOIN "), LEFT(" LEFT JOIN "), OR(
				" OR "), ST_BRACE1(" ( "), ST_BRACE2(" (( "), ST_BRACE3(" ((( "), ST_BRACE4(" (((( "), ST_BRACE5(" ((((( ");

		private String datum;

		IWrap(String datum)
		{
			this.datum = datum;
		}

		public String append(String data)
		{
			return data + datum;
		}

		public String get()
		{
			return datum;
		}

		public String prepend(String data)
		{
			return datum + data;
		}

	}

	public IParam addBean(Class<?> clazz, String aliasName);

	public IParam equal(String lhs, String rhs);

	public IParam fetch(String fetch);

	public EnumInterface get_AddEntityBean();

	public String get_OrderBy();

	public String get_ProcedureName();

	public List<?> getDataList();

	public long getDataListCount();

	public int getMaxResults();

	public int getMinResults();

	public HttpServletRequest getRequest();

	public Set<ClassAndAlias> getSearchBeanClass();

	public String getSearchColumns();

	public LinkedHashMap<String, Object> getSearchCondtionMap();

	public String getSearchDistinctColumns();

	public LinkedHashSet<String> getSearchFetchSet();

	public LinkedHashSet<String> getSearchJoinSet();

	public LinkedHashMap<String, Object> getSearchValueMap();

	public void set_AddEntityBean(EnumInterface _AddEntityBean);

	public void set_OrderBy(String _OrderBy);

	public void set_ProcedureName(String _ProcedureName);

	public void setDataList(List<?> dataList);

	public void setDataListCount(long dataListCount);

	public void setMaxResults(int maxResults);

	public void setMinResults(int minResults);

	public void setRequest(HttpServletRequest request);

	public void setSearchBeanClass(Set<ClassAndAlias> searchBeanClass);

	public void setSearchColumns(String searchColumns);

	public void setSearchCondtionMap(LinkedHashMap<String, Object> searchCondtionMap);

	public void setSearchDistinctColumns(String searchColumns);

	public void setSearchValueMap(LinkedHashMap<String, Object> searchValueMap);

	public String getSearchCountColumns();

	public void setSearchCountColumns(String searchCountColumns);

}
