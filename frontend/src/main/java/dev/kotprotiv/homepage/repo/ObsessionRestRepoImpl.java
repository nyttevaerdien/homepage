package dev.kotprotiv.homepage.repo;

import dev.kotprotiv.dto.ObsessionDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
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
  @Retryable(retryFor = Exception.class, maxAttempts = 10, backoff = @Backoff(delay = 1000))
  public ObsessionDto retrieve() {
    return restTemplate.getForObject(URL, ObsessionDto.class);
  }

  @Recover
  private ObsessionDto recover(Exception e) {
		ObsessionDto obsessionDto = new ObsessionDto();
		obsessionDto.setName("Nothing");
		obsessionDto.setUrl(null);
		return obsessionDto;
  }
}
