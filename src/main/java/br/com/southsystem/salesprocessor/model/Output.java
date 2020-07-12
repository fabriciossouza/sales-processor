package br.com.southsystem.salesprocessor.model;

public class Output {
   private static final String TC_MESSAGE = "Quantidade de clientes no arquivo de entrada: ";
   private static final String TS_MESSAGE = "Quantidade de vendedores no arquivo de entrada: ";
   private static final String MESI_MESSAGE = "ID da venda mais cara: ";
   private static final String WSN_MESSAGE = "O pior vendedor ja encontrado: ";

   private int totalOfCustomers;
   private int totalOfSalesmen;
   private long mostExpensiveSaleId;
   private String worstSalesmanName;

   public int getTotalOfCustomers() {
      return totalOfCustomers;
   }

   public void setTotalOfCustomers(int totalOfCustomers) {
      this.totalOfCustomers = totalOfCustomers;
   }

   public int getTotalOfSalesmen() {
      return totalOfSalesmen;
   }

   public void setTotalOfSalesmen(int totalOfSalesmen) {
      this.totalOfSalesmen = totalOfSalesmen;
   }

   public long getMostExpensiveSaleId() {
      return mostExpensiveSaleId;
   }

   public void setMostExpensiveSaleId(long mostExpensiveSaleId) {
      this.mostExpensiveSaleId = mostExpensiveSaleId;
   }

   public String getWorstSalesmanName() {
      return worstSalesmanName;
   }

   public void setWorstSalesmanName(String worstSalesmanName) {
      this.worstSalesmanName = worstSalesmanName;
   }

   public String getTotalOfCustomersMessage() {
      return TC_MESSAGE + this.totalOfCustomers;
   }

   public String getTotalOfSalesmenMessage() {
      return TS_MESSAGE + this.totalOfSalesmen;
   }

   public String getMostExpensiveSaleIdMessage() {
      return MESI_MESSAGE + this.mostExpensiveSaleId;
   }

   public String getWorstSalesmanNameMessage() {
      return WSN_MESSAGE + this.worstSalesmanName;
   }


   @Override
   public String toString() {
      return "Output{" +
              "totalOfCustomers=" + totalOfCustomers +
              ", totalOfSalesmen=" + totalOfSalesmen +
              ", mostExpensiveSaleId=" + mostExpensiveSaleId +
              ", worstSalesmanName='" + worstSalesmanName + '\'' +
              '}';
   }
}
