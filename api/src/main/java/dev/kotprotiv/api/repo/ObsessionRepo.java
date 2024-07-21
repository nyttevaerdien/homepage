package dev.kotprotiv.api.repo;

import dev.kotprotiv.api.model.Obsession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObsessionRepo extends JpaRepository<Obsession, Long> {}
