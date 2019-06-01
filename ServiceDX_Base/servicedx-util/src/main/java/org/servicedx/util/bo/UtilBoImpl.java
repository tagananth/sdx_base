package org.servicedx.util.bo;

import java.util.List;

import org.servicedx.util.DataTableParam;
import org.servicedx.util.IParam.ENamed;
import org.servicedx.util.dao.IBaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilBoImpl implements UtilBo
{
	@Autowired
	private IBaseDAO iBaseDAO;

	@SuppressWarnings("unchecked")
	public List<Object[]> getContextDocBasePathList()
	{
		DataTableParam dtParam = new DataTableParam();
		try
		{
			dtParam.addBean(Class.forName("org.servicedx.admin.model.ProducersProperty"), "PP");
			dtParam.searchColumns = "PP.property, PP.value";

			ENamed.EqualTo.param_AND(dtParam, "PP.group", "ResourceHandler");
			ENamed.EqualTo.param_AND(dtParam, "PP.status", true);

			return (List<Object[]>) iBaseDAO.getDataList(dtParam).getDataList();

		}
		catch (Exception excep)
		{
		}

		return null;
	}

}
