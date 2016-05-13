package com.services.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.common.Configuration;

import org.hibernate.HibernateException;

import com.beans.Images;
import com.beans.Response;
import com.common.AWS_S3util;
import com.common.CommonUtilities;
import com.common.Constants;
import com.dao.EmManager;

public class ImagesImpl {

	private static EntityManager em;

	public static ImagesImpl instance;

	private ImagesImpl() {

	}

	public static ImagesImpl getInstance() {
		if (instance == null) {
			instance = new ImagesImpl();
			em = EmManager.getInstance().getEm();
		}

		return instance;
	}

	public Response add(Images image) {
		Response resp = new Response();

		if (CommonUtilities.isEmpty(image.getEntityTyp())
				|| null == image.getEntityId()) {
			resp.setSTATUS(Constants.FAIL);
			resp.setERROR_CODE(Constants.RESP_MISSING_PARAMS);
			resp.setERROR_MESSAGE("Entity Type & Entity Id  is Manadatory");
			return resp;
		}

		String image_name = null;

		image_name = image.getEntityTyp() + "/" + image.getImgTyp() + "/"
				+ image.getImgname();

		AWS_S3util us = new AWS_S3util();
		resp = us.upload_s3File(image.getImage(), image_name);
		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			image.setStatus(Constants.ACTIVE);
			image.setS3Path(image_name);
			image.setImgUrl(Configuration.getInstance("server").getProperty("AWS_URL")+Configuration.getInstance("server").getProperty("s3_bucket_name")+"/"+image_name);
			System.out.println(image.toString());
			em.persist(image);

			resp.setERROR_CODE("0000");
			resp.setSTATUS("SUCCESS");

			em.getTransaction().commit();

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

	public Images download(Images image) {
		Response resp = new Response();

		try {

			Images dwnlod_img = new Images();

			if (CommonUtilities.isEmpty(image.getEntityTyp())
					|| null == image.getEntityId()) {
				dwnlod_img.setEntityId(0L);
				dwnlod_img.setImage(null);
				dwnlod_img.setImgname(null);
				dwnlod_img.setImgTyp(null);
				return dwnlod_img;
			}
			String image_name = image.getEntityTyp() + "/" + image.getImgTyp()
					+ "/" + image.getImgname();
			AWS_S3util us = new AWS_S3util();
			dwnlod_img = us.download_s3File(image_name);
			dwnlod_img.setEntityId(image.getEntityId());

			if (null != dwnlod_img.getImage()) {
				dwnlod_img.setImgname(null);

			}

			return dwnlod_img;

		} catch (Exception e) {
			resp.setSTATUS("FAIL");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}
		return null;

	}

	public Response updateimage(Images image) {
		Response resp = new Response();
		System.out.println("Update Images ==>" + image);

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			em.merge(image);
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

	public Response deleteimage(Images image) {
		Response resp = new Response();

		System.out.println("Deleting image  =>" + image.toString());

		try {

			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query q = em
					.createNativeQuery("UPDATE IMAGES set status=:status WHERE ENTITY_ID=:entityId AND ENTITY_TYP=:entityTyp AND S3_PATH=:s3Path");
			q.setParameter("status", Constants.DELETED);
			q.setParameter("entityId", image.getEntityId());
			q.setParameter("entityTyp", image.getEntityTyp());
			q.setParameter("s3Path", image.getS3Path());

			int updateCount = q.executeUpdate();

			System.out.println("Number of Images Deleted = " + updateCount);
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

	public List<Images> getImageList(Long entityId, String entityTyp) {
		// TODO Auto-generated method stub
		return null;
	}

}
