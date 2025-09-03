/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
public class ElimTecnologoInternalFrame extends javax.swing.JInternalFrame {

    
    private controlador.EliminarTecnologoControl eliminarPacientesControl;
    private DefaultTableModel tabla;
    public ElimTecnologoInternalFrame() {
        initComponents();
        eliminarPacientesControl=new controlador.EliminarTecnologoControl(this);
        String titulosTabla[]={"Identificacion","Nombres","Apellidos","Fecha Nac","Sexo"};
        tabla = new DefaultTableModel(null,titulosTabla);
        ResultadosTbl.setModel(tabla);
        EliminarBtn.addActionListener(eliminarPacientesControl);
    }
    public DefaultTableModel getTableModel(){
        return tabla;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        IdentificacionOpt = new javax.swing.JRadioButton();
        NombresOpt = new javax.swing.JRadioButton();
        ApellidosOpt = new javax.swing.JRadioButton();
        ValorTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        EliminarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultadosTbl = new javax.swing.JTable();
        lbImage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Eliminar Tecnico");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(IdentificacionOpt);
        IdentificacionOpt.setText("Identificacion");
        getContentPane().add(IdentificacionOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 232, -1, -1));

        buttonGroup1.add(NombresOpt);
        NombresOpt.setText("Nombres");
        getContentPane().add(NombresOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 232, -1, -1));

        buttonGroup1.add(ApellidosOpt);
        ApellidosOpt.setText("Apellidos");
        getContentPane().add(ApellidosOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 232, -1, -1));

        ValorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorTxtActionPerformed(evt);
            }
        });
        getContentPane().add(ValorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 263, 141, -1));

        jLabel1.setText("Valor a eliminar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 266, -1, -1));

        EliminarBtn.setText("Eliminar");
        getContentPane().add(EliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        ResultadosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ResultadosTbl.setFocusable(false);
        jScrollPane1.setViewportView(ResultadosTbl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 430, 203));
        getContentPane().add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 70, 60));

        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -16, 430, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ValorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton ApellidosOpt;
    public javax.swing.JButton EliminarBtn;
    public javax.swing.JRadioButton IdentificacionOpt;
    public javax.swing.JRadioButton NombresOpt;
    public javax.swing.JTable ResultadosTbl;
    public javax.swing.JTextField ValorTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JLabel lbImage;
    // End of variables declaration//GEN-END:variables
}
