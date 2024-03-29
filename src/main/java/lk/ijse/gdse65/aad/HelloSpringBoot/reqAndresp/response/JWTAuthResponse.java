package lk.ijse.gdse65.aad.HelloSpringBoot.reqAndresp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class JWTAuthResponse {
    private String token;
}
