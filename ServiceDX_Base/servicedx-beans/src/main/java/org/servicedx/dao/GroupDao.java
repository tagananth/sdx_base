package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.Group;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends CassandraRepository<Group, Long>
{

	@Query("select * from group where customerid = ?0 and status = true ALLOW FILTERING")
	List<Group> fetchByCustomerId(final long customerId);

	@Query("select count(1) from group where  customerid = ?0 and groupname = ?1 ALLOW FILTERING")
	int checkGroupExists(final long customerId, final String groupName);

	@AllowFiltering
	@Query("delete group where customerid = ?0 and groupid = ?1")
	int deleteGroup(final long customerId, final long groupId);

	@AllowFiltering
	@Query("select * from group where customerid = ?0 and groupname like ?1 and status = true ALLOW FILTERING")
	List<Group> findByGroupName(final long customerId, final String groupName);

	@AllowFiltering
	Group findByGroupId(final long groupId);

	@Query("update group set status = false, modifieddate = ?0, modifiedby = ?1 , modifiedbyname=?2 where groupId = ?3 ")
	void blockGroup(final LocalDateTime modifiedDate, final Long modifiedBy, String modifiedByName, final long groupId);

	@AllowFiltering
	@Query("select * from group where customerid = ?0 and groupid in (?1) and status = true")
	List<Group> getGroupList(Authentication auth, long[] groupIds);

	@Query("select * from group where customerid = ?0 and type =?1 and status = true and active = true  ALLOW FILTERING")
	List<Object> fetchByCustomerIdAndType(final long customerId, final String type);
}
