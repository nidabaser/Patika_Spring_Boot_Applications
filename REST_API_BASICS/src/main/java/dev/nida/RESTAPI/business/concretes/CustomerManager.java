package dev.nida.RESTAPI.business.concretes;

import dev.nida.RESTAPI.business.abstracts.ICustomerService;
import dev.nida.RESTAPI.dao.CustomerRepo;
import dev.nida.RESTAPI.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepo.delete(this.getById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }
}
