package com.beans;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SCHEDULE")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Schedule")
public class Schedule {

	// Entity to Hold Working Schedule Days & Time Window for Any Doctor/Lab Branch/Hospital 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCHDLE_ID", unique = true)
	Long scheduleId;
	@Column(name = "DOC_ID")
	Long docId;
	@Column(name = "LAB_BRANCH_CD")
	Long branchCode;
	

	String working_days;  // || Separated Values - MON||TUE||WED||THURS||FRI||SAT||SUN

	
	Time morning_time_start;  // Start Time of Morning Shift 
	Time morning_time_end;	 //  End Time of Morning Shift
	Integer morning_tokens_avlbl;	 //  Number of Patients that can be Served in Morning, 
							//so that System can dynamically calculate TimeSlot for each Patient
	Integer morning_tokens_booked;   // If morning_tokens_booked < morning_tokens_avlbl Then Booking is Open
	
	
	Time afternoon_time_start;		// Start Time of AfterNoon Shift
	Time afternoon_time_end;		// End Time of AfterNoon Shift
	Integer afternoon_tokens_avlbl;   // Number of Patients that can be Served in Afternoon
								      //so that System can dynamically calculate TimeSlot for each Patient
	Integer afternoon_tokens_booked;   // If afternoon_tokens_avlbl < afternoon_tokens_booked Then Booking is Open
	
	
	
	
	Time evening_time_start;		// Start Time of Evening Shift
	Time evening_time_end;			// End Time of Evening Shift
	Integer evening_tokens_avlbl;		// Number of Patients that can be Served in Evening
									//so that System can dynamically calculate TimeSlot for each Patient
	Integer evening_tokens_booked;  // If evening_tokens_avlbl < evening_tokens_booked Then Booking is Open
	
	
	
	Time night_time_start;		// Start Time of Night Shift
	Time night_time_end;			// End Time of Night Shift
	Integer night_tokens_avlbl;		// Number of Patients that can be Served in Night
									//so that System can dynamically calculate TimeSlot for each Patient
	Integer night_tokens_booked;  // If night_tokens_avlbl < night_tokens_booked Then Booking is Open
	
	Integer status;
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public Long getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}
	public String getWorking_days() {
		return working_days;
	}
	public void setWorking_days(String working_days) {
		this.working_days = working_days;
	}
	public Time getMorning_time_start() {
		return morning_time_start;
	}
	public void setMorning_time_start(Time morning_time_start) {
		this.morning_time_start = morning_time_start;
	}
	public Time getMorning_time_end() {
		return morning_time_end;
	}
	public void setMorning_time_end(Time morning_time_end) {
		this.morning_time_end = morning_time_end;
	}
	public Integer getMorning_tokens_avlbl() {
		return morning_tokens_avlbl;
	}
	public void setMorning_tokens_avlbl(Integer morning_tokens_avlbl) {
		this.morning_tokens_avlbl = morning_tokens_avlbl;
	}
	public Integer getMorning_tokens_booked() {
		return morning_tokens_booked;
	}
	public void setMorning_tokens_booked(Integer morning_tokens_booked) {
		this.morning_tokens_booked = morning_tokens_booked;
	}
	public Time getAfternoon_time_start() {
		return afternoon_time_start;
	}
	public void setAfternoon_time_start(Time afternoon_time_start) {
		this.afternoon_time_start = afternoon_time_start;
	}
	public Time getAfternoon_time_end() {
		return afternoon_time_end;
	}
	public void setAfternoon_time_end(Time afternoon_time_end) {
		this.afternoon_time_end = afternoon_time_end;
	}
	public Integer getAfternoon_tokens_avlbl() {
		return afternoon_tokens_avlbl;
	}
	public void setAfternoon_tokens_avlbl(Integer afternoon_tokens_avlbl) {
		this.afternoon_tokens_avlbl = afternoon_tokens_avlbl;
	}
	public Integer getAfternoon_tokens_booked() {
		return afternoon_tokens_booked;
	}
	public void setAfternoon_tokens_booked(Integer afternoon_tokens_booked) {
		this.afternoon_tokens_booked = afternoon_tokens_booked;
	}
	public Time getEvening_time_start() {
		return evening_time_start;
	}
	public void setEvening_time_start(Time evening_time_start) {
		this.evening_time_start = evening_time_start;
	}
	public Time getEvening_time_end() {
		return evening_time_end;
	}
	public void setEvening_time_end(Time evening_time_end) {
		this.evening_time_end = evening_time_end;
	}
	public Integer getEvening_tokens_avlbl() {
		return evening_tokens_avlbl;
	}
	public void setEvening_tokens_avlbl(Integer evening_tokens_avlbl) {
		this.evening_tokens_avlbl = evening_tokens_avlbl;
	}
	public Integer getEvening_tokens_booked() {
		return evening_tokens_booked;
	}
	public void setEvening_tokens_booked(Integer evening_tokens_booked) {
		this.evening_tokens_booked = evening_tokens_booked;
	}
	public Time getNight_time_start() {
		return night_time_start;
	}
	public void setNight_time_start(Time night_time_start) {
		this.night_time_start = night_time_start;
	}
	public Time getNight_time_end() {
		return night_time_end;
	}
	public void setNight_time_end(Time night_time_end) {
		this.night_time_end = night_time_end;
	}
	public Integer getNight_tokens_avlbl() {
		return night_tokens_avlbl;
	}
	public void setNight_tokens_avlbl(Integer night_tokens_avlbl) {
		this.night_tokens_avlbl = night_tokens_avlbl;
	}
	public Integer getNight_tokens_booked() {
		return night_tokens_booked;
	}
	public void setNight_tokens_booked(Integer night_tokens_booked) {
		this.night_tokens_booked = night_tokens_booked;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
