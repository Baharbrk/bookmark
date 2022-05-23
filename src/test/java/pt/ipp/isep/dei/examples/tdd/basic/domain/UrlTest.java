package pt.ipp.isep.dei.examples.tdd.basic.domain;

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

    public void testIsUrlSecureWithSecureUrl() {
        // Arrange
        Url secureUrl = new Url();
        secureUrl.setUrl("https://www.google.com/");
        boolean result = true;

        // Act
        boolean validatedUrl = secureUrl.isUrlSecure();

        // Assert
        assertEquals(result, validatedUrl);
    }

    public void testIsUrlSecureWithInsecureUrl() {
        // Arrange
        Url inSecureUrl = new Url();
        inSecureUrl.setUrl("http://www.google.com/");
        boolean result = false;

        // Act
        boolean validatedUrl = inSecureUrl.isUrlSecure();

        // Assert
        assertEquals(result, validatedUrl);
    }
}



