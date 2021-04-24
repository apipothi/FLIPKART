package com.apipothi.flipkart.to.service;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import java.util.List;

import com.apipothi.flipkart.request.FlipkartRequest;
import com.apipothi.flipkart.to.FlipkartTO;

public interface FlipkartService {

	public String addProductFromManufacturer(List<FlipkartTO> manufacturerProductDetails);

	public List<FlipkartTO> getByIDProductInFlipkart(int id);

	public List<FlipkartTO> getAllProductInFlipkart();

	public String addProductInFlipkart(List<FlipkartRequest> request);

	public String updateProductInFlipkart(FlipkartRequest request);

	public boolean deleteProductInFlipkart(int id);
}
