package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlTest {

    @Test
    public void testValidatedUrlWithInvalidUrl() {
        Url invalidUrl = new Url();
        invalidUrl.setUrl("httjhgoogle.com/");
        boolean result = false;

        // Act
        boolean validatedUrl = invalidUrl.validateUrl();
        // Assert
        assertEquals(result, validatedUrl);
    }

    @Test
    public void testAddUrl() {
        Url url = new Url();
        url.setUrl("https://www.google.com/");
        url.addUrl();
        boolean result = true;

        boolean addedUrl = url.addUrl();
        assertEquals(result, addedUrl);
    }


    @Test
    public void testValidateUrlWithValidUrl() {
        // Arrange
        Url validUrl = new Url();
        validUrl.setUrl("https://www.google.com/");
        boolean result = true;

        // Act
        boolean validatedUrl = validUrl.validateUrl();

        // Assert
        assertEquals(result, validatedUrl);
    }

    @Test
    public void testIsUrlSecureWithSecureUrl() {
        // Arrange
        Url secureUrl = new Url("https://www.google.com/");
        boolean result = true;

        // Act
        boolean validatedUrl = secureUrl.isUrlSecure();

        // Assert
        assertEquals(result, validatedUrl);
    }

    @Test
    public void testIsUrlSecureWithInsecureUrl() {
        // Arrange
        Url InsecureUrl = new Url("http://www.google.com/");
        boolean result = false;

        // Act
        boolean validatedUrl = inSecureUrl.isUrlSecure();

        // Assert
        assertEquals(result, validatedUrl);
    }
}



