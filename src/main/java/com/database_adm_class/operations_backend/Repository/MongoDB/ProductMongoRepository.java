package com.database_adm_class.operations_backend.Repository.MongoDB;

import com.database_adm_class.operations_backend.Domain.Entity.Product;

// MongoDB version:
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, String> {}