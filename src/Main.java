package src;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int productNum = 0;
        int amount = 0;
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        System.out.println("Список товаров для покупки:");
        Basket basket = new Basket (products,prices);
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб\\шт");
        }
        File txtFile = new File("basket.txt");
        if (txtFile.exists()){
            Basket.loadFromTxtFile(txtFile);

        } else {
            txtFile.createNewFile();
        }

        while (true) {
            System.out.println("Выберите номер товара и количество или введите end");
            String inputString = scan.nextLine();
            if (inputString.equals("end")) {
                System.out.println("Ваша корзина:");
                basket.printCart();
                break;
            } else {

                String[] parts = inputString.split(" ");
                productNum = Integer.parseInt(parts[0]) - 1; // Номер продукта
                amount = Integer.parseInt(parts[1]); // Количество продукта
                basket.addToCart(productNum,amount);
                basket.saveTxt(txtFile);
            }
        }
    }
}
