package com.yang.test;

import com.yang.view.home.LeftPanel;
import com.yang.view.home.TopPanel;
import com.yang.view.order.OrderCentralPanel;
import com.yang.view.order.OrderCentralPanelTest;
import com.yang.view.order.ReturnOrder;

import javax.swing.*;
import java.awt.*;


public class Test1 extends JFrame {

    public Test1() {
        init();
        this.setTitle("江理影院后台管理");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void init(){
        Container container = this.getContentPane();
        //默认水平分割
        JSplitPane splitPane = new JSplitPane();
        //设置左面大小
        splitPane.setDividerLocation(200);
        //左部放置部件
        /*splitPane.setLeftComponent(new LeftPanel());*/
        //设置分割线大小
        splitPane.setDividerSize(10);
        //设置不可改变
        splitPane.setEnabled(false);
        container.add(splitPane,BorderLayout.CENTER);


        final JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//垂直分割
        splitPane1.setDividerLocation(70);
        splitPane1.setDividerSize(10);
        //设置ui小部件
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setContinuousLayout(true);

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setSize(600,500);
        jTabbedPane.add("订单信息",null);
        jTabbedPane.add("申请退款",null);
        /*splitPane1.setBottomComponent(new OrderCentralPanelTest());*/
        splitPane1.setBottomComponent(jTabbedPane);
        /*splitPane1.setTopComponent(new TopPanel());*/
        splitPane1.setEnabled(false);
        splitPane.setRightComponent(splitPane1);


    }

    public static void main(String[] args) {
        new Test1();
    }
}
