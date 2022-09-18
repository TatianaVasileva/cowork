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
        System.out.println("Список продуктов и стоимости единицы:");
        //System.out.println(new Product[]{new Product(70, "Молоко"), new Product(400, "Сыр"),
        //new Product(40, "Хлеб"), new Product(88, "Йогурт"), new Product(20, "Свекла")
// чтобы избежать бесконечного копирования пробуем через цикл for
        for (int i = 0; i < products.length; i++) { // length чтобы узнать какой размер
            System.out.println((i + 1) + "." + products[i] + " " + price[i] + " руб.ед");
        }
        int total = 0;
        int productNum;
        int[] yourBasket = new int[products.length];
        int amount;

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
                if (yourBasket[productNum] + amount < 0) { //если введенное количество меньше, чем товара в корзине
                    System.out.println("Количество товара в корзине не может быть меньше 0");
                    continue;
                }
                if (amount == 0) {//если введен 0
                    total -= (yourBasket[productNum] * price[productNum]);//цена всей корзины минус стоимость товара в ней
                    yourBasket[productNum] = 0;
                } else {
                    yourBasket[productNum] = yourBasket[productNum] + amount;
                    int sum = amount * price[productNum];
                    total += sum;
                }

            } catch (NumberFormatException e) { //ячейка в которую положить если ошибка
                System.out.println("Ошибка. Нужно вводить только числа");
                continue;
            }

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