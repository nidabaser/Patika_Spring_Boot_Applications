package dev.nida.spring;

import org.springframework.web.bind.annotation.*;

/**
 * @author Nida Başer
 * May 2024
 */

@RestController //ResponseBody ve Controller gerekmez.
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/")
    public String get(){
        return "Customer get metodu çalıştı";
    }

    @PostMapping("/save")
    public String save(@RequestBody String data){
        return "Customer Save metodundan gelen veri: " + data;
    }

}
