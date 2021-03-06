/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.tela;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.fachada.FachadaAutor;
import project_poo_ads20181.fachada.FachadaLivro;

/**
 *
 * @author valte
 */
public class TLAutor extends javax.swing.JFrame {
    /**
     * Creates new form TLAutor
     */
    public TLAutor() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        TextId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        alterarAutor = new javax.swing.JButton();
        listarAutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaAutor = new javax.swing.JTable();
        salvaAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Id");

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        alterarAutor.setText("Alterar");
        alterarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAutorActionPerformed(evt);
            }
        });

        listarAutor.setText("listar");
        listarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarAutorActionPerformed(evt);
            }
        });

        TabelaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Autor", "Nome Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaAutor);

        salvaAutor.setText("salvar");
        salvaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alterarAutor)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salvaAutor))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(alterarAutor))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listarAutor)
                    .addComponent(salvaAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Autor a = new Autor();
        a.setId(Integer.parseInt(TextId.getText()));
        FachadaAutor fat = new FachadaAutor();
        try{
            fat.excluirAutor(a);
            JOptionPane.showMessageDialog(this, "Autor excluido com sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        }catch(GeralException e){
            JOptionPane.showMessageDialog(this, "Autor nao excluido","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, "Autor nao excluido","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(this, "erro de conexão,contate o ADM","Mensagem",JOptionPane.INFORMATION_MESSAGE);
            
        }
        try {
            lista();
        } catch (ConexaoException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeralException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void alterarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAutorActionPerformed
      Autor a = new Autor();
        a.setNome(TextNome.getText());
        a.setId(Integer.parseInt(TextId.getText()));
        FachadaAutor fat = new FachadaAutor();
        try{
            fat.alterarAutor(a);
            JOptionPane.showMessageDialog(this, "Autor Alterado com sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        }catch(GeralException e){
            JOptionPane.showMessageDialog(this, "Autor nao alterado","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, "erro de conexão, contate o ADM","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        } 
        try {
            lista();
        } catch (ConexaoException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeralException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alterarAutorActionPerformed

    private void listarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarAutorActionPerformed
        try {
            lista();
        } catch (ConexaoException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeralException ex) {
            Logger.getLogger(TLAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarAutorActionPerformed

    private void salvaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaAutorActionPerformed
        Autor a = new Autor();
        a.setNome(TextNome.getText());
        FachadaAutor fat = new FachadaAutor();
        try{
        fat.salvarAutor(a);
        JOptionPane.showMessageDialog(this, "Autor salvo com sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        }catch(GeralException e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Mensagem",JOptionPane.ERROR_MESSAGE);
        } catch (DAOException ex) {
            
        }
    }//GEN-LAST:event_salvaAutorActionPerformed
     private void lista() throws ConexaoException, DAOException, GeralException{
        FachadaAutor fat = new FachadaAutor(); //CRIAR A INSTANCIA DA FACHADA
        DefaultTableModel modelo = new DefaultTableModel(); // INSTANCIA O OBJETO PADRÃO DE TABELA - ADICIONE A IMPORTAÇÃO
        ArrayList<Autor> lista = new ArrayList(); // CRIA UMA LISTA, DE ARRAYLIST DE LIVRO
        try {  
            lista = fat.listarAutor(); // BUSCA OS DADOS DO BANCO PARA A LISTA
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error ao listar :" + ex);
        }
        
       modelo = (DefaultTableModel) TabelaAutor.getModel(); // CHECA O JTABLE PARA RECEBER OS DADOS
        if(modelo.getRowCount() > 0){  //se existir linha 
            modelo.setRowCount(0); // apaga todas as linhas
        }
        for (Autor a : fat.listarAutor()) { 
            modelo.addRow(new Object[]{ 
                a.getId(),a.getNome()
            });
        } // TRAS AS INFORMAÇÕES NA TABELA COM OS DADOS SOLICITADOS.
     }  
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
            java.util.logging.Logger.getLogger(TLAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TLAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TLAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TLAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TLAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaAutor;
    private javax.swing.JTextField TextId;
    private javax.swing.JTextField TextNome;
    private javax.swing.JButton alterarAutor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarAutor;
    private javax.swing.JButton salvaAutor;
    // End of variables declaration//GEN-END:variables
}
