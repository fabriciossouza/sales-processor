package br.com.southsystem.salesprocessor.model.builder;

import br.com.southsystem.salesprocessor.model.Sale;
import br.com.southsystem.salesprocessor.model.Salesman;

import java.math.BigDecimal;

public class SaleBuilder {

    private Sale sale = new Sale();

    private SaleBuilder() {

    }

    public static SaleBuilder saleBuilder() {
        return new SaleBuilder();
    }

    public SaleBuilder withId(String id) {
        sale.setId(Long.parseLong(id));
        return this;
    }

    public SaleBuilder withCost(BigDecimal cost) {
        sale.setCost(cost);
        return this;
    }

    public SaleBuilder withSalesman(Salesman salesman) {
        sale.setSalesman(salesman);
        return this;
    }

    public Sale build() {
        return sale;
    }
}
