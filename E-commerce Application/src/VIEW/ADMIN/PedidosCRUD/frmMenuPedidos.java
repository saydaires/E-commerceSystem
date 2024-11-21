/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW.ADMIN.PedidosCRUD;

import MODEL.PedidosMODEL;
import SERVICE.PedidosSERVICE;
import VIEW.ADMIN.LoginMenuPrincipal.frmMenuAdmin;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aires
 */
public class frmMenuPedidos extends javax.swing.JFrame {
    List<Integer> idPedidosBuscados = new ArrayList<>();

    /**
     * Creates new form frmMenuPedidos
     */
    public frmMenuPedidos() {
        initComponents();
        setResizable(false);
         DefaultTableModel tableModel = (DefaultTableModel) tablePedidos.getModel();
         tableModel.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane3 = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnRetorno2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnLimparTable = new javax.swing.JButton();
        btnListarPedidos = new javax.swing.JButton();
        spinnerId = new javax.swing.JSpinner();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MENU DE PEDIDOS");

        btnDeletar.setBackground(new java.awt.Color(153, 0, 0));
        btnDeletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletar.setText("DELETAR PEDIDO");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnRetorno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/return.png"))); // NOI18N
        btnRetorno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetorno2ActionPerformed(evt);
            }
        });

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ID Cliente", "Data Pedido", "Status Pedido"
            }
        ));
        jScrollPane5.setViewportView(tablePedidos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID PEDIDO ");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimparTable.setText("LIMPAR TABELA");
        btnLimparTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTableActionPerformed(evt);
            }
        });

        btnListarPedidos.setText("LISTAR PEDIDOS");
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(51, 102, 255));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("ATUALIZAR STATUS");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnDeletar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnRetorno2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnLimparTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnListarPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(spinnerId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btnAtualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLimparTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListarPedidos))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(btnRetorno2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel4)))
                .addContainerGap())
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnRetorno2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnAtualizar))
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparTable)
                    .addComponent(btnListarPedidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Evento de risco! Cuidado");
        this.dispose();
        frmDeletar telaDeletar = new frmDeletar();
        telaDeletar.setVisible(true);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnRetorno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetorno2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmMenuAdmin menuAdmin = new frmMenuAdmin();
        menuAdmin.setVisible(true);
    }//GEN-LAST:event_btnRetorno2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int idPedido = (Integer) spinnerId.getValue();
        PedidosMODEL pedido = PedidosSERVICE.buscarPedido(idPedido);

        if(pedido != null && !idPedidosBuscados.contains(idPedido)) {
            DefaultTableModel tableModel = (DefaultTableModel) tablePedidos.getModel();
            idPedidosBuscados.add(pedido.getIdPedido());
            java.util.Date dataPedido = null;
            try {
                dataPedido = pedido.getDataPedido();
            } catch(ParseException e) {
                JOptionPane.showMessageDialog(null, "Data mal formatada!");
                return;
            }

            Object[] registro = {pedido.getIdPedido(), pedido.getIdCliente(), dataPedido, pedido.getStatusPedido()};
            tableModel.addRow(registro);
        }
        spinnerId.setValue(0);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTableActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tablePedidos.getModel();
        idPedidosBuscados.clear();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_btnLimparTableActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tablePedidos.getModel();
        tableModel.setRowCount(0); // limpar a tabela se ja possuir linhas inseridas
        List<PedidosMODEL> listaPedidos = PedidosSERVICE.listarPedidos();
        for(PedidosMODEL pedido : listaPedidos) {
            idPedidosBuscados.add(pedido.getIdPedido());
            java.sql.Date dataPedido = null;

            try {
                dataPedido = pedido.getDataPedido();
            } catch(ParseException e) {
                JOptionPane.showMessageDialog(null, "Data mal formatada!");
                return;
            }

            Object[] registro = {pedido.getIdPedido(), pedido.getIdCliente(), dataPedido, pedido.getStatusPedido()};
            tableModel.addRow(registro);
        }
    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        this.dispose();
        frmAtualizar telaAtualizar = new frmAtualizar();
        telaAtualizar.setVisible(true);
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLimparTable;
    private javax.swing.JButton btnListarPedidos;
    private javax.swing.JButton btnRetorno2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner spinnerId;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables
}
