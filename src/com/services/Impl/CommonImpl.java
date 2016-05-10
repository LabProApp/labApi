package com.services.Impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.beans.Doctor;
import com.beans.Patient;
import com.beans.Response;
import com.beans.S3Image;
import com.common.AWS_S3util;
import com.common.CommonUtilities;
import com.common.Constants;
import com.dao.EmManager;

public class CommonImpl {

	private static EntityManager em;

	public static CommonImpl instance;

	private CommonImpl() {

	}

	public static CommonImpl getInstance() {
		if (instance == null) {
			instance = new CommonImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response upload_s3(S3Image img) {
		Response resp = new Response();

		if (CommonUtilities.isEmpty(img.getImg_type())
				|| CommonUtilities.isEmpty(img.getImg_name())) {
			resp.setSTATUS(Constants.FAIL);
			resp.setERROR_CODE(Constants.RESP_MISSING_PARAMS);
			resp.setERROR_MESSAGE("Image Type & Image Name is Manadatory");
			return resp;
		}

		String img_name = null;

		if (img.getUser_type().equalsIgnoreCase(Constants.DOCTOR)) {
			img_name = Constants.DOCTOR + "/" + img.getImg_type() + "/"
					+ img.getImg_name();
		}
		if (img.getUser_type().equalsIgnoreCase(Constants.LAB_BRANCH)) {
			img_name = Constants.LAB_BRANCH + "/" + img.getImg_type() + "/"
					+ img.getImg_name();
		}
		if (img.getUser_type().equalsIgnoreCase(Constants.LAB_OFFICE)) {
			img_name = Constants.LAB_OFFICE + "/" + img.getImg_type() + "/"
					+ img.getImg_name();
		}
		if (img.getUser_type().equalsIgnoreCase(Constants.PATIENT)) {
			img_name = Constants.PATIENT + "/" + img.getImg_type() + "/"
					+ img.getImg_name();
		}
		AWS_S3util us = new AWS_S3util();
		resp = us.upload_s3File(img.getImage(), img_name);
		try {
			if (img.getUser_type().equalsIgnoreCase(Constants.DOCTOR)) {

				//Need to update particular image with img.getImg_num();
				
				Doctor d = new Doctor();
				Query q = em
						.createNativeQuery("UPDATE DOCTOR set IMG_PATH=:img_path WHERE DOC_ID=:doctorId");
				q.setParameter("img_path", img.getImg_name());
				q.setParameter("doctorId", img.getId());

				int updateCount = q.executeUpdate();

				System.out
						.println("Number of Doctors Updated = " + updateCount);

			}
			if (img.getUser_type().equalsIgnoreCase(Constants.LAB_BRANCH)) {

			}
			if (img.getUser_type().equalsIgnoreCase(Constants.LAB_OFFICE)) {

			}
			if (img.getUser_type().equalsIgnoreCase(Constants.PATIENT)) {

				Patient d = new Patient();
				Query q = em
						.createNativeQuery("UPDATE PATIENT set IMG_PATH=:img_path WHERE PTNT_ID=:ptntId");
				q.setParameter("img_path", img.getImg_name());
				q.setParameter("ptntId", img.getId());

				int updateCount = q.executeUpdate();

				System.out.println("Number of Patients Updated = "
						+ updateCount);

			}
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

	public S3Image download_s3(String img_name) {
		S3Image dwnlod_img = new S3Image();

		if (CommonUtilities.isEmpty(img_name)) {
			dwnlod_img.setId("0");
			dwnlod_img.setImage(null);
			dwnlod_img.setImg_name(null);
			dwnlod_img.setImg_type(null);

			return dwnlod_img;
		}

		AWS_S3util us = new AWS_S3util();
		dwnlod_img = us.download_s3File(img_name);
		if (null != dwnlod_img.getImage()) {
			dwnlod_img.setImg_name(img_name);

		}

		return dwnlod_img;
	}

}
