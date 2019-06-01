package org.servicedx.bean.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IScheduleDetails extends ICommonCustomerBean
{
	public long getScheduleId();
	
	public String getScheduleName();

	public long getScheduleDetailId();

	public long getUserId();

	public String getUserName();

	public long getGroupId();

	public String getGroupName();

	public String getScheduleTime();

	public String getIntervalDay();

	public String getOccurrenceType();

	public String getStartDate();

	public String getEntity();
	
	public String getEndDate();

	public void setScheduleDetailId(long scheduleDetailId);

	public void setScheduleId(long scheduleId);

	public void setScheduleName(String scheduleName);
	
	public void setUserId(long userId);

	public void setUserName(String userName);

	public void setGroupId(long groupId);

	public void setGroupName(String groupName);

	public void setScheduleTime(String scheduleTime);

	public void setIntervalDay(String intervalDay);

	public void setOccurrenceType(String occurrenceType);

	public void setStartDate(String startDate);

	public void setEndDate(String endDate);
	
	public void setEntity(String entity);
	
}