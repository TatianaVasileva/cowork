import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products =// ������ ���� ������ ��������
                {"������",
                        "���",
                        "����",
                        "������",
                        "������"
                };
        int[] price = {70, 400, 40, 88, 20};//������� ������ ����
        System.out.println("������ ��������� � ��������� �������:");
        //System.out.println(new Product[]{new Product(70, "������"), new Product(400, "���"),
        //new Product(40, "����"), new Product(88, "������"), new Product(20, "������")
// ����� �������� ������������ ����������� ������� ����� ���� for
        for (int i = 0; i < products.length; i++) { // length ����� ������ ����� ������
            System.out.println((i + 1) + "." + products[i] + " " + price[i] + " ���.��");
        }
        int total = 0;
        int productNum;
        int[] yourBasket = new int[products.length];
        int amount;

        while (true) {
            System.out.println(" �������� ����� � ���������� ��� ������� end");
            String input = scanner.nextLine();//������ ��� ���� ������ ������
            if (input.equals("end")) {
                break;
            }
            try { // ���� try, ��� ����� ���������� ������
                String[] part = input.split(" ");//�����������
                if (part.length != 2) {

                    System.out.println("������������ ����! ����� ������ ��� �����");
                    continue;
                }

                productNum = Integer.parseInt(part[0]) - 1;
                if ((productNum + 1) > products.length || productNum + 1 <= 0) {
                    System.out.println("������.����� ������� ����� �������� �� ������");
                    continue;
                }
                amount = Integer.parseInt(part[1]);
                if (yourBasket[productNum] + amount < 0) { //���� ��������� ���������� ������, ��� ������ � �������
                    System.out.println("���������� ������ � ������� �� ����� ���� ������ 0");
                    continue;
                }
                if (amount == 0) {//���� ������ 0
                    total -= (yourBasket[productNum] * price[productNum]);//���� ���� ������� ����� ��������� ������ � ���
                    yourBasket[productNum] = 0;
                } else {
                    yourBasket[productNum] = yourBasket[productNum] + amount;
                    int sum = amount * price[productNum];
                    total += sum;
                }

            } catch (NumberFormatException e) { //������ � ������� �������� ���� ������
                System.out.println("������. ����� ������� ������ �����");
                continue;
            }

            System.out.println("���� �������:");
            for (int m = 0; m < products.length; m++) { //��������
                int currentPrice = yourBasket[m] * price[m];
                if (yourBasket[m] > 0) {
                    System.out.println(products[m] + " " + yourBasket[m] + " ��. " + currentPrice + " ���. � �����");
                }
            }
            System.out.println("�����: " + total + " ���");//����
        }
        }
    }