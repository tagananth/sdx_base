package org.servicedx.dao;

import java.util.List;

import org.servicedx.bean.model.Department;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CassandraRepository<Department, Long>, IQueryConstants
{
	@AllowFiltering
	@Query("select * from department where customerid = ?0 and status = true ALLOW FILTERING")
	List<Department> getDepartmentList(final long customerId);

	@Query("select count(1) from department where  customerid = ?0 and departmentname = ?1 ALLOW FILTERING")
	int checkDepartmentExists(final long customerId, final String departmentName);

	@AllowFiltering
	Department findByDepartmentId(final long departmentId);

}
