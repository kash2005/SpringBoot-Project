package lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.authObj;

import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.JWTAuthResponse;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignIn;
import lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure.SignUp;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(SignUp signUp);
}
