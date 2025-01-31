package maze;
import java.util.*;

public class Game {
    static int countLevels = 0;
    static Scanner scan = new Scanner(System.in);

    public static void startGame() {
        int rows = 15;
        int columns = 15;
        char[][] maze = MazeGenerator.generateMaze(rows, columns);
        int[] currentPosition = MazeGenerator.findStart(maze);
        int[] finalPosition = MazeGenerator.findExit(maze);
        boolean flag = false;
        Outputs.printMaze(maze, currentPosition);

        while (currentPosition[0] != finalPosition[0] || currentPosition[1] != finalPosition[1]) {

            System.out.println("Сделайте ход:");
            String step = scan.next().toLowerCase();

            if (step.equals("s")) {
                if (maze[currentPosition[0] + 1][currentPosition[1]] == '#') {
                    flag = true;
                } else if (maze[currentPosition[0] + 1][currentPosition[1]] == '.') {
                    currentPosition[0] += 1;
                }
            } else if (step.equals("w")) {
                if (currentPosition[0] == 0 || maze[currentPosition[0] - 1][currentPosition[1]] == '#') {
                    flag = true;
                } else if (maze[currentPosition[0] - 1][currentPosition[1]] == '.') {
                    currentPosition[0] -= 1;
                }
            } else if (step.equals("a")) {
                if (maze[currentPosition[0]][currentPosition[1]-1] == '#') {
                    flag = true;
                } else if (maze[currentPosition[0]][currentPosition[1] - 1] == '.') {
                    currentPosition[1] -= 1;
                }
            } else if (step.equals("d")) {
                if (maze[currentPosition[0]][currentPosition[1]+1] == '#') {
                    flag = true;
                } else if (maze[currentPosition[0]][currentPosition[1] + 1] == '.') {
                    currentPosition[1] += 1;
                }
            }
            Outputs.deleteMaze();
            if(flag) {
                System.out.println("Не ходи туда");
                flag = false;
            }
            Outputs.printMaze(maze, currentPosition);
        }
        Outputs.deleteMaze();
        countLevels++;
        System.out.println("Поздравляю! Вы достигли финиша\nКоличество пройденных уровней: " + countLevels);
        Outputs.printNextLevel();


    }
}