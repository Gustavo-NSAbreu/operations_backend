package com.database_adm_class.operations_backend.Domain.DTO;


public record DataUpdateProduct(
  String id,
  String name,
  Float price,
  String description
) {}