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


            String[] saleProducts = { // Товары по акции
                    "Сахар",
                    "Гречка",
                    "Тушенка",
            };
            int[] salePrises = {
                    80,
                    60,
                    40,
            };

            int[] saleNumb = new int[3];

            System.out.println(System.lineSeparator() + "Список товаров по акции 2 = 3: ");
            for (int j = 0; j < saleProducts.length; j++) {
                System.out.println((j + 1) + ". " + saleProducts[j] + " " + salePrises[j] + " руб.ед");
            }

            int saleOllSum = 0;
            int saleProductNum = 0;
            int saleAmount = 0;

            while (true) {
                System.out.println(System.lineSeparator() + "Выберите товар и количество или введите end");
                String inputS = scanner.nextLine();//1 2
                if (inputS.equals("end")) {
                    break;
                }
                String[] parts = input.split(" ");

                if (parts.length != 2) {
                    System.out.println("Некорректный ввод! Нужно ввести два числа!");
                    continue;
                }

                try {
                    saleProductNum = Integer.parseInt(parts[0]) - 1;
                    saleAmount = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка. Нужно вводить только числа");
                    continue;
                }

                if (saleProductNum < 0 || saleProductNum > 2) {
                    System.out.println("Ошибка.Нужно выбрать номер продукта из списка");
                    continue;
                }

                if (saleAmount == 3) {
                    saleNumb[saleProductNum] += saleAmount;
                    int sumS = (saleAmount * salePrises[saleProductNum]) - salePrises[saleProductNum];
                    saleOllSum += sum;
                } else {
                    saleNumb[saleProductNum] += saleAmount;
                    int sumS = saleAmount * salePrises[saleProductNum];
                    saleOllSum += sum;
                }
            }
            System.out.println("Ваша корзина: ");

            for (int j = 0; j < saleNumb.length; j++) {
                if (saleNumb[j] != 0) {
                    System.out.println(saleProducts[j] + " " + saleNumb[j] + " ед " +
                            salePrises[j] + " руб.ед " + (saleNumb[j] * salePrises[j]) + " в сумме без скидки");
                }
            }
            System.out.println("Итого (со скидкой): " + saleOllSum + "рублей");
        }
    }
}
