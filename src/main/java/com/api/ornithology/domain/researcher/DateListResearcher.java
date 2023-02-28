package com.api.ornithology.domain.researcher;

public record DateListResearcher(Long id, String nome, String email) {
    public DateListResearcher(Researcher researcher) {
        this(researcher.getId(), researcher.getNome(), researcher.getEmail());
    }
}
