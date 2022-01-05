package ru.charov.mctwo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Message {
    private Integer id;
    private Integer session_id;

    private LocalDateTime MC1_timestamp;

    private LocalDateTime MC2_timestamp;

    private LocalDateTime MC3_timestamp;

    private LocalDateTime end_timestamp;
}
