package dev.kotprotiv.api.service;

import dev.kotprotiv.api.model.Obsession;
import dev.kotprotiv.api.repo.ObsessionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("obsessionService")
@RequiredArgsConstructor
public class ObsessionServiceImpl implements ObsessionService {

  private final ObsessionRepo obsessionRepo;

  @Override
  public Obsession retrieve() {
    List<Obsession> all = obsessionRepo.findAll();
    if (all.size() != 1) {
      log.error("No obsession set; skipping");
      return getDefault();
    }
    return all.get(0);
  }

  @Override
  public void update(Obsession obsession) {
    obsessionRepo.deleteAll();
    obsessionRepo.save(obsession);
  }

  private Obsession getDefault() {
    Obsession obsession = new Obsession();
    obsession.setName("No obsession for now");
    obsession.setUrl("https://www.youtube.com/embed/jfKfPfyJRdk?si=2pdv4BzGvnJg9q0X");
    return obsession;
  }
}
