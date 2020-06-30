package aaryan.microservices.beerbrewary.web.Customerservice;

import aaryan.microservices.beerbrewary.web.model.Customer;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class Customerserviceimpl implements CustomerService {

    @Override
    public Customer getCustbyId() {
        return Customer.builder().Id(UUID.randomUUID()).name("AARYAN").build();
    }
}
