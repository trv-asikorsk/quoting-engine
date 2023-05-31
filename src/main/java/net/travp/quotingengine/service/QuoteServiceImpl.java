package net.travp.quotingengine.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.travp.quotingengine.model.Person;

@Service
public class QuoteServiceImpl implements QuoteService {

    private static final int BASE_PREMIUM = 1000;

    @Override
    public Map<String, Integer> getQuote(Person person) {
        return new HashMap<String, Integer>() {
            {
                put("premium", calculatePremium(person));
            }
        };
    }

    public int calculatePersonAgeIncrease(LocalDate dateOfBirth) {
        int years = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if (years < 25) {
            return (25 - years) * 50;
        }
        return 0;
    }

    public int calculateVehicleAge(LocalDate dateOfManufacture) {
        int years = Period.between(dateOfManufacture, LocalDate.now()).getYears();
        if (years < 5) {
            return 0;
        }
        return (years - 5) * 100;
    }

    public int calculatePropertyDamageIncrease(Integer limit) {
        if (limit == null)
            return 0;
        double factor = Math.floor(limit / 10000) * 0.05;
        return (int) (BASE_PREMIUM * factor);
    }

    public int calculateCollisionIncrease(Integer deductable) {
        if (deductable == null)
            return 0;
        double factor = Math.floor(deductable / 1000) * 0.03;
        return (int) (BASE_PREMIUM * factor);
    }

    public int calculateBodyInjuryIncrease(Integer limit) {
        if (limit == null)
            return 0;
        double factor = Math.floor(limit / 25000) * 0.1;
        return (int) (BASE_PREMIUM * factor);
    }

    public int calculateUninsuredUnderinsuredIncrease(Integer limit) {
        if (limit == null)
            return 0;
        double factor = Math.floor(limit / 10000) * 0.02;
        return (int) (BASE_PREMIUM * factor);
    }

    public int calculateComprehensiveIncrease(Integer deductable) {
        if (deductable == null)
            return 0;
        double factor = Math.floor(deductable / 1000) * 0.01;
        return (int) (BASE_PREMIUM * factor);
    }

    // can be modified to return a quote for different limits and different vehicles
    // currently just grabs first vehicle and first set of limits if not empty
    // (not as sophisticated as it could be: potentially output all possible
    // premiums as a JSON response)
    public int calculatePremium(Person person) {
        int premium = BASE_PREMIUM;
        premium += calculatePersonAgeIncrease(person.getDateOfBirth());
        premium += person.getVehicles().size() == 0 ? 0 : calculateVehicleAge(person.getVehicles().get(0).getYear());
        premium += person.getCoverages().getPropertyDamage().getLimits().size() == 0 ? 0
                : calculatePropertyDamageIncrease(person.getCoverages().getPropertyDamage().getLimits().get(0));
        premium += calculateCollisionIncrease(person.getCoverages().getCollision().getDeductible());
        premium += person.getCoverages().getBodilyInjuryPerPerson().getLimits().size() == 0 ? 0
                : calculateBodyInjuryIncrease(person.getCoverages().getBodilyInjuryPerPerson().getLimits().get(0));
        premium += person.getCoverages().getBodilyInjuryPerAccident().getLimits().size() == 0 ? 0
                : calculateBodyInjuryIncrease(person.getCoverages().getBodilyInjuryPerAccident().getLimits().get(0));
        premium += person.getCoverages().getUninsuredMotoristPerPerson().getLimits().size() == 0 ? 0
                : calculateUninsuredUnderinsuredIncrease(
                        person.getCoverages().getUninsuredMotoristPerPerson().getLimits().get(0));
        premium += person.getCoverages().getUninsuredMotoristPerAccident().getLimits().size() == 0 ? 0
                : calculateUninsuredUnderinsuredIncrease(
                        person.getCoverages().getUninsuredMotoristPerAccident().getLimits().get(0));
        premium += person.getCoverages().getUnderinsuredMotoristPerPerson().getLimits().size() == 0 ? 0
                : calculateUninsuredUnderinsuredIncrease(
                        person.getCoverages().getUnderinsuredMotoristPerPerson().getLimits().get(0));
        premium += person.getCoverages().getUnderinsuredMotoristPerAccident().getLimits().size() == 0 ? 0
                : calculateUninsuredUnderinsuredIncrease(
                        person.getCoverages().getUnderinsuredMotoristPerAccident().getLimits().get(0));
        premium += calculateComprehensiveIncrease(person.getCoverages().getComprehensive().getDeductible());
        return premium;
    }
}
