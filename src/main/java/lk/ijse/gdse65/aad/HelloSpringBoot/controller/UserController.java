package lk.ijse.gdse65.aad.HelloSpringBoot.controller;

import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.JWTAuthResponse;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignIn;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignUp;
import lk.ijse.gdse65.aad.HelloSpringBoot.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    //signup
    @PostMapping("/signup")
    public ResponseEntity<JWTAuthResponse> signup(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    //signin
    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> signin(@RequestBody SignIn signIn) {
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }
}
