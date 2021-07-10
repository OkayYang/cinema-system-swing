package com.yang.view.filmSale;

import com.yang.view.order.ReturnOrder;

import javax.swing.*;

public class FilmSalePage extends JTabbedPane {
    public FilmSalePage() {
        init();
        this.setSize(600,500);
    }
    private void init(){
        this.add("场次大厅",new FilmSaleTable());
        this.add("添加场次",new ReturnOrder());
        this.add("售票中心",new ReturnOrder());
    }
}
