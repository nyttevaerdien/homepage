package dev.kotprotiv.homepage.controller;

import dev.kotprotiv.dto.ObsessionDto;
import dev.kotprotiv.homepage.repo.ObsessionRestRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  private final ObsessionRestRepo obsessionRestRepo;

  public HomeController(ObsessionRestRepo obsessionRestRepo) {
    this.obsessionRestRepo = obsessionRestRepo;
  }

  @RequestMapping("/")
  public String viewHome(Model model) {
    ObsessionDto obsession = obsessionRestRepo.retrieve();
    model.addAttribute("obsession", obsession);
    return "home";
  }
}
