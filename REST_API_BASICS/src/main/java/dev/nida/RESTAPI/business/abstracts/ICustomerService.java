package dev.nida.RESTAPI.business.abstracts;

import dev.nida.RESTAPI.entity.Customer;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public interface ICustomerService {
    Customer getById(int id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(int id);

    List<Customer> findAll();
}
