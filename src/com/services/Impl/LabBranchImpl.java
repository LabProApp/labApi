package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import com.beans.LabBranch;
import com.beans.Response;
import com.common.Constants;
import com.dto.LabBranchDto;

public class LabBranchImpl {

	private static LabBranchImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private LabBranchImpl() {

	}

	public static LabBranchImpl getInstance() {
		if (instance == null)
			instance = new LabBranchImpl();
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

	public Response addLab(LabBranch lab_branch) {
		Response resp = new Response();
		System.out.println("Add Lab Branch =>" + lab_branch);

		Long labbranchCode = null;
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(lab_branch);

			System.out.println("Lab Branch Created - " + labbranchCode
					+ "Lab Office - " + lab_branch.getLabOfficeId());
			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");

			em.getTransaction().commit();
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="
					+ lab_branch.getLabOfficeId());
			em.getTransaction().rollback();
			ce.printStackTrace();

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

	public LabBranch getLab(Long labbranchCode) {
		LabBranch lab_branch = null;
		Response resp = new Response();

		try {
			lab_branch = em.find(LabBranch.class, labbranchCode);
			if (lab_branch == null) {
				lab_branch = new LabBranch();
				lab_branch.setLabOfficeId(0L);
				lab_branch.setLabbranchCode(0L);
			}
			System.out.println("Lab Branch Fetched - "
					+ lab_branch.getLabbranchCode() + "Lab Office - "
					+ lab_branch.getLabOfficeId());

		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0002");

			e.printStackTrace();
		} finally {

		}

		return lab_branch;

	}

	public List<LabBranchDto> getLabList(Long OfficeId) {
		List<Object[]> objList = null;
		List<LabBranchDto> LabBranchDtoList = null;
		System.out.println("Get Entire LabBranch List");

		try {
			
			Query q = em
					.createNativeQuery("SELECT LAB_BRANCH_CD,LAB_OFFICE_ID,LAB_NAME,STATUS,LAB_BR_OWNER,ADD_LINE1,ADD_LINE2,ADD_LINE3,CITY,STATE,ZIP,COUNTRY,PRIM_MOBILE,EMAIL_ID,IMG_PATH FROM LAB_BRANCH l,ADDRESS a where ADDRESS_ID=labAddress_ADDRESS_ID AND LAB_OFFICE_ID =:OfficeId");
			q.setParameter("OfficeId", OfficeId);

			objList = q.getResultList();

			LabBranchDtoList = new ArrayList<LabBranchDto>(objList.size());
			for (Object obj[] : objList) {
				
				LabBranchDto labBranchDto = new LabBranchDto();
				if (obj[0] instanceof Number) {
					labBranchDto
							.setLabbranchCode(((Number) obj[0]).longValue()); // LAB_BRANCH_CD
				}
				if (obj[1] instanceof Number) {
					labBranchDto.setLabOfficeId(((Number) obj[1]).longValue()); // LAB_OFFICE_ID
				}
				if (obj[2] instanceof String) {
					labBranchDto.setLabName(((String) obj[2])); // LAB_NAME
				}
				if (obj[3] instanceof Number) {
					labBranchDto.setStatus(((Number) obj[3]).intValue()); // STATUS
				}
				if (obj[4] instanceof String) {
					labBranchDto.setLabBranchOwner((String) obj[4]); // LAB_BR_OWNER
				}
				if (obj[5] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine1((String) obj[5]); // ADD_LINE1
				}
				if (obj[6] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine2((String) obj[6]); // ADD_LINE2
				}
				if (obj[7] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine3((String) obj[7]); // ADD_LINE3
				}
				if (obj[8] instanceof String) {
					labBranchDto.getLabAddress().setCity((String) obj[8]); // CITY
				}
				if (obj[9] instanceof String) {
					labBranchDto.getLabAddress().setState((String) obj[9]); // STATE
				}
				if (obj[10] instanceof String) {
					labBranchDto.getLabAddress().setZip((String) obj[10]); // CITY
				}
				if (obj[11] instanceof String) {
					labBranchDto.getLabAddress().setCountry((String) obj[11]); // COUNTRY
				}
				if (obj[12] instanceof String) {
					labBranchDto.setPrimaryMobileNo((String) obj[12]); // COUNTRY
				}
				if (obj[13] instanceof String) {
					labBranchDto.setEmailID((String) obj[13]); // EMAIL_ID
				}
				if (obj[14] instanceof String) {
					labBranchDto.setImg_path((String) obj[14]); // IMG_PATH
				}
				LabBranchDtoList.add(labBranchDto);

			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return LabBranchDtoList;
	}

	public List<LabBranchDto> getLabBranchByCity(String city,String state) {
		List<Object[]> objList = null;
		List<LabBranchDto> LabBranchDtoList = null;
		System.out.println("Get Entire LabBranch List");

		try {
			
			Query q = em.createNativeQuery("SELECT LAB_BRANCH_CD,LAB_OFFICE_ID,LAB_NAME,STATUS,LAB_BR_OWNER,ADD_LINE1,ADD_LINE2,ADD_LINE3,CITY,STATE,ZIP,COUNTRY,PRIM_MOBILE,EMAIL_ID,IMG_PATH FROM LAB_BRANCH l,ADDRESS a where ADDRESS_ID=labAddress_ADDRESS_ID AND a.CITY =:city AND a.state = :state");
			q.setParameter("city", city);
			q.setParameter("state", state);

			objList = q.getResultList();

			LabBranchDtoList = new ArrayList<LabBranchDto>(objList.size());
			for (Object obj[] : objList) {
				
				LabBranchDto labBranchDto = new LabBranchDto();
				if (obj[0] instanceof Number) {
					labBranchDto
							.setLabbranchCode(((Number) obj[0]).longValue()); // LAB_BRANCH_CD
				}
				if (obj[1] instanceof Number) {
					labBranchDto.setLabOfficeId(((Number) obj[1]).longValue()); // LAB_OFFICE_ID
				}
				if (obj[2] instanceof String) {
					labBranchDto.setLabName(((String) obj[2])); // LAB_NAME
				}
				if (obj[3] instanceof Number) {
					labBranchDto.setStatus(((Number) obj[3]).intValue()); // STATUS
				}
				if (obj[4] instanceof String) {
					labBranchDto.setLabBranchOwner((String) obj[4]); // LAB_BR_OWNER
				}
				if (obj[5] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine1((String) obj[5]); // ADD_LINE1
				}
				if (obj[6] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine2((String) obj[6]); // ADD_LINE2
				}
				if (obj[7] instanceof String) {
					labBranchDto.getLabAddress().setAddressLine3((String) obj[7]); // ADD_LINE3
				}
				if (obj[8] instanceof String) {
					labBranchDto.getLabAddress().setCity((String) obj[8]); // CITY
				}
				if (obj[9] instanceof String) {
					labBranchDto.getLabAddress().setState((String) obj[9]); // STATE
				}
				if (obj[10] instanceof String) {
					labBranchDto.getLabAddress().setZip((String) obj[10]); // CITY
				}
				if (obj[11] instanceof String) {
					labBranchDto.getLabAddress().setCountry((String) obj[11]); // COUNTRY
				}
				if (obj[12] instanceof String) {
					labBranchDto.setPrimaryMobileNo((String) obj[12]); // COUNTRY
				}
				if (obj[13] instanceof String) {
					labBranchDto.setEmailID((String) obj[13]); // EMAIL_ID
				}
				if (obj[14] instanceof String) {
					labBranchDto.setImg_path((String) obj[14]); // IMG_PATH
				}
				LabBranchDtoList.add(labBranchDto);

			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return LabBranchDtoList;
	}
	public Response updateLabBranch(LabBranch lab_branch) {

		Response resp = new Response();
		System.out.println("Update Lab Branch ==>" + lab_branch);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(lab_branch);
			em.getTransaction().commit();

			resp.setSTATUS("SUCCESS");
			resp.setERROR_CODE("0000");
		} catch (ConstraintViolationException ce) {
			resp.setSTATUS("FAIL");
			resp.setERROR_CODE("0003");
			resp.setERROR_MESSAGE("No Lab Branch Exists with Office Id ="
					+ lab_branch.getLabOfficeId());
			em.getTransaction().rollback();
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

	public Response deleteLabBranch(Long labBranchCode) {
		Response resp = new Response();

		System.out.println("Deleting Lab Branch  =>" + labBranchCode);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE LAB_BRANCH set status=:status WHERE LAB_BRANCH_CD=:labBranchCode");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("labBranchCode", labBranchCode);

			int updateCount = q.executeUpdate();

			System.out.println("Number of LAB_BRANCH Deleted = " + updateCount);
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

	public Response activateLabBranch(Long labBranchCode) {
		Response resp = new Response();

		System.out.println("Activating Lab Branch  =>" + labBranchCode);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE LAB_BRANCH set status=:status WHERE LAB_BRANCH_CD=:labBranchCode");
			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("labBranchCode", labBranchCode);

			int updateCount = q.executeUpdate();

			System.out.println("Number of LAB_BRANCH Activated = " + updateCount);
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
}
