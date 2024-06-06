package demo.cleva.core;

import demo.cleva.core.exception.LectureCarteException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapReader
{
    private static final String MAP_PATH = "carte.txt";

    public static boolean[][] readMap() throws LectureCarteException {
        File file = new File(Objects.requireNonNull(MapReader.class.getClassLoader().getResource(MAP_PATH)).getFile());
        List<String> lines = new ArrayList<>();
        try {
            try (InputStream is = new FileInputStream(file);
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        }
        catch (IOException e) {
            throw new LectureCarteException("Impossible de lire la carte");
        }

        boolean[][] result = new boolean[lines.size()][lines.getFirst().length()];
        int xMax = lines.getFirst().length();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.length() != xMax) {
                throw new LectureCarteException("Toutes les lignes de la carte n'ont pas la même longueur");
            }
            for (int j = 0; j < line.length(); j++) {
                result[i][j] = line.charAt(j) == ' ';
            }
        }
        return result;
    }
}
