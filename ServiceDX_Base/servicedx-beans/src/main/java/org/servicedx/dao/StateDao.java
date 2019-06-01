package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.States;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDao extends CassandraRepository<States, String>, IQueryConstants
{
	@AllowFiltering
	@Query("select * from states where country = ?0 and statename Like ?1 and status = true ALLOW FILTERING")
	List<States> getStateList(String country, String statename);

	@AllowFiltering
	@Query("select * from states where country = ?0 and status = true ALLOW FILTERING")
	List<States> getStateList(String country);

}
