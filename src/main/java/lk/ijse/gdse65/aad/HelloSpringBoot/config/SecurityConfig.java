package lk.ijse.gdse65.aad.HelloSpringBoot.config;

import lk.ijse.gdse65.aad.HelloSpringBoot.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserService userService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer :: disable)
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//                return http.build();
        http.csrf(AbstractHttpConfigurer :: disable)
            .authorizeHttpRequests(req->req.requestMatchers("")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(getAuthenticationProvider()).addFilterBefore();
            return http.build();

    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider dap = new  DaoAuthenticationProvider();
        dap.setUserDetailsService(userService.userdetailsService());//To:user service
        dap.setPasswordEncoder(passwordEncoder());
        return dap;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
//        User.withDefaultPasswordEncoder()
//                .username("kamal")
//                .password("1234")
//                .roles("USER").build();
        return new InMemoryUserDetailsManager(User.withDefaultPasswordEncoder()
             .username("kamal")
             .password("1234")
             .roles("USER").build());
    }
}
