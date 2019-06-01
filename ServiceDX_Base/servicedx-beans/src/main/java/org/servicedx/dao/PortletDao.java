package org.servicedx.dao;

import java.util.Optional;

import org.servicedx.bean.model.Portlet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PortletDao extends CassandraRepository<Portlet, String>{

	
	@AllowFiltering
	@Query("select * from portlets where portletid=?0 ALLOW FILTERING")
	Optional<Portlet> getPortlet(String portletid);
}