package com.apipothi.flipkart.model;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "flipkart")
public class FlipkartProduct {

	@Id
	private int id;

	@Field("F_PRODUCT_ID")
	private String productid;
	@Field("F_PRODUCT_NAME")
	private String productname;
	@Field("F_PRODUCT_PRICE")
	private long productprice;

	public FlipkartProduct() {
	}

	public FlipkartProduct(int id, String productid, String productname, long productprice) {
		super();
		this.id = id;
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public long getProductprice() {
		return productprice;
	}

	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}

	@Override
	public String toString() {
		return "FlipkartProduct [id=" + id + ", productid=" + productid + ", productname=" + productname
				+ ", productprice=" + productprice + "]";
	}

}
