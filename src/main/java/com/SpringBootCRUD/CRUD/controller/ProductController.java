package com.SpringBootCRUD.CRUD.controller;

import com.SpringBootCRUD.CRUD.model.Product;
import com.SpringBootCRUD.CRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/home")
    public String home(){
        return  "welcome !!!!";
    }
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list=productService.getAllProducts();
        return  new ResponseEntity<List<Product>>(list,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) throws Exception {
        Product p=productService.getProductById(id);
        return new  ResponseEntity<Product>(p,HttpStatus.OK);

    }
    @PostMapping("/product")
    public ResponseEntity<String> create (@RequestBody Product product){
        Product p= productService.saveProduct(product);
        return new ResponseEntity<String>("Product with "+p.getId()+"has been saved",HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<String> update( @PathVariable int id,@RequestBody Product productDetails)  throws Exception{
       Product updateProduct = productService.getProductById(id);
        updateProduct.setName(productDetails.getName());
        updateProduct.setPrice(productDetails.getPrice());
        updateProduct.setDescription(productDetails.getDescription());
       productService.saveProduct(updateProduct);
       return new ResponseEntity<String>("Product has been updated",HttpStatus.OK);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) throws Exception{
         productService.deleteProduct(id);

        return new ResponseEntity<String>("Product with id"+id+"has been deleted",HttpStatus.OK);
    }


}
