package dev.kotprotiv.api.service;

import dev.kotprotiv.api.model.Obsession;

public interface ObsessionService {
  Obsession retrieve();

  void update(Obsession obsession);
}
