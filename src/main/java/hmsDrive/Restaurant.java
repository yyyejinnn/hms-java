/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsDrive;

import hms.object.Reserve;
import hms.check.CheckSrc;
import hms.check.CheckInSrc;
import hms.object.Dishtxt;
import hms.textfiles.DishTextFiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LYJ
 */
public class Restaurant extends javax.swing.JFrame {
    /**
     * Creates new form CheckInSrc
     */
    private ArrayList<Dishtxt> dishArrayList = new ArrayList<>();
    private ArrayList<Reserve> checkArrayList = new ArrayList<>();
    private CheckSrc check = new CheckSrc();
    private DefaultTableModel dTbl;
    
    public int num;
    
    public Restaurant() {
        initComponents();
    }
    
    public Restaurant(int num) {
        this.num = num;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MENU_DLG = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        MENU_TBL = new javax.swing.JTable();
        MENU_OK = new javax.swing.JButton();
        PAY_DLG = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CARD_PAY = new javax.swing.JRadioButton();
        CACH_PAY = new javax.swing.JRadioButton();
        PAY_OK_BTN = new javax.swing.JButton();
        PAY_FEE_FIELD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PAY_MENU_FIELD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        SEARCH_FIELD = new javax.swing.JTextField();
        SEARCH_BTN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CHECKIN_TBL = new javax.swing.JTable();
        MENU_FIELD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MENU_FEE_FIELD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MENU_BTN = new javax.swing.JButton();
        PAY_BTN = new javax.swing.JButton();
        RESERVE_BTN = new javax.swing.JButton();
        PRE_BTN = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        MENU_DLG.setLocation(new java.awt.Point(100, 100));
        MENU_DLG.setMinimumSize(new java.awt.Dimension(310, 270));

        MENU_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "종류", "가격"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(MENU_TBL);

        MENU_OK.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        MENU_OK.setText("확인");
        MENU_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_DLGLayout = new javax.swing.GroupLayout(MENU_DLG.getContentPane());
        MENU_DLG.getContentPane().setLayout(MENU_DLGLayout);
        MENU_DLGLayout.setHorizontalGroup(
            MENU_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_DLGLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(MENU_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MENU_DLGLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(MENU_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        MENU_DLGLayout.setVerticalGroup(
            MENU_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_DLGLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MENU_OK)
                .addGap(22, 22, 22))
        );

        PAY_DLG.setLocation(new java.awt.Point(80, 80));
        PAY_DLG.setMinimumSize(new java.awt.Dimension(340, 380));

        jLabel6.setText("요금:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "결제 방법", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("굴림", 1, 12))); // NOI18N

        CARD_PAY.setText("카드");

        CACH_PAY.setText("현금");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(CARD_PAY, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(CACH_PAY)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CARD_PAY)
                    .addComponent(CACH_PAY))
                .addContainerGap())
        );

