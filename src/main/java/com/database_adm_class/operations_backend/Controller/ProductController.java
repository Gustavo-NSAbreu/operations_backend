package com.database_adm_class.operations_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.database_adm_class.operations_backend.Domain.DTO.DataRegisterProduct;
import com.database_adm_class.operations_backend.Domain.DTO.DataUpdateProduct;
import com.database_adm_class.operations_backend.Domain.Entity.Product;
import com.database_adm_class.operations_backend.Service.ProductService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        var products = service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<String> registerProducts(@RequestBody @Validated DataRegisterProduct dataRegisterProduct ) {
        service.register(dataRegisterProduct);
        return ResponseEntity.ok("Product created");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Validated DataUpdateProduct dataUpdateProduct) {
        service.update(dataUpdateProduct);
        return ResponseEntity.ok("Product updated");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
}