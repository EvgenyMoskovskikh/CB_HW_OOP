package com.company.hw6.view;

import com.company.hw6.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
}
