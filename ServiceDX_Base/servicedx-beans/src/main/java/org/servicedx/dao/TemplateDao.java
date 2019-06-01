package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.Template;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateDao extends CassandraRepository<Template, String>
{

	List<Template> getByTemplateId(final long templateId);

	@AllowFiltering
	List<Template> getByMessageType(final String messageType);

}
