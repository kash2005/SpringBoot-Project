package lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
