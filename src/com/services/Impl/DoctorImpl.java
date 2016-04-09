package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Doctor;
import com.beans.QueryParam;
import com.beans.Response;
import com.common.Constants;
import com.dto.LabBranchDto;

public class DoctorImpl {

	private static DoctorImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private DoctorImpl() {

	}

	public static DoctorImpl getInstance() {
		if (instance == null)
			instance = new DoctorImpl();

		try {
			if (entityManagerFactory == null || em == null) {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("mediapp");
				em = entityManagerFactory.createEntityManager();

			}

		} catch (Exception ex) {
			System.err.println("Failed to create entityManagerFactory object."
					+ ex);
			ex.printStackTrace();
		}
		return instance;
	}

	public Response add(Doctor doctor) {

		Response resp = new Response();
		System.out.println("Add Doctor =>" + doctor);

		Long doctorId = null;
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(doctor);

			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return resp;
	}

	public Doctor get(Long doctorId) {

		Response resp = new Response();
		Doctor doctor = null;

		try {
			doctor = em.find(Doctor.class, doctorId);
			if (doctor == null) {
				doctor = new Doctor();
				doctor.setDocId(0L);
			}

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

			e.printStackTrace();
		} finally {
			// em.close();
		}

		return doctor;

	}

	public List<Doctor> getdoctorList() {
		List<Doctor> docList = new ArrayList<Doctor>();
		System.out.println("Get Entire doctor List");
		try {

			docList = em.createQuery("SELECT d FROM Doctor d").getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			// em.close();
		}

		System.out.println("Entire Doctor List " + docList);
		return docList;

	}

	public Response updatedoctor(Doctor doctor) {
		Response resp = new Response();
		System.out.println("Update Doctor ==>" + doctor);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(doctor);
			em.getTransaction().commit();

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}

		return resp;
	}

	public Response deletedoctor(Long doctorId) {
		Response resp = new Response();

		System.out.println("Delete doctor");
		System.out.println("Deleting doctor  =>" + doctorId);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE DOCTOR set status=:status WHERE DOC_ID=:doctorId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("doctorId", doctorId);

			int updateCount = q.executeUpdate();
			System.out.println("Number of Doctors Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}

	public Response activatedoctor(Long doctorId) {

		Response resp = new Response();

		System.out.println("Activating doctor  =>" + doctorId);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE DOCTOR set status=:status WHERE DOC_ID=:doctorId");
			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("doctorId", doctorId);

			int updateCount = q.executeUpdate();
			System.out.println("Number of Doctors Activated = " + updateCount);
			em.getTransaction().commit();
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return resp;

	}

	public List<Doctor> getDoctorbyCity_Spec(String city,String spec,String state) {
		// Return List of Doctor including DoctorId,Name, Hospital Name, Fee,
		// Degree, Experience,Address,Primary/Secondary Mobile Number,Email
		// ID,ImgPath,bookFlag

		List<Object[]> docList = new ArrayList<Object[]>();
		List<Doctor> DoctorDtoList = null;
		System.out.println("getDoctorbyCity_Spec doctor List");
		try {

			Query q = em
					.createNativeQuery("SELECT d.DOC_ID,d.DOC_NAME,d.STATUS,d.HOSP_NAME,d.DOC_DEGREE,d.DOC_SPEC,d.DOC_EXP,d.FEE,d.BOOK_FLAG,d.PRIM_MOBILE,d.SECOND_MOBILE,d.EMAIL_ID,d.IMG_PATH,a.ADDRESS_ID,a.ADD_LINE1,a.ADD_LINE2,a.ADD_LINE3,a.CITY,a.STATE,a.COUNTRY,a.ZIP FROM Doctor d,Address a where d.docAddress_ADDRESS_ID = a.ADDRESS_ID AND a.CITY like :city AND a.STATE like :state AND d.DOC_SPEC like :specialization AND d.STATUS = :status");
		
			q.setParameter("city", city);
			q.setParameter("state", state);
			q.setParameter("specialization", spec);
			
			q.setParameter("status", Constants.ACTIVE);

			docList = q.getResultList();

			DoctorDtoList = new ArrayList<Doctor>(docList.size());

			for (Object obj[] : docList) {

				Doctor doctor = new Doctor();
				if (obj[0] instanceof Number) {
					doctor.setDocId(((Number) obj[0]).longValue()); // DOC_ID
				}
				if (obj[1] instanceof String) {
					doctor.setDoctorName(((String) obj[1])); // DOC_NAME
				}
				if (obj[2] instanceof Number) {
					doctor.setStatus(((Number) obj[2]).intValue()); // STATUS
				}
				if (obj[3] instanceof String) {
					doctor.setHospitalName(((String) obj[3])); // HOSP_NAME
				}
				if (obj[4] instanceof String) {
					doctor.setDoctorDegrees(((String) obj[4])); // DOC_DEGREE
				}
				if (obj[5] instanceof String) {
					doctor.setDoctorSpecialization(((String) obj[5])); // DOC_SPEC
				}

				if (obj[6] instanceof String) {
					doctor.setDoctorExperience(((String) obj[6])); // DOC_EXP
				}
				if (obj[7] instanceof Number) {
					doctor.setFee(((Number) obj[7]).intValue()); // FEE
				}
				if (obj[8] instanceof Number) {
					doctor.setBookFlag(((Number) obj[8]).intValue()); // Book_Flag
				}
				if (obj[9] instanceof String) {
					doctor.setPrimaryMobileNo(((String) obj[9])); // PRIM_MOBILE
				}
				if (obj[10] instanceof String) {
					doctor.setSecondaryMobileNo(((String) obj[10])); // SECOND_MOBILE
				}
				if (obj[11] instanceof String) {
					doctor.setEmailID(((String) obj[11])); // EMAIL_ID
				}
				if (obj[12] instanceof String) {
					doctor.setImg_path(((String) obj[12])); // IMG_PATH
				}
				if (obj[13] instanceof Number) {
					doctor.getDocAddress().setAddressId(
							((Number) obj[13]).longValue()); // ADDRESS_ID
				}
				if (obj[14] instanceof String) {
					doctor.getDocAddress().setAddressLine1(((String) obj[14])); // ADD_LINE1
				}
				if (obj[15] instanceof String) {
					doctor.getDocAddress().setAddressLine2(((String) obj[15])); // ADD_LINE2
				}
				if (obj[16] instanceof String) {
					doctor.getDocAddress().setAddressLine3(((String) obj[16])); // ADD_LINE3
				}
				if (obj[17] instanceof String) {
					doctor.getDocAddress().setCity(((String) obj[17])); // CITY
				}
				if (obj[18] instanceof String) {
					doctor.getDocAddress().setState(((String) obj[18])); // STATE
				}
				if (obj[19] instanceof String) {
					doctor.getDocAddress().setCountry(((String) obj[19])); // COUNTRY
				}
				if (obj[20] instanceof String) {
					doctor.getDocAddress().setZip(((String) obj[20])); // ZIP
				}
				DoctorDtoList.add(doctor);

			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			// em.close();
		}

		System.out.println("Entire Doctor List " + DoctorDtoList);
		return DoctorDtoList;

	}

	public List<Doctor> getDoctorbyGPS_Spec() {
		// TODO Auto-generated method stub
		return null;
	}
}
