package com.yang.view.film;

import com.yang.service.FilmService;
import com.yang.service.Impl.FilmServiceImpl;
import com.yang.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FilmTable  extends Panel {

    private FilmService filmService=(FilmService) SpringUtil.getApplicationContext().getBean("filmService");

    public FilmTable() {
        init();
        /*this.setBounds(220,90,600,500);*/
        this.setSize(600,450);
    }
    private void init() {
        Object[] columnNames = {"电影编号", "电影名", "电影类型", "地区", "放映时长","上映时间","价格"};
        final Object[][] rowData= filmService.showSchedulInfor();
        // 创建 表格模型，指定 所有行数据 和 表头
        TableModel tableModel = new DefaultTableModel(rowData, columnNames);

        // 使用 表格模型 创建 表格

        final JTable table = new JTable(tableModel){
            //禁止单元格编辑
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //设置滚动面板
        table.setPreferredScrollableViewportSize(new Dimension(590, 350));
        JScrollPane scrollPane = new JScrollPane(table);
        //设置单一选中
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setShowGrid(true);
        JTableHeader jTableHeader = table.getTableHeader();
        //设置表头是否可移动
        jTableHeader.setReorderingAllowed(true);

        table.setSelectionBackground(Color.red);
        //设置指定列的宽度
        /*table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);*/
        this.add(scrollPane);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>=2){

                    int fid =(int) rowData[table.getSelectedRow()][0];

                    int opt = JOptionPane.showConfirmDialog(FilmTable.this,
                            "是否删除id为:"+fid+"的电影?", "确认信息",
                            JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        try {
                            if (filmService.delFilm(fid)){
                                JOptionPane.showMessageDialog(FilmTable.this,"删除成功，请刷新！","提示",JOptionPane.PLAIN_MESSAGE);
                            }else                             JOptionPane.showMessageDialog(FilmTable.this,"退款失败！","提示",JOptionPane.PLAIN_MESSAGE);

                        }catch (Exception e1){
                            JOptionPane.showMessageDialog(FilmTable.this,"该电影已有人购买，不可删除！","提示",JOptionPane.PLAIN_MESSAGE);

                        }

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
