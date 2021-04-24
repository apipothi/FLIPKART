package com.apipothi.flipkart.feign;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
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
