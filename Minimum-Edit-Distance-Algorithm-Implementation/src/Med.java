
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author siyar
 */
public class Med extends javax.swing.JFrame {

    /**
     * Creates new form Med
     */
    public Med() {
        initComponents();
        setSize(700,700);
        setLocation(400, 100);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sourceTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        targetTextField = new javax.swing.JTextField();
        find_med_button = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        transactionsLabel = new javax.swing.JLabel();
        timeLabelMed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Source: ");

        jLabel2.setText("Target:");

        find_med_button.setText(" find the MED value");
        find_med_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_med_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(sourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(targetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(find_med_button)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transactionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timeLabelMed, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transactionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(timeLabelMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find_med_button)
                    .addComponent(jLabel2)
                    .addComponent(targetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        HomePage home_page=new HomePage();
        setVisible(false);
        home_page.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void find_med_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_med_buttonActionPerformed
        
        long start = System.currentTimeMillis();
        
        String source = sourceTextField.getText();
        String target = targetTextField.getText();
        
        String[][] med_matrix =new String[source.length() + 2][target.length() + 2];
        
        for (int i = 0; i < source.length() + 2; i++) {
            for (int j = 0; j < target.length() + 2; j++) {
                if(i == 0 && j == 0){
                    med_matrix[i][j] = "";
                }
                else if(i + j == 1){
                    med_matrix[i][j] = "#";
                }
                else if(j == 0){
                    med_matrix[i][j] = String.valueOf(source.charAt(i-2));
                }
                else if(i == 0){
                    med_matrix[i][j] = String.valueOf(target.charAt(j-2));
                }
                else if(j == 1){
                    med_matrix[i][j] = String.valueOf((i-1));
                }
                else if(i == 1){
                    med_matrix[i][j] = String.valueOf((j-1));
                }
                else if(med_matrix[i][0].equals(med_matrix[0][j])){
                    med_matrix[i][j] = med_matrix[i - 1][j - 1];
                }
                else{
                    med_matrix[i][j] = String.valueOf(Math.min(Integer.parseInt(med_matrix[i - 1][j - 1]), Math.min(Integer.parseInt(med_matrix[i - 1][j ]), Integer.parseInt(med_matrix[i][j - 1])))+1);

                }

            }
            
        }

        ArrayList<Integer> row_index_path = new ArrayList();
        ArrayList<Integer> column_index_path = new ArrayList();
        
        ArrayList<String> transactions = new ArrayList();
        
        int k = source.length() + 1;
        int l = target.length() + 1;
        
        while(!(k == 1 && l == 1)){

            row_index_path.add(k);
            column_index_path.add(l);

            int left = 999 ;
            int cross = 999 ;
            int top = 999 ;
            try {
                if(!(k == 1 && l != 1)){
                    
                    top = Integer.parseInt(med_matrix[k-1][l]);
                }

            } catch (NumberFormatException e) {
                
            }
            try {
                cross = Integer.parseInt(med_matrix[k-1][l-1]);
                
            } catch (NumberFormatException e) {
                
            }
            try {
                if(!(l == 1 && k != 1)){
                    left = Integer.parseInt(med_matrix[k][l-1]);
                }
                
                
            } catch (NumberFormatException e) {
                
            }
            
            if(cross <= left && cross <= top ){

                if (!med_matrix[k][0].equals(med_matrix[0][l])) {
                    transactions.add(0,"substitution " + med_matrix[k][0] +" with " + med_matrix[0][l] );
                }
                k--;
                l--;
            }else if(left <= top && left <= cross ){
                transactions.add(0,"insertion " + med_matrix[0][l]);
                l--;
            }else{
                transactions.add(0,"deletion " + med_matrix[k][0]);
                k--;
            }
        }
        
        row_index_path.add(1);
        column_index_path.add(1);
        
        
        String transactions_str = "<html><div style='font-family: Arial, sans-serif; font-size: 14pt; margin: 10px;'>";
        for (int i = 0; i < transactions.size(); i++) {
            transactions_str += "<span style='color: #007bff;'>" + (i + 1) + ".</span> " + transactions.get(i) + "<br>";
        }
        
        transactions_str += "</div></html>";
        

        String matrixText = "<html><table border='1' cellpadding='10' style='font-size: 16pt;'>";
        for (int i = 0; i < med_matrix.length; i++) {
            matrixText += "<tr>";
            for (int j = 0; j < med_matrix[i].length; j++) {
                
                if(row_index_path.get(row_index_path.size() - 1) == i && column_index_path.get(column_index_path.size() - 1) == j ){
                    matrixText += "<td><span style='color: #f00;'>" + med_matrix[i][j] + "</span></td>";
                    row_index_path.remove(row_index_path.size() - 1);
                    column_index_path.remove(column_index_path.size() - 1);
                }
                else{
                    matrixText += "<td>" + med_matrix[i][j] + "</td>";
                }
                
                
            }
            matrixText += "</tr>";
        }
        matrixText += "</table></html>";

        String last = matrixText+transactions_str;
        
        resultLabel.setText(matrixText);
        transactionsLabel.setText(transactions_str);
        
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        timeLabelMed.setText("Process took "+timeElapsed+" millisecond.");

    }//GEN-LAST:event_find_med_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Med().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton find_med_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextField sourceTextField;
    private javax.swing.JTextField targetTextField;
    private javax.swing.JLabel timeLabelMed;
    private javax.swing.JLabel transactionsLabel;
    // End of variables declaration//GEN-END:variables
}