package org.example.view;

import org.example.controller.ProductController;
import org.example.entity.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductController productController = new ProductController();

    public void showProducts() throws SQLException {
        List<Product> products = productController.getAllProducts();
        System.out.println("Список товаров : ");
        products.forEach(product -> System.out.println(product.toString()));
    }

    public void createProducts() {
        try {
            Product newProduct = new Product();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер товара: ");
            Integer number = scanner.nextInt();
            newProduct.setNumber(number);

            System.out.println("Введите кол-во товаров: ");
            Integer amount = scanner.nextInt();
            newProduct.setNumber(amount);
            productController.saveProduct(newProduct);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteProduct() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id товара, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        productController.deleteProduct(id);
    }
    public void updateProduct() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id товара, который хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Product newProduct;
            newProduct = productController.getProductById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер товара: ");
            Integer number = scanner.nextInt();
            newProduct.setNumber(number);

            System.out.println("Введите кол-во товаров: ");
            Integer amount = scanner.nextInt();
            newProduct.setNumber(amount);

            productController.editProduct(newProduct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdProduct() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id товара, который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (productController.getProductById(id) != null) {
                System.out.println(productController.getProductById(id).toString());
            } else {
                System.out.println("Такого товара не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdProduct();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все товары");
            System.out.println(" 2. Добавить новый товар");
            System.out.println(" 3. Удалить товар");
            System.out.println(" 4. Обновить информацию о товаре");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    createProducts();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    getByIdProduct();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
}
