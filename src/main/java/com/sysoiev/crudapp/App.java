package com.sysoiev.crudapp;

import com.sysoiev.crudapp.view.CommonView;

public class App {
    public static void main(String[] args) {
        CommonView view = CommonView.getInstance();
        view.run();
    }
}
