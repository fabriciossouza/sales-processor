package br.com.southsystem.salesprocessor.parser;

import br.com.southsystem.salesprocessor.model.Customer;
import br.com.southsystem.salesprocessor.model.Output;
import br.com.southsystem.salesprocessor.model.Sale;
import br.com.southsystem.salesprocessor.model.Salesman;
import br.com.southsystem.salesprocessor.model.builder.OutputBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EntityParser {

   private static final Logger logger = LogManager.getLogger(EntityParser.class);
   private static final String DELIMITER = "\\u00E7"; // delimiter: ç
   private static final String SALESPERSON_DATA = "001";
   private static final String CUSTOMER_DATA = "002";
   private static final String SALES_DATA = "003";
   private static final int SIZE_COMPLETE_LINE = 4;
   
   private Set<Customer> customers = new HashSet<>();;
   private Set<Salesman> salesmen  = new HashSet<>();;
   private Set<Sale> sales = new TreeSet<>();


   public void parse(String entityData){
      String[] parsedEntityData = entityData.split(DELIMITER);
      if (parsedEntityData.length == SIZE_COMPLETE_LINE) {
         parseEntityBasedOnItsType(parsedEntityData);
         logger.info("Line parsed: " + entityData);
      } else {
         logger.error("Invalid parser data in line: " + entityData);
      }
   }

   public Output buildOutput(){
      Output output = null;
      if(!this.customers.isEmpty())
         output = OutputBuilder.outputBuilder()
             .withTotalOfCustomers(this.customers.size())
             .withTotalOfSalesmen(this.salesmen.size())
             .withMostExpensiveSaleId(getMostExpensiveSaleId())
             .withWorstSalesmanName(getWorstSalesmanName())
             .build();
      this.clearData();
      return output;
   }


   private void parseEntityBasedOnItsType(String[] parsedEntityData) {
      if (SALESPERSON_DATA.equals(parsedEntityData[0])) {
         Salesman salesman = Salesman.from(parsedEntityData);
         this.salesmen.add(salesman);
      } else if (CUSTOMER_DATA.equals(parsedEntityData[0])) {
         Customer customer = Customer.from(parsedEntityData);
         this.customers.add(customer);
      } else if (SALES_DATA.equals(parsedEntityData[0])) {
         Sale sale = Sale.from(parsedEntityData,
             getSalesmanByName(parsedEntityData[3]));
         this.sales.add(sale);
      }
   }

   private Salesman getSalesmanByName(String name){
      for (Salesman salesman : this.salesmen){
         if (salesman.getName().equals(name)){
            return salesman;
         }
      }
      return null;
   }


   private Long getMostExpensiveSaleId(){
      Long mostExpensiveSaleId = null;
      if (this.sales.size() > 0){
         Sale mostExpensiveSale = ((TreeSet<Sale>)this.sales).first();
         mostExpensiveSaleId = mostExpensiveSale.getId();
      }
      return mostExpensiveSaleId;
   }

   private String getWorstSalesmanName(){
      String worstSalesmanName = null;
      if (this.salesmen.size() > 0){
         TreeSet<Salesman> sortedSalesmen = new TreeSet<>(this.salesmen);
         Salesman worstSalesman = sortedSalesmen.first();
         worstSalesmanName = worstSalesman.getName();
         sortedSalesmen.clear();
      }
      return worstSalesmanName;
   }

   private void clearData(){
      this.customers.clear();
      this.salesmen.clear();
      this.sales.clear();
   }
}
