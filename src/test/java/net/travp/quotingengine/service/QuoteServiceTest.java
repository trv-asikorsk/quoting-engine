package net.travp.quotingengine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.travp.quotingengine.model.Person;

@SpringBootTest
public class QuoteServiceTest {

    private static Person person1;
    private static Person person2;
    private static Person person3;

    @Autowired
    QuoteServiceImpl service;

    @BeforeAll
    public static void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        person1 = objectMapper.readValue(new File("src/test/resources/input1.json"), Person.class);
        person2 = objectMapper.readValue(new File("src/test/resources/input2.json"), Person.class);
        person3 = objectMapper.readValue(new File("src/test/resources/input3.json"), Person.class);
    }

    @Test
    public void calculatePersonAgeIncreaseTest1() {
        assertEquals(0, service.calculatePersonAgeIncrease(LocalDate.of(1990, 1, 1)));
    }

    @Test
    public void calculatePersonAgeIncreaseTest2() {
        assertEquals(100, service.calculatePersonAgeIncrease(LocalDate.of(2000, 1, 1)));
    }

    @Test
    public void calculatePersonAgeIncreaseTest3() {
        assertEquals(600, service.calculatePersonAgeIncrease(LocalDate.of(2010, 1, 1)));
    }

    @Test
    public void calculatePersonAgeIncreaseTest4() {
        assertEquals(0, service.calculatePersonAgeIncrease(LocalDate.of(1998, 1, 1)));
    }

    @Test
    public void calculateVehicleAgeTest1() {
        assertEquals(800, service.calculateVehicleAge(LocalDate.of(2010, 1, 1)));
    }

    @Test
    public void calculateVehicleAgeTest2() {
        assertEquals(0, service.calculateVehicleAge(LocalDate.of(2020, 1, 1)));
    }

    @Test
    public void calculateVehicleAgeTest3() {
        assertEquals(0, service.calculateVehicleAge(LocalDate.of(2018, 1, 1)));
    }

    @Test
    public void calculateVehicleAgeTest4() {
        assertEquals(100, service.calculateVehicleAge(LocalDate.of(2017, 1, 1)));
    }

    @Test
    public void calculatePropertyDamageIncreaseTest1() {
        assertEquals(50, service.calculatePropertyDamageIncrease(10000));
    }

    @Test
    public void calculatePropertyDamageIncreaseTest2() {
        assertEquals(100, service.calculatePropertyDamageIncrease(20000));
    }

    @Test
    public void calculatePropertyDamageIncreaseTest3() {
        assertEquals(0, service.calculatePropertyDamageIncrease(5000));
    }

    @Test
    public void calculatePropertyDamageIncreaseTest4() {
        assertEquals(0, service.calculatePropertyDamageIncrease(1000));
    }

    @Test
    public void calculateCollisionIncreaseTest1() {
        assertEquals(30, service.calculateCollisionIncrease(1000));
    }

    @Test
    public void calculateCollisionIncreaseTest2() {
        assertEquals(60, service.calculateCollisionIncrease(2000));
    }

    @Test
    public void calculateCollisionIncreaseTest3() {
        assertEquals(0, service.calculateCollisionIncrease(500));
    }

    @Test
    public void calculateCollisionIncreaseTest4() {
        assertEquals(0, service.calculateCollisionIncrease(100));
    }

    @Test
    public void calculateBodyInjuryIncreaseTest1() {
        assertEquals(100, service.calculateBodyInjuryIncrease(25000));
    }

    @Test
    public void calculateBodyInjuryIncreaseTest2() {
        assertEquals(200, service.calculateBodyInjuryIncrease(50000));
    }

    @Test
    public void calculateBodyInjuryIncreaseTest3() {
        assertEquals(0, service.calculateBodyInjuryIncrease(10000));
    }

    @Test
    public void calculateBodyInjuryIncreaseTest4() {
        assertEquals(0, service.calculateBodyInjuryIncrease(1000));
    }

    @Test
    public void calculateUninsuredUnderinsuredIncreaseTest1() {
        assertEquals(20, service.calculateUninsuredUnderinsuredIncrease(10000));
    }

    @Test
    public void calculateUninsuredUnderinsuredIncreaseTest2() {
        assertEquals(40, service.calculateUninsuredUnderinsuredIncrease(20000));
    }

    @Test
    public void calculateUninsuredUnderinsuredIncreaseTest3() {
        assertEquals(0, service.calculateUninsuredUnderinsuredIncrease(5000));
    }

    @Test
    public void calculateUninsuredUnderinsuredIncreaseTest4() {
        assertEquals(0, service.calculateUninsuredUnderinsuredIncrease(1000));
    }

    @Test
    public void calculateComprehensiveIncrease1() {
        assertEquals(10, service.calculateComprehensiveIncrease(1000));
    }

    @Test
    public void calculateComprehensiveIncrease2() {
        assertEquals(20, service.calculateComprehensiveIncrease(2000));
    }

    @Test
    public void calculateComprehensiveIncrease3() {
        assertEquals(0, service.calculateComprehensiveIncrease(500));
    }

    @Test
    public void calculateComprehensiveIncrease4() {
        assertEquals(0, service.calculateComprehensiveIncrease(100));
    }

    @Test
    public void calculatePremiumTest() {
        assertEquals(5000, service.calculatePremium(person1));
    }

    @Test
    public void calculatePremiumTest2() {
        assertEquals(4000, service.calculatePremium(person2));
    }

    @Test
    public void calculatePremiumTest3() {
        assertEquals(11040, service.calculatePremium(person3));
    }

    @Test
    public void getQuoteTest1() {
        assertEquals(5000, service.getQuote(person1).get("premium"));
    }

    @Test
    public void getQuoteTest2() {
        assertEquals(4000, service.getQuote(person2).get("premium"));
    }

    @Test
    public void getQuoteTest3() {
        assertEquals(11040, service.getQuote(person3).get("premium"));
    }
}
