package com.company.hw3;

import java.util.ArrayList;
import java.util.Collections;

public class InitialPeople {
    public static ArrayList<Manager> initManager(){
        ArrayList<Manager> managers = new ArrayList<>();
        Manager m1 = new Manager("Иванова", "Мария", "Игоревна", "asd@mail.com", 324324,
                "Руководитель", 200000, 8, 12);
        Collections.addAll(managers, m1);
        return managers;
    }

    public static ArrayList<HR> initHR(){
        ArrayList<HR> hr = new ArrayList<>();
        HR hr1 = new HR("Янкина", "Мария","Петровна","zusdu@de,com", 342424,"HR", 35000, 2);
        HR hr2 = new HR("Попова", "Ольга","Леонидовна","dfs@de,com", 53452,"HR", 40000, 4);
        HR hr3 = new HR("Дубина", "Виолета","-","iuky@de,com", 865745,"HR", 35000, 3);
        HR hr4 = new HR("Морозова", "Василиса","Петровна","bvm@de,com", 56743,"HR", 50000, 8);
        Collections.addAll(hr, hr1, hr2, hr3, hr4);
        return hr;
    }

    public static ArrayList<Programist> initProgramist(){
        ArrayList<Programist> programists = new ArrayList<>();
        Programist p1 = new Programist("Филиппов","Дмитрий","Аксеонович", "rewrw@mail.ru", 43532, "разработка веб-сайтов", 200000, 7,"site-ozon","JS");
        Programist p2 = new Programist("Антилопов","Анатолий","Федотович", "nbgc@mail.ru", 3756, "бэк", 130000, 7,"site-ozon","Java");
        Programist p3 = new Programist("Мохнатый","Василий","Игоревич", "dgjk@mail.ru", 8975, "разработка веб-сайтов", 90000, 3,"site-ozon","JS");
        Programist p4 = new Programist("Попов","Петр","Андреевич", "gjhj@mail.ru", 1675, "разработка веб-сайтов", 100000, 2,"site-ozon","JS");
        Programist p5 = new Programist("Хвастунов","Олег","Васильевич", "xcvbbn@mail.ru", 8974, "бэк", 150000, 4,"site-ozon","Java");
        Programist p6 = new Programist("Евдокимов","Максим","Дмитриевич", "kvc@mail.ru", 24243, "бэк", 90000, 4,"site-ozon","Java");
        Collections.addAll(programists, p1, p2, p3, p4, p5, p6);
        return programists;
    }

    public static ArrayList<Candidate> initCandidate(){
        ArrayList<Candidate> candidates = new ArrayList<>();
        Candidate c1 = new Candidate("Пуплчкин","Анатолий","Маркович","ppo@sdsd.ru",5363463);
        Candidate c2 = new Candidate("Хрюшечкин","Марк","Сергеевич","ejwio@dsbk.ru",84684);
        Candidate c3 = new Candidate("Ласточкин","Евдокий","-","jshda@dhbch.com",8763866);
        Candidate c4 = new Candidate("Попочкин","Павел","Сергеевич","refer@eve.ru",65738);
        Candidate c5 = new Candidate("Курочкин","Александр","Игоревич","fwdwfw@efew.ru",976765);
        Collections.addAll(candidates, c1, c2, c3, c4, c5 );
        return candidates;
    }
}
