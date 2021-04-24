package com.apipothi.flipkart.response;

import java.util.List;

import com.apipothi.flipkart.to.FlipkartTO;

/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * WEB       : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
public class FlipkartResponse {

	private int applicationport;
	private String applicationname;
	private int statuscode;
	private String message;
	private List<FlipkartTO> productDetails;
	
	public FlipkartResponse() {
	}

	public FlipkartResponse(int applicationport, String applicationname, int statuscode, String message,
			List<FlipkartTO> productDetails) {
		super();
		this.applicationport = applicationport;
		this.applicationname = applicationname;
		this.statuscode = statuscode;
		this.message = message;
		this.productDetails = productDetails;
	}

	public int getApplicationport() {
		return applicationport;
	}

	public void setApplicationport(int applicationport) {
		this.applicationport = applicationport;
	}

	public String getApplicationname() {
		return applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FlipkartTO> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<FlipkartTO> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "FlipkartResponse [applicationport=" + applicationport + ", applicationname=" + applicationname
				+ ", statuscode=" + statuscode + ", message=" + message + ", productDetails=" + productDetails + "]";
	}

}
