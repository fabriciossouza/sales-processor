package br.com.southsystem.salesprocessor.model.builder;

import br.com.southsystem.salesprocessor.model.Salesman;

import java.math.BigDecimal;

public class SalesmanBuilder {

    private Salesman salesman = new Salesman();

    private SalesmanBuilder() {

    }

    public static SalesmanBuilder saleBuilder() {
        return new SalesmanBuilder();
    }

    public SalesmanBuilder withId(String id) {
        salesman.setCpf(Long.parseLong(id));
        return this;
    }

    public SalesmanBuilder withName(String name) {
        salesman.setName(name);
        return this;
    }

    public SalesmanBuilder withSalary(BigDecimal salary) {
        salesman.setSalary(salary);
        return this;
    }

    public Salesman build() {
        return salesman;
    }
}
