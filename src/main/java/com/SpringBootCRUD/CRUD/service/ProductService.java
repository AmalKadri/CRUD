package com.SpringBootCRUD.CRUD.service;

import com.SpringBootCRUD.CRUD.model.Product;
import com.SpringBootCRUD.CRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

     @Autowired
     private ProductRepository productRepository;

     public Product saveProduct(Product  product){
          return productRepository.save(product);
     }

     public List<Product> getAllProducts(){

          return   productRepository.findAll();
     }

     public Product getProductById( int id) throws  Exception{
          return productRepository.findById(id).orElseThrow(()->new Exception("Product not found !"));
     }

     public void deleteProduct( int id) throws Exception{
          productRepository.deleteById(id);

     }

     public Product updateProduct(   Product productDetails)  throws Exception {
          Product updateProduct = productRepository.findById(productDetails.getId()).orElseThrow(() -> new Exception("product not found "));
          updateProduct.setName(productDetails.getName());
          updateProduct.setPrice(productDetails.getPrice());
          updateProduct.setDescription(productDetails.getDescription());
         return productRepository.save(updateProduct);

     }

}
