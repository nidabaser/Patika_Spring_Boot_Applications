package dev.nida.RESTAPI.dao;

import dev.nida.RESTAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nida Başer
 * May 2024
 */

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
