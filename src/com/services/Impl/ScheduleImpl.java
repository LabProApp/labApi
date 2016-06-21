package com.services.Impl;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Doctor;
import com.beans.LabBranch;
import com.beans.LabRep;
import com.beans.Response;
import com.beans.Schedule;
import com.common.Constants;
import com.dao.EmManager;

public class ScheduleImpl {

	/*
	 * private static String selectquery =
	 * "SELECT SCHDLE_ID,DOC_ID,LAB_BRANCH_CD,LAB_REP_CD,WORKING_DAYS,MRNG_START,MRNG_END,MRNG_TKNS_TOTAL,"
	 * + "AFTRN_START,AFTRN_END,AFTRN_TKNS_TOTAL," +
	 * "EVNG_START,EVNG_END,EVNG_TKNS_TOTAL," +
	 * "NIGHT_START,NIGHT_END,NIGHT_TKNS_TOTAL,STATUS " + "FROM SCHEDULE s ";
	 */
	private static String selectquery = "SELECT * FROM SCHEDULE s ";

	private static EntityManager em;

	public static ScheduleImpl instance;

	private ScheduleImpl() {

	}

	public static ScheduleImpl getInstance() {
		if (instance == null) {
			instance = new ScheduleImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response addSchedule(Schedule schedule) {

		Response resp = new Response();
		System.out.println("Add Schedule =>" + schedule.toString());

		if (null == schedule.getDocId() && null == schedule.getBranchCode()
				&& null == schedule.getLabRepId()) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_NORECORD);
			resp.setERROR_MESSAGE("Schedule Must Configured for DOCTOR/LABORATORY/LAB REPRESENTATIVE");
			return resp;
		}
		if (null != schedule.getDocId()) {

			DoctorImpl dcl = DoctorImpl.getInstance();
			Doctor doctor = dcl.get(schedule.getDocId());
			if (doctor.getDocId() == 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_NORECORD);
				resp.setERROR_MESSAGE("No Doctor " + schedule.getDocId()
						+ " Exists");

				return resp;

			}

			List<Schedule> scheduleList = getScheduleListbyDoctor(schedule
					.getDocId());
			if (scheduleList.size() > 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_ALREADYEXISTS);
				resp.setERROR_MESSAGE("Schedule for Doctor  "
						+ schedule.getDocId() + " Already Exists");

				return resp;

			}
		}
		if (null != schedule.getBranchCode()) {

			LabBranchImpl lcl = LabBranchImpl.getInstance();
			LabBranch labBranch = lcl.getLab(schedule.getBranchCode());
			if (labBranch.getLabbranchCode() == 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_NORECORD);
				resp.setERROR_MESSAGE("No Lab Branch "
						+ schedule.getBranchCode() + " Exists");

				return resp;

			}
			List<Schedule> scheduleList = getScheduleListbyLabBranch(schedule
					.getBranchCode());
			if (scheduleList.size() > 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_ALREADYEXISTS);
				resp.setERROR_MESSAGE("Schedule for Lab Branch "
						+ schedule.getBranchCode() + " Already Exists");

				return resp;

			}
		}
		if (null != schedule.getLabRepId()) {

			LabRepImpl lcl = LabRepImpl.getInstance();
			LabRep labrep = lcl.get(schedule.getLabRepId());
			if (labrep.getLabRepresentativeId() == 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_NORECORD);
				resp.setERROR_MESSAGE("No Lab Rep " + schedule.getLabRepId()
						+ " Exists");

				return resp;

			}

			List<Schedule> scheduleList = getScheduleListbyLabRep(schedule
					.getLabRepId());
			if (scheduleList.size() > 0) {
				resp.setSTATUS("FAIL");
				resp.setERROR_CODE(Constants.RESP_ALREADYEXISTS);
				resp.setERROR_MESSAGE("Schedule for Lab Rep  "
						+ schedule.getLabRepId() + " Already Exists");

				return resp;

			}
		}

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			populates_times(schedule);

			em.persist(schedule);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");

			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0001");
			resp.setERROR_MESSAGE(e.getMessage());
			em.getTransaction().rollback();
			e.printStackTrace();
		} catch (Exception e) {
			resp.setERROR_MESSAGE(e.getMessage());
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0001");
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		finally {
			// em.close();
		}

		return resp;
	}

	private void populates_times(Schedule schedule) {
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

			if (null != schedule.getMorning_time_start_str())
				schedule.setMorning_time_start(simpleDateFormat.parse(schedule
						.getMorning_time_start_str()));
			if (null != schedule.getAfternoon_time_end_str())
				schedule.setMorning_time_end(simpleDateFormat.parse(schedule
						.getMorning_time_end_str()));

			if (null != schedule.getAfternoon_time_start_str())
				schedule.setAfternoon_time_start(simpleDateFormat
						.parse(schedule.getAfternoon_time_start_str()));
			if (null != schedule.getAfternoon_time_end_str())
				schedule.setAfternoon_time_end(simpleDateFormat.parse(schedule
						.getAfternoon_time_end_str()));

			if (null != schedule.getEvening_time_start_str())
				schedule.setEvening_time_start(simpleDateFormat.parse(schedule
						.getEvening_time_start_str()));
			if (null != schedule.getEvening_time_end_str())
				schedule.setEvening_time_end(simpleDateFormat.parse(schedule
						.getEvening_time_end_str()));

			if (null != schedule.getNight_time_start_str())
				schedule.setNight_time_start(simpleDateFormat.parse(schedule
						.getNight_time_start_str()));
			if (null != schedule.getNight_time_end_str())
				schedule.setNight_time_end(simpleDateFormat.parse(schedule
						.getNight_time_end_str()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Schedule getSchedulebyScheduleId(Long scheduleId) {

		Response resp = new Response();
		Schedule Schedule = null;

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Schedule = (Schedule) em.find(Schedule.class, scheduleId);
			if (Schedule == null) {
				Schedule = new Schedule();
				Schedule.setScheduleId(0L);
			}
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			e.printStackTrace();
		} finally {

		}

		return Schedule;

	}

	public Response updateSchedule(Schedule schedule) {
		Response resp = new Response();
		System.out.println("Update Schedule ==>" + schedule);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Schedule Schedule = (Schedule) em.find(Schedule.class,
					schedule.getScheduleId());
			if (Schedule == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Schedule with Id = "
						+ schedule.getScheduleId());
				return resp;
			}

			em.merge(schedule);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public Response deleteSchedule(Long ScheduleId) {
		Response resp = new Response();

		System.out.println("Delete Schedule");
		System.out.println("Deleting Schedule  =>" + ScheduleId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Schedule Schedule = (Schedule) em.find(Schedule.class, ScheduleId);
			if (Schedule == null) {
				resp.setERROR_CODE("0001");
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("No Schedule with Id = " + ScheduleId);
				return resp;
			}
			Schedule.setStatus(Constants.DELETED);
			em.merge(Schedule);
			em.getTransaction().commit();
			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}

	public List<Schedule> getScheduleListbyLabBranch(Long labBranchCd) {

		List<Object[]> objList = null;
		List<Schedule> scheduleList = null;
		System.out.println("Get Entire Schedule List for a Lab Branch = "
				+ labBranchCd);

		try {
			Query q = em.createNativeQuery(selectquery
					+ " where LAB_BRANCH_CD =:labBranchCd", Schedule.class);
			q.setParameter("labBranchCd", labBranchCd);
			scheduleList = q.getResultList();

			for (Iterator<Schedule> iterator = scheduleList.iterator(); iterator
					.hasNext();) {
				Schedule schedule = (Schedule) iterator.next();
				populates_times(schedule);
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Entire Schedule List " + scheduleList);
		return scheduleList;

	}

	public List<Schedule> getScheduleListbyLabRep(Long labRepId) {

		List<Object[]> objList = null;
		List<Schedule> scheduleList = null;
		System.out.println("Get Entire Schedule List");

		try {
			Query q = em.createNativeQuery(selectquery
					+ " where LAB_REP_CD =:labRepId", Schedule.class);
			q.setParameter("labRepId", labRepId);
			scheduleList = q.getResultList();
			/*
			 * objList = q.getResultList(); scheduleList =
			 * populateScheduleList(objList);
			 */
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}
		System.out.println("Entire Schedule List " + scheduleList);
		return scheduleList;

	}

	public List<Schedule> getScheduleListbyDoctor(Long doctorId) {
		// List<Object[]> objList = null;
		List<Schedule> scheduleList = null;
		System.out.println("Get Entire Schedule List");

		try {
			Query q = em.createNativeQuery(selectquery
					+ " where DOC_ID =:DoctorId", Schedule.class);
			q.setParameter("DoctorId", doctorId);
			scheduleList = q.getResultList();
			/*
			 * objList = q.getResultList(); scheduleList =
			 * populateScheduleList(objList);
			 */
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
		}

		System.out.println("Entire Schedule List " + scheduleList);
		return scheduleList;

	}

	/*
	 * private List<Schedule> populateScheduleList(List<Object[]> objList) {
	 * 
	 * List<Schedule> scheduleList = new ArrayList<Schedule>(objList.size());
	 * for (Object obj[] : objList) { Schedule schedule = new Schedule(); if
	 * (obj[0] instanceof Number) { schedule.setScheduleId(((Number)
	 * obj[0]).longValue()); // SCHDLE_ID } if (obj[1] instanceof Number) {
	 * schedule.setScheduleId(((Number) obj[1]).longValue()); // DOC_ID } if
	 * (obj[2] instanceof Number) { schedule.setBranchCode(((Number)
	 * obj[2]).longValue()); // LAB_BRANCH_CD } if (obj[3] instanceof Number) {
	 * schedule.setLabRepId(((Number) obj[3]).longValue()); // LAB_REP_CD } if
	 * (obj[4] instanceof String) { schedule.setWorking_days((String) obj[4]);
	 * // WORKING_DAYS } if (obj[5] instanceof Date) {
	 * schedule.setMorning_time_start((Date) obj[5]); // MRNG_START } if (obj[6]
	 * instanceof Date) { schedule.setMorning_time_end((Date) obj[6]); //
	 * MRNG_END } if (obj[7] instanceof Number) {
	 * schedule.setMorning_tokens_total(((Number) obj[7]).intValue()); //
	 * MRNG_TKNS_TOTAL }
	 * 
	 * if (obj[8] instanceof Date) { schedule.setAfternoon_time_start((Date)
	 * obj[8]); // AFTRN_START } if (obj[9] instanceof Date) {
	 * schedule.setAfternoon_time_end((Date) obj[9]); // AFTRN_END } if (obj[10]
	 * instanceof Number) { schedule.setAfternoon_tokens_total(((Number)
	 * obj[10]) .intValue()); // AFTRN_TKNS_TOTAL }
	 * 
	 * if (obj[11] instanceof Date) { schedule.setEvening_time_start((Date)
	 * obj[11]); // EVNG_START } if (obj[12] instanceof Date) {
	 * schedule.setEvening_time_end((Date) obj[12]); // EVNG_END } if (obj[13]
	 * instanceof Number) { schedule.setEvening_tokens_total(((Number)
	 * obj[13]).intValue()); // EVNG_TKNS_TOTAL }
	 * 
	 * if (obj[14] instanceof Date) { schedule.setNight_time_start((Date)
	 * obj[14]); // NIGHT_START } if (obj[15] instanceof Date) {
	 * schedule.setNight_time_end((Date) obj[15]); // NIGHT_END } if (obj[16]
	 * instanceof Number) { schedule.setNight_tokens_total(((Number)
	 * obj[16]).intValue()); // NIGHT_TKNS_TOTAL }
	 * 
	 * if (obj[17] instanceof Number) { schedule.setStatus(((Number)
	 * obj[17]).intValue()); // STATUS } scheduleList.add(schedule); } return
	 * scheduleList; }
	 */

}
