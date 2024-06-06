package demo.cleva.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MapReaderTest {

    @Test
    void readMap() throws IOException {
        boolean[][] gameMap = MapReader.readMap();
        assertNotNull(gameMap);
    }
}