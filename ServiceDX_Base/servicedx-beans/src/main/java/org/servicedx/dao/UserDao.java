package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.City;
import org.servicedx.bean.model.Country;
import org.servicedx.bean.model.States;
import org.servicedx.bean.model.Users;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;

@Repository
public interface UserDao extends CassandraRepository<Users, Long>, IQueryConstants
{
	@AllowFiltering
	@Query("select * from country where countryname Like ?0 ALLOW FILTERING")
	List<Country> getCountryList(String countryName);

	@AllowFiltering
	@Query("select * from country")
	List<Country> getCountryList();

	@AllowFiltering
	@Query("select * from states where statename Like ?0 and country = ?1 and status = true ALLOW FILTERING")
	List<States> getStateList(String statename, String country);

	@AllowFiltering
	@Query("select * from cities where city Like ?0 and state = ?1 and status = true ALLOW FILTERING")
	List<City> getCityList(String city, String state);

	@Query("select * from users where emailid = ?0 ALLOW FILTERING")
	Users getByEmailId(String emailId);

	@AllowFiltering
	Users findByUserId(final long userId);
	
	@Query("select * from users where status = true and active = true and userid = ?0 ALLOW FILTERING")
	Users findByActiveUserId(final long userId);

	@Query("select * from users where status = true and customerid = ?0 ALLOW FILTERING")
	List<Users> fetchByCustomer(final long customerId); 
	
	@Query("select * from users where status = true and roleid=?0 and customerid = ?1 ALLOW FILTERING")
	List<Users> fetchUsersListByRole(final String roleName, final long customerId); 
	
	@AllowFiltering
	@Query("select username, customerid from users where username=?0 ALLOW FILTERING")
	Row checkUserName(final String userName);

	@Modifying
	@Query("select * from users where username like ?0")
	List<Users> findByUserName(final String userName);
	
	@Query("select * from users where username = ?0 ALLOW FILTERING")
	Users getByUserName(final String userName);

	@AllowFiltering
	Users findByTokenKey(final String tokenKey);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and emailid like ?1 ALLOW FILTERING")
	List<Object> getUsersByEmailId(long customerId, String searchParam);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and emailid1 like ?1 ALLOW FILTERING")
	List<Object> getUsersByEmailId1(long customerId, String searchParam);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and firstname like ?1 ALLOW FILTERING")
	List<Object> getUsersByFirstName(long customerId, String searchParam);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and lastname like ?1 ALLOW FILTERING")
	List<Object> getUsersByLastName(long customerId, String searchParam);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and mobileno like ?1 ALLOW FILTERING")
	List<Object> getUsersByMobileNo(long customerId, String searchParam);

	@AllowFiltering
	@Query("select userid, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and mobileno1 like ?1 ALLOW FILTERING")
	List<Object> getUsersByMobileNo1(long customerId, String searchParam);

	@AllowFiltering
	@Query("select * from users where status = true ALLOW FILTERING")
	List<Users> getAllUsers();
	
	@AllowFiltering
	@Query("select userid,username, firstname,lastname, emailid, emailid1, mobileno, mobileno1 from users where customerid = ?0 and status = true and active = true ALLOW FILTERING")
	List<Object> getUsersByCustomerId(long customerId);
}
