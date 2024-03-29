package com.Productimage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Productimage.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	Product findById(int id);
}
