package net.travp.quotingengine.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import net.travp.quotingengine.model.person.Coverages;
import net.travp.quotingengine.model.person.Vehicle;

@Getter
@Setter
public class Person {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String licenseNumber;
    private ArrayList<Vehicle> vehicles;
    private Coverages coverages;
}
