package src;

import java.io.*;

public class Basket {
    private String[] products;
    private int[] prices;
    private static int[] basket = new int[3];
    private int sumProducts;

    public Basket(String[] products, int[] prices) {
        this.products = products;
        this.prices = prices;
    }

    public void addToCart(int productNum, int amount) {
        // Вычисляем сумму продуктов
        basket[productNum] += amount;

    }

    public void saveTxt(File txtFile) throws IOException {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            for (int e : basket) {
                out.print(e + " ");
            }
        }
    }

    static Basket loadFromTxtFile(File txtFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            for (int i = 0; i < parts.length; i++) {
                basket[i] = Integer.parseInt(parts[i]);
            }
        }
        return null;
    }

    public void printCart() {
        for (int i = 0; i < products.length; i++) {
            if (basket[i] > 0) {
                System.out.println(products[i] + " " + basket[i] + " по " + prices[i] + " руб\\шт" + " на сумму: " + (prices[i] * basket[i]));
                sumProducts += basket[i] * prices[i];
            }
        }

        System.out.println("Итого: " + sumProducts);
    }

}
