package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Response;
import com.beans.Speciality;
import com.common.Constants;
import com.dao.EmManager;

public class SpecialityImpl {

	private static EntityManager em;

	public static SpecialityImpl instance;

	private SpecialityImpl() {

	}

	public static SpecialityImpl getInstance() {
		if (instance == null) {
			instance = new SpecialityImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response add(Speciality spec) {
		Response resp = new Response();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(spec);
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");
			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_FAIL);
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public List<Speciality> getspecsListbyTag(String searchString) {
		List<Speciality> specList = null;
	//	List<Object[]> objList;
		System.out.println("Get Entire spec List");

		try {

			Query q = em
					.createNativeQuery("SELECT * FROM SPECIALITY WHERE SEARCH_TAGS like :searchString",Speciality.class);
			q.setParameter("searchString", "%" + searchString + "%");
			
			specList= q.getResultList();
		/*	objList = q.getResultList();
			specList = new ArrayList<Speciality>(objList.size());
			for (Object obj[] : objList) {

				Speciality spec = new Speciality();
				if (obj[0] instanceof Number) {
					spec.setSpecId(((Number) obj[0]).longValue()); // SPEC_ID
				}
				if (obj[1] instanceof String) {
					spec.setSpecName(((String) obj[1])); // SPEC_NAME
				}
				if (obj[2] instanceof String) {
					spec.setSearch_tags(((String) obj[2])); // SEARCH_TAGS
				}
				specList.add(spec);
			}*/

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Entire Speciality List " + specList);
		return specList;

	}

	public List<Speciality> getspecList() {
		List<Speciality> specList = new ArrayList<Speciality>();
		System.out.println("Get Entire spec List");

		try {
			specList = em.createQuery("SELECT t FROM Speciality t")
					.getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}

		System.out.println("Entire Speciality List " + specList);
		return specList;

	}

	public Response updatespec(Speciality spec) {
		Response resp = new Response();
		System.out.println("Update Speciality ==>" + spec);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(spec);
			em.getTransaction().commit();
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE(Constants.RESP_FAIL);
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return resp;
	}

	public Response deletespec(Long specId) {
		Response resp = new Response();

		System.out.println("Delete spec");
		System.out.println("Deleting spec  =>" + specId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query q = em
					.createNativeQuery("UPDATE SPECIALITY set status=:status WHERE SPEC_ID=:specId");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("specId", specId);

			int updateCount = q.executeUpdate();

			System.out.println("Number of Patients Deleted = " + updateCount);
			em.getTransaction().commit();
			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}
		return resp;

	}
}
