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
public class Response {

	private int statuscode;
	private String message;
	private int port;
	private String appname;
	private List<FlipkartTO> productDetails;

	public Response() {
	}

	public Response(int statuscode, String message, int port, String appname, List<FlipkartTO> productDetails) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.port = port;
		this.appname = appname;
		this.productDetails = productDetails;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public List<FlipkartTO> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<FlipkartTO> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "Response [statuscode=" + statuscode + ", message=" + message + ", port=" + port + ", appname=" + appname
				+ ", productDetails=" + productDetails + "]";
	}

}
