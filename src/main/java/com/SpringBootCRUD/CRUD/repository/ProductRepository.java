package com.SpringBootCRUD.CRUD.repository;

import com.SpringBootCRUD.CRUD.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {

}
