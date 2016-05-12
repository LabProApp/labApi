package com.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Doctor;
import com.beans.LabBranch;
import com.beans.LabOffice;
import com.beans.Patient;
import com.beans.Response;
import com.beans.Users;
import com.common.CommonUtilities;
import com.common.Constants;
import com.dao.EmManager;

public class UsersImpl {

	private static EntityManager em;

	public static UsersImpl instance;

	private UsersImpl() {

	}

	public static UsersImpl getInstance() {
		if (instance == null) {
			instance = new UsersImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response add(Users user) {

		Response resp = new Response();
		System.out.println("Add Users =>" + user);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			List<Users> usersList = get(user.getEmailId());

			if (usersList.size() > 0) {

				resp.setERROR_CODE(Constants.RESP_ALREADYEXISTS);
				resp.setSTATUS("FAIL");
				resp.setERROR_MESSAGE("User with EMAIL ID:" + user.getEmailId()
						+ " Already Exists");

				return resp;

			}

			user.setStatus(Constants.PENDNG_ACTIVATE);
			String OTP = CommonUtilities.generateOTP();
			user.setOtp(OTP);
			CommonUtilities cu = new CommonUtilities();
			try {
				cu.sendActivationLinkEmail("rupinder@finxera.com",OTP);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setOtpSentTime(new Date());
			em.persist(user);

			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_DBERROR);
			em.getTransaction().rollback();
			e.printStackTrace();
		} catch (Exception e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_CONNERROR);
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return resp;
	}

	public List<Users> get(String emailId) {
		Response resp = new Response();

		List<Object[]> objlist = null;
		List<Users> userList = null;
		try {

			Query q = em
					.createNativeQuery("SELECT ID,EMAIL_ID,MOBILE,ENC_PASSWD,USER_TYPE,STATUS,OTP,OTP_TIME,NAME FROM USERS where EMAIL_ID=:emailId");
			q.setParameter("emailId", emailId);

			objlist = q.getResultList();

			userList = new ArrayList<Users>(objlist.size());
			for (Object obj[] : objlist) {

				Users user = new Users();

				if (obj[0] instanceof Number) {
					user.setId(((Number) obj[0]).longValue()); // ID
				}

				if (obj[1] instanceof String) {
					user.setEmailId(((String) obj[1])); // EMAIL_ID
				}
				if (obj[2] instanceof String) {
					user.setMobile(((String) obj[2])); // MOBILE
				}
				if (obj[3] instanceof String) {
					user.setEncPassword(((String) obj[3])); // ENC_PASSWD
				}
				if (obj[4] instanceof String) {
					user.setUserTyp(((String) obj[4])); // USER_TYPE
				}
				if (obj[5] instanceof Number) {
					user.setStatus(((Number) obj[5]).intValue()); // STATUS
				}
				if (obj[6] instanceof String) {
					user.setOtp(((String) obj[6])); // OTP
				}
				if (obj[7] instanceof Date) {
					user.setOtpSentTime((Date) obj[7]); // OTP SetTime
				}
				if (obj[8] instanceof String) {
					user.setName(((String) obj[8])); // Name
				}
				userList.add(user);
			}

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return userList;

	}

	public Response updateuser(Users user) {
		Response resp = new Response();
		System.out.println("Update Users ==>" + user);

		try {

			List<Users> usersList = get(user.getEmailId());
			if (usersList != null) {
				if (usersList.size() == 0) {
					resp.setERROR_CODE(Constants.RESP_NORECORD);
					resp.setSTATUS("FAIL");
					resp.setERROR_MESSAGE("No User with EMAIL ID:"
							+ user.getEmailId());

					return resp;
				}
				if (usersList.size() == 1) {
					user.setId(usersList.get(0).getId());
				}

			}
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(user);
			em.getTransaction().commit();
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
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

	public Response deleteuser(String emailId) {
		Response resp = new Response();

		System.out.println("Deleting user  =>" + emailId);

		try {

			List<Users> usersList = get(emailId);
			if (usersList != null) {
				if (usersList.size() == 0) {
					resp.setERROR_CODE(Constants.RESP_NORECORD);
					resp.setSTATUS("FAIL");
					resp.setERROR_MESSAGE("No User with EMAIL ID:" + emailId);

					return resp;
				}
			}
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE USERS set status=:status WHERE EMAIL_ID=:emailId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("emailId", emailId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of Users Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
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

	public Response activateuser(String emailId, String otp) {

		Response resp = new Response();
		System.out.println("Activating user  =>" + emailId + " Otp " + otp);
		String emailIdstr = null;
		Users user = null;
		if (null != emailId) {
			/*
			 * byte[] decodedBytes = Base64.decodeBase64(emailId); emailIdstr =
			 * new String(decodedBytes); System.out.println("decodedBytes " +
			 * emailIdstr);
			 */
			emailIdstr = emailId;
		}
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			List<Users> usersList = get(emailIdstr);
			if (usersList != null) {
				if (usersList.size() == 0) {
					resp.setERROR_CODE(Constants.RESP_NORECORD);
					resp.setSTATUS("FAIL");
					resp.setERROR_MESSAGE("No User with EMAIL ID:" + emailIdstr);

					return resp;
				}
				if (usersList.size() == 1) {

					user = usersList.get(0);
					if (user.getStatus() == Constants.ACTIVE) {
						resp.setERROR_CODE(Constants.RESP_ALREADYEXISTS);
						resp.setSTATUS("FAIL");
						resp.setERROR_MESSAGE("User with EMAIL ID:"
								+ emailIdstr + " Already Active");

						return resp;
					}
					long diff = (new Date()).getTime()
							- user.getOtpSentTime().getTime();

					long diffSeconds = diff / 1000 % 60;
					long diffMinutes = diff / (60 * 1000) % 60;
					long diffHours = diff / (60 * 60 * 1000) % 24;
					long diffDays = diff / (24 * 60 * 60 * 1000);

					System.out.print(diffDays + " days, ");
					System.out.print(diffHours + " hours, ");
					System.out.print(diffMinutes + " minutes, ");
					System.out.print(diffSeconds + " seconds.");

					if (diffMinutes > 30) {

						resp.setERROR_CODE(Constants.RESP_OTP_EXPIRED);
						resp.setSTATUS("FAIL");
						resp.setERROR_MESSAGE("OTP has been Expired, Please generate a new one.");
						return resp;

					}
					if (!otp.equalsIgnoreCase(user.getOtp())) {

						resp.setERROR_CODE(Constants.RESP_NORECORD);
						resp.setSTATUS("FAIL");
						resp.setERROR_MESSAGE("OTP has not been matched, Please generate a new one.");
						return resp;

					}

				}

			}

			Query q = em
					.createNativeQuery("UPDATE USERS set status=:status WHERE EMAIL_ID=:emailIdstr");

			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("emailIdstr", emailIdstr);
			int updateCount = q.executeUpdate();
			System.out.println("Number of Users Activated = " + updateCount);

			if (user.getUserTyp().equalsIgnoreCase(Constants.DOCTOR)) {
				DoctorImpl dImpl = DoctorImpl.getInstance();
				Doctor d = new Doctor();
				d.setDoctorName(user.getName());
				d.setPrimaryMobileNo(user.getMobile());
				d.setEmailID(user.getEmailId());
				d.setStatus(Constants.ACTIVE);
				Response r = dImpl.add(d);
				if (r.getSTATUS().equalsIgnoreCase(Constants.FAIL)) {

					resp.setSTATUS("FAIL");
					resp.setERROR_CODE(Constants.RESP_DBERROR);
					em.getTransaction().rollback();

				}
			}

			if (user.getUserTyp().equalsIgnoreCase(Constants.LAB_OFFICE)) {

				LabOfficeImpl loImpl = LabOfficeImpl.getInstance();
				LabOffice lo = new LabOffice();
				lo.setLabName(user.getName());
				lo.setPrimaryMobileNo(user.getMobile());
				lo.setEmailID(user.getEmailId());
				lo.setStatus(Constants.ACTIVE);
				Response r = loImpl.addLabOffice(lo);
				if (r.getSTATUS().equalsIgnoreCase(Constants.FAIL)) {

					resp.setSTATUS("FAIL");
					resp.setERROR_CODE(Constants.RESP_DBERROR);
					em.getTransaction().rollback();

				}
			}
			if (user.getUserTyp().equalsIgnoreCase(Constants.LAB_BRANCH)) {

				LabBranchImpl lbImpl = LabBranchImpl.getInstance();
				LabBranch lb = new LabBranch();
				lb.setLabName(user.getName());
				lb.setPrimaryMobileNo(user.getMobile());
				lb.setEmailID(user.getEmailId());
				lb.setStatus(Constants.ACTIVE);
				Response r = lbImpl.addLab(lb);
				if (r.getSTATUS().equalsIgnoreCase(Constants.FAIL)) {

					resp.setSTATUS("FAIL");
					resp.setERROR_CODE(Constants.RESP_DBERROR);
					em.getTransaction().rollback();

				}
			}
			if (user.getUserTyp().equalsIgnoreCase(Constants.PATIENT)) {
				PatientImpl lbImpl = PatientImpl.getInstance();
				Patient pt = new Patient();
				pt.setPatientName(user.getName());
				pt.setPrimaryMobileNo(user.getMobile());
				pt.setEmailID(user.getEmailId());
				pt.setStatus(Constants.ACTIVE);
				Response r = lbImpl.add(pt);
				if (r.getSTATUS().equalsIgnoreCase(Constants.FAIL)) {

					resp.setSTATUS("FAIL");
					resp.setERROR_CODE(Constants.RESP_DBERROR);
					em.getTransaction().rollback();

				}
			}

			em.getTransaction().commit();
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
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
}
