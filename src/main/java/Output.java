import java.util.Iterator;

public class Output {

    //Сообщает что товар добавлен
    public static void sayAddProduct(Product product, Calc calc) {

        System.out.printf("--------------------------------------\n" +
                "Товар " + product.product + " за %.2f успешно добвален\n" +
                "Итоговый чек: %.2f " + checkRUB(calc.getProductsSum()) + "\n" +
                "--------------------------------------\n",product.price, calc.getProductsSum());

    }

    //Подвести итог и посчитать результат
    public static void showAndCalculate(Calc calc){

        Iterator<Product> iterator = calc.productsAray.iterator();

        System.out.println("----------------ИТОГ----------------\nДобавленные товары: ");

        while(iterator.hasNext()){
            Product product = iterator.next();
            System.out.printf("  %s за %.2f " + checkRUB(product.price) + "\n", product.product, product.price);
        }

        System.out.printf("------------------------------------\n" +
                "  Товаров на сумму %.2f " + checkRUB(calc.getProductsSum()) + "\n" +
                "  Количество персон " + calc.person + "\n"+
                "  С 1 персоны  %.2f " + checkRUB(calc.getProductsSum()) + "\n" +
                "------------------------------------\n",calc.getProductsSum(), (calc.getProductsSum() / calc.person));

    }

    //Проверяет и возвращает какое окончание у рубля
    public static String checkRUB(double rubls){

        if ((int)rubls % 10 >= 2 && (int)rubls % 10 <= 4){
            return "рубля";
        } else if ((int)rubls % 10 == 1) {
            return "рубль";
        } else {
            return "рублей";
        }
    }
}
