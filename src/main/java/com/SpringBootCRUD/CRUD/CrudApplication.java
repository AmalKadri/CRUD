package com.SpringBootCRUD.CRUD;

import com.SpringBootCRUD.CRUD.model.Product;
import com.SpringBootCRUD.CRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication   {

	public static void main(String[] args) {


		SpringApplication.run(CrudApplication.class, args);
	}



}
