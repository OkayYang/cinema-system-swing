package com.yang.view.home;

import com.yang.view.film.FilmPage;
import com.yang.view.filmSale.FilmSalePage;
import com.yang.view.order.OrderPage;
import com.yang.view.retrun.ReturnInfor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home extends JFrame {
    private static JLabel label1 =LeftPanel.label1;
    static JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//垂直分割
    private static JButton btn1 = LeftPanel.btn1;
    private static JButton btn2 = LeftPanel.btn2;
    private static JButton btn3 = LeftPanel.btn3;
    private static JButton btn4 = LeftPanel.btn4;

    public Home() {
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
        splitPane.setLeftComponent(new LeftPanel());
        //设置分割线大小
        splitPane.setDividerSize(10);
        //设置不可改变
        splitPane.setEnabled(false);
        container.add(splitPane,BorderLayout.CENTER);



        splitPane1.setDividerLocation(70);
        splitPane1.setDividerSize(10);
        //设置ui小部件
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setContinuousLayout(true);
        /*splitPane1.setBottomComponent(new OrderCentralPanelTest());*/
        splitPane1.setBottomComponent(new OrderPage());
        splitPane1.setTopComponent(new TopPanel());

        splitPane1.setEnabled(false);
        splitPane.setRightComponent(splitPane1);
        btn1.addMouseListener(new MouseClickEvent(){
            @Override
            public void mouseClicked(MouseEvent e) {
                TopPanel.index=1;
                TopPanel.jTextField.setForeground(Color.gray);
                TopPanel.jTextField.setFont(new Font("宋体",Font.PLAIN,12));
                TopPanel.jTextField.setText("请输入购买人姓名");
                splitPane1.setDividerLocation(70);
                splitPane1.setBottomComponent(new OrderPage());
            }
        });
        btn2.addMouseListener(new MouseClickEvent(){
            @Override
            public void mouseClicked(MouseEvent e) {
                TopPanel.index=2;
                TopPanel.jTextField.setForeground(Color.gray);
                TopPanel.jTextField.setFont(new Font("宋体",Font.PLAIN,12));
                TopPanel.jTextField.setText("请输入电影名");
                splitPane1.setDividerLocation(70);
                splitPane1.setBottomComponent(new FilmPage());
            }
        });
        btn3.addMouseListener(new MouseClickEvent(){
            @Override
            public void mouseClicked(MouseEvent e) {
                TopPanel.index=3;
                TopPanel.jTextField.setForeground(Color.gray);
                TopPanel.jTextField.setFont(new Font("宋体",Font.PLAIN,12));
                TopPanel.jTextField.setText("请输入影厅名");
                splitPane1.setDividerLocation(70);
                splitPane1.setBottomComponent(new FilmSalePage());
            }
        });
        btn4.addMouseListener(new MouseClickEvent(){
            @Override
            public void mouseClicked(MouseEvent e) {
                TopPanel.index=4;
                TopPanel.jTextField.setForeground(Color.gray);
                TopPanel.jTextField.setFont(new Font("宋体",Font.PLAIN,12));
                TopPanel.jTextField.setText("请输入退款人姓名");
                splitPane1.setDividerLocation(70);
                splitPane1.setBottomComponent(new ReturnInfor());
            }
        });

    }
    class MouseClickEvent implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

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
    }
}
