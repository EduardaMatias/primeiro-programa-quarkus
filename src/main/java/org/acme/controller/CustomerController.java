package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.entity.Customer;
import org.acme.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Path("/api/customer")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        try {
            customers = customerService.findAllCustomers();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return customers;
    }

    @POST
    @Transactional
    public void postCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }
}
