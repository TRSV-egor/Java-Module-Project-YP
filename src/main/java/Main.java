
public class Main {
    public static void main(String[] args) {
        //Создаём объект калькулятор
        Calc calc = new Calc(Input.getPersonCount());
        //Запрос у пользователя товаров
        Input.getAndAddPositions(calc);
        //Показать результат
        Output.showAndCalculate(calc);
    }
}