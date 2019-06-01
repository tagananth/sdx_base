package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.City;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends CassandraRepository<City, String>, IQueryConstants
{
	@AllowFiltering
	@Query("select * from cities where state = ?0 and city Like ?1 and status = true ALLOW FILTERING")
	List<City> getCityList(String state, String city);

	@AllowFiltering
	@Query("select * from cities where state = ?0 and status = true ALLOW FILTERING")
	List<City> getCityList(String state);
}
