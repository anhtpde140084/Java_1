/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawword;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import javax.swing.JColorChooser;

/**
 *
 * @author tranp
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    Graphics g = null;
    Color color = null;
    Font font = null;
    int fontStyle = Font.PLAIN;
    int fontSize = 15;
    String fontName = Font.SANS_SERIF;
    String drawnText = "";

    public MainFrame() {
        initComponents();
        this.setSize(900, 400);
        loadFonts();
        g = this.pDraw.getGraphics();
        color = Color.BLACK;
        g.setColor(color);
        font = new Font(fontName, fontStyle, fontSize);
        this.showFontProperties();
    }

    private void loadFonts() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = env.getAllFonts();
        // load fonts to combobox cbFont
        this.cbFont.removeAllItems();
        String fName;
        for (Font font1 : fonts) {
            fName = font1.getFontName();
            this.cbFont.addItem(fName);
        }
    }

    private void showFontProperties() {
        txtProperties.setText("");
        txtProperties.append("Family: " + font.getFamily() + "\n");
        txtProperties.append("Name: " + font.getName() + "\n");
        txtProperties.append("Style: " + font.getStyle() + "\n");
        txtProperties.append("Size: " + font.getSize() + "\n");
        if (g != null) {
            FontMetrics fm = g.getFontMetrics();
            txtProperties.append("\nFont metrics: \n");
            txtProperties.append("Ascent: " + fm.getAscent() + "\n");
            txtProperties.append("Max. Ascent: " + fm.getMaxAscent() + "\n");
            txtProperties.append("Descent: " + fm.getDescent() + "\n");
            txtProperties.append("Leading: " + fm.getLeading() + "\n");
            txtProperties.append("Height: " + fm.getHeight() + "\n");
            txtProperties.append("Max. advance: " + fm.getMaxAdvance() + "\n");
            if (drawnText.length() > 0) {
                txtProperties.append("String width: " + fm.stringWidth(drawnText) + "\n");
            }
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

        jPanel1 = new javax.swing.JPanel();
        lbColor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnColor = new javax.swing.JButton();
        cbFont = new javax.swing.JComboBox<>();
        txtSize = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbFonStyle = new javax.swing.JComboBox<>();
        txt1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProperties = new javax.swing.JTextArea();
        pDraw = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 51))); // NOI18N

        lbColor.setBackground(new java.awt.Color(0, 0, 0));
        lbColor.setOpaque(true);

        jLabel1.setText("Font:");

        btnColor.setText("Choose Color");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });

        cbFont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontActionPerformed(evt);
            }
        });

        txtSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSizeFocusLost(evt);
            }
        });
        txtSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSizeActionPerformed(evt);
            }
        });

        jLabel2.setText("Size:");

        jLabel3.setText("Style");

        jLabel4.setText("Drawn Text");

        cbFonStyle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLAIN", "ITALIC", "BOLD" }));
        cbFonStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFonStyleActionPerformed(evt);
            }
        });

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFonStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFonStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Font Properties", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N

        txtProperties.setColumns(20);
        txtProperties.setRows(5);
        jScrollPane1.setViewportView(txtProperties);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_END);

        pDraw.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Click mouse to draw text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 204, 204))); // NOI18N
        pDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pDrawMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pDrawLayout = new javax.swing.GroupLayout(pDraw);
        pDraw.setLayout(pDrawLayout);
        pDrawLayout.setHorizontalGroup(
            pDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );
        pDrawLayout.setVerticalGroup(
            pDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        jPanel2.add(pDraw, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        // TODO add your handling code here:
        Color newColor = JColorChooser.showDialog(this, "Choose a color", color);
        if (newColor != null) {
            color = newColor;
        }
        lbColor.setBackground(color);
    }//GEN-LAST:event_btnColorActionPerformed

    private void cbFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontActionPerformed
        // TODO add your handling code here:
        this.fontName = ((String) cbFont.getSelectedItem());
        font = new Font(fontName, fontStyle, fontSize);
        this.showFontProperties();
    }//GEN-LAST:event_cbFontActionPerformed

    private void cbFonStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFonStyleActionPerformed
        // TODO add your handling code here:
        String str = (String) (cbFonStyle.getSelectedItem());
        if (str.equalsIgnoreCase("Bold")) {
            fontStyle = Font.BOLD;
        } else if (str.equalsIgnoreCase("Italic")) {
            fontStyle = Font.ITALIC;
        } else {
            fontStyle = Font.PLAIN;
        }
    }//GEN-LAST:event_cbFonStyleActionPerformed

    private void txtSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSizeActionPerformed
        // TODO add your handling code here:
        fontSize = Integer.parseInt(txtSize.getText());
        font = new Font(fontName, fontStyle, fontSize);
        g.setFont(font);
        this.showFontProperties();
    }//GEN-LAST:event_txtSizeActionPerformed

    private void txtSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSizeFocusLost
        // TODO add your handling code here:
        fontSize = Integer.parseInt(txtSize.getText());
        font = new Font(fontName, fontStyle, fontSize);
        g.setFont(font);
        this.showFontProperties();
    }//GEN-LAST:event_txtSizeFocusLost

    private void pDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pDrawMouseClicked
        // TODO add your handling code here:
        int x = evt.getX();
        int y = evt.getY();
        g.setFont(font);
        g.setColor(color);
        drawnText = txt1.getText();
        g.drawString(drawnText, x, y);
        showFontProperties();
    }//GEN-LAST:event_pDrawMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pDraw.removeAll();
        pDraw.revalidate();
        pDraw.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColor;
    private javax.swing.JComboBox<String> cbFonStyle;
    private javax.swing.JComboBox<String> cbFont;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbColor;
    private javax.swing.JPanel pDraw;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextArea txtProperties;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
