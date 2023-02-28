package com.company.hw6.view;

import com.company.hw6.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopUI extends JFrame implements View {

    private Label lCity;
    private JTextArea answer;
    private TextField city;
    private Presenter presenter;
    private JButton findInfo;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        lCity = new Label("Город: (например: moscow)");
        findInfo = new JButton("Узнать погоду");
        city = new TextField();
        answer = new JTextArea();
        this.setBounds(200, 100, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 5, 5));
        container.add(lCity);
        container.add(city);
        findInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClick(city.getText());
            }
        });
        container.add(answer);
        container.add(findInfo);
        setVisible(true);

    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}
