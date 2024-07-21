package dev.kotprotiv.homepage.repo;

import dev.kotprotiv.dto.ObsessionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("obsessionRestRepo")
public class ObsessionRestRepoImpl implements ObsessionRestRepo {

  private static final String URL = "http://api:8080/obsession";

  private final RestTemplate restTemplate;

  public ObsessionRestRepoImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public ObsessionDto retrieve() {
    return restTemplate.getForObject(URL, ObsessionDto.class);
  }
}
