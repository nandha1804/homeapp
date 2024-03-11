package com.Productimage.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Min;

@Entity
public class Product {
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int id, byte[] image, String footwearname, String brandname, int price, int availability) {
		super();
		this.id = id;
		this.image = image;
		this.footwearname = footwearname;
		this.brandname = brandname;
		this.price = price;
		this.availability = availability;
	}


	public Product(MultipartFile file, String string, String string2, int i, int j) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + Arrays.toString(image) + ", footwearname=" + footwearname
				+ ", brandname=" + brandname + ", price=" + price + ", availability=" + availability + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	       private int id ;
	       @Lob
	       private byte[] image;
	       private String footwearname;
	       private String brandname;
	       private int price;
	       private int availability;
	       
		public int getAvailability() {
			return availability;
		}
		public void setAvailability(int availability) {
			this.availability = availability;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		public String getFootwearname() {
			return footwearname;
		}
		public void setFootwearname(String footwearname) {
			this.footwearname = footwearname;
		}
		public String getBrandname() {
			return brandname;
		}
		public void setBrandname(String brandname) {
			this.brandname = brandname;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
	       

}
