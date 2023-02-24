package com.company.hw5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем соединение....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            Company company = new Company();
            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("add")) {
                    String empSurname = dataInputStream.readUTF();
                    String empName = dataInputStream.readUTF();
                    int empAge = Integer.parseInt(dataInputStream.readUTF());
                    String empDep = dataInputStream.readUTF();
                    String empPost = dataInputStream.readUTF();
                    company.addEmployeeList(empSurname, empName, empAge, empDep, empPost);
                    dataOutputStream.writeUTF("Сотрудник " + empSurname + " добавлен");
                } else if (clientRequest.equals("del")) {
                    dataOutputStream.writeUTF(company.showEmployee());
                    int num = Integer.parseInt(dataInputStream.readUTF());
                    company.deleteEmployee(company.getList().get(num - 1));
                    dataOutputStream.writeUTF("Сотрудник " + company.getList().get(num - 1) + " удален");
                } else if (clientRequest.equals("change")) {
                    dataOutputStream.writeUTF(company.showEmployee());
                    int num = Integer.parseInt(dataInputStream.readUTF());
                    String newDep = dataInputStream.readUTF();
                    company.changeDepartment(company.getList().get(num), newDep);
                    dataOutputStream.writeUTF("Департамент изменен");
                    String newPost = dataInputStream.readUTF();
                    company.changePost(company.getList().get(num), newPost);
                    dataOutputStream.writeUTF("Должность изменена");
                } else if (clientRequest.equals("show")) {
                    dataOutputStream.writeUTF(company.showEmployee());
                } else if (clientRequest.equals("exit")) {
                    break;
                } else {
                    System.out.println("Такой команды не существует!");
                }
                System.out.println("Мы получили строку: " + clientRequest);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
