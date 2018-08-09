package com.hpe.hpdev.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;


@Order(0)
public class RequestFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        Enumeration enums = request.getHeaderNames();

        while (enums.hasMoreElements()) {
            String name = (String) enums.nextElement();

            System.out.println("header:" + name + " = " + request.getHeader(name));
        }


        Map m = request.getParameterMap();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " = " + request.getParameter(key));
        }

        System.out.println("request.getMethod() = " + request.getMethod().toString());
        System.out.println("request.getRequestURI().toString() = " + request.getRequestURI().toString());


        filterChain.doFilter(request, response);
    }

}
