package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.GroupMember;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberDao extends CassandraRepository<GroupMember, Long>
{

	@AllowFiltering
	@Query("select * from groupmember where customerid = ?0 and parentgroupid = ?1 ALLOW FILTERING")
	GroupMember findByGroupMemberId(long customerId, String parentGroupId);

	@AllowFiltering
	List<GroupMember> findByGroupId(final long groupId);

	@Query("delete from groupmember where customerid = ?0 and parentgroupid like ?1 ALLOW FILTERING")
	int deleteGroupMembersByGroupId(long customerId, String groupId);

	@Query("delete from groupmember where groupmemberid = ?0")
	void deleteGroupMemberById(long groupMemberId);

	@Query("update groupmember set status = false  , modifieddate= ?0 where parentgroupid like ?1 ALLOW FILTERING")
	int blockGroupMemberByGroupId(final LocalDateTime modifiedDate, final String groupId);

	@AllowFiltering
	@Query("select * from groupmember where customerid = ?0 and parentgroupid like ?1 ALLOW FILTERING")
	List<GroupMember> findGroupMembersByGroupId(long customerId, String groupId);

}
