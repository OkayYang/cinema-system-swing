package com.yang.view.film;

import com.yang.view.order.ReturnOrder;

import javax.swing.*;

public class FilmPage extends JTabbedPane {
    public FilmPage() {
        init();
        this.setSize(600,500);
    }
    private void init(){
        this.add("电影信息",new FilmTable());
        this.add("添加电影",new AddFilm());
    }
}
