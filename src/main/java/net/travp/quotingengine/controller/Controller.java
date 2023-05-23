package net.travp.quotingengine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.travp.quotingengine.model.Person;
import net.travp.quotingengine.service.QuoteService;

@RestController
public class Controller {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quote")
    public Map<String, Integer> getQuote(@RequestBody Person person) {
        return quoteService.getQuote(person);
    }
}
