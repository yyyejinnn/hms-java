/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsDrive;

import hms.check.CheckInSrc;
import hms.object.Dishtxt;
import hms.textfiles.DishTextFiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LYJ
 */
public class SystemRoomService extends javax.swing.JFrame {
    /**
     * Creates new form CheckInSrc
     */
    private ArrayList<Dishtxt> restaurantArrayList = new ArrayList<>();
    private DefaultTableModel dTbl;
    private int row = -1;
    
    private String menu = "";
    private String fee = "";
    private String updateMenu = "";
    private String updateFee = "";
    
    public int num;
    
    public SystemRoomService() {
        initComponents();
        
        dTbl = (DefaultTableModel) RT_TBL.getModel();
        
        //레스토랑 목록 검색
        restaurantArrayList = DishTextFiles.getRoomServiceListTxt();
        
        //테이블에 출력
        for (Dishtxt r : restaurantArrayList){
            dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                r.getMenu(),
                r.getFee()
            });
        }
    }
    
    public SystemRoomService(int num) {
        this.num = num;
        initComponents();
        
        dTbl = (DefaultTableModel) RT_TBL.getModel();
        
        //레스토랑 목록 검색
        restaurantArrayList = DishTextFiles.getRoomServiceListTxt();
        
        //테이블에 출력
        for (Dishtxt r : restaurantArrayList){
            dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                r.getMenu(),
                r.getFee()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UPDATE_DLG = new javax.swing.JDialog();
        UPDATE_FEE_FIELD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        UPDATE_MENU_FIELD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UPDATE_OK = new javax.swing.JButton();
        INSERT_DLG = new javax.swing.JDialog();
        INSERT_FEE_FIELD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        INSERT_MENU_FIELD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        INSERT_OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RT_TBL = new javax.swing.JTable();
        UPDATE_BTN = new javax.swing.JButton();
        DELETE_BTN = new javax.swing.JButton();
        INSERT_BTN = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        UPDATE_DLG.setMinimumSize(new java.awt.Dimension(280, 280));

        UPDATE_FEE_FIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_FEE_FIELDActionPerformed(evt);
            }
        });

        jLabel5.setText("가격:");

        jLabel4.setText("서비스 종류:");

        UPDATE_OK.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        UPDATE_OK.setText("수정");
        UPDATE_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPDATE_DLGLayout = new javax.swing.GroupLayout(UPDATE_DLG.getContentPane());
        UPDATE_DLG.getContentPane().setLayout(UPDATE_DLGLayout);
        UPDATE_DLGLayout.setHorizontalGroup(
            UPDATE_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_DLGLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(UPDATE_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UPDATE_DLGLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UPDATE_FEE_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPDATE_DLGLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UPDATE_MENU_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UPDATE_DLGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UPDATE_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        UPDATE_DLGLayout.setVerticalGroup(
            UPDATE_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_DLGLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(UPDATE_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(UPDATE_MENU_FIELD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UPDATE_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(UPDATE_FEE_FIELD))
                .addGap(31, 31, 31)
                .addComponent(UPDATE_OK)
                .addGap(59, 59, 59))
        );

        INSERT_DLG.setMinimumSize(new java.awt.Dimension(280, 280));

        INSERT_FEE_FIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERT_FEE_FIELDActionPerformed(evt);
            }
        });

        jLabel6.setText("가격:");

        jLabel7.setText("서비스 종류:");

        INSERT_OK.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        INSERT_OK.setText("추가");
        INSERT_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERT_OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout INSERT_DLGLayout = new javax.swing.GroupLayout(INSERT_DLG.getContentPane());
        INSERT_DLG.getContentPane().setLayout(INSERT_DLGLayout);
        INSERT_DLGLayout.setHorizontalGroup(
            INSERT_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INSERT_DLGLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(INSERT_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(INSERT_DLGLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSERT_FEE_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(INSERT_DLGLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSERT_MENU_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INSERT_DLGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(INSERT_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        INSERT_DLGLayout.setVerticalGroup(
            INSERT_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INSERT_DLGLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(INSERT_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(INSERT_MENU_FIELD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(INSERT_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(INSERT_FEE_FIELD))
                .addGap(31, 31, 31)
                .addComponent(INSERT_OK)
                .addGap(59, 59, 59))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel1.setText("룸 서비스 관리");

        RT_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "서비스 종류", "가격"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(RT_TBL);

        UPDATE_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        UPDATE_BTN.setText("수정");
        UPDATE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_BTNActionPerformed(evt);
            }
        });

        DELETE_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        DELETE_BTN.setText("삭제");
        DELETE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_BTNActionPerformed(evt);
            }
        });

        INSERT_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        INSERT_BTN.setText("추가");
        INSERT_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERT_BTNActionPerformed(evt);
            }
        });

        jMenu1.setText("메뉴");

        jMenuItem1.setText("뒤로가기");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("종료");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UPDATE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DELETE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INSERT_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UPDATE_BTN)
                    .addComponent(DELETE_BTN)
                    .addComponent(INSERT_BTN))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //상단 메뉴바 뒤로가기 버튼
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new System(num).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //상단 메뉴바 종료 버튼
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void DELETE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_BTNActionPerformed
        // TODO add your handling code here:
        dTbl = (DefaultTableModel) RT_TBL.getModel();
        row = RT_TBL.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(null, "삭제할 서비스를 선택해주십시오.");
        } else{
            menu = (String) dTbl.getValueAt(row, 0);
            fee = (String) dTbl.getValueAt(row, 1);
            
            DishTextFiles.deleteRtRsListTxt(menu, fee, 2);
            
            JOptionPane.showMessageDialog(null, "삭제 완료되었습니다.");
            this.setVisible(false);
            new SystemRoomService(num).setVisible(true);
        }
    }//GEN-LAST:event_DELETE_BTNActionPerformed

    private void UPDATE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_BTNActionPerformed
        // TODO add your handling code here:
        dTbl = (DefaultTableModel) RT_TBL.getModel();
        row = RT_TBL.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(null, "수정할 서비스를 선택해주십시오.");
        } else{
            //UPDATE_DLG init
            menu = (String) dTbl.getValueAt(row, 0);
            fee = (String) dTbl.getValueAt(row, 1);
                
            UPDATE_MENU_FIELD.setText(menu);
            UPDATE_FEE_FIELD.setText(fee);

            UPDATE_DLG.setVisible(true);
        }
    }//GEN-LAST:event_UPDATE_BTNActionPerformed

    private void INSERT_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERT_BTNActionPerformed
        // TODO add your handling code here:
        INSERT_DLG.setVisible(true);
    }//GEN-LAST:event_INSERT_BTNActionPerformed

    private void UPDATE_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_OKActionPerformed
        // TODO add your handling code here:
        
        //업데이트
        updateMenu = UPDATE_MENU_FIELD.getText();
        updateFee = UPDATE_FEE_FIELD.getText();
        
        DishTextFiles.updateRtRsListTxt(menu, fee, updateMenu, updateFee, 2);
        
        JOptionPane.showMessageDialog(null, "수정 완료되었습니다.");
        UPDATE_DLG.dispose();
        new SystemRoomService(num).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UPDATE_OKActionPerformed

    private void UPDATE_FEE_FIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_FEE_FIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPDATE_FEE_FIELDActionPerformed

    private void INSERT_FEE_FIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERT_FEE_FIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INSERT_FEE_FIELDActionPerformed

    private void INSERT_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERT_OKActionPerformed
        // TODO add your handling code here:
        
        menu = INSERT_MENU_FIELD.getText();
        fee = INSERT_FEE_FIELD.getText();
        
        if(menu.equals("") | fee.equals("")){
            JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오.");
        } else {
            DishTextFiles.setRtRsListTxt(menu, fee, 2);
            JOptionPane.showMessageDialog(null, "룸 서비스가 추가 되었습니다.");
            INSERT_DLG.dispose();
            new SystemRoomService(num).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_INSERT_OKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckInSrc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInSrc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInSrc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInSrc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemRoomService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE_BTN;
    private javax.swing.JButton INSERT_BTN;
    private javax.swing.JDialog INSERT_DLG;
    private javax.swing.JTextField INSERT_FEE_FIELD;
    private javax.swing.JTextField INSERT_MENU_FIELD;
    private javax.swing.JButton INSERT_OK;
    private javax.swing.JTable RT_TBL;
    private javax.swing.JButton UPDATE_BTN;
    private javax.swing.JDialog UPDATE_DLG;
    private javax.swing.JTextField UPDATE_FEE_FIELD;
    private javax.swing.JTextField UPDATE_MENU_FIELD;
    private javax.swing.JButton UPDATE_OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
