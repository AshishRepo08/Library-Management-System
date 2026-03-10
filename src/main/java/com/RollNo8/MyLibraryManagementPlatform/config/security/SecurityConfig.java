package com.RollNo8.MyLibraryManagementPlatform.config.security;

import com.RollNo8.MyLibraryManagementPlatform.config.security.filter.JwtFilter;
import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import com.RollNo8.MyLibraryManagementPlatform.repository.LibraryUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<UserDetails> usersList = new ArrayList<>();
//        usersList.add(new User("roma","{noop}roma", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        usersList.add(new User("donna","{noop}donna",Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//
//        return new InMemoryUserDetailsManager(usersList);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {

        httpSecurity
                .authorizeHttpRequests(
                configurer -> configurer
                                                               .requestMatchers(HttpMethod.GET,"/").permitAll()
                                                               .requestMatchers(HttpMethod.GET,"/login").permitAll()
                                                               .requestMatchers(HttpMethod.GET,"/register").permitAll()
                                                               .requestMatchers(HttpMethod.POST,"/register").permitAll()
                                                               .requestMatchers(HttpMethod.POST,"/jwt/**").permitAll()
                                                               .requestMatchers("/h2-console/**").permitAll()
                                                               .requestMatchers(HttpMethod.GET,"/images/**","/css/**","/home.css").permitAll()
                                                               .requestMatchers("/v3/api-docs/**","/swagger-ui/**","/swagger-ui.html").permitAll()
                                                               .requestMatchers(HttpMethod.DELETE,"/v2/books/book/**").hasRole("ADMIN")
                                                               .anyRequest().authenticated());

                //.formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/",true));
                httpSecurity.httpBasic(Customizer.withDefaults());

                //CSRF is required only for cookie-based browser authentication.
                //For token-based APIs, CSRF is unnecessary and should be disabled
                httpSecurity.csrf(csrf -> csrf.disable());
                httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

                //Adding JWT Filter --------------------------------------------------------------------------
                httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService myLibraryDetailsService(LibraryUserRepo libraryUserRepo) {
        return username -> {
            System.out.println("username:"+username);
            LibraryUser libraryUser = libraryUserRepo.findByUsername(username);
            if(libraryUser!=null){
                return libraryUser;
            } else {
                throw new UsernameNotFoundException("User's " +username + "not found");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
