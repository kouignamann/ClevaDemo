package demo.cleva.core;

public class Aventurier {
    protected int x;
    protected int y;

    public Aventurier() {
    }

    public Aventurier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String printPosition() {
        String result = String.format("Le personnage se trouve en (%d,%d)%n", x, y);
        System.out.printf(result);
        return result;
    }
}
