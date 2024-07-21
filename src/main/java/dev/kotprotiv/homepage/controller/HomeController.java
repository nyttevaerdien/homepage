package dev.kotprotiv.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String viewHome(Model model) {

    model.addAttribute("appName", "My HomePage!");
    return "home";
  }
}
