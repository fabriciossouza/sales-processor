package br.com.southsystem.salesprocessor.model.builder;

import br.com.southsystem.salesprocessor.model.Output;

import java.util.Optional;

public class OutputBuilder {

    private Output output = new Output();

    private OutputBuilder() {

    }

    public static OutputBuilder outputBuilder() {
        return new OutputBuilder();
    }

    public OutputBuilder withTotalOfSalesmen(int totalOfSalesmen) {
        output.setTotalOfSalesmen(totalOfSalesmen);
        return this;
    }

    public OutputBuilder withTotalOfCustomers(int totalOfCustomers) {
        output.setTotalOfCustomers(totalOfCustomers);
        return this;
    }

    public OutputBuilder withMostExpensiveSaleId(Long mostExpensiveSaleId) {
        output.setMostExpensiveSaleId(mostExpensiveSaleId);
        return this;
    }

    public OutputBuilder withWorstSalesmanName(String worstSalesmanName) {
        output.setWorstSalesmanName(worstSalesmanName);
        return this;
    }

    public Output build() {
        return output;
    }
}
