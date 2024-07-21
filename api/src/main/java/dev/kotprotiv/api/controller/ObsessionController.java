package dev.kotprotiv.api.controller;

import dev.kotprotiv.dto.ObsessionDto;
import dev.kotprotiv.api.service.ObsessionConverter;
import dev.kotprotiv.api.service.ObsessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obsession")
public class ObsessionController {

  private final ObsessionService obsessionService;
  private final ObsessionConverter obsessionConverter;

  public ObsessionController(
      ObsessionService obsessionService, ObsessionConverter obsessionConverter) {
    this.obsessionService = obsessionService;
    this.obsessionConverter = obsessionConverter;
  }

  @PostMapping
  public void set(@RequestBody ObsessionDto dto) {
    obsessionService.update(obsessionConverter.convertFrom(dto));
  }

  @GetMapping
  public ObsessionDto get() {
    return obsessionConverter.convertTo(obsessionService.retrieve());
  }
}
