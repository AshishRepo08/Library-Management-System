package com.RollNo8.MyLibraryManagementPlatform.config.security.filter;

import com.RollNo8.MyLibraryManagementPlatform.repo.LibraryUserRepo;
import com.RollNo8.MyLibraryManagementPlatform.serviceJWT.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         //Your receive token from client in this format -> Bearer eyJhcio.ddjseosjdoadd.kdowoddkdsslskf


        //For Authenticating the token, we need to 1. Remove the prefix "Bearer" 2. Validate the remaining token
        //----------------------------------------------------------------------------------------------------------


        //Authentication Token : Step 1 -> Get the token from the headers
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(authHeader !=null && authHeader.startsWith("Bearer")){  //Verifying here that the authHeader should not be null and should start with "Bearer".
            token = authHeader.substring(7);
            username = jwtService.extractUserName(token);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            //If SecurityContextHolder.getContext().getAuthentication() !=null, that means the user is already authenticated. So, no need to do anything


            //We are going to validate the token. If it's validated, we need to create an authentication object.

            //Here we are passing token to verify it. And, we are mentioning username because we will verify if this username is part of the database
            UserDetails loggedInUser = context.getBean(LibraryUserRepo.class).findByUsername(username);
            if(jwtService.validateToken(token, loggedInUser)) {

                //Below is token i am creating for the next filter
                UsernamePasswordAuthenticationToken tokenForNextFilter = new UsernamePasswordAuthenticationToken(loggedInUser,null,loggedInUser.getAuthorities());
                tokenForNextFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


                //Now, that finally all verification are done, we are going to set the value so signify that authentication for this request is complete
                //This is set for what we ran a get for in the line 47 and 48
                SecurityContextHolder.getContext().setAuthentication(tokenForNextFilter);
            }
        }

        //Now, we are finally saying -> Continue in the filter chain.
        filterChain.doFilter(request,response);

    }
}
