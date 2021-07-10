package com.yang.view.order;

import javax.swing.*;

public class OrderCentralPanelTest  extends JTabbedPane {

    public OrderCentralPanelTest() {
        init();
        this.setSize(600,500);


    }
    private void init(){
        this.add("订单信息",new OrderCentralPanel());
        this.add("申请退款",new ReturnOrder());
    }
}
