package com.yang.view.filmSale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Addschedul extends JPanel{
    public Addschedul() {
        this.setSize(600,500);
        this.setLayout(null);
        Font font = new Font("宋体",Font.PLAIN,22);


        JLabel jLabel1 = new JLabel("影厅名称:");
        JLabel jLabel2 = new JLabel("电影名称:");
        JLabel jLabel3 = new JLabel("电影票量:");
        JLabel jLabel4 = new JLabel("播放时间:");
        JButton button1 = new JButton("add");
        JButton button2 = new JButton("clear");

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();


        jLabel1.setBounds(5,50,100,30);
        jLabel2.setBounds(5,140,100,30);
        jLabel4.setBounds(5,230,100,30);
        jLabel3.setBounds(5,320,100,30);

        button1.setBounds(380,380,100,30);
        button2.setBounds(500,380,100,30);
        field1.setBounds(110,50,260,30);
        field2.setBounds(110,140,260,30);
        field3.setBounds(110,230,260,30);
        field4.setBounds(110,320,260,30);

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        field1.setFont(font);
        field2.setFont(font);
        field3.setFont(font);
        field4.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(button1);
        this.add(button2);

        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);


    }
}
