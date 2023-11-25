package com.database_adm_class.operations_backend.Repository.MariaDB;

import com.database_adm_class.operations_backend.Domain.Entity.Product;

// MariaDB version:
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMariaRepository extends JpaRepository<Product, String> {}
