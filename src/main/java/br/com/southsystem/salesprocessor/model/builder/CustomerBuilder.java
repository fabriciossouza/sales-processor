package br.com.southsystem.salesprocessor.model.builder;

import br.com.southsystem.salesprocessor.model.Customer;

public class CustomerBuilder {

    private Customer customer = new Customer();

    private CustomerBuilder() {

    }

    public static CustomerBuilder customerBuilder() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withCnpj(String cnpj) {
        customer.setCnpj(Long.parseLong(cnpj));
        return this;
    }

    public CustomerBuilder withName(String name) {
        customer.setName(name);
        return this;
    }

    public CustomerBuilder withBusinessArea(String businessArea) {
        customer.setBusinessArea(businessArea);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
