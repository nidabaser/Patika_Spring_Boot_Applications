package dev.nida.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nida Başer
 * May 2024
 */

@Controller
@ResponseBody
@RequestMapping("/senabilgisayar") //Ortak olan path burada belirtilir. Mesela http://localhost:8080/senabilgisayar/ sonrası özelleştirilmiş pathler
public class TestController {

    @GetMapping("/")
    public String home(){
        return "Hoşgeldiniz";
    }

    @GetMapping("/about") // Bu notasyonun uzun hali şudur: @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){
        return "Sena bilgisayar 2000 yılından beri Eskişehir'de hizmet vermektedir.";
    }

    //Aynı mantık Post için:
    //@PostMapping("/about") // @RequestMapping(value = "/about", method = RequestMethod.POST)

    @GetMapping("/user/{userId}")
    public String getUserOnlyId(@PathVariable("userId") int user_id){
        return "User id : " + user_id;
    }

    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable("userId") int user_id, @PathVariable("userName") String username){
        return "User id : " + user_id + " -- Username : " + username;
    }


}
