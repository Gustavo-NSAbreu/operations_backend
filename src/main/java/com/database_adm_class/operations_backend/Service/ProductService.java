package com.database_adm_class.operations_backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database_adm_class.operations_backend.Domain.DTO.DataRegisterProduct;
import com.database_adm_class.operations_backend.Domain.DTO.DataUpdateProduct;
import com.database_adm_class.operations_backend.Domain.Entity.Product;
import com.database_adm_class.operations_backend.Repository.ProductMariaRepository;

@Service
public class ProductService {

  @Autowired
  private ProductMariaRepository repository;

  public List<Product> getAll() {
    return repository.findAll();
  }

  public Product register(DataRegisterProduct requestProduct) {
    var product = new Product(requestProduct);
    return repository.save(product);
  }

  public Product update(DataUpdateProduct dataUpdateProduct) {
    Product product = repository.findById(dataUpdateProduct.id()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    product.update(dataUpdateProduct);
    return repository.save(product);
  }

  public void delete(String id) {
    Product product = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    repository.delete(product);
  }
}