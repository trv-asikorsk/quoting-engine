package net.travp.quotingengine.model.person;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Vehicle {
    private String make;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate year;
    private String vin;
}
