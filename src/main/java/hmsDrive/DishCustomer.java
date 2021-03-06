/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsDrive;

import hms.check.CheckInSrc;
import hms.object.Dishtxt;
import hms.textfiles.DishTextFiles;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LYJ
 */
public class DishCustomer extends javax.swing.JFrame {
    /**
     * Creates new form CheckInSrc
     */
    
    public int num;
    
    private ArrayList<Dishtxt> dCustomerArrayList = new ArrayList<>();
    private DefaultTableModel dTbl;
    
    public DishCustomer() {  //예약된 전체 목록 출력
        initComponents();
        
        dTbl = (DefaultTableModel) DCUSTOMER_TABLE.getModel();
        
        //예약자 목록 검색
        dCustomerArrayList = DishTextFiles.getDishCustomerListTxt();
        
        //테이블에 출력
        for (Dishtxt r : dCustomerArrayList){
            dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                r.getRoomIdx(),
                r.getName(),
                r.getPeopleNum(),
                r.getMenu(),
                r.getFee()
            });
        }
        
    }
    
    public DishCustomer(int num) {  //예약된 전체 목록 출력
        this.num = num;
        initComponents();
        
        dTbl = (DefaultTableModel) DCUSTOMER_TABLE.getModel();
        
        //예약자 목록 검색
        dCustomerArrayList = DishTextFiles.getDishCustomerListTxt();
        
        //테이블에 출력
        for (Dishtxt r : dCustomerArrayList){
            dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                r.getRoomIdx(),
                r.getName(),
                r.getPeopleNum(),
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

        jLabel1 = new javax.swing.JLabel();
        SEARCH_FIELD = new javax.swing.JTextField();
        SEARCH_BTN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DCUSTOMER_TABLE = new javax.swing.JTable();
        CANCEL_BTN = new javax.swing.JButton();
        PRE_BTN = new javax.swing.JButton();
        FINISH_BTN = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel1.setText("식사 서비스 예약 내역");

        SEARCH_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        SEARCH_BTN.setText("검색");
        SEARCH_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCH_BTNActionPerformed(evt);
            }
        });

        jLabel3.setText("예약자 명 또는 객실 번호:");

        DCUSTOMER_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "호실", "예약자명", "인원 수", "서비스 종류", "가격"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DCUSTOMER_TABLE);

        CANCEL_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        CANCEL_BTN.setText("예약 취소");
        CANCEL_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCEL_BTNActionPerformed(evt);
            }
        });

        PRE_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        PRE_BTN.setText("이전");
        PRE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRE_BTNActionPerformed(evt);
            }
        });

        FINISH_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        FINISH_BTN.setText("서비스 완료");
        FINISH_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINISH_BTNActionPerformed(evt);
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SEARCH_FIELD)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PRE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FINISH_BTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CANCEL_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SEARCH_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(SEARCH_BTN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CANCEL_BTN)
                    .addComponent(PRE_BTN)
                    .addComponent(FINISH_BTN))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //상단 메뉴바 뒤로가기 버튼
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new Dish(num).setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //상단 메뉴바 종료 버튼
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //식사 서비스 예약 취소 버튼
    private void CANCEL_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCEL_BTNActionPerformed
        dTbl = (DefaultTableModel) DCUSTOMER_TABLE.getModel();
        int row = -1;
        
        row = DCUSTOMER_TABLE.getSelectedRow();
        String dCustomerIdx = (String) dTbl.getValueAt(row, 0);
        
        if (row == -1){
            JOptionPane.showMessageDialog(null, "취소할 목록을 선택해주십시오");
        } else{
            //dishCustomerList.txt에서 삭제
            DishTextFiles.deleteDishCustomerListTxt(dCustomerIdx);
            JOptionPane.showMessageDialog(null, "식사서비스가 취소 되었습니다.");
        
            new DishCustomer(num).setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_CANCEL_BTNActionPerformed

    //이전 버튼
    private void PRE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRE_BTNActionPerformed
        // TODO add your handling code here:
        new Dish(num).setVisible(true);
        dispose();
    }//GEN-LAST:event_PRE_BTNActionPerformed

    //예약된 식사서비스 검색 버튼
    private void SEARCH_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCH_BTNActionPerformed

        String search = SEARCH_FIELD.getText();
        dTbl = (DefaultTableModel) DCUSTOMER_TABLE.getModel();
        dTbl.setNumRows(0);
        
        //예약자 목록 검색
        dCustomerArrayList = DishTextFiles.getDishCustomerListTxt(search);
        
        //예약 되지않은 고객일 경우
        if(dCustomerArrayList.isEmpty()){
            JOptionPane.showMessageDialog(null, "예약되지않은 고객입니다.");
        } else{
            //테이블에 검색된 목록 출력
            for (Dishtxt r : dCustomerArrayList){
                dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                        r.getRoomIdx(),
                        r.getName(),
                        r.getPeopleNum(),
                        r.getMenu(),
                        r.getFee()
                    });
                
            }
        }
    }//GEN-LAST:event_SEARCH_BTNActionPerformed

    //식사 서비스 완료
    private void FINISH_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINISH_BTNActionPerformed
        // TODO add your handling code here:
        dTbl = (DefaultTableModel) DCUSTOMER_TABLE.getModel();
        int row = -1;
        
        row = DCUSTOMER_TABLE.getSelectedRow();
        String dCustomerIdx = (String) dTbl.getValueAt(row, 0);
        
        if (row == -1){
            JOptionPane.showMessageDialog(null, "완료된 목록을 선택해주십시오");
        } else{
            //dishCustomerList.txt에서 삭제
            DishTextFiles.deleteDishCustomerListTxt(dCustomerIdx);
            JOptionPane.showMessageDialog(null, "식사서비스가 완료 되었습니다.");
        
            new DishCustomer(num).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_FINISH_BTNActionPerformed

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
                new DishCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL_BTN;
    private javax.swing.JTable DCUSTOMER_TABLE;
    private javax.swing.JButton FINISH_BTN;
    private javax.swing.JButton PRE_BTN;
    private javax.swing.JButton SEARCH_BTN;
    private javax.swing.JTextField SEARCH_FIELD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
