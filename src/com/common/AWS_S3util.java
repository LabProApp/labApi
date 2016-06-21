package com.common;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.beans.Images;
import com.beans.Response;

public class AWS_S3util {

	public static void main(String[] args) throws IOException {
		AWS_S3util sc = new AWS_S3util();
		Images s3img = new Images();
		try {
			
			/*InputStream is = is = new FileInputStream(
					"/Users/nikhil/Profile-APR.pdf");

			byte[] bytes = IOUtils.toByteArray(is);
			s3img.setImage(bytes);
			s3img.setImgname("Profile-APR.pdf");
			s3img.setImgTyp("profile");
			s3img.setEntityTyp(Constants.DOCTOR);
			Response resp = sc.upload_s3File(bytes,
					"DOCTOR/profile/Profile-APR.pdf");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	public Images download_s3File(String keyName) {
		String bucketName = Configuration.getInstance("server").getProperty(
				"s3_bucket_name");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(Configuration
				.getInstance("server").getProperty("aws_access_key_id"),
				Configuration.getInstance("server").getProperty(
						"aws_secret_access_key"));
		AmazonS3 s3client = new AmazonS3Client(awsCreds);

		Images dwnlod_img = new Images();
		try {
			System.out.println("Uploading a new object to S3 from a file\n");

			S3Object object = s3client.getObject(new GetObjectRequest(
					bucketName, keyName));
			InputStream objectData = object.getObjectContent();
			byte[] bytes = IOUtils.toByteArray(objectData);

			dwnlod_img.setImage(bytes);
			objectData.close();

			return dwnlod_img;
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which "
					+ "means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());

			dwnlod_img.setEntityId(0L);
			dwnlod_img.setImage(null);
			dwnlod_img.setImgname(null);
			dwnlod_img.setImgTyp(null);
			return dwnlod_img;

		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which "
					+ "means the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			dwnlod_img.setEntityId(0L);
			dwnlod_img.setImage(null);
			dwnlod_img.setImgname(null);
			dwnlod_img.setImgTyp(null);
			return dwnlod_img;
		} catch (Exception ace) {

			System.out.println("Error Message: " + ace.getMessage());
			dwnlod_img.setEntityId(0L);
			dwnlod_img.setImage(null);
			dwnlod_img.setImgname(null);
			dwnlod_img.setImgTyp(null);
			return dwnlod_img;
		}

	}

	public Response upload_s3File(byte[] contents, String keyName) {
		String bucketName = Configuration.getInstance("server").getProperty(
				"s3_bucket_name");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(Configuration
				.getInstance("server").getProperty("aws_access_key_id"),
				Configuration.getInstance("server").getProperty(
						"aws_secret_access_key"));
		AmazonS3 s3client = new AmazonS3Client(awsCreds);
		Response resp = new Response();
		try {
			System.out.println("Uploading a new object to S3 from a file\n");

			InputStream stream = new ByteArrayInputStream(contents);
			ObjectMetadata meta = new ObjectMetadata();

			meta.setContentLength(contents.length);
			System.out.println(contents.length);

			meta.setContentType("application/text");
			System.out.println("Uploading Image in " + bucketName
					+ " with Key " + keyName);
			
			AccessControlList acl = new AccessControlList();
			//acl.grantPermission(new CanonicalGrantee("d25639fbe9c19cd30a4c0f43fbf00e2d3f96400a9aa8dabfbbebe1906Example"), Permission.ReadAcp);
			acl.grantPermission(GroupGrantee.AllUsers, Permission.FullControl);
			//acl.grantPermission(new EmailAddressGrantee("user@email.com"), Permission.WriteAcp);

			
			s3client.putObject(new PutObjectRequest(bucketName, keyName, stream,meta).withAccessControlList(acl));

			
		//	s3client.putObject(bucketName, keyName, stream, meta);
			
			// s3client.getResourceUrl("your-bucket", "some-path/some-key.jpg");

			resp.setSTATUS(Constants.SUCCESS);
			resp.setERROR_CODE(Constants.RESP_SUCCESS);

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which "
					+ "means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());

			resp.setSTATUS(Constants.FAIL);
			resp.setERROR_CODE(Constants.RESP_CONNERROR);
			return resp;
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which "
					+ "means the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			resp.setSTATUS(Constants.FAIL);
			resp.setERROR_CODE(Constants.RESP_CONNERROR);
		} catch (Exception ace) {
			ace.printStackTrace();
			System.out.println("Error Message: " + ace.getMessage());
			resp.setSTATUS(Constants.FAIL);
			resp.setERROR_CODE(Constants.RESP_CONNERROR);
		}
		return resp;
	}

}
