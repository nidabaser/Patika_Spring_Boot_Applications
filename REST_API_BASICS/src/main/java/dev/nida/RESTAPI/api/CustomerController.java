package dev.nida.RESTAPI.api;

import dev.nida.RESTAPI.business.abstracts.ICustomerService;
import dev.nida.RESTAPI.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

@RestController
@RequestMapping("/v1") //// --> /v1/customer da olurdu ama getmapping için bu daha anlamlı
public class CustomerController {

    @Autowired //IoC'ye bıraktık
    private ICustomerService customerService;

    // LİSTELEME
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK) // RESPONSE BELİRTMEK GEREKİR
    public List<Customer> findAll() {
        return this.customerService.findAll(); // Customer nesnesini -> JSON formatına çevirir
    }

    // YENİ KAYIT EKLEME
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED) // Nesne üretildi başarılı 201
    public Customer save(@RequestBody Customer customer) { // JSON -> Customer nesnesine çevirir.
        return this.customerService.save(customer);
    }

    // KAYIT GÜNCELLEME
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK) // 200 başarılı
    public Customer update(@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    // KAYIT SİLME
    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }

    // TEKİL VERİ ÇEKME
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable("id") int id) {
        return this.customerService.getById(id);
    }

}