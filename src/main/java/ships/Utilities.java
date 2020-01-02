package ships;

import java.util.Scanner;

public class Utilities {
    static void checkIfTheChoiceIsQuit(String answer){
        if (answer.equals("quit")) {
            System.out.println("Żegnam!");
            System.exit(0);
        }
    }

    static String checkNull(String answer){
        Scanner sc= new Scanner(System.in);
        if(answer == null){
            System.out.println("Źle wprowadzone dane.");
            answer = sc.nextLine();
            return checkNull(answer);
        }
        return answer;
    }

    static Integer checkNull(Integer answer){
        Scanner sc= new Scanner(System.in);
        if(answer == null){
            System.out.println("Źle wprowadzone dane.");
            answer = sc.nextInt();
            return checkNull(answer);
        }
        return answer;
    }

    static void displayPersonField(boolean[][] field){
        for (boolean[] k : field) {
            for (boolean l : k) {
                if (l) {
                    System.out.print("[X]  ");
                } else {
                    System.out.print("[ ]  ");
                }
            }
            System.out.println();
        }
    }
}
