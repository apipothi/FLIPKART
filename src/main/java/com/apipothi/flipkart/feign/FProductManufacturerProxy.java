package com.apipothi.flipkart.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.apipothi.flipkart.response.Response;

//@FeignClient(name = "productmanufacturer", url = "localhost:8080")


//@FeignClient(name = "productmanufacturer")
@FeignClient(name = "apigateway-service")
@RibbonClient(name = "productmanufacturer")
public interface FProductManufacturerProxy {
	@GetMapping("/productmanufacturer/getallproduct")
	//@GetMapping("/getallproduct")
	public Response getuserDetailsFromUserService();

}
