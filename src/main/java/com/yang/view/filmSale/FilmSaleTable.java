package com.yang.view.filmSale;

import com.yang.services.FilmService;
import com.yang.services.OrderInforService;
import com.yang.services.SchedulService;
import com.yang.view.film.FilmTable;
import com.yang.view.order.ReturnMoney2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FilmSaleTable extends Panel {
    public FilmSaleTable() {
        init();
        /*this.setBounds(220,90,600,500);*/
        this.setSize(600,450);
    }
    private void init() {
        Object[] columnNames = {"场次编号", "影厅名", "电影名", "题材", "时长","播放时间","库存"};
        final Object[][] rowData= SchedulService.showFilmInfor();
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
                    int sid =(int) rowData[table.getSelectedRow()][0];

                    int opt = JOptionPane.showConfirmDialog(FilmSaleTable.this,
                            "是否删除id为:"+sid+"的电影?", "确认信息",
                            JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        if (SchedulService.delSchedul(sid)){
                            JOptionPane.showMessageDialog(FilmSaleTable.this,"删除成功，请刷新！","提示",JOptionPane.PLAIN_MESSAGE);
                        }else                             JOptionPane.showMessageDialog(FilmSaleTable.this,"退款失败！","提示",JOptionPane.PLAIN_MESSAGE);

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
