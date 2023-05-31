package net.travp.quotingengine.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.travp.quotingengine.model.Person;
import net.travp.quotingengine.service.QuoteService;

@ExtendWith(MockitoExtension.class)
public class ControllerTests {

    @InjectMocks
    Controller controller;

    @Mock
    QuoteService quoteService;

    @Test
    public void testGetQuote() {
        var request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var expected = Map.of("premium", 1000);
        when(quoteService.getQuote(any(Person.class))).thenReturn(expected);

        var person = new Person();
        var response = controller.getQuote(person);

        assertEquals(expected, response);
    }
}
