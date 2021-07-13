package com.yang.view.home;

import com.yang.view.film.AddFilm;
import com.yang.view.film.FindFilm;
import com.yang.view.filmSale.FindScheduls;
import com.yang.view.order.FindOrder;
import com.yang.view.order.OrderPage;
import com.yang.view.retrun.FindReturnInfor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopPanel extends JPanel {
    static int index =1;
    static JTextField jTextField = new JTextField(10);
    private static JSplitPane splitPane1 = Home.splitPane1;

    public TopPanel() throws HeadlessException {
        init();
        this.setSize(600,80);
        this.setLayout(null);
    }
    private void init(){
        jTextField.setForeground(Color.gray);
        jTextField.setFont(new Font("宋体",Font.PLAIN,12));
        jTextField.setText("请输入购买人姓名");
        jTextField.setBounds(100,20,300,30);
        jTextField.setFont(new Font(null, Font.PLAIN, 20));
        JButton jButton = new JButton("查询");
        jButton.setBounds(420,20,75,30);
        this.add(jTextField);
        this.add(jButton);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = jTextField.getText();
                if (!"".equals(name)){
                    System.out.println(index);
                    if (index==1){
                        splitPane1.setDividerLocation(70);
                        splitPane1.setBottomComponent(new FindOrder(name));
                        /*jTextField.setText("");*/

                    }
                    else if (index==2){
                        splitPane1.setDividerLocation(70);
                        splitPane1.setBottomComponent(new FindFilm(name));
                        /*jTextField.setText("");*/

                    }else if (index==3){
                        splitPane1.setDividerLocation(70);
                        splitPane1.setBottomComponent(new FindScheduls(name));
                        /*jTextField.setText("");*/

                    }
                    else if (index==4){
                        splitPane1.setDividerLocation(70);
                        splitPane1.setBottomComponent(new FindReturnInfor(name));
                        /*jTextField.setText("");*/

                    }
                }

                //JOptionPane.showMessageDialog(TopPanel.this.getParent(),"小二正在快马加鞭完善中....！","提示",JOptionPane.PLAIN_MESSAGE);

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
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setForeground(Color.BLACK);
                jTextField.setFont(new Font("宋体",Font.PLAIN,18));
                jTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }
}
