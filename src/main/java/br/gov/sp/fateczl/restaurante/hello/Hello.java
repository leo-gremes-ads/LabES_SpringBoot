package br.gov.sp.fateczl.restaurante.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello
{
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}