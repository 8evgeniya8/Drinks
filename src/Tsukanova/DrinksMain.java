package Tsukanova;

import java.util.Arrays;
import java.util.Scanner;

import static Tsukanova.DrinksMachine.*;

//Інструменти для використання:
//        1) enum (напої)
//        2) константи (ціни)
//        3) static (загальна вартість)
//        4) switch (вибір напою)
//        Завдання:
//        #1 зробіть enum DrinksMachine, який вміє робити КАВУ,
//        ЧАЙ, ЛИМОНАД, МОХІТО, МИНЕРАЛКУ, КОКА_КОЛУ;
//        #2 Зробіть клас Drinks, де константами задайте ціну напою;
//        #3 Зробіть підрахунок кількості виготовлених
//        напоїв та загальної суми, яку повинен заплатити клієнт;
//        #4 Зробіть спосіб приготування кожного напою;
//        #5 Зробіть switch-case оператор,
//        який буде робити напій (викликаючи відповідний метод)
//        в залежності від вибору клієнта;
//        #6 Додайте можливість вибору напою
//        для користувача і залежно від вибору робіть йому напій;
//        #7 Користувач повинен мати можливість замовити кілька напоїв
//        #8 І насамкінець клієнт має побачити, скільки грошей він повинен заплатити;
public class DrinksMain {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            for (DrinksMachine drink : DrinksMachine.values()) {
                System.out.println(drink.ordinal() + 1 + ". " + drink);
            }
            System.out.println("Завершити 0 :");

            if (sca.hasNextInt()) {
                int choice = sca.nextInt();

                if (choice == 0) {
                    break;
                }

                if (choice < 1 || choice > DrinksMachine.values().length) {
                    System.out.println("Не вірно");
                    continue;
                }

                DrinksMachine selectedDrink = DrinksMachine.values()[choice - 1];
                double price = getPrice(selectedDrink);
                Drinks.sum += price;

                makeDrink(selectedDrink);

                System.out.println("Ціна: " + price);
            } else {
                System.out.println("Вибери номер із списку");
                sca.next();
            }
            System.out.println(" ");
        }

        System.out.println("Кількість: " + Drinks.sumDrinks);
        System.out.println("Сума: " + Drinks.sum);

        sca.close();
    }

    private static double getPrice(DrinksMachine drink) {
        switch (drink) {
            case COFFEE:
                return Drinks.cofePrice;
            case TEA:
                return Drinks.teaPrice;
            case LEMONADE:
                return Drinks.lemonPrice;
            case MOJITO:
                return Drinks.mojitoPrice;
            case MINERAL:
                return Drinks.mineralPrice;
            case COCA_COLA:
                return Drinks.cocaPrice;
        }
        return 0;
    }

    private static void makeDrink(DrinksMachine drink) {
        Drinks.sumDrinks++;
        switch (drink) {
            case COFFEE:
                makeCoffee();
                break;
            case TEA:
                makeTea();
                break;
            case LEMONADE:
                makeLemonade();
                break;
            case MOJITO:
                makeMojito();
                break;
            case MINERAL:
                makeMineral();
                break;
            case COCA_COLA:
                makeCoca();
                break;
        }
    }

    private static void makeCoca() {
        System.out.println("Готується Кола");
    }

    private static void makeMineral() {
        System.out.println("Готується Вода");
    }

    private static void makeMojito() {
        System.out.println("Готується Мохіто");
    }

    private static void makeCoffee() {
        System.out.println("Готується Кава");
    }

    private static void makeTea() {
        System.out.println("Готується Чай");
    }

    private static void makeLemonade() {
        System.out.println("Готується Лимонад");
    }
}
