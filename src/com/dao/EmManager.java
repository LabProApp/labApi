package com.dao;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.common.Configuration;

public class EmManager {

	public final static Properties jdbcProperties = new Properties();
	private static EmManager instance;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;
	public static final String dataSource = "mediapp";

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		EmManager.em = em;
	}

	private EmManager() {
	}

	// Get the only object available
	public static EmManager getInstance() {
		if (instance == null) {
			instance = new EmManager();

			entityManagerFactory = Persistence.createEntityManagerFactory(
					dataSource, Configuration.getInstance("server"));

			em = entityManagerFactory.createEntityManager();

		}
		return instance;
	}

}
