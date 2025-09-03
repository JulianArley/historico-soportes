package vista;

import java.awt.Color;
import java.awt.Image;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrincipalJFrame extends javax.swing.JFrame {

    RegTecnologoInternalFrame regPacienteInternalFrame;
    ConsTecnologoInternalFrame consPacienteInternalFrame;
    ElimTecnologoInternalFrame elimPacienteInternalFrame;
    ModiTecnologoInternalFrame modiPacienteInternalFrame;

    ElimSoporteInternalFrame elimSoporteInternalFrame;
    RegSoporteInternalFrame regSoporteInternalFrame;
    ConsSoporteInternalFrame consSoporteInternalFrame;
    ModiSoporteInternalFrame modiSoporteInternalFrame;

    RegDependenciaInternalFrame regDependenciaInternalFrame;
    ElimDependenciaInternalFrame elimDependenciaInternalFrame;
    ModiDependenciaInternalFrame modiDependenciaInternalFrame;
    ConsDependenciaInternalFrame consDependenciaInternalFrame;
    
    ModiCorreoInternalFrame modCor;

    public PrincipalJFrame() {

        regPacienteInternalFrame = new RegTecnologoInternalFrame();
        consPacienteInternalFrame = new ConsTecnologoInternalFrame();
        elimPacienteInternalFrame = new ElimTecnologoInternalFrame();
        modiPacienteInternalFrame = new ModiTecnologoInternalFrame();

        elimSoporteInternalFrame = new ElimSoporteInternalFrame();
        regSoporteInternalFrame = new RegSoporteInternalFrame();
        consSoporteInternalFrame = new ConsSoporteInternalFrame();
        modiSoporteInternalFrame = new ModiSoporteInternalFrame();

        regDependenciaInternalFrame = new RegDependenciaInternalFrame();
        elimDependenciaInternalFrame = new ElimDependenciaInternalFrame();
        modiDependenciaInternalFrame = new ModiDependenciaInternalFrame();
        consDependenciaInternalFrame = new ConsDependenciaInternalFrame();
        
        modCor=new ModiCorreoInternalFrame();

        add(regPacienteInternalFrame);
        add(consPacienteInternalFrame);
        add(elimPacienteInternalFrame);
        add(modiPacienteInternalFrame);

        add(regSoporteInternalFrame);
        add(elimSoporteInternalFrame);
        add(consSoporteInternalFrame);
        add(modiSoporteInternalFrame);

        add(regDependenciaInternalFrame);
        add(elimDependenciaInternalFrame);
        add(modiDependenciaInternalFrame);
        add(consDependenciaInternalFrame);
        
        add(modCor);

        initComponents();

        /*------------------------------------------------------------------Tabla de notificacion-------------------------------------------------------------------*/
        String titTbl[] = {"Identificador", "Descripcion", "Usuario", "Dependencia", "Tipo", "Soporte fecha", "Hora soporte", "Identificacion tecnico", "Nombre tecnico", "Apellido tecnico", "Id Dependencia", "Id tecnico", "Estado"};
        DefaultTableModel tab = (DefaultTableModel) notiTab.getModel();
        tab = new DefaultTableModel(null, titTbl);
        notiTab.setModel(tab);

        /*----------------------------------------------------------------------------------------------------------------------------------------------------------*/
        notificacion.setVisible(false);
        modelo.GestorDatos gd = new modelo.GestorDatos();
        String reg[] = new String[13];
        ArrayList<String> l = new ArrayList<String>();
        l = gd.estadoSoportes();
        
        if (l.size()!=0) {
            notificacion.setVisible(true);
            int tam = l.size();
            int aux = 0;
            for (int i = 0; i < (tam / 13); i++) {
                for (int j = 0; j < 1; j++) {
                    reg[0] = l.get(aux) + "";
                    aux++;
                    reg[1] = l.get(aux) + "";
                    aux++;
                    reg[2] = l.get(aux) + "";
                    aux++;
                    reg[3] = l.get(aux) + "";
                    aux++;
                    reg[4] = l.get(aux) + "";
                    aux++;
                    reg[5] = l.get(aux) + "";
                    aux++;
                    reg[6] = l.get(aux) + "";
                    aux++;
                    reg[7] = l.get(aux) + "";
                    aux++;
                    reg[8] = l.get(aux) + "";
                    aux++;
                    reg[9] = l.get(aux) + "";
                    aux++;
                    reg[10] = l.get(aux) + "";
                    aux++;
                    reg[11] = l.get(aux) + "";
                    aux++;
                    reg[12] = l.get(aux) + "";
                    aux++;
                    tab.addRow(reg);
                    tab.fireTableDataChanged();
                }
            }
        }

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/pollo.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lab.getWidth(),
                lab.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lab.setIcon(iconoEscalado);

        setExtendedState(MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notificacion = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        notiTab = new javax.swing.JTable();
        lab = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTION DE SOPORTES");
        setMinimumSize(getMaximumSize());
        setName("PrincipalJFrame"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notificacion.setClosable(true);
        notificacion.setVisible(true);

        notiTab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(notiTab);

        notificacion.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(notificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 220));
        getContentPane().add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        jMenu1.setText("Archivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Imprimir Soportes Por Tecnico");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Imprimir Tecnicos Registrados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Imprimir Dependencias");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Imprimir Soportes Por Dia");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Generar Excel");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acciones");
        jMenu2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenu2FocusGained(evt);
            }
        });
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu2MouseEntered(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenu7.setText("Tecnicos");

        jMenuItem12.setText("Agregar tecnico");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuItem13.setText("Eliminar tecnico");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setText("Modificar tecnico");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem15.setText("Consultar tecnico");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenu2.add(jMenu7);

        jMenu8.setText("Dependencias");

        jMenuItem16.setText("Agregar dependencia");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenuItem17.setText("Eliminar dependencia");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenuItem18.setText("Modificar dependencia");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem18);

        jMenuItem19.setText("Consultar dependencia");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem19);

        jMenu2.add(jMenu8);

        jMenu5.setText("Soportes");

        jMenuItem7.setText("Crear soporte");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Eliminar soporte");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("Modificar soporte");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("Consultar Soporte");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenu2.add(jMenu5);

        jMenuItem11.setText("Modificar correo de envio");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        reportes.GestorReportes gr = new reportes.GestorReportes();
        gr.ejecutarReporte("report2.jasper");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        regSoporteInternalFrame.setVisible(true);
        regSoporteInternalFrame.jTextField2.setEditable(false);
        regSoporteInternalFrame.correosText.setEditable(false);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(regSoporteInternalFrame.lbImage.getWidth(),
                regSoporteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        regSoporteInternalFrame.lbImage.setIcon(iconoEscalado);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        elimSoporteInternalFrame.setVisible(true);

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(elimSoporteInternalFrame.lbImage.getWidth(),
                elimSoporteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        elimSoporteInternalFrame.lbImage.setIcon(iconoEscalado);


    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        consSoporteInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(consSoporteInternalFrame.lbImage.getWidth(),
                consSoporteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        consSoporteInternalFrame.lbImage.setIcon(iconoEscalado);
        consSoporteInternalFrame.jTextField1.setEditable(false);

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseEntered

    private void jMenu2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenu2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2FocusGained

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        regPacienteInternalFrame.setVisible(true);

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(regPacienteInternalFrame.lbImage.getWidth(),
                regPacienteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        regPacienteInternalFrame.lbImage.setIcon(iconoEscalado);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        elimPacienteInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(elimPacienteInternalFrame.lbImage.getWidth(),
                elimPacienteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        elimPacienteInternalFrame.lbImage.setIcon(iconoEscalado);
        elimPacienteInternalFrame.jTextField1.setEditable(false);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        consPacienteInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(consPacienteInternalFrame.lbImage.getWidth(),
                consPacienteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        consPacienteInternalFrame.jTextField2.setEditable(false);
        consPacienteInternalFrame.lbImage.setIcon(iconoEscalado);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        regDependenciaInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(regDependenciaInternalFrame.lbImage.getWidth(),
                regDependenciaInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        regDependenciaInternalFrame.lbImage.setIcon(iconoEscalado);
        regDependenciaInternalFrame.jTextField1.setEditable(false);

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        elimDependenciaInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(elimDependenciaInternalFrame.lbImage.getWidth(),
                elimDependenciaInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        elimDependenciaInternalFrame.lbImage.setIcon(iconoEscalado);
        elimDependenciaInternalFrame.jTextField1.setEditable(false);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        consDependenciaInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(consDependenciaInternalFrame.lbImage.getWidth(),
                consDependenciaInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        consDependenciaInternalFrame.lbImage.setIcon(iconoEscalado);
        consDependenciaInternalFrame.jTextField1.setEditable(false);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        modiDependenciaInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(modiDependenciaInternalFrame.lbImage.getWidth(),
                modiDependenciaInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        modiDependenciaInternalFrame.lbImage.setIcon(iconoEscalado);
        modiDependenciaInternalFrame.jTextField1.setEditable(false);

    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        modiPacienteInternalFrame.setVisible(true);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(modiPacienteInternalFrame.lbImage.getWidth(),
                modiPacienteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        modiPacienteInternalFrame.lbImage.setIcon(iconoEscalado);
        modiPacienteInternalFrame.jTextField1.setEditable(false);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        modiSoporteInternalFrame.setVisible(true);
        modiSoporteInternalFrame.tipo.setSelectedItem(null);
        modiSoporteInternalFrame.estado.setSelectedItem(null);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/image002.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(modiSoporteInternalFrame.lbImage.getWidth(),
        modiSoporteInternalFrame.lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        modiSoporteInternalFrame.lbImage.setIcon(iconoEscalado);
        modiSoporteInternalFrame.jTextField1.setEditable(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        reportes.GestorReportes gr = new reportes.GestorReportes();
        gr.ejecutarReporte("PacientesReport.jasper");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        reportes.GestorReportes gr = new reportes.GestorReportes();
        gr.ejecutarReporte("report3.jasper");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        reportes.GestorReportes gr = new reportes.GestorReportes();
        gr.ejecutarReporte("reporteFechas.jasper");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        recurso.ExportarDatos e=new recurso.ExportarDatos();
        try{
            e.ExportarInformacion();
        }catch(ClassNotFoundException l){
            l.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        modCor.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    public javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab;
    public javax.swing.JTable notiTab;
    public javax.swing.JInternalFrame notificacion;
    // End of variables declaration//GEN-END:variables
}
