package dev.kotprotiv.api.service;

import dev.kotprotiv.api.model.Obsession;
import dev.kotprotiv.api.model.ObsessionDto;
import org.springframework.stereotype.Service;

@Service("obsessionConverter")
public class ObsessionConverter {

  public Obsession convertFrom(ObsessionDto dto) {
    Obsession value = new Obsession();
    value.setName(dto.getName());
    value.setUrl(dto.getUrl());
    return value;
  }

  public ObsessionDto convertTo(Obsession entity) {
    ObsessionDto value = new ObsessionDto();
    value.setName(entity.getName());
    value.setUrl(entity.getUrl());
    return value;
  }
}
