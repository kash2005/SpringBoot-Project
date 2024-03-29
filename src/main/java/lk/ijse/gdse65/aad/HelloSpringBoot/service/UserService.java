package lk.ijse.gdse65.aad.HelloSpringBoot.service;

import lk.ijse.gdse65.aad.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userdetailsService();
    void save(UserDTO userDTO);
}
