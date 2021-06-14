package org.example.view;

import org.example.controller.SellerController;
import org.example.entity.Seller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SellerView {
    private SellerController sellerController = new SellerController();

    public void showClients() throws SQLException {
        List<Seller> sellers = sellerController.getAllSellers();
        System.out.println("Список продавцов: ");
        sellers.forEach(seller -> System.out.println(seller.toString()));
    }

    public void createSeller() {
        try {
            Seller newSeller = new Seller();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newSeller.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newSeller.setLastname(lastname);

            System.out.println("Введите вид товаров: ");
            String sp = scanner.nextLine();
            newSeller.setSpeciality(sp);

            sellerController.saveSeller(newSeller);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteSeller() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id продавца, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        sellerController.deleteSeller(id);
    }
    public void updateSeller() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id продавца, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Seller newSeller;
            newSeller = sellerController.getSellerById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newSeller.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newSeller.setLastname(lastname);

            System.out.println("Введите вид товаров: ");
            String sp = scanner.nextLine();
            newSeller.setSpeciality(sp);

            sellerController.editSeller(newSeller);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdSeller() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id продавца, которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (sellerController.getSellerById(id) != null) {
                System.out.println(sellerController.getSellerById(id).toString());
            } else {
                System.out.println("Такого продавца не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdSeller();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех продавцов");
            System.out.println(" 2. Добавить нового продавца");
            System.out.println(" 3. Удалить продавца");
            System.out.println(" 4. Обновить информацию о продавце");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showClients();
                    break;
                case 2:
                    createSeller();
                    break;
                case 3:
                    deleteSeller();
                    break;
                case 4:
                    updateSeller();
                    break;
                case 5:
                    getByIdSeller();
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
