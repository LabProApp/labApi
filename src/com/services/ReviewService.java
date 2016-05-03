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
import com.beans.Reviews;
import com.services.Impl.ReviewImpl;

@Path("/review")
public class ReviewService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Reviews review) {

		System.out.println("Add Reviews =>" + review);
		ReviewImpl reviewImpl = ReviewImpl.getInstance();
		Response resp = reviewImpl.add(review);
		return resp;
	}

	@GET
	@Path("/getReviewforDoctor")
	@Produces(MediaType.APPLICATION_XML)
	public List<Reviews> getReviewforDoctor(@QueryParam("docId") Long docId) {
		ReviewImpl reviewImpl = ReviewImpl.getInstance();
		List<Reviews> reviewList = reviewImpl.getReviewforDoctor(docId);
		return reviewList;

	}

	@GET
	@Path("/getReviewforLabBranch")
	@Produces(MediaType.APPLICATION_XML)
	public List<Reviews> getReviewforLabBranch(
			@QueryParam("branchCd") Long branchCd) {
		ReviewImpl reviewImpl = ReviewImpl.getInstance();
		List<Reviews> reviewList = reviewImpl.getReviewforLabBranch(branchCd);
		return reviewList;

	}

}
