package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.Country;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends CassandraRepository<Country, String>, IQueryConstants
{
	@AllowFiltering
	@Query("select * from country where countryname Like ?0 ALLOW FILTERING")
	List<Country> getCountryList(String countryName);

	@AllowFiltering
	@Query("select * from country")
	List<Country> getCountryList();

}
