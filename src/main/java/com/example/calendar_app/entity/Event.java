package com.example.calendar_app.entity;

import lombok.*;

import java.time.LocalDate;

@Builder(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Event {
    @NonNull
    private LocalDate date;
    @NonNull
    private String description;
    @NonNull
    private String name;


}
