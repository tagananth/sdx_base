package org.servicedx.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.bean.model.Schedule;
import org.servicedx.bean.model.ScheduleDetails;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDetailsDao extends CassandraRepository<ScheduleDetails, Long>
{
	@AllowFiltering
	public List<ScheduleDetails> findByScheduleId(long scheduleId);

	@AllowFiltering
	public List<ScheduleDetails> findByUserId(long userId);

	@Query("select * from scheduledetails where userId = ?0 and status= true allow filtering")
	public List<ScheduleDetails> findScheduleDetailsByUserId(long userId);

	@Query("update scheduledetails set status = false, modifiedby=?0, modifiedbyname = ?1, modifieddate=?2 where scheduledetailId=?3 ")
	public ScheduleDetails blockScheduleDetailsById(Long modifiedBy, String modifiedName, LocalDateTime modifiedTime ,long scheduledetailId);

	@Query("delete from scheduledetails where scheduledetailId=?0")
	public void deleteByScheduleDetailId(long scheduleDetailId);

	@Query("select username, occurrencetype, comments, startdate, enddate, scheduletime,intervalday from scheduledetails where status = true and active = true and customerid = ?0 ALLOW FILTERING")
	public List<ScheduleDetails> getScheduleDateTime(long customerId);

}
