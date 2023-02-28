package com.api.ornithology.domain.researcher;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record DataRecordResearcher(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email
) {
}
