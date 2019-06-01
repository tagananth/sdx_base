package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.Attachment;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentDao extends CassandraRepository<Attachment, String>
{

	@AllowFiltering
	List<Attachment> getByMessageId(final long messageId);
	
	@AllowFiltering
	long countByMessageId(final long messageId);

}
