package by.lina;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    static int[] gameField = {0,0,0,
            0,0,0,
            0,0,0};

    public static void main(String[] args) {

        boolean b;
        boolean X = false;
        do {
            X = !X;
            gameFieldDrawing();
            if (X = X) {
                System.out.println("Введите номер ячейки для X:");
            } else {
                System.out.println("Введите номер ячейки для O:");
            }
            int n = getNumber();
            if (X = X){
                gameField[n] = 1;
            } else {
                gameField[n] = 2;
            }
            b = !isGameOver(n);
            if (Draw()) {
                System.out.println("Победила дружба!");
                return;
            }
        } while (b);
        gameFieldDrawing();
        System.out.println();

        if (X = X) {
            System.out.println("Победитель X!");
        } else {
            System.out.println("Победитель О!");
        }
    }


    static int getNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < gameField.length && gameField[n] == 0) {
                    return n;
                }
                System.out.println("Выберите свободну ячейку и впишите значение");
            }
            //обработка ошибок
            catch (NumberFormatException e) {
                System.out.println("Пожалуйста, впишите верное значение");
            } catch (IOException e) {
            }
        }
    }


    static boolean isGameOver(int n) {

        int row = n - n % 3; //совпадение по горизонтали
        if (gameField[row] == gameField[row + 1] &&
                gameField[row] == gameField[row + 2])
            return true; //номер строки
        int column = n % 3; //совпадение по вертикали

        if (gameField[column] == gameField[column + 3])
            if (gameField[column] == gameField[column + 6])
                return true; //номер столбца

        if (n % 2 != 0)
            return false; //n - на одной из граней

//левая диагональ
        if (n % 4 == 0) {
            if (gameField[0] == gameField[4] &&
                    gameField[0] == gameField[8]) return true;
            if (n != 4) return false;
        }
        return gameField[2] == gameField[4] &&
                gameField[2] == gameField[6];
    } //совпадения на левой диагонали

    static void gameFieldDrawing() {
        System.out.println("     |     |     ");
        for (int i = 0; i < gameField.length; i++) {
            if (i != 0) {
                if (i % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else
                    System.out.print("|");
            }

            if (gameField[i] == 0) {
                System.out.print("  " + i + "  ");
            }
            if (gameField[i] == 1) {
                System.out.print("  X  ");
            }
            if (gameField[i] == 2) {
                System.out.print("  O  ");
            }
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

    public static boolean Draw() {
        //для каждого цикла
        for (int n : gameField)
            if (n == 0) {
                return false;
            }
        return true;
    }
}
