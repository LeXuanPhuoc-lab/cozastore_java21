package cybersoft.example.cozastore_java21.config;

import cybersoft.example.cozastore_java21.filter.JwtFilter;
import cybersoft.example.cozastore_java21.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomAuthenProvider customAuthenProvider;

    // cau hinh PasswordEncoder va luu tren IOC
    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
    }

    @Autowired
    JwtFilter jwtFilter;

    // filter dung de custom rule lien quan toi API hoac cau hinh cua security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable() // Tat cau hinh lien quan toi tan cong CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests() //Qui dinh lai cac rule lien quan den chung thuc cho link duoc goi
                    .requestMatchers("/signin","/signup").permitAll()
                .and()
//                .httpBasic()
//                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                // khai bao su dung custom user deltail service
                //.userDetailsService(customUserDetailService)
                // khai bao chuan ma hoa password ma custom user detail service dang su dung
                //.passwordEncoder(passwordEncoder())
                //.and()

                // dung AuthenticationProvider da custom
                .authenticationProvider(customAuthenProvider)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//
//        // Admin
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("123456"))
//                .roles("ADMIN","SAVE")
//                .build();
//
//        // User
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("123456"))
//                .roles("USER","DELETE")
//                .build();
//
//        UserDetails test = customUserDetailService.loadUserByUsername("phuoclx@gmail.com");
//
//        System.out.println(test.getUsername());
//        System.out.println(test.getPassword());
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

}