        PAY_OK_BTN.setText("결제");
        PAY_OK_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAY_OK_BTNActionPerformed(evt);
            }
        });

        PAY_FEE_FIELD.setEditable(false);
        PAY_FEE_FIELD.setFocusable(false);

        jLabel7.setText("서비스 종류:");

        PAY_MENU_FIELD.setEditable(false);
        PAY_MENU_FIELD.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel2.setText("결제");

        jMenu2.setText("메뉴");
        jMenu2.setActionCommand("Menu");

        jMenuItem3.setText("뒤로가기");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("종료");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar2.add(jMenu2);

        PAY_DLG.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout PAY_DLGLayout = new javax.swing.GroupLayout(PAY_DLG.getContentPane());
        PAY_DLG.getContentPane().setLayout(PAY_DLGLayout);
        PAY_DLGLayout.setHorizontalGroup(
            PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAY_DLGLayout.createSequentialGroup()
                .addGroup(PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAY_DLGLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(PAY_DLGLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAY_DLGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAY_DLGLayout.createSequentialGroup()
                        .addGroup(PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PAY_DLGLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PAY_FEE_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PAY_DLGLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PAY_MENU_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAY_DLGLayout.createSequentialGroup()
                        .addComponent(PAY_OK_BTN)
                        .addGap(135, 135, 135))))
        );
        PAY_DLGLayout.setVerticalGroup(
            PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAY_DLGLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PAY_MENU_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PAY_DLGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PAY_FEE_FIELD, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PAY_OK_BTN)
                .addGap(59, 59, 59))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel1.setText("레스토랑 서비스");

        SEARCH_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        SEARCH_BTN.setText("검색");
        SEARCH_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCH_BTNActionPerformed(evt);
            }
        });

        jLabel3.setText("예약자 명 또는 객실 번호:");

        CHECKIN_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "호실", "예약자명", "인원 수"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CHECKIN_TBL);
        if (CHECKIN_TBL.getColumnModel().getColumnCount() > 0) {
            CHECKIN_TBL.getColumnModel().getColumn(2).setHeaderValue("인원 수");
        }

        MENU_FIELD.setEditable(false);
        MENU_FIELD.setFocusable(false);

        jLabel4.setText("서비스 종류:");

        MENU_FEE_FIELD.setEditable(false);
        MENU_FEE_FIELD.setFocusable(false);

        jLabel5.setText("가격:");

        MENU_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        MENU_BTN.setText("레스토랑 서비스 메뉴");
        MENU_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_BTNActionPerformed(evt);
            }
        });

        PAY_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        PAY_BTN.setText("예약 및 결제");
        PAY_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAY_BTNActionPerformed(evt);
            }
        });

        RESERVE_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        RESERVE_BTN.setText("예약");
        RESERVE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESERVE_BTNActionPerformed(evt);
            }
        });

        PRE_BTN.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        PRE_BTN.setText("이전");
        PRE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRE_BTNActionPerformed(evt);
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SEARCH_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PRE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RESERVE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PAY_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(MENU_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MENU_FEE_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MENU_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MENU_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(MENU_FIELD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(MENU_FEE_FIELD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SEARCH_BTN)
                    .addComponent(SEARCH_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PAY_BTN)
                    .addComponent(RESERVE_BTN)
                    .addComponent(PRE_BTN))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
// 검색 버튼
    private void SEARCH_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCH_BTNActionPerformed
    
        try{
            String search = SEARCH_FIELD.getText();
            dTbl = (DefaultTableModel) CHECKIN_TBL.getModel();
            dTbl.setNumRows(0);
            
            //체크인 목록 검색
            checkArrayList = check.check(search.trim(),2);

            //존재하지않는 고객일 경우
            if(checkArrayList.isEmpty()){
                JOptionPane.showMessageDialog(null, "존재하지 않는 고객입니다.");
                dTbl.setNumRows(0);
            } else{
            //테이블에 검색 목록 출력
                for (Reserve r : checkArrayList){
                    dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                        r.getRoomNum(),
                        r.getName(),
                        r.getPeopleNum()
                        });
                }
            }
            
        } catch(IOException ex){
            Logger.getLogger(RoomService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SEARCH_BTNActionPerformed

    //상단 메뉴바 뒤로가기 버튼
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Dish pre = new Dish(num);
        pre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //상단 메뉴바 종료 버튼
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //메뉴 모달창
    private void MENU_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_BTNActionPerformed
        // TODO add your handling code here:
        MENU_DLG.setVisible(true);
        dTbl = (DefaultTableModel) MENU_TBL.getModel();
            
        //1.restaurant.txt 불러오기
        dishArrayList = DishTextFiles.getRestaurantListTxt();

        //2. 테이블에 목록 출력
        for (Dishtxt r : dishArrayList){
            dTbl.insertRow(dTbl.getRowCount(), new Object[]{
                r.getMenu(),
                r.getFee()
            });
        }
    }//GEN-LAST:event_MENU_BTNActionPerformed

    //메뉴 모달창 확인 버튼
    private void MENU_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_OKActionPerformed
        // TODO add your handling code here: 
        dTbl = (DefaultTableModel) MENU_TBL.getModel();
        
        //textField에 값출력
        int row = MENU_TBL.getSelectedRow();
        MENU_FIELD.setText((String) dTbl.getValueAt(row, 0));
        MENU_FEE_FIELD.setText((String) dTbl.getValueAt(row, 1));
        
        MENU_DLG.dispose();
    }//GEN-LAST:event_MENU_OKActionPerformed

    //예약 및 바로결제
    private void PAY_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAY_BTNActionPerformed
        // TODO add your handling code here:
        
        dTbl = (DefaultTableModel) CHECKIN_TBL.getModel();
        int row = -1;
        row = CHECKIN_TBL.getSelectedRow();
        
         if(row == -1){
            JOptionPane.showMessageDialog(null, "예약할 객실을 선택해주십시오");
        }else{
            String roomIdx = (String) dTbl.getValueAt(row, 0);
            String name = (String) dTbl.getValueAt(row, 1);
            String peopleNum = (String) dTbl.getValueAt(row, 2);
            String menu = MENU_FIELD.getText();
            String menuFee = MENU_FEE_FIELD.getText();
            String payFee = menuFee;  //체크아웃시 결제
        
            if (menu.equals("")| menuFee.equals("")){
                JOptionPane.showMessageDialog(null, "이용할 메뉴를 선택해주십시오.");
            } else{
                //txt에 저장
                String[] dishCustomer = { roomIdx, name, peopleNum, menu, menuFee, payFee };
                DishTextFiles.setDishCustomerListTxt(dishCustomer);
                
                //결제창 이동 init
                PAY_MENU_FIELD.setText(menu);
                PAY_FEE_FIELD.setText(menuFee);
                ButtonGroup pay = new ButtonGroup();
                pay.add(CACH_PAY);
                pay.add(CARD_PAY);
                CARD_PAY.setSelected(true);
                PAY_DLG.setVisible(true);
            }
         }
    }//GEN-LAST:event_PAY_BTNActionPerformed

    //예약만
    private void RESERVE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESERVE_BTNActionPerformed
        // TODO add your handling code here:
        dTbl = (DefaultTableModel) CHECKIN_TBL.getModel();
        int row = -1;
        row = CHECKIN_TBL.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(null, "예약할 객실을 선택해주십시오");
        }else{
            String roomIdx = (String) dTbl.getValueAt(row, 0);
            String name = (String) dTbl.getValueAt(row, 1);
            String peopleNum = (String) dTbl.getValueAt(row, 2);
            String menu = MENU_FIELD.getText();
            String menuFee = MENU_FEE_FIELD.getText();
            String payFee = menuFee;  //체크아웃시 결제
        
            if (menu.equals("")| menuFee.equals("")){
                JOptionPane.showMessageDialog(null, "이용할 메뉴를 선택해주십시오.");
            } else{
                //txt에 저장
                String[] dishCustomer = { roomIdx, name, peopleNum, menu, menuFee, payFee };
                DishTextFiles.setDishCustomerListTxt(dishCustomer);
        
                //예약완료창
                JOptionPane.showMessageDialog(null, "예약 되었습니다.");
                dTbl.setNumRows(0);
                MENU_DLG.dispose();
            }
        }
    }//GEN-LAST:event_RESERVE_BTNActionPerformed

    private void PAY_OK_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAY_OK_BTNActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "결제 완료되었습니다.");
        PAY_DLG.dispose();
    }//GEN-LAST:event_PAY_OK_BTNActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void PRE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRE_BTNActionPerformed
        // TODO add your handling code here:
        new Dish(num).setVisible(true);
        dispose();
    }//GEN-LAST:event_PRE_BTNActionPerformed

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
                new Restaurant(2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CACH_PAY;
    private javax.swing.JRadioButton CARD_PAY;
    private javax.swing.JTable CHECKIN_TBL;
    private javax.swing.JButton MENU_BTN;
    private javax.swing.JDialog MENU_DLG;
    private javax.swing.JTextField MENU_FEE_FIELD;
    private javax.swing.JTextField MENU_FIELD;
    private javax.swing.JButton MENU_OK;
    private javax.swing.JTable MENU_TBL;
    private javax.swing.JButton PAY_BTN;
    private javax.swing.JDialog PAY_DLG;
    private javax.swing.JTextField PAY_FEE_FIELD;
    private javax.swing.JTextField PAY_MENU_FIELD;
    private javax.swing.JButton PAY_OK_BTN;
    private javax.swing.JButton PRE_BTN;
    private javax.swing.JButton RESERVE_BTN;
    private javax.swing.JButton SEARCH_BTN;
    private javax.swing.JTextField SEARCH_FIELD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
