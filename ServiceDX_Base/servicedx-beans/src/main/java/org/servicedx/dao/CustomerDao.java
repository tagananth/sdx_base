package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.Customer;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;

@Repository
public interface CustomerDao extends CassandraRepository<Customer, Long>
{
	@AllowFiltering
	public Customer findByCustomerId(long customerId);

	@AllowFiltering
	public int countByCustomerName(String customerName);

	@AllowFiltering
	public List<Customer> findByCustomerName(String customerName);

	@Query("select * from customer where customername like ?0 allow filtering")
	public List<Customer> findCustomerDetailsByName(String customerName);

	// not used
	@Query("update customer set status = false where customerid=?0 allow filtering")
	public Customer blockCustomerById(long customerId);

	@AllowFiltering
	@Query("select customername from customer where customername like ?0 ALLOW FILTERING")
	public Row checkCustomerName(String customerName);
	
	@Query("select * from customer where status = true ALLOW FILTERING")
	public List<Customer> getCustomerList();

}
