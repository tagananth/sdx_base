package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.Configuration;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationDao extends CassandraRepository<Configuration, String>
{

	@Query("select * from configuration where customerid = ?0 and status = true ALLOW FILTERING")
	List<Configuration> fetchByCustomerId(final long customerId);

	@Query("select * from configuration where customerid = ?0 and status = true and active=true and type='SMS' ALLOW FILTERING")
	List<Configuration> fetchSMSConfig(final long customerId);

	@Query("select * from configuration where customerid = ?0 and status = true and active=true and type='Email' ALLOW FILTERING")
	List<Configuration> fetchEmailConfig(final long customerId);

	@AllowFiltering
	List<Configuration> findByConfigurationId(final long configId);

	@AllowFiltering
	List<Configuration> findByConfigurationNameAndCustomerId(String configName, long customerId);

	@Query("select count(1) from configuration where configurationname = ?0 and customerid = ?1 ALLOW FILTERING")
	int checkConfigurationExists(final String configurationName, final long customerId);

	@Query("update configuration set status = false, modifieddate = ?0, modifiedby = ?1 , modifiedbyname=?2 where configurationid = ?3 ")
	void blockConfiguration(final LocalDateTime modifiedDate, final Long modifiedBy, String modifiedByName, final long configurationId);

	@Query("select * from configuration where configurationname like ?0 and customerid = ?1 and status = true ALLOW FILTERING")
	List<Configuration> searchByConfigurationName(String configName, long custId);

	@Query("delete from configuration where configurationid like ?0 ALLOW FILTERING")
	void deleteConfiguration(long configurationId);

}
