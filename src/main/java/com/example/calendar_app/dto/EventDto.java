package com.example.calendar_app.dto;

import lombok.Value;

import java.time.LocalDate;


public record EventDto(LocalDate date, String description, String name) {

}
