package maze;
import java.util.Random;

public class MazeGenerator {
    public static Random random = new Random();

    public static char[][] generateMaze(int rows, int columns) {
        char[][] maze = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze[i][j] = '#';
            }
        }

        generatePath(1, 1, maze);
        return maze;
    }

    private static void generatePath(int x, int y, char[][] maze) {
        int[] directions = {0, 1, 2, 3};
        shuffleDirections(directions);

        for (int i = 0; i < directions.length; i++) {
            int newX = x;
            int newY = y;

            switch (directions[i]) {
                case 0: newY -= 2; break;
                case 1: newX += 2; break;
                case 2: newY += 2; break;
                case 3: newX -= 2; break;
            }

            if (limitMaze(newX, newY, maze) && maze[newY][newX] == '#') {
                maze[y + (newY - y) / 2][x + (newX - x) / 2] = '.';
                maze[newY][newX] = '.';
                generatePath(newX, newY, maze);
            }
        }
    }

    private static boolean limitMaze(int x, int y, char[][] maze) {
        return x > 0 && x < maze[0].length && y > 0 && y < maze.length;
    }

    private static void shuffleDirections(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    public static int[] findStart(char[][] maze) {
        int[] startPoint = {0, 0};
        while (startPoint[1] == 0) {
            int ind = random.nextInt(maze[0].length - 2) + 1;
            if (maze[1][ind] == '.') {
                startPoint[1] = ind;
                maze[0][ind] = '.';
            }
        }
        return startPoint;
    }

    public static int[] findExit(char[][] maze) {
        int[] exitPoint = {maze.length - 1, 0};
        while (exitPoint[1] == 0) {
            int ind = random.nextInt(maze[0].length - 2) + 1;
            if (maze[maze.length - 2][ind] == '.') {
                exitPoint[1] = ind;
                maze[maze.length - 1][ind] = '.';
            }
        }
        return exitPoint;
    }

}
