package br.com.edu.classinsight.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeedbackDTO(
        @NotBlank
        String descricao,

        @NotNull @Min(0) @Max(10)
        Integer nota
) {
}
