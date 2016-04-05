package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Doctor;
import com.beans.DoctorDto;
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

	public List<DoctorDto> getdoctorListBySpecializationAddress(String city,String specialization) {
		List<Object[]> docList = new ArrayList<Object[]>();
		List<DoctorDto> DoctorDtoList = null;
		System.out.println("getdoctorListByAddress doctor List");
		try {

			Query q = em.createNativeQuery("SELECT * FROM Doctor d,Address a where d.docAddress_ADDRESS_ID = a.ADDRESS_ID AND a.CITY=:city AND d.DOC_SPEC like %:specialization%");
			q.setParameter("city", city);
			q.setParameter("city", specialization);
			
			docList = q.getResultList();

			DoctorDtoList = new ArrayList<DoctorDto>(docList.size());
			for (Object obj[] : docList) {

				DoctorDto doctorDto = new DoctorDto();

				DoctorDtoList.add(doctorDto);

			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			// em.close();
		}

		System.out.println("Entire Doctor List " + DoctorDtoList);
		return DoctorDtoList;

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
}
