package com.yang.view.film;

import com.eltima.components.ui.DatePicker;
import com.yang.model.Film;
import com.yang.services.FilmService;
import com.yang.view.filmSale.TicketCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Locale;

public class AddFilm extends JPanel {
    public AddFilm() {
        this.setSize(600,500);
        this.setLayout(null);
        Font font = new Font("宋体",Font.PLAIN,18);
        JLabel jLabel1 = new JLabel("电影名称:");
        JLabel jLabel2 = new JLabel("电影类型:");
        JLabel jLabel3 = new JLabel("电影价格:");
        JLabel jLabel4 = new JLabel("上映时间:");
        JLabel jLabel5 = new JLabel("放映时长:");
        JLabel jLabel6 = new JLabel("上映地区:");
        JButton button1 = new JButton("add");
        JButton button2 = new JButton("clear");

        final JTextField field1 = new JTextField();
        final JTextField field2 = new JTextField();
        final JTextField field3 = new JTextField();
        final DatePicker field4;
        field4 = getDatePicker();
        /*JTextField field4 = new JTextField();*/
        final JTextField field5 = new JTextField();
        final JTextField field6 = new JTextField();


        jLabel1.setBounds(0,50,100,30);
        jLabel4.setBounds(0,150,100,30);
        jLabel6.setBounds(0,250,100,30);
        jLabel2.setBounds(300,50,100,30);
        jLabel5.setBounds(300,150,100,30);
        jLabel3.setBounds(300,250,100,30);
        button1.setBounds(380,380,100,30);
        button2.setBounds(500,380,100,30);
        field1.setBounds(85,50,200,30);
        field2.setBounds(385,50,200,30);
        field3.setBounds(385,250,200,30);
        field4.setBounds(85,150,200,30);
        field5.setBounds(385,150,200,30);
        field6.setBounds(85,250,200,30);

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        field1.setFont(font);
        field2.setFont(font);
        field3.setFont(font);
        field4.setFont(font);
        field5.setFont(font);
        field6.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);
        this.add(jLabel6);
        this.add(button1);
        this.add(button2);

        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(field5);
        this.add(field6);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String fname = field1.getText();
                    String type =field2.getText();
                    Date date = (Date) field4.getValue();
                    String durTime = field5.getText();
                    String region = field6.getText();
                    int price = Integer.parseInt(field3.getText());
                    if ("".equals(fname)||"".equals(type)||"".equals(durTime)||"".equals(region)||"".equals(field3.getText())){
                        JOptionPane.showMessageDialog(AddFilm.this,"添加信息不能为空！","提示",JOptionPane.PLAIN_MESSAGE);
                    }else {
                        Film film = new Film(fname,type,region,durTime,date,price);
                        if (FilmService.addFilm(film)){
                            JOptionPane.showMessageDialog(AddFilm.this,"添加成功！","提示",JOptionPane.PLAIN_MESSAGE);
                        }else                     JOptionPane.showMessageDialog(AddFilm.this,"添加失败，请返回检查！","提示",JOptionPane.PLAIN_MESSAGE);

                    }

                }catch (Exception e2){
                    JOptionPane.showMessageDialog(AddFilm.this,"输入信息有误，请返回检查！","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




    }
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };

        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
}
