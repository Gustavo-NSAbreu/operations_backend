package com.database_adm_class.operations_backend.Domain.Entity;

import java.sql.Date;

import com.database_adm_class.operations_backend.Domain.DTO.DataRegisterProduct;
import com.database_adm_class.operations_backend.Domain.DTO.DataUpdateProduct;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private Float price;
  private String description;

  public Product(DataRegisterProduct requestProduct) {
    this.name = requestProduct.name();
    this.price = requestProduct.price();
    this.description = requestProduct.description();
  }

  public void update(DataUpdateProduct dataUpdateProduct) {
    if (dataUpdateProduct.name() != null && dataUpdateProduct.name().length() > 0) {
      this.name = dataUpdateProduct.name();
    }
    if (dataUpdateProduct.price() != null) {
      this.price = dataUpdateProduct.price();
    }
    if (dataUpdateProduct.description() != null && dataUpdateProduct.name().length() > 0) {
      this.description = dataUpdateProduct.description();
    }
    if ( dataUpdateProduct.name() == null && dataUpdateProduct.price() == null && dataUpdateProduct.description() == null) {
      throw new IllegalStateException("At least one of the filed must be provided.");
    }
  }
}