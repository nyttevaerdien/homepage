package dev.kotprotiv.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "obsession")
public class Obsession {

  @Id
  @GeneratedValue(generator = "Incremental")
  private Long id;

  private String name;
  private String url;
}
