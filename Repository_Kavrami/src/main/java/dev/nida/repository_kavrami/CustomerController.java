package dev.nida.repository_kavrami;

/**
 * @author Nida Başer
 * May 2024
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") int id){
        return this.customerRepo.findById(id).orElseThrow(); // Boş nesne döndürürse exception atar
    }

    @PostMapping("/save") // Aslında bu işlem için id gönderirsen update, göndermezsen save olarak ilerliyor
    public Customer save(@RequestBody Customer customer){
        return this.customerRepo.save(customer);
    }

    @GetMapping("/find-all")
    public List<Customer> findAll(){
        return this.customerRepo.findAll();
    }

    @GetMapping("/mail/{mail}")
    public Customer findByMail(@PathVariable("mail") String mail){
        return this.customerRepo.findByMail(mail);
    }

    // İki koşullu hali VE AND VEYA OR
    @GetMapping("/find/{mail}/{gender}")
    public Customer findByMailAndGender(@PathVariable("mail") String mail, @PathVariable("gender") Customer.Gender gender){
        return this.customerRepo.findByMailAndGender(mail, gender);
    }

    @GetMapping("/find/{gender}")
    public List<Customer> findByGender(@PathVariable("gender") Customer.Gender gender){
        return this.customerRepo.findByGender(gender);
    }

    // OZEL SORGU CUSTOM WUERY
    @GetMapping("/find/{gender}")
    public List<Customer> getQueryByGender(@PathVariable("gender") Customer.Gender gender){
        return this.customerRepo.getQueryByGender(gender);
    }

}