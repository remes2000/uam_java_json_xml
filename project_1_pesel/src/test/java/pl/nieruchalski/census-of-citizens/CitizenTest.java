package test;

import org.junit.jupiter.api.Test;
import pl.nieruchalski.Citizen;
import pl.nieruchalski.InvalidPeselException;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {
    @Test
    public void invalidPeselThrowsException() {
        assertThrows(InvalidPeselException.class, () -> {
            new Citizen("Test", "Test", "City", "002818885588");
        });
    }

    @Test
    public void setNameTest() {
        Citizen citizen = new Citizen("Name", "Lastname", "City", "55030101193");
        assertEquals(citizen.getName(), "Name");
    }

    @Test
    public void setLastNameTest() {
        Citizen citizen = new Citizen("Name", "Lastname", "City", "55030101193");
        assertEquals(citizen.getLastName(), "Lastname");
    }

    @Test
    public void setCityTest() {
        Citizen citizen = new Citizen("Name", "Lastname", "City", "55030101193");
        assertEquals(citizen.getCity(), "City");
    }

    @Test
    public void setValidPeselTest() {
        Citizen citizen = new Citizen("Name", "Lastname", "City", "55030101193");
        assertEquals(citizen.getPeselNumber(), "55030101193");
    }
}