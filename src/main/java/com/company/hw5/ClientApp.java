package com.company.hw5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    private static final String SERVER_MENU = "\nВведите необходимое: "
            + "\n\tadd"
            + "\n\tdel"
            + "\n\tchange"
            + "\n\tshow"
            + "\n\texit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 1234)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println(SERVER_MENU);
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);
                if (request.equals("add")) {
                    System.out.println("Введите данные сотрудника: ");
                    System.out.println("Введите фамилию: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите имя: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите возраст: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите департамент: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите должность: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                } else if (request.equals("del")) {
                    System.out.println("Выберите сотрудника, которого нужно удалить: ");
                    dataInputStream.readUTF();
                    dataOutputStream.writeUTF(scanner.nextLine());
                } else if (request.equals("change")) {
                    dataInputStream.readUTF();
                    System.out.println("Выберите сотрудника, чьи данные нужно изменить: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Измените департамент: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Измените должность: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                } else if (request.equals("show")) {
                    System.out.println("Список всех сотрудников: ");
                } else if (request.equals("exit")) {
                    break;
                } else {
                    System.out.println("Такой команды не существует!");
                }
                System.out.println("Получили сообщение от сервера: " + dataInputStream.readUTF());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
