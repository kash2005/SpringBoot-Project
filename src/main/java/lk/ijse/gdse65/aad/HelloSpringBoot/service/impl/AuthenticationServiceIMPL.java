package lk.ijse.gdse65.aad.HelloSpringBoot.service.impl;

import lk.ijse.gdse65.aad.HelloSpringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.Role;
import lk.ijse.gdse65.aad.HelloSpringBoot.entity.UserEntity;
import lk.ijse.gdse65.aad.HelloSpringBoot.repostory.UserDAO;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.JWTAuthResponse;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignIn;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignUp;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.AuthenticationService;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDAO userDAO;
    private final JWTService jwtService;
    private final ConversionData conversionData;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        var userDAOByEmail = userDAO.findByEmail(signIn.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        var token = jwtService.generateToken(userDAOByEmail);
        return JWTAuthResponse.builder().token(token).build();
    }

    @Override
    public JWTAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .firstName(signUp.getFirstName())
                .lastName(signUp.getLastName())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        var save = userDAO.save(conversionData.toUserEntity(buildUser));
        jwtService.generateToken(save);
        return JWTAuthResponse.builder().build();
    }
}
