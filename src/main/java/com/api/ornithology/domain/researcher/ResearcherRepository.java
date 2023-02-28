package com.api.ornithology.domain.researcher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearcherRepository extends JpaRepository<Researcher, Long> {
    Page<Researcher> findAllByAtivoTrue(Pageable page);
}
