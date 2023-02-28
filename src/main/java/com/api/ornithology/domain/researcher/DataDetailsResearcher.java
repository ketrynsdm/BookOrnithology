package com.api.ornithology.domain.researcher;

public record DataDetailsResearcher(Long id, String nome, String email) {

    public DataDetailsResearcher(Researcher researcher) {
        this(researcher.getId(), researcher.getNome(), researcher.getEmail());
    }
}
