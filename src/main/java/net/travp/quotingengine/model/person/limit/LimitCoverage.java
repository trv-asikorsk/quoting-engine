package net.travp.quotingengine.model.person.limit;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class LimitCoverage {
        private ArrayList<Integer> limits;
}
