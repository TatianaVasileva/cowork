import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products =// массив типа стринг названия
                {"Молоко",
                        "Сыр",
                        "Хлеб",
                        "Йогурт",
                        "Свекла"
                };
        int[] price = {70, 400, 40, 88, 20};//интовый массив цена
        int[] numer = new int[5];//размер массива
        System.out.println("Список продуктов и стоимости единицы:");
        //System.out.println(new Product[]{new Product(70, "Молоко"), new Product(400, "Сыр"),
        //new Product(40, "Хлеб"), new Product(88, "Йогурт"), new Product(20, "Свекла")
// чтобы избежать бесконечного копирования пробуем через цикл for
        for (int i = 0; i < products.length; i++) { // length чтобы узнать какой размер
            System.out.println((i + 1) + "." + products[i] + " " + price[i] + " руб.ед");
        }
        int total = 0;
        int productNum = 0;
        int[] yourBasket = new int[products.length];
        int amount = 0;

        while (true) {
            System.out.println(" Выберите товар и количество или введите end");
            String input = scanner.nextLine();//Молоко сыр хлеб йогурт свекла
            if (input.equals("end")) {
                break;
            }
            try { // блок try, где может возникнуть ошибка
                String[] part = input.split(" ");//разделитель
                if (part.length != 2) {

                    System.out.println("Некорректный ввод! Нужно ввести два числа");
                    continue;
                }

                productNum = Integer.parseInt(part[0]) - 1;
                if ((productNum + 1) > products.length || productNum + 1 <= 0) {
                    System.out.println("Ошибка.Нужно выбрать номер продукта из списка");
                    continue;
                }
                amount = Integer.parseInt(part[1]);
                if (amount <= 0) {
                    System.out.println("Ошибка.Количество не может быть меньше 0");

                    continue;
                }

            } catch (NumberFormatException e) { //ячейка в которую положить если ошибка
                System.out.println("Ошибка. Нужно вводить только числа");
                continue;
            }

            numer[productNum] += amount;//присвоить

            int sum = amount * price[productNum];//подсчитать

            yourBasket[productNum] = yourBasket[productNum] + amount;//корзина
            total += sum;//вывод итога

            System.out.println("Ваша корзина:");
            for (int m = 0; m < products.length; m++) { //скложить
                int currentPrice = yourBasket[m] * price[m];
                if (yourBasket[m] > 0) {
                    System.out.println(products[m] + " " + yourBasket[m] + " ед. " + currentPrice + " руб. в сумме");
                }
            }
            System.out.println("Итого: " + total + " руб");//итог
        }
    }
}