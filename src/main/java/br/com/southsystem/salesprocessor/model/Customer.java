package br.com.southsystem.salesprocessor.model;

import br.com.southsystem.salesprocessor.model.builder.CustomerBuilder;

import java.util.Optional;

public class Customer {

   private long cnpj;
   private String name;
   private String businessArea;

   public long getCnpj() {
      return cnpj;
   }

   public void setCnpj(long cnpj) {
      this.cnpj = cnpj;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBusinessArea() {
      return businessArea;
   }

   public void setBusinessArea(String businessArea) {
      this.businessArea = businessArea;
   }

   public static Customer from(String[] entityData){
      if(null != entityData) {
         return CustomerBuilder.customerBuilder().withCnpj(entityData[1])
                 .withName(entityData[2])
                 .withBusinessArea(entityData[3])
                 .build();
      }
      return null;
   }

   @Override
   public String toString() {
      return "Customer{" +
              "cnpj=" + cnpj +
              ", name='" + name + '\'' +
              ", businessArea='" + businessArea + '\'' +
              '}';
   }
}
