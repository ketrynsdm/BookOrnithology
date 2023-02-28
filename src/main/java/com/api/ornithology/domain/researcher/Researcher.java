package com.api.ornithology.domain.researcher;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "researcher")
@Entity(name = "Researcher")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Researcher {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Boolean ativo;

    public Researcher(DataRecordResearcher dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
    }

    public void delete() {
        this.ativo = false;
    }
}
