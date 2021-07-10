package com.yang.view.login;

import com.yang.services.LoginService;
import com.yang.view.home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class LoginView extends JFrame{
    private static JLabel fpd = new JLabel("忘记密码");
    private static JButton btn1 = new JButton("登入");
    private static JPasswordField jpf = new JPasswordField(25);
    private static JTextField jtName = new JTextField("",25);

    public LoginView() throws HeadlessException {
        init();
        this.setTitle("admin登陆");
        this.setSize(530, 410);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);



    }


    public void init() {

        Container container =  this.getContentPane();

        container.setLayout(null);
        //账号窗口设置
        JLabel label1 = new JLabel();

        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/logo1.png")).getFile()));
        JLabel ljName = new JLabel("账号:");
        JLabel ljName1 = new JLabel("密码:");

        jtName.setBounds(125,155,300,40);
        ljName.setBounds(75,155,50,40);
        label1.setBounds(160,30,200,100);


        //密码窗口设置
        jpf.setBounds(125,200,300,40);

        fpd.setBounds(350,240,100,30);
        fpd.setFont(new Font("宋体",Font.PLAIN,12));
        fpd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ljName1.setBounds(75,200,50,40);
        //登入按钮设置
        btn1.setBounds(125, 290, 300, 40);
        container.add(fpd);
        container.add(label1);
        container.add(btn1);
        container.add(jtName);
        container.add(ljName);
        container.add(jpf);
        container.add(ljName1);
        //登入窗口容器设置
        /**
         * 忘记密码触发事件
         */
        fpd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new ForgetPassWord(LoginView.this);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fpd.setFont(new Font("宋体",Font.PLAIN,15));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                fpd.setFont(new Font("宋体",Font.PLAIN,12));

            }
        });

        /**
         * 登陆事件监控
         */
        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String name = jtName.getText();
                String password = String.valueOf(jpf.getPassword());
                if ("".equals(name)||"".equals(password)){
                    JOptionPane.showMessageDialog(LoginView.super.getContentPane(),"账号密码不能为空！","提示",JOptionPane.PLAIN_MESSAGE);
                }else{

                    if (LoginService.adminLogin(name,password)){
                        //JOptionPane.showMessageDialog(LoginView.super.getContentPane(),"登陆成功！","提示",JOptionPane.PLAIN_MESSAGE);
                        new Home();
                        LoginView.this.dispose();
                    }else {
                        JOptionPane.showMessageDialog(LoginView.super.getContentPane(),"账号或密码错误！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
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
}
