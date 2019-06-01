package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.Message;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends CassandraRepository<Message, String> {

	List<Message> getByMessageId(final long messageId);

	@AllowFiltering
	@Query("select * from message limit 10")
	List<Message> getRecentActivities();

	@AllowFiltering
	List<Message> findBySendId(final String sendId);

	@AllowFiltering
	@Query("select * from message where modifieddate >= ?0 and modifieddate <= ?1 ALLOW FILTERING")
	List<Message> filterByDateRange(LocalDateTime startDate, LocalDateTime endDate);

	@AllowFiltering
	@Query("select messageid,sendid,userid,groupid,message,messagestatus,emailid,mobilenumber,createddate from message where status = true ALLOW FILTERING")
	List<Message> getNotifications();
	
	@AllowFiltering
	@Query("update message set status = false where messageid = ?0")
	void deleteNotification(long messageId);
	
}
