package net.travp.quotingengine.service;

import java.util.Map;

import net.travp.quotingengine.model.Person;

public interface QuoteService {

    public abstract Map<String, Integer> getQuote(Person person);
}
