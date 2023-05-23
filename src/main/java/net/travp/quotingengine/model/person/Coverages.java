package net.travp.quotingengine.model.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.travp.quotingengine.model.person.deductable.Collision;
import net.travp.quotingengine.model.person.deductable.Comprehensive;
import net.travp.quotingengine.model.person.limit.BodilyInjuryPerAccident;
import net.travp.quotingengine.model.person.limit.BodilyInjuryPerPerson;
import net.travp.quotingengine.model.person.limit.PropertyDamage;
import net.travp.quotingengine.model.person.limit.UnderinsuredMotoristPerAccident;
import net.travp.quotingengine.model.person.limit.UnderinsuredMotoristPerPerson;
import net.travp.quotingengine.model.person.limit.UninsuredMotoristPerAccident;
import net.travp.quotingengine.model.person.limit.UninsuredMotoristPerPerson;

@Getter
@Setter
@ToString
public class Coverages {
    private PropertyDamage propertyDamage;
    private Collision collision;
    private BodilyInjuryPerPerson bodilyInjuryPerPerson;
    private BodilyInjuryPerAccident bodilyInjuryPerAccident;
    private UninsuredMotoristPerPerson uninsuredMotoristPerPerson;
    private UninsuredMotoristPerAccident uninsuredMotoristPerAccident;
    private UnderinsuredMotoristPerPerson underinsuredMotoristPerPerson;
    private UnderinsuredMotoristPerAccident underinsuredMotoristPerAccident;
    private Comprehensive comprehensive;
}
