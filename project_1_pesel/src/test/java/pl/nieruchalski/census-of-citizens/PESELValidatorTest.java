package test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import pl.nieruchalski.PESELValidator;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class PESELValidatorTest {

    PESELValidator peselValidator;

    @BeforeAll
    public void setup() {
        peselValidator = new PESELValidator();
    }

    @Test
    public void tooShortTest() {
       assertEquals(false, this.peselValidator.isValid("123"));
    }

    @Test
    public void tooLongTest() {
        assertEquals(false, this.peselValidator.isValid("111111111111"));
    }

    @Test
    public void invalidCharactersTest() {
        assertEquals(false, this.peselValidator.isValid("1111111111W"));
    }

    @Test
    public void validPeselMEqualZero() {
        assertEquals(true, this.peselValidator.isValid("55030101230"));
    }

    @Test
    public void validPeselMNotEqualToZero() {
        assertEquals(true, this.peselValidator.isValid("55030101193"));
    }

    @Test
    public void invalidPeselMEqualZero() {
        assertEquals(false, this.peselValidator.isValid("55030101235"));
    }

    @Test
    public void invalidPeselMNotEqualZero() {
        assertEquals(false, this.peselValidator.isValid("55030101192"));
    }
}