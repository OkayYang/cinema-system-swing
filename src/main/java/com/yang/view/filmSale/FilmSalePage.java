package com.yang.view.filmSale;

import javax.swing.*;

public class FilmSalePage extends JTabbedPane {
    public FilmSalePage() {
        init();
        this.setSize(600,500);
    }
    private void init(){
        this.add("场次大厅",new FilmSaleTable());
        this.add("添加场次",new Addschedul());
        this.add("售票中心",new TicketCenter());
    }
}
