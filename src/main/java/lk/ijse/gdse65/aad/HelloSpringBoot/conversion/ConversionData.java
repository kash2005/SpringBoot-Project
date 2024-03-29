package lk.ijse.gdse65.aad.HelloSpringBoot.conversion;

import lk.ijse.gdse65.aad.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.CustomerEntity;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConversionData {
    final private ModelMapper modelMapper;

    //Student Obj mapping
    //CustomerMapping
    public CustomerDTO convertToCustomerDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    //UserMapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity user){
        return modelMapper.map(user,UserDTO.class);
    }
}
