package dev.nida.RESTAPI.api;

import dev.nida.RESTAPI.business.abstracts.ICustomerService;
import dev.nida.RESTAPI.dto.CustomerResponse;
//import dev.nida.RESTAPI.dto.CustomerDtoConvert;
import dev.nida.RESTAPI.dto.CustomerSaveRequest;
import dev.nida.RESTAPI.dto.CustomerUpdateRequest;
import dev.nida.RESTAPI.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nida Başer
 * May 2024
 */

@RestController
@RequestMapping("/v1") //// --> /v1/customer da olurdu ama getmapping için bu daha anlamlı
public class CustomerController {

    @Autowired //IoC'ye bıraktık
    private ICustomerService customerService;

    //@Autowired
    //private CustomerDtoConvert converter;

    @Autowired
    private ModelMapper modelMapper;

    // LİSTELEME
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK) // RESPONSE BELİRTMEK GEREKİR
    public List<CustomerResponse> findAll() {

        // MODEL MAPPER AUTOMATIC METHOD
        return this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponse.class)
        ).collect(Collectors.toList());

        // MODEL MAPPER MANUEL METHODS CUSTOM
        // METHOD 3
        /*
        return this.customerService.findAll().stream().map(
                customer -> this.converter.convertDto(customer)
        ).collect(Collectors.toList());
        */
        // METHOD 2
        /*
        List<Customer> customerList = this.customerService.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(
                customer -> this.converter.convertDto(customer)
        ).collect(Collectors.toList());
        return customerDtoList;
        */
        // METHOD 1
        //return this.customerService.findAll(); // Customer nesnesini -> JSON formatına çevirir
    }

    // YENİ KAYIT EKLEME
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED) // Nesne üretildi başarılı 201
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer newCustomer = this.modelMapper.map(customerSaveRequest, Customer.class);
        newCustomer.setOnDate(LocalDate.now()); // Date'i de kendimiz doldurduk request'ten gelmesini istemiyoruz
        return this.customerService.save(newCustomer);
    }

    // SAVE REQUEST BEFORE MODEL MAPPER
    //public Customer save(@RequestBody Customer customer) { // JSON -> Customer nesnesine çevirir.
    //    return this.customerService.save(customer);
    //}

    // KAYIT GÜNCELLEME
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK) // 200 başarılı
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest) {
        Customer updatedCustomer = this.customerService.getById(customerUpdateRequest.getId());
        updatedCustomer.setName(customerUpdateRequest.getName()); // Sadece isim ve gender güncellenebilecektir.
        updatedCustomer.setGender(customerUpdateRequest.getGender()); // Diğer veriler request edilse de güncellenmezzz
        return this.customerService.update(updatedCustomer);
    }

    // UPDATE REQUEST BEFORE MODEL MAPPER
//    public Customer update(@RequestBody Customer customer) {
//        return this.customerService.update(customer);
//    }

    // KAYIT SİLME
    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
    }

    // TEKİL VERİ ÇEKME
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") int id) { // DTO ile sadece istediğimiz verileri çekebildik.
        // MODEL MAPPER
        return this.modelMapper.map(this.customerService.getById(id), CustomerResponse.class);

        // return this.converter.convertDto(this.customerService.getById(id));
        //Uzun hali aşağıdaki, kısa hali yukarıdaki
//        Customer customer = this.customerService.getById(id);
//        CustomerDto customerDto = this.converter.convertDto(customer);
//        return customerDto;
    }

}