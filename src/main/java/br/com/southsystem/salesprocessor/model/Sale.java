package br.com.southsystem.salesprocessor.model;

import br.com.southsystem.salesprocessor.model.builder.SaleBuilder;

import java.math.BigDecimal;
import java.util.Optional;

public class Sale implements Comparable<Sale>{
   private static final String OPEN = "[";
   private static final String CLOSE = "]";
   private static final String EMPTY = "";
   private static final String COMMA = ",";
   private static final String DASH = "-";

   private Long id;
   private BigDecimal cost;
   private Salesman salesman;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public BigDecimal getCost() {
      return cost;
   }

   public void setCost(BigDecimal cost) {
      this.cost = cost;
   }

   public Salesman getSalesman() {
      return salesman;
   }

   public void setSalesman(Salesman salesman) {
      this.salesman = salesman;
   }

   public static Sale from(String[] entityData, Salesman salesman){
      if(null != entityData) {
         Sale sale = SaleBuilder.saleBuilder().withId(entityData[1])
                 .withCost(getCost(entityData[2]))
                 .withSalesman(salesman)
                 .build();
         salesman.setSale(sale);
         return sale;
      }
      return null;
   }


   @Override
   public int compareTo(Sale sale) {
      return sale.getCost().compareTo(this.getCost());
   }


   private static BigDecimal getCost(String entityItens){
      BigDecimal value = BigDecimal.ZERO;
      String[] parsedEntityItens =
          entityItens.replace(OPEN, EMPTY).replace(CLOSE, EMPTY).split(COMMA);

      if (parsedEntityItens.length > 0){
         for(String parsedEntityItem : parsedEntityItens){
            String[] parts = parsedEntityItem.split(DASH);
            if (parts.length == 3){
               value = value.add(new BigDecimal(parts[1])
                   .multiply(new BigDecimal(parts[2])));
            }
         }
      }
      return value;
   }

   @Override
   public String toString() {
      return "Sale{" +
              "id=" + id +
              ", cost=" + cost + "}";
   }
}
