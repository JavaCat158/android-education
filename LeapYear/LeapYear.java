import java.util.Scanner;

/*
Программа  игра угадай сколько дней в году которая проверяет
правильно ли пользователь указал количество дней в году и 
сколько раз указал правильное количество
fields:
Scanner scanner поле которое считывает введеные данные;
int count счетчик правильных ответов;
int day количество дней в году;
int myChoiceDay количество дней указанное пользователем
 */

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0; // счетчик правильных ответов

        // цикл 
        while (true) {
            System.out.println("Введите год: ");
            int year = scanner.nextInt();
            int day;

            System.out.println("Введите количество дней: ");
            int myChoiceDay = scanner.nextInt();

            if (year % 400 == 0) { // год является високосным
                day = 366;
            }
            if (year % 100 == 0) { // год не является високосным
                day = 365;
            }
            if (year % 4 == 0) {     // год является високосным
                day = 366;
            } else {
                day = 365;              // остальные случаи
            }

            // условие при правильном ответе счетчик повышается
            if (day == myChoiceDay) {
                count++;
            } else {
                System.out.println("Не правильно! В этом году " + day);
                System.out.println("Набрано очков: " + count);
                break;
            }
        }
    }
}