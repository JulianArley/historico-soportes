/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Soporte 2
 */
public class ConsSoporteInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsSoporteInternalFrame
     */
    
    private controlador.GestorSoporteControl gestorSoporteControl;
    private DefaultTableModel tab;
    
    public ConsSoporteInternalFrame() {
        initComponents();
        
        gestorSoporteControl=new controlador.GestorSoporteControl(this);
        String titTbl[]={"Identificador","Descripcion","Usuario","Dependencia","Tipo","Soporte fecha","Hora soporte","Identificacion tecnico","Nombre tecnico","Apellido tecnico","Id Dependencia","Id tecnico","Estado"};
        tab=new DefaultTableModel(null,titTbl);
        consTbl.setModel(tab);
        buscarBtn.addActionListener(gestorSoporteControl);
    }
    
    public DefaultTableModel getTableModel(){
        return tab;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        usuarioOpt = new javax.swing.JRadioButton();
        fechaOpt = new javax.swing.JRadioButton();
        tipoOpt = new javax.swing.JRadioButton();
        tecnologoOpt = new javax.swing.JRadioButton();
        valor = new javax.swing.JTextField();
        dateValor = new com.toedter.calendar.JDateChooser();
        buscarBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consTbl = new javax.swing.JTable();
        lbImage = new javax.swing.JLabel();
        todoOpt = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Consultar Soportes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(usuarioOpt);
        usuarioOpt.setText("Dependencia");
        getContentPane().add(usuarioOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, -1));

        buttonGroup1.add(fechaOpt);
        fechaOpt.setText("Fecha");
        getContentPane().add(fechaOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 70, -1));

        buttonGroup1.add(tipoOpt);
        tipoOpt.setText("Tipo");
        getContentPane().add(tipoOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 60, -1));

        buttonGroup1.add(tecnologoOpt);
        tecnologoOpt.setText("Tecnico");
        getContentPane().add(tecnologoOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 100, -1));

        valor.setAlignmentX(1.0F);
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 200, 32));

        dateValor.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dateValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 200, 32));

        buscarBtn.setText("Buscar");
        getContentPane().add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 130, -1));

        consTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        consTbl.setShowGrid(false);
        jScrollPane2.setViewportView(consTbl);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1140, 190));
        getContentPane().add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 100));

        buttonGroup1.add(todoOpt);
        todoOpt.setText("Todo");
        getContentPane().add(todoOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 1150, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscarBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JTable consTbl;
    public com.toedter.calendar.JDateChooser dateValor;
    public javax.swing.JRadioButton fechaOpt;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JLabel lbImage;
    public javax.swing.JRadioButton tecnologoOpt;
    public javax.swing.JRadioButton tipoOpt;
    public javax.swing.JRadioButton todoOpt;
    public javax.swing.JRadioButton usuarioOpt;
    public javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
