package com.hs.controller;

import com.hs.entity.Customer;
import com.hs.service.CustomerService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpCookie;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/login")
    public String login(String username, String passwd, HttpSession session, HttpServletResponse resp){
        int i = customerService.login(username, passwd);
        if (i==-1){
            return "user not exist";
        }else {
            if (i==0){
                return "passwd error";
            }else {
                session.setAttribute("username",username);
                Cookie cookie=new Cookie("username",username);
                resp.addCookie(cookie);
                return "ok";
            }
        }
    }

    @PostMapping("/customer/register")
    public String register(Customer customer){
        System.out.println(customer);
        int i = customerService.register(customer);
        if (i==1){
            return "register ok";
        }else {
            return "username has been existed";
        }

    }

    @GetMapping("/customer/exit")
    public void exit(HttpSession session,HttpServletResponse resp) throws IOException {
        session.removeAttribute("username");
    }
}
