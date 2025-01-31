package maze;

import java.util.Scanner;

import static maze.Game.startGame;

public class Menu {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        prizivMenu();
    }

    public static void prizivMenu() {
        System.out.println("====== ИГРОВОЕ МЕНЮ ======");
        System.out.println("     Добро пожаловать ");
        System.out.println("1: Начать игру");
        System.out.println("2: Правила игры");
        System.out.println("3: О создателе");
        System.out.println("4: Выход");
        String command = scan.nextLine();
        switch (command) {
            case "1":
                startGame();
                break;
            case "2":
                openRules();
                break;
            case "3":
                showCredits();
                break;
            case "4":
                break;
            default:
                System.out.println("Такой команды не существует\n ");
                prizivMenu();
                break;
        }

    }

    private static void showCredits() {
        System.out.println("@zlodey_britanetc - руководитель, администратор, менеджер, сценарист, креативный вдохновитель проекта,\nаналитик, дизайнер, генератор идей, исследователь, разработчик, реализатор и просто хороший человек ;)");
        System.out.println();
        prizivMenu();

    }

    private static void openRules() {
        System.out.println("Правила игры: для каждого хода нужно ввести с клавиатуры буквы s (вниз), w (вверх), a (влево) или d (вправо)." +
                "\nСимволом <<.>> обозначается проход, <<#>> - стена, знак <<&>> показывает текущее положение игрока.\n");
        prizivMenu();

    }


}