package com.common;

import java.sql.Time;

import com.beans.Appointment;
import com.beans.Schedule;

public class CommonUtilities {

	public static final String MORNING = "MORNING";
	public static final String AFTERNOON = "AFTERNOON";
	public static final String EVENING = "EVENING";
	public static final String NIGHT = "NIGHT";
	public static Integer TimeDiff(Time time_end,
			Time time_start) {
		// TODO Auto-generated method stub
		return null;
	}
	public static Time TimeAdd(Time startTime, int minutes) {
		// TODO Auto-generated method stub
		return null;
	}
	public  static Time getStartTime(Schedule schedule) {
		 Time start = null;
		//schedule.getMorning_time_start())(schedule.getMorning_tokens_booked()/schedule.getMorning_tokens_avlbl());
		return start;
	
		
		
	}
	public static Time getEndTime(Schedule schedule) {
		Time end =null; 
		//= CommonUtilities.TimeAdd(appmnt.getStartTime(),CommonUtilities.TimeDiff(schedule.getMorning_time_end(),schedule.getMorning_time_start())/schedule.getMorning_tokens_avlbl()));
		return null;
	}
	public static int getTokenNum(Schedule schedule, Appointment appmnt) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
}
