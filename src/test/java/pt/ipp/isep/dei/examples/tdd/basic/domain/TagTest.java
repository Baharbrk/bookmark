package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TagTest {
    @Test
    public void TestAddNewTagName() {
        // Act
        Tag tag = new Tag("Google");
        // Assert
        assertEquals("Google", tag.name);
    }
}
