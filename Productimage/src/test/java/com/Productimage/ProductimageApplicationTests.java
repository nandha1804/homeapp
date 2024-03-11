package com.Productimage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.multipart.MultipartFile;

import com.Productimage.Repository.ProductRepository;
import com.Productimage.Service.ProductService;
import com.Productimage.exception.Productnotfoundexception;
import com.Productimage.model.Product;

@SpringBootTest
class ProductimageApplicationTests {

	@MockBean
	ProductRepository repo;
	@Autowired
	ProductService service;
	@Test
	void contextLoads() {
	}
	@Test

    public void saveProductTest() throws IOException
	{
		Product p = new Product();
        p.setId(1);
        p.setFootwearname("abcd");
        p.setBrandname("mojaris");
        p.setImage(new byte[0]);
        p.setPrice(1000);
        p.setAvailability(300);
        when(repo.save(p)).thenReturn(p);

    }
	@Test
	
		public void getItems_Success_Test() throws IOException {
			MultipartFile file=mock(MultipartFile.class);
			when(file.getBytes()).thenReturn(new byte[0]);
			when(repo.findAll()).thenReturn(Stream.of(new Product (file,"Crocs","crocs",1000,300),new Product (file,"Sandals","Nike",1000,600)).collect(Collectors.toList()));
  	        assertEquals(2,service.findAllproducts().size());
		
	}
	@Test
	
	public void getItems_NotSuccess_Test() throws IOException {
		MultipartFile file=mock(MultipartFile.class);
		when(file.getBytes()).thenReturn(new byte[0]);
		when(repo.findAll()).thenReturn(new ArrayList<>());
	        assertEquals(Collections.emptyList(),service.findAllproducts());
	
	}
	 @Test
	   public void getItems_SuccessById_Test() throws IOException, Productnotfoundexception {
		MultipartFile file=mock(MultipartFile.class);
		when(file.getBytes()).thenReturn(new byte[0]);
		Product p = new Product();
		p.setId(1);
		 p.setFootwearname("abcd");
	        p.setBrandname("mojaris");
	        p.setImage(new byte[0]);
	        p.setPrice(1000);
	        p.setAvailability(300);
		when(repo.findById(1)).thenReturn(p);
		assertEquals(p,service.findByid(1));
	   }
	 @Test
	   public void getItems_NotSuccessById_Test() throws IOException, Productnotfoundexception {
		MultipartFile file=mock(MultipartFile.class);
		when(file.getBytes()).thenReturn(new byte[0]);
		Product p = new Product();
		p.setId(1);
		 p.setFootwearname("abcd");
	        p.setBrandname("mojaris");
	        p.setImage(new byte[0]);
	        p.setPrice(1000);
	        p.setAvailability(300);
		when(repo.findById(1)).thenReturn(null);
		//assertEquals("Product not found",service.findByid(1));
	   }
	 @Test
	   public void delete_SuccessById_Test() throws IOException {
		MultipartFile file=mock(MultipartFile.class);
		when(file.getBytes()).thenReturn(new byte[0]);
		Product p = new Product();
		p.setId(1);
		 p.setFootwearname("abcd");
	        p.setBrandname("mojaris");
	        p.setImage(new byte[0]);
	        p.setPrice(1000);
	        p.setAvailability(300);
		when(repo.findById(1)).thenReturn(p);
		Mockito.doNothing().when(repo).deleteById(1);
		assertEquals("deleted",service.deleteproduct(1));
	   }
	 @Test
	 public void update_NorecordExists() throws IOException {
		    MultipartFile file=mock(MultipartFile.class);
			when(file.getBytes()).thenReturn(new byte[0]);
			Product p = new Product();
			p.setId(1);
			p.setFootwearname("abcd");
		    p.setBrandname("mojaris");
		    p.setImage(new byte[0]);
		    p.setPrice(1000);
		    p.setAvailability(300);  
			
			Product i=new Product();
			i.setId(1);
			i.setFootwearname("asdf");
		    i.setBrandname("nike");
		    i.setImage(new byte[0]);
		    i.setPrice(10000);
		    i.setAvailability(400);
			when(repo.save(i)).thenReturn(null);
			String s=service.updateProductId(1,file,"asdf","nike",10000,400);
			System.out.println(s);
			assertEquals("0",s);
			
	   }
	 @Test
	 public void update_recordExists() throws IOException {
		    MultipartFile file=mock(MultipartFile.class);
			when(file.getBytes()).thenReturn(new byte[0]);
//			Product p = new Product();
//			p.setId(1);
//			p.setFootwearname("abcd");
//		    p.setBrandname("mojaris");
//		    p.setImage(new byte[0]);
//		    p.setPrice(1000);
//		    p.setAvailability(300);  
			
			Product i=new Product();
			i.setId(1);
			i.setFootwearname("asdf");
		    i.setBrandname("nike");
		    i.setImage(new byte[0]);
		    i.setPrice(10000);
		    i.setAvailability(400);
		    when(repo.findById(1)).thenReturn(i);
			when(repo.save(i)).thenReturn(i);
			String s=service.updateProductId(1,file,"asdf","nike",10000,400);
			System.out.println(s);
			assertEquals("Product updated",s);
			
	   }

	

}
