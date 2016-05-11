package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.beans.Response;
import com.beans.Users;
import com.services.Impl.UsersImpl;

@Path("/user")
public class UserService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Users user) {

		System.out.println("Add Users =>" + user);
		UsersImpl userImpl = UsersImpl.getInstance();
		Response resp = userImpl.add(user);
		return resp;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> get(
			@QueryParam("emailId") String emailId) {
		UsersImpl userImpl = UsersImpl.getInstance();
		List<Users> userList = userImpl.get(emailId);
		return userList;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateuser(Users user) {

		UsersImpl userImpl = UsersImpl.getInstance();
		Response resp = userImpl.updateuser(user);
		resp.setSTATUS("SUCCESS");
		return resp;
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteuser(
			@QueryParam("emailId") String emailId) {

		System.out.println("Delete user");
		UsersImpl userImpl = UsersImpl.getInstance();
		Response resp = userImpl.deleteuser(emailId);

		return resp;

	}

	@POST
	@Path("/activateuser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateuser(
			@QueryParam("emailId") String emailId,@QueryParam("otp") String otp) {

		System.out.println("Activate user");
		UsersImpl userImpl = UsersImpl.getInstance();
		Response resp = userImpl.activateuser(emailId,otp);

		return resp;

	}
}
