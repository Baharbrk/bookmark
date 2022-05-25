package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlTest {

    @Test
    public void testValidatedUrlWithInvalidUrl() {
        Url invalidUrl = new Url("httjhgoogle.com/");
        boolean result = false;

        // Act
        boolean validatedUrl = invalidUrl.validateUrl();
        // Assert
        assertEquals(result, validatedUrl);
    }

    @Test
    public void testValidateUrlWithValidUrl() {
        // Arrange
        Url validUrl = new Url("https://www.google.com/");
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
        Url inSecureUrl = new Url("http://www.google.com/");
        boolean result = false;

        // Act
        boolean validatedUrl = inSecureUrl.isUrlSecure();

        // Assert
        assertEquals(result, validatedUrl);
    }

    @Test
    public void testTagUrl() {
        // Arrange
        Url url = new Url("https://www.google.com/");
        Tag tag = new Tag("Google");
        url.tagUrl(tag);

        // Assert
        assertTrue(url.tags.contains(tag));
    }
}



