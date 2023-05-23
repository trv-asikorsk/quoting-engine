package net.travp.quotingengine.model.person.limit;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class LimitCoverage {
        private ArrayList<Integer> limits;
}
