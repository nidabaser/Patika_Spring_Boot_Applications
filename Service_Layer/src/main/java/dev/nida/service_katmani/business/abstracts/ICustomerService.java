package dev.nida.service_katmani.business.abstracts;

import dev.nida.service_katmani.Customer;

/**
 * @author Nida Başer
 * May 2024
 */

public interface ICustomerService {

    Customer getById(int id);

    Customer save(Customer customer);

    void delete(Customer customer);

    Customer update(Customer customer);

}
