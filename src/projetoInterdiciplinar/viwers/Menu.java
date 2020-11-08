
package projetoInterdiciplinar.viwers;

import java.awt.Component;
import projetoInterdiciplinar.controler.ControllerMenu;

public class Menu extends javax.swing.JFrame {

    private ControllerMenu controller;
    public Menu() {
        initComponents();
        controller = new ControllerMenu(this);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemConsultar = new javax.swing.JMenuItem();
        itemEditar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        itemAdicionar = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        sobreItem = new javax.swing.JMenuItem();
        creditoItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estoque ");

        desktopPane.setOpaque(false);
        desktopPane.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/BackgroundI.jpg"))); // NOI18N
        desktopPane.add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 700);

        fileMenu.setMnemonic('P');
        fileMenu.setText("Produto");

        itemConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/clipboard.png"))); // NOI18N
        itemConsultar.setMnemonic('c');
        itemConsultar.setText("Consultar");
        itemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarActionPerformed(evt);
            }
        });
        fileMenu.add(itemConsultar);

        itemEditar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/edit.png"))); // NOI18N
        itemEditar.setMnemonic('e');
        itemEditar.setText("Editar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        fileMenu.add(itemEditar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/relatorio (1).png"))); // NOI18N
        jMenuItem1.setMnemonic('R');
        jMenuItem1.setText("Relatorio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('A');
        editMenu.setText("Adicionar");

        itemAdicionar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/add-smartphone.png"))); // NOI18N
        itemAdicionar.setMnemonic('c');
        itemAdicionar.setText("Celular");
        itemAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdicionarActionPerformed(evt);
            }
        });
        editMenu.add(itemAdicionar);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('S');
        helpMenu.setText("Sobre");
        helpMenu.setToolTipText("");

        sobreItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/ponto-de-interrogacao.png"))); // NOI18N
        sobreItem.setMnemonic('c');
        sobreItem.setText("Sobre");
        sobreItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreItemActionPerformed(evt);
            }
        });
        helpMenu.add(sobreItem);

        creditoItem.setMnemonic('a');
        creditoItem.setText("Crédito");
        creditoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditoItemActionPerformed(evt);
            }
        });
        helpMenu.add(creditoItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarActionPerformed
        controller.navegarConsulta();
    }//GEN-LAST:event_itemConsultarActionPerformed

    private void itemAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdicionarActionPerformed
        controller.navergarAdicionar();
    }//GEN-LAST:event_itemAdicionarActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        controller.navegarEditarProduto();
    }//GEN-LAST:event_itemEditarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controller.navegarRelatorio();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void sobreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreItemActionPerformed
        controller.navegarSobre();
    }//GEN-LAST:event_sobreItemActionPerformed

    private void creditoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditoItemActionPerformed
        controller.navegarCreditos();
    }//GEN-LAST:event_creditoItemActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    public void addComponentDesktopPane(Component comp){
        desktopPane.add(comp);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem creditoItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem itemAdicionar;
    private javax.swing.JMenuItem itemConsultar;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem sobreItem;
    // End of variables declaration//GEN-END:variables

}
