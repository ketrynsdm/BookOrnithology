package com.api.ornithology.repositories;

import com.api.ornithology.models.OrnithologyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookOrnithologyRepository extends JpaRepository<OrnithologyModel, Long> {
}
