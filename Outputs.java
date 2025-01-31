package maze;

import java.util.Scanner;

public class Outputs {
    static Scanner scan = new Scanner(System.in);

    public static void printMaze(char[][] maze, int[] currentPosition) {
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                if (i == currentPosition[0] && j == currentPosition[1]) {
                    System.out.print("& ");
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void deleteMaze() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void printNextLevel() {
        System.out.println("1: Следующий уровень");
        System.out.println("2: Выход");
        String command = scan.nextLine();
        if (command.equals("1")) {
            Game.startGame();
        } else if (command.equals("2")) {
            Game.countLevels = 0;
            Menu.prizivMenu();
        } else {
            System.out.println("Такой команды не существует");
            printNextLevel();
        }

    }

}

