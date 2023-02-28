package com.company.hw6;

import com.company.hw6.model.Service;
import com.company.hw6.model.WeatherService;
import com.company.hw6.presenter.Presenter;
import com.company.hw6.view.*;

public class MenuHw6 {

    public static void startApp(){
        View view = new DesktopUI();  //графическая
//        View view = new ConsoleUI();    //консольная
        Service service = new WeatherService();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
