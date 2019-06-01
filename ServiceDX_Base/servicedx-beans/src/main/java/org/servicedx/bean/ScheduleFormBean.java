package org.servicedx.bean;

import java.util.Map;

import org.servicedx.bean.model.Schedule;
import org.servicedx.bean.model.ScheduleDetails;
import org.springframework.security.core.Authentication;

public class ScheduleFormBean extends APIStatus
{

	private static final long	serialVersionUID	= 5862342185767193951L;

	public Schedule				schedule			= new Schedule();

	public ScheduleDetails		scheduleDetails		= new ScheduleDetails();

	public ScheduleDetails		repoScheduleDetails;
	
	public Schedule				repoSchedule;
	
	public Map<String,String> 	entityDetailMap;
	
	public String 				entity;
	
	public String 				timeZone;

	public void updateRepoScheduleDetails(Authentication auth)
	{
		repoScheduleDetails.setActive(scheduleDetails.isActive());
		repoScheduleDetails.setComments(scheduleDetails.getComments());
		repoScheduleDetails.setCustomerName(scheduleDetails.getCustomerName());
		repoScheduleDetails.modifiedUserInfo(auth);
	}
	
	public void updateRepoSchedule(Authentication auth)
	{
		repoSchedule.setActive(schedule.isActive());
		repoSchedule.setComments(schedule.getComments());
		repoSchedule.setCustomerName(schedule.getCustomerName());
		repoSchedule.modifiedUserInfo(auth);
	}
}
