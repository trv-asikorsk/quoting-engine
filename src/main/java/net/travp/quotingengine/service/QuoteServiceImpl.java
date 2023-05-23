package net.travp.quotingengine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.travp.quotingengine.model.Person;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Override
    public Map<String, Integer> getQuote(Person person) {
        return new HashMap<String, Integer>() {
            {
                put("premium", 100);
            }
        };
    }

}
