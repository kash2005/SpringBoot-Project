package lk.ijse.gdse65.aad.HelloSpringBoot.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.aad.HelloSpringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.UserEntity;
import lk.ijse.gdse65.aad.HelloSpringBoot.repostory.UserDAO;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserDAO userDAO;
    private final ConversionData conversionData;
    @Override
    public UserDetailsService userdetailsService() {
        return username ->
                userDAO.findByEmail(username)
                        .orElseThrow(() ->new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void save(UserDTO userDTO) {
        conversionData.toUserDTO(userDAO.save(conversionData.toUserEntity(userDTO)));
    }
}
