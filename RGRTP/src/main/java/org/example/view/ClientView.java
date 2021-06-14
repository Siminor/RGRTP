package org.example.view;

import org.example.controller.ClientController;
import org.example.entity.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    private ClientController clientController = new ClientController();

    public void showClients() throws SQLException {
        List<Client> clients = clientController.getAllClients();
        System.out.println("Список клиентов: ");
        clients.forEach(client -> System.out.println(client.toString()));
    }

    public void createClient() {
        try {
            Client newClient = new Client();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newClient.setName(name);

            System.out.println("Введите фамилию: ");
            String surname = scanner.nextLine();
            newClient.setSurname(surname);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newClient.setTelephone(tel);

            System.out.println("Введите паспорт: ");
            String passport = scanner.nextLine();
            newClient.setPassport(passport);
            clientController.saveClient(newClient);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteClient() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id клиента, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        clientController.deleteClient(id);
    }
    public void updateClient() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id клиента, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Client newClient;
            newClient = clientController.getClientById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newClient.setName(name);

            System.out.println("Введите фамилию: ");
            String surname = scanner.nextLine();
            newClient.setSurname(surname);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newClient.setTelephone(tel);

            System.out.println("Введите паспорт: ");
            String passport = scanner.nextLine();
            newClient.setPassport(passport);

            clientController.editClient(newClient);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdClient() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id клиента которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (clientController.getClientById(id) != null) {
                System.out.println(clientController.getClientById(id).toString());
            } else {
                System.out.println("Такого клиента не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdClient();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех клиентов");
            System.out.println(" 2. Добавить нового клиента");
            System.out.println(" 3. Удалить клиента ");
            System.out.println(" 4. Обновить информацию о клиенте  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showClients();
                    break;
                case 2:
                    createClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    getByIdClient();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
}
