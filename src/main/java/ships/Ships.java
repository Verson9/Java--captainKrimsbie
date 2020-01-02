package ships;

import java.util.Scanner;

public enum Ships {

    UNI1("UNI1",1),
    UNI2("UNI2", 1),
    UNI3("UNI3", 1),
    UNI4("UNI4", 1),
    UNI5("UNI5", 1),

    DUO1("DUO1", 2),
    DUO2("DUO2", 2),
    DUO3("DUO3", 2),
    DUO4("DUO4", 2),

    TRI1("TRI1", 3),
    TRI2("TRI2", 3),
    TRI3("TRI3", 3),

    QUAD1("QUAD1", 4),
    QUAD2("QUAD2", 4),

    PENTA("PENTA", 5);

    private final int length;
    private final String name;
    private boolean[][] position = new boolean[10][10];
    private boolean positionType;   // true -> poziom, false -> pion


    Ships(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void setPositionType(boolean positionType) {
        this.positionType = positionType;
    }

    public void setPosition(int x, int y) {
        for (int i = 0; i < length; i++) {
            position[x][y] = true;
            if (positionType) {
                x++;
            } else {
                y++;
            }
        }
    }

    void clearPosition(){
        for (boolean[] y:position) {
            for (boolean x:y) {
                x = false;
            }
        }
    }

    public boolean[][] getPosition() {
        return position;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }
}
