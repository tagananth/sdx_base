package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.PortletUsers;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PortletUserDao extends CassandraRepository<PortletUsers, String>{

	
	@AllowFiltering
	@Query("select * from portletusers where userid=?0 and status = true ALLOW FILTERING")
	List<PortletUsers> getByUserid(String userId);
}