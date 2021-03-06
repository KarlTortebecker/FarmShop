package org.casjedcem.Farmshop.service;

import org.casjedcem.Farmshop.model.Product;
import org.casjedcem.Farmshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.saveAndFlush(product);
    }

    public void removeProductById(Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategory(int id){
        return productRepository.findAllByCategory_Id(id);
    }
    public List<Product> getAllProductsByProducer(int id){
        return productRepository.findAllByProducerUserId(id);
    }
}
