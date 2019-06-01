package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.Schedule;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao extends CassandraRepository<Schedule, Long>
{
	@AllowFiltering
	public Schedule findByScheduleId(long scheduleId);

	@Query("select * from schedule where customerid = ?0 and schedulename like ?1 allow filtering")
	public List<Schedule> findScheduleByName(long customerId, String scheduleName);

	@Query("update schedule set status = false, modifiedby=?0, modifiedbyname = ?1, modifieddate=?2 where scheduleId=?3")
	public Schedule blockScheduleById(Long modifiedBy, String modifiedName, LocalDateTime modifiedTime ,long scheduleId);

	@Query("select * from schedule where status = true ALLOW FILTERING")
	public List<Schedule> getScheduleList();

	@Query("select * from schedule where status = true and customerid = ?0 ALLOW FILTERING")
	public List<Schedule> getScheduleByCustomer(long customerId);

}
