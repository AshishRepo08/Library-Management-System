package com.RollNo8.MyLibraryManagementPlatform.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

//In the context of Spring Boot, interceptors are components that allow you to intercept HTTP requests and responses in your web application.
// They provide a way to execute code before the request is handled by a controller and after the response is generated.

@Slf4j
@Component
public class CustomInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(CustomInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        logger.info("Pre Handle Method is Calling");
        logger.info("Request Url: "+request.getRequestURL());
        //logger.info("Request Method: "+request.getMethod());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{
        logger.info("Post Handle Method is Calling");
        logger.info("Response Status: "+response.getStatus());
    }

//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception{
//        logger.info("After Completion method is calling");
//        if(ex !=null){
//            logger.severe("Exception: "+ex.getMessage());
//        } else {
//            logger.info("After Completion method is concluded");
//        }
//    }
}
