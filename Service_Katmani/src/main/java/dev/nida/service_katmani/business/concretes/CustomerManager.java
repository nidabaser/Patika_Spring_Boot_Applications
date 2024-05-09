package dev.nida.service_katmani.business.concretes;

import dev.nida.service_katmani.Customer;
import dev.nida.service_katmani.business.abstracts.ICustomerService;
import dev.nida.service_katmani.dao.CustomerRepo;
import org.springframework.stereotype.Service;

/**
 * @author Nida Başer
 * May 2024
 */

@Service
public class CustomerManager implements ICustomerService {

    public final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepo.delete(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == 0) {
            throw new RuntimeException("Lütfen id değerini 0'dan büyük girin");
        }
        return this.customerRepo.save(customer);
    }
}
