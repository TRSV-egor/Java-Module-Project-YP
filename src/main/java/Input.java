import java.util.Scanner;

public class Input {

    //Запросить у пользователя количество человек, возвращает количество
    public static int getPersonCount(){

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("На скольких человек необходимо разделить счёт?");

            if (!scanner.hasNextInt()){
                scanner.nextLine();
                System.out.println("Необходимо ввести количество цифрами");
            } else {
                int personCount = scanner.nextInt();
                if (personCount > 1) {
                    System.out.println("Счёт будет разделён на " + personCount + " персон");
                    return personCount;
                } else if (personCount == 1){
                    System.out.println("Вы один? Тогда нет смысла ничего считать и делить :)");
                } else {
                    System.out.println("Меньше одного - это некорректное значение для подсчёта.");
                }
            }
        }

    }

    //Запрос товаров у пользователя и добавление их в калькулятор
public static void getAndAddPositions(Calc calc){

    Scanner scanner = new Scanner(System.in);

    String productName;
    double price;

    do {

        System.out.println("Введите наименование товара");

            productName = scanner.nextLine();

        System.out.println("и его цену, в формате 'рубли.копейки', например 10.45 или 11.40.");

        if (scanner.hasNextDouble()){
            price = scanner.nextDouble();

            if (price < 0){
                System.out.println("Ошибка! Цена меньше нуля.");
                continue;
            }

        } else {
            System.out.println("Вы ввели цену неверно!");
            scanner.nextLine();
            continue;
        }

        scanner.nextLine();

        if (calc.contains(productName)){
            calc.changePrice(price, productName);
        } else {
            Product product = new Product(productName, price);
            calc.addProduct(product);
        }

        System.out.println("Хотите добавить ещё один товар? Введите любой символ\nи нажмите Enter.\nА для завершения ввода товаров введите 'Завершить'");

        if (scanner.next().equalsIgnoreCase("Завершить")){
            break;
        }

        scanner.nextLine();

    } while (true);

}

}
