package org.servicedx.bean.model;

public interface ISchedule extends ICommonCustomerBean
{
	public long getScheduleId();

	public String getScheduleName();

	public String getOccurrenceType();

	public void setScheduleId(long scheduleId);

	public void setScheduleName(String scheduleName);

	public void setOccurrenceType(String occurrenceType);

}