package aaryan.microservices.beerbrewary.web.Controller;


import aaryan.microservices.beerbrewary.web.Customerservice.CustomerService;
import aaryan.microservices.beerbrewary.web.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService custservice;


    @GetMapping({"/{Customerid}"})
    public ResponseEntity<Customer> getCustomer(@PathVariable UUID Customerid){

        return new ResponseEntity<>(custservice.getCustbyId(), HttpStatus.OK);
    }
}
