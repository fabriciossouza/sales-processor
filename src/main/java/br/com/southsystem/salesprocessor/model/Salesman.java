package br.com.southsystem.salesprocessor.model;

import br.com.southsystem.salesprocessor.model.builder.SalesmanBuilder;

import java.math.BigDecimal;

public class Salesman implements Comparable<Salesman>{
   private long cpf;
   private String name;
   private BigDecimal salary;
   private Sale sale;

   public long getCpf() {
      return cpf;
   }

   public void setCpf(long cpf) {
      this.cpf = cpf;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public BigDecimal getSalary() {
      return salary;
   }

   public void setSalary(BigDecimal salary) {
      this.salary = salary;
   }

   public Sale getSale() {
      return sale;
   }

   void setSale(Sale sale) {
      this.sale = sale;
   }

   public static Salesman from(String[] entityData){
      if(entityData != null) {
         return SalesmanBuilder.saleBuilder()
                 .withId(entityData[1])
                 .withName(entityData[2])
                 .withSalary(new BigDecimal(entityData[3]))
                 .build();
      }
      return null;
   }

   @Override
   public int compareTo(Salesman salesman) {
      return this.getSale().getCost().compareTo(
         salesman.getSale().getCost());
   }
}

