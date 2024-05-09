package dev.nida.service_katmani.api;

import dev.nida.service_katmani.Customer;
import dev.nida.service_katmani.business.abstracts.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nida Başer
 * May 2024
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    /*

    // IOC : Inversion of Control
    // 3 farklı yöntem var: Constructor, Field, Setter

    // CONTRUCTOR metoduyla
    private final ICustomerService customerService;
    @Autowired // 4.3'den sonra spring bunu otomatik algılıyor @Autowired notasyonu kaldırılabilir.
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    // SETTER metoduyla
    private ICustomerService customerService;

    @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    // FIELD metoduyla
    @Autowired
    private ICustomerService customerService;

     */


    // MANUEL yöntem
    /*
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") int id) {
        return customerService.getById(id);
    }
     */

}
