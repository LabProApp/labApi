package com.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Response;
import com.beans.Users;
import com.common.Constants;

public class UsersImpl {

	private static UsersImpl instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;

	private UsersImpl() {

	}

	public static UsersImpl getInstance() {
		if (instance == null) {
			instance = new UsersImpl();
		}

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

			em.persist(user);

			resp.setERROR_CODE(Constants.RESP_SUCCESS);
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();
		} catch (HibernateException e) {
			resp.setSTATUS("FAIL");

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
					.createNativeQuery("SELECT ID,EMAIL_ID,MOBILE,ENC_PASSWD,USER_TYPE,STATUS FROM USERS where EMAIL_ID=:emailId");
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

	public Response activateuser(String emailId) {

		Response resp = new Response();
		System.out.println("Activating user  =>" + emailId);

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			List<Users> usersList = get(emailId);
			if (usersList != null) {
				if (usersList.size() == 0) {
					resp.setERROR_CODE(Constants.RESP_NORECORD);
					resp.setSTATUS("FAIL");
					resp.setERROR_MESSAGE("No User with EMAIL ID:" + emailId);

					return resp;
				}
				if (usersList.size() == 1) {

					Users user = usersList.get(0);
					if (user.getStatus() == Constants.ACTIVE) {
						resp.setERROR_CODE(Constants.RESP_FAIL);
						resp.setSTATUS("FAIL");
						resp.setERROR_MESSAGE("User with EMAIL ID:" + emailId
								+ " Already Active");

						return resp;
					}
				}
			}

			Query q = em
					.createNativeQuery("UPDATE USERS set status=:status WHERE EMAIL_ID=:emailId");

			q.setParameter("status", Constants.ACTIVE);
			q.setParameter("emailId", emailId);
			int updateCount = q.executeUpdate();
			System.out.println("Number of Users Activated = " + updateCount);
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
