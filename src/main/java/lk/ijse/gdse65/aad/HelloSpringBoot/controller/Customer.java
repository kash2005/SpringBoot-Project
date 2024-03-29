package lk.ijse.gdse65.aad.HelloSpringBoot.controller;

import lk.ijse.gdse65.aad.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/customer")

public class Customer {
    @Autowired
    CustomerService customerService;

    @GetMapping("/health")
    public String healthTest(){
        return "CustomerHealth Test";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@RequestBody CustomerDTO customerDTO, Errors errors){
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }
        customerService.saveCustomer(customerDTO);
    }
}
