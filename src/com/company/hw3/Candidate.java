package com.company.hw3;

import com.company.helper.ScannerHelper;

public class Candidate extends User{

    public Candidate(String lastName, String name, String fathersName, String email, int phone) {
        super(lastName, name, fathersName, email, phone);
    }

    @Override
    public void sendEmail(String email) {
        String text = ScannerHelper.getIntFromString("Введите текст сообщения: ");
        System.out.println("Сообщение \"" + text + "\" отправлено. Получатель: " + email);
    }

    @Override
    public String toString() {
        return "\n\tИмя: " + this.getName() + "\n\tФамилия: " + this.getLastName() + "\n\tТелефон: " + this.getPhone() +
                "\n\tПочта: " + this.getEmail();
    }
}
