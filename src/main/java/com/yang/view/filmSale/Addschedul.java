package com.yang.view.filmSale;

import com.eltima.components.ui.DatePicker;
import com.yang.model.Film;
import com.yang.model.Schedul;
import com.yang.services.FilmService;
import com.yang.services.SchedulService;
import com.yang.view.login.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Locale;

public class Addschedul extends JPanel{
    public Addschedul() {
        this.setSize(600,500);
        this.setLayout(null);
        Font font = new Font("宋体",Font.PLAIN,22);


        JLabel jLabel1 = new JLabel("电影编号:");
        JLabel jLabel2 = new JLabel("影厅名称:");
        JLabel jLabel3 = new JLabel("电影票量:");
        JLabel jLabel4 = new JLabel("播放时间:");
        JButton button1 = new JButton("add");
        JButton button2 = new JButton("clear");

        final String[] s = FilmService.selectAllFname();
        final JComboBox field1 = new JComboBox(s);

        final JTextField field2 = new JTextField();
        /*final JTextField field3 = new JTextField();*/
        final JTextField field4 = new JTextField();
        final DatePicker field3;
        field3 = getDatePicker();


        jLabel1.setBounds(5,50,130,30);
        jLabel2.setBounds(5,140,130,30);
        jLabel4.setBounds(5,230,130,30);
        jLabel3.setBounds(5,320,130,30);

        button1.setBounds(380,380,100,30);
        button2.setBounds(500,380,100,30);
        field1.setBounds(150,50,260,30);
        field2.setBounds(150,140,260,30);
        field3.setBounds(150,230,260,30);
        field4.setBounds(150,320,260,30);

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

        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field2.setText("");
                field4.setText("");
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
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int stock =0;
                    int fid = FilmService.findFid(s[field1.getSelectedIndex()]);
                    String sname = field2.getText();
                    Date date = (Date) field3.getValue();
                    if (s[field1.getSelectedIndex()]!=null){
                        stock = Integer.parseInt(field4.getText());
                    }
                    Schedul schedul = new Schedul();
                    schedul.setFid(fid);
                    schedul.setsStock(stock);
                    schedul.setsName(sname);
                    schedul.setsTime(date);
                    if (SchedulService.addSchedul(schedul)){
                        JOptionPane.showMessageDialog(Addschedul.this,"添加成功！","提示",JOptionPane.PLAIN_MESSAGE);
                    }else                     JOptionPane.showMessageDialog(Addschedul.this,"添加失败，请返回检查！","提示",JOptionPane.PLAIN_MESSAGE);


                }catch ( Exception ex){
                    JOptionPane.showMessageDialog(Addschedul.this,"输入信息有误，请返回检查！","提示",JOptionPane.PLAIN_MESSAGE);
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
        String DefaultFormat = "yyyy-MM-dd HH:mm";
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
