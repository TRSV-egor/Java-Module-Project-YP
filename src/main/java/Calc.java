import java.util.ArrayList;
import java.util.Iterator;

//Класс калькулятора для хранения, добавления и пересчёта товаров
public class Calc {
    int person;

    public Calc(int person) {
        this.person = person;
    }

    ArrayList<Product> productsAray = new ArrayList<>();

    //Добавляет товар в калькулятор
    public void addProduct(Product product) {

        productsAray.add(product);
        Output.sayAddProduct(product, this);

    }


    //Получить текущую сумму в калькуляторе
    public double getProductsSum() {
        Iterator<Product> iterator = productsAray.iterator();
        double sum = 0;

        while (iterator.hasNext()) {
            Product product = iterator.next();
            sum += product.price;
        }

        return sum;
    }

    //Проевряет содержится ли название в хранилище
    public boolean contains(String productName) {

        for (Product product : productsAray) {
            if (product.product.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    //Меняет цену у указанного товара
    public void changePrice(double newPrice, String productName) {

        for (Product product : productsAray) {
            if (product.product.equalsIgnoreCase(productName)) {
                product.price += newPrice;
                Output.sayAddProduct(product, this);
            }

        }
    }
}
