package dev.nida.service_katmani.dao;

import dev.nida.service_katmani.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nida Başer
 * May 2024
 */

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
