package demo.cleva.core;

import demo.cleva.core.exception.AventureException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AventureTest {

    @Test
    void testAventurierConsturition() throws IOException {
        Aventure uneAventure = new Aventure(3,0);
        assertNotNull(uneAventure);
    }

    @Test
    void whenAventurierHorsCarte_thenThrowsIllegalState() {
        assertThrows(AventureException.class, () -> new Aventure(50,0));
    }

    @Test
    void whenAventurierObstacle_thenThrowsIllegalState() {
        assertThrows(AventureException.class, () -> new Aventure(0,0));
    }

    @Test
    void whenAventurierDirectionUnrecognised_thenThrowsIllegalState() throws IOException {
        Aventure uneAventure = new Aventure(3,0);
        assertThrows(AventureException.class, () -> uneAventure.deplacerAventurier('I'));
    }

    @Test
    void whenAventurierDirectionRecognised_thenDoesNotThrowsIllegalState() throws IOException {
        Aventure uneAventure = new Aventure(3,0);
        assertDoesNotThrow(() -> uneAventure.deplacerAventurier('N'));
        assertDoesNotThrow(() -> uneAventure.deplacerAventurier('S'));
        assertDoesNotThrow(() -> uneAventure.deplacerAventurier('E'));
        assertDoesNotThrow(() -> uneAventure.deplacerAventurier('O'));
    }

    @Test
    void testCleva1() throws IOException {
        Aventure uneAventure = new Aventure(3,0);
        uneAventure.deplacerAventurier("SSSSEEEEEENN");
        uneAventure.getAventurier().printPosition();
        assertEquals(uneAventure.getPositionX(), 9);
        assertEquals(uneAventure.getPositionY(), 2);
    }

    @Test
    void testCleva2() throws IOException {
        Aventure uneAventure = new Aventure(6, 9);
        uneAventure.deplacerAventurier("OONOOOSSO");
        uneAventure.getAventurier().printPosition();
        assertEquals(uneAventure.getPositionX(), 7);
        assertEquals(uneAventure.getPositionY(), 5);
    }
}