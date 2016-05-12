package com.common;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Time;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;

import com.beans.Appointment;
import com.beans.Schedule;

public class CommonUtilities {

	public static void main(String[] args) {
		CommonUtilities cu = new CommonUtilities();
		try {
			cu.sendActivationLinkEmail("nikhil@finxera.com", cu.generateOTP());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Integer TimeDiff(Time time_end, Time time_start) {

		return null;
	}

	public static Time TimeAdd(Time startTime, int minutes) {

		return null;
	}

	public static Time getStartTime(Schedule schedule) {
		Time start = null;

		return start;

	}

	public static Time getEndTime(Schedule schedule) {

		return null;
	}

	public static int getTokenNum(Schedule schedule, Appointment appmnt) {

		return 0;
	}

	public void sendActivationLinkEmail(String emailId, String link)
			throws MessagingException {

		final String username = Configuration.getInstance("server")
				.getProperty("mail.smtp.user");
		final String password = Configuration.getInstance("server")
				.getProperty("mail.smtp.password");

		Properties props = new Properties();
		props.put("mail.smtp.auth", Configuration.getInstance("server")
				.getProperty("mail.smtp.auth"));
		props.put(
				"mail.smtp.starttls.enable",
				Configuration.getInstance("server").getProperty(
						"mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", Configuration.getInstance("server")
				.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", Configuration.getInstance("server")
				.getProperty("mail.smtp.socketFactory.port"));

		/*
		 * Session session = Session.getInstance(
		 * Configuration.getInstance("server"), new javax.mail.Authenticator() {
		 * protected PasswordAuthentication getPasswordAuthentication() { return
		 * new PasswordAuthentication(username, password); } });
		 */

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("DOCLAB User Activation");
			message.setText("Dear User,"
					+ "Please Use below One Time Password to Activate your user.\n\n"
					+ link
					+ "\n\n"
					+ ""
					+ "Please note OTP is valid only for 30 minutes\n\n Thanks\nCustomer Service Team");
			System.out.println(session.toString());
			System.out.println(message.toString());
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("OTP Mail Send Error " + e.getMessage());
			throw e;
		}

	}

	public static String generateActivationLink(String EmailId) {
		byte[] encodedBytes = Base64.encodeBase64(EmailId.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));

		String link = "http://localhost:8080/LabApi/api/user/activateuser?emailId="
				+ new String(encodedBytes);
		return link;
	}

	public static String generateOTP() {

		int size = 6;
		StringBuilder generatedToken = new StringBuilder();
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			// Generate 20 integers 0..20
			for (int i = 0; i < size; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedToken.toString();

	}

	public static boolean isEmpty(String value) {
		if (null == value)
			return true;
		if (value.length() == 0)
			return true;
		return false;
	}

}
