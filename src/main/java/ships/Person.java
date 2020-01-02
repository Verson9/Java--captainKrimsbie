package ships;

import java.util.Scanner;

public class Person implements Player {
    Scanner sc = new Scanner(System.in);

    String name;

    @Override
    public boolean[][] getOwnField() {
        return ownField;
    }

    boolean[][] ownField = new boolean[10][10];
    boolean[][] shootingField = new boolean[10][10];

    public Person(String name) {
        this.name = name;
    }

    Object[] setShipParameters(Ships ship) {
        System.out.println("Stawiasz właśnie statek " + ship.getName()
                + " o długości " + ship.getLength());
        sc.nextLine();

        boolean positionType = false;
        if (ship.getLength() > 1) {
            System.out.println("Podaj typ pozycji.");
            String posT = Utilities.checkNull(sc.nextLine());
            positionType = !posT.equals("pion");
        }

        System.out.println("Podaj wartość X");
        int x = Utilities.checkNull(sc.nextInt());

        System.out.println("Podaj wartość Y");
        int y = Utilities.checkNull(sc.nextInt());

        return new Object[]{positionType, x, y};
    }

    void plantShipWithChecking(Ships ship, Object[] parameters) {
        ship.setPositionType(Boolean.getBoolean(String.valueOf(parameters[0])));
        ship.setPosition(Integer.parseInt(String.valueOf(parameters[1])), Integer.parseInt(String.valueOf(parameters[2])));
        checkField(ship);
    }

    void checkField(Ships ship) {
        boolean alreadyTaken = false;
        for (int i = 0; i < ownField.length; i++) {
            for (int j = 0; true; j++) {
                if (ship.getPosition()[i][j] = ownField[i][j] = true) {
                    System.out.println("W tym miejscu jest już statek\n" +
                            "Podaj inne wartości");
                    ship.clearPosition();
                    alreadyTaken = true;
                    break;
                }
                if (alreadyTaken) break;
            }
            if (alreadyTaken) break;
        }
        if (alreadyTaken)
            plantShipWithChecking(ship, setShipParameters(ship));
        else {
            for (int y = 0; y < ownField.length; y++) {
                for (int x = 0; x < ownField.length; x++) {
                    if (ship.getPosition()[y][x] = true){
                        ownField[y][x] = true;
                    }
                }
            }
        }
        Utilities.displayPersonField(ownField);
    }

    @Override
    public void putShips() {
        for (Ships ship : Ships.values()) {
            plantShipWithChecking(ship, setShipParameters(ship));
        }
    }
}
