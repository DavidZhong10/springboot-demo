package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {

        System.out.println("--------测试启动springboot-demo项目---------");
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public void hello(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));
        if(id > 0){
            resp.sendRedirect("/ok.html");
        }else{
            req.getRequestDispatcher("/fail.html").forward(req,resp);
        }
        System.out.println("id值为：" + req.getParameter("id"));
    }

}