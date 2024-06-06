package demo.cleva.core;

import demo.cleva.core.exception.AventureException;
import demo.cleva.core.exception.LectureCarteException;

import java.io.IOException;

public class Aventure {

    private final Aventurier aventurier;
    private final boolean[][] carte;

    public Aventure() throws IOException {
        this.carte = MapReader.readMap();
        if (carte.length < 1 || carte[0].length < 1) {
            throw new LectureCarteException("La carte est vide");
        }
        this.aventurier = new Aventurier();
    }

    public Aventure(int x, int y) throws IOException {
        this.carte = MapReader.readMap();
        if (carte.length < 1 || carte[0].length < 1) {
            throw new LectureCarteException("La carte est vide");
        }
        this.aventurier = new Aventurier();
        this.setPositionAventurier(x, y);
    }

    public void setPositionAventurier(int x, int y) {
        if (x < 0 || x >= this.carte[0].length || y < 0 || y >= this.carte.length) {
            throw new AventureException(String.format("la position (%d, %d) est en dehors de la carte", x, y));
        }
        if (!this.carte[y][x]) {
            throw new AventureException(String.format("la position (%d, %d) n'est pas accessible sur la carte", x, y));
        }
        this.aventurier.x = x;
        this.aventurier.y = y;
    }

    public void deplacerAventurier(char direction) {
        switch (direction) {
            case 'N':
                if (this.aventurier.y > 0 && carte[this.aventurier.y - 1][this.aventurier.x]) {
                    this.aventurier.y--;
                }
                break;
            case 'S':
                if (this.aventurier.y <= carte.length - 2 && carte[this.aventurier.y + 1][this.aventurier.x]) {
                    this.aventurier.y++;
                }
                break;
            case 'E':
                if (this.aventurier.x <= carte[this.aventurier.y].length - 2 && carte[this.aventurier.y][this.aventurier.x + 1]) {
                    this.aventurier.x++;
                }
                break;
            case 'O':
                if (this.aventurier.x > 0 && carte[this.aventurier.y][this.aventurier.x - 1]) {
                    this.aventurier.x--;
                }
                break;
            default:
                throw new AventureException("Direction non reconnue");
        }
    }

    public void deplacerAventurier(String directions) {
        for (char c : directions.toCharArray()) {
            deplacerAventurier(c);
        }
    }

    public String printCarte() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < this.carte.length; y++) {
            for (int x = 0; x < this.carte[y].length; x++) {
                if (x == this.aventurier.x && y == this.aventurier.y) {
                    result.append('O');
                }
                else if (this.carte[y][x]) {
                    result.append(' ');
                }
                else {
                    result.append('#');
                }
            }
            result.append('\n');
        }
        return result.toString();
    }

    public Aventurier getAventurier() {
        return aventurier;
    }

    public int getPositionX() {
        return this.aventurier.x;
    }

    public int getPositionY() {
        return this.aventurier.y;
    }
}
