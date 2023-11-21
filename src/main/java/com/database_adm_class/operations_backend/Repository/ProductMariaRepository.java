package com.database_adm_class.operations_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.database_adm_class.operations_backend.Domain.Entity.Product;


public interface ProductMariaRepository extends JpaRepository<Product, String> {}
