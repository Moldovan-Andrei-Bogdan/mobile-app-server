package com.mecorp.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @NotEmpty
    @NotNull
    private String title;

    @NotEmpty
    @NotNull
    private String occurrenceDate;

    @NotEmpty
    @NotNull
    private String jiraLink;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    private String spentHours;
}
