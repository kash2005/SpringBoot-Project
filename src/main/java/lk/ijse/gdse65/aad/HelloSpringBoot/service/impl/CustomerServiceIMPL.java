package lk.ijse.gdse65.aad.HelloSpringBoot.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.aad.HelloSpringBoot.controller.Customer;
import lk.ijse.gdse65.aad.HelloSpringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.CustomerEntity;
import lk.ijse.gdse65.aad.HelloSpringBoot.repostory.CustomerDAO;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerDAO customerDao;
    @Autowired
    private ConversionData convert;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = convert.convertToCustomerEntity(customerDTO);
        CustomerEntity customer = customerDao.save(customerEntity);
        return convert.convertToCustomerDTO(customer);
    }
}
