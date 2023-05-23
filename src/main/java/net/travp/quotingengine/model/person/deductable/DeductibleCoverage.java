package net.travp.quotingengine.model.person.deductable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class DeductibleCoverage {
    private Integer deductible;
}
