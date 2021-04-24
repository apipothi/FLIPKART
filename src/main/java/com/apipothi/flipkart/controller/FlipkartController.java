package com.apipothi.flipkart.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apipothi.flipkart.feign.FProductManufacturerProxy;
import com.apipothi.flipkart.request.FlipkartRequest;
import com.apipothi.flipkart.response.FlipkartResponse;
import com.apipothi.flipkart.response.Response;
import com.apipothi.flipkart.to.FlipkartTO;
import com.apipothi.flipkart.to.service.impl.FlipkartServiceImpl;

@RestController
public class FlipkartController {

	private final static Logger logger = LoggerFactory.getLogger(FlipkartController.class);

	@Value("${server.port}")
	int port;

	@Value("${spring.application.name}")
	String appname;

	@Autowired
	FProductManufacturerProxy proxy;

	@Autowired
	FlipkartServiceImpl service;

	
	@Value("${productmanufacturer.ribbon.listOfServers}")
	private List<String> listOfServers;
	
	/*
	 * Take All the product from PRODUCT MANUFACTURER and save it in to FLIPKART DB
	 */
	@GetMapping("/listOfServers")
	public List<String> getBookInfo() {
		
		System.out.println("Book Price as Integer List - " + listOfServers);
		
		return listOfServers;
		
	}
	
	
	@GetMapping("/addAllProductFromManufacturer")
	public Response addAllProductFromManufacturer() {
		String statusMsg = "";
		Response myresponse = new Response();
		Response response = proxy.getuserDetailsFromUserService();
		logger.info("Response form Manufacturer proxy {}" + response);
		List<FlipkartTO> manufacturerProductDetails = response.getProductDetails();
		try {
			statusMsg = service.addProductFromManufacturer(manufacturerProductDetails);
			myresponse.setMessage(statusMsg);
			myresponse.setPort(response.getPort());
			myresponse.setAppname(response.getAppname());
			myresponse.setStatuscode(response.getStatuscode());

		} catch (Exception e) {
			statusMsg = "Exception Occured during data insertion" + e;
			myresponse.setMessage(statusMsg);
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(400);
			logger.error("-Exception{}", e);
		}
		logger.info("-Response from Product Manufacturer-addAllProductFromManufacturer- {}", myresponse);
		return myresponse;
	}

	@GetMapping("/getProductByIDInFlipkart/{id}")
	public Response getProductByIDInFlipkart(@PathVariable int id) {
		// Get The data from Flipkart DB by ID
		logger.info("***START---getProductByIDInFlipkart() id{} " + id);
		Response myresponse = new Response();
		try {
			List<FlipkartTO> flipkartProductList = service.getByIDProductInFlipkart(id);
			myresponse.setProductDetails(flipkartProductList);
			myresponse.setMessage("SUCCESS");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);
		} catch (Exception e) {
			myresponse.setProductDetails(null);
			myresponse.setMessage("Exception Occured During getting the flipkart data by ID");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(400);
		}
		return myresponse;
	}

	@GetMapping("/getFlipkartProducts")
	public Response getProductInFlipkart() {
		// Get all the data from Flipkart DB
		logger.info("***START---getProductInFlipkart()");
		Response myresponse = new Response();
		try {
			List<FlipkartTO> listOfflipkartProduct = service.getAllProductInFlipkart();
			myresponse.setProductDetails(listOfflipkartProduct);
			myresponse.setMessage("SUCCESS");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);

		} catch (Exception e) {
			myresponse.setProductDetails(null);
			myresponse.setMessage("Exception Occured During getting the flipkart data");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(400);
		}
		return myresponse;
	}

	@PostMapping("/addProductInFlipkart")
	public Response addProductInFlipkart(@RequestBody List<FlipkartRequest> request) {
		// Add the data in Flipkart DB
		logger.info("***START---addProductInFlipkart()" + request);
		String statusMsg = "";
		Response myresponse = new Response();
		try {
			statusMsg = service.addProductInFlipkart(request);
			myresponse.setMessage(statusMsg);
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);

		} catch (Exception e) {
			myresponse.setProductDetails(null);
			myresponse.setMessage("Exception Occured During adding the data in flipkart");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(400);
		}
		return myresponse;
	}

	@PutMapping("/updateProductInFlipkart/{id}")
	public Response updateProductInFlipkart(@PathVariable int id, FlipkartRequest request) {
		// Update the data in Flipkart DB
		Response myresponse = new Response();
		String statusMsg = "";
		try {
			request.setId(id);
			statusMsg = service.updateProductInFlipkart(request);
			myresponse.setMessage(statusMsg);
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);
		} catch (Exception e) {
			myresponse.setMessage("Exception Occured During updating the flipkart data");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(400);
		}
		return myresponse;
	}

	@DeleteMapping("/deleteProductInFlipkart/{id}")
	public Response deleteProductInFlipkart(@PathVariable int id) {
		// Delete the data in Flipkart DB
		boolean isSuccess;
		Response myresponse = new Response();
		isSuccess = service.deleteProductInFlipkart(id);
		if (isSuccess) {
			myresponse.setMessage("Data Deleted sucessfully");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);
		} else {
			myresponse.setMessage("Exception Occured while deleting the Data");
			myresponse.setPort(port);
			myresponse.setAppname(appname);
			myresponse.setStatuscode(200);
		}
		return myresponse;
	}
}
