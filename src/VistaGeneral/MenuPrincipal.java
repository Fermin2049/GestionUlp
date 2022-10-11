/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaGeneral;

import Data.AlumnoData;
import VistaAlumnos.editarAlumno;
import VistaAlumnos.eliminarAlumno;
import VistaAlumnos.vistaAgregarAlumno;
import VistaAlumnoYMateria.Calificaciones;
import VistaAlumnoYMateria.alumnosPorMateria;
import VistaAlumnoYMateria.materiaPorAlumnos;
import VistaInscripciones.inscripciones;
import VistaMaterias.agregarMateria;
import VistaMaterias.editarMateria;
import VistaMaterias.eliminarMateria;
import javax.swing.JInternalFrame;


public class MenuPrincipal extends javax.swing.JFrame {



    AlumnoData ad = new AlumnoData();

    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void centrarVentanaInterna(JInternalFrame internalFrame){
        int x= (panelPrincipal.getWidth()/2)- internalFrame.getWidth()/2;
        int y= (panelPrincipal.getHeight()/2)- internalFrame.getHeight()/2;
        if(internalFrame.isShowing()){
            internalFrame.setLocation(x, y);
        }else {
            panelPrincipal.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        panelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiAgregarAlumno = new javax.swing.JMenuItem();
        jmiEditarAlumno = new javax.swing.JMenuItem();
        jmiEliminarAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAgregarMateria = new javax.swing.JMenuItem();
        jmiEditarMateria = new javax.swing.JMenuItem();
        jmiEliminarMateria = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jmiAlumnosXMateria = new javax.swing.JMenuItem();
        jmiMateriaXAlumno = new javax.swing.JMenuItem();
        jmiCalificaciones = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmiInscripciones = new javax.swing.JMenuItem();

        jRadioButtonMenuItem7.setSelected(true);
        jRadioButtonMenuItem7.setText("jRadioButtonMenuItem7");

        jRadioButtonMenuItem8.setSelected(true);
        jRadioButtonMenuItem8.setText("jRadioButtonMenuItem8");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jRadioButtonMenuItem9.setSelected(true);
        jRadioButtonMenuItem9.setText("jRadioButtonMenuItem9");

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jRadioButtonMenuItem4.setSelected(true);
        jRadioButtonMenuItem4.setText("jRadioButtonMenuItem4");

        jMenuItem12.setText("jMenuItem12");

        jMenuItem14.setText("jMenuItem14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setEnabled(false);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumnos");

        jmiAgregarAlumno.setText("Agregar Alumno");
        jmiAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAgregarAlumno);

        jmiEditarAlumno.setText("Editar Alumno");
        jmiEditarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiEditarAlumno);

        jmiEliminarAlumno.setText("Eliminar Alumno");
        jmiEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiEliminarAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materias");

        jmiAgregarMateria.setText("Agregar Materia");
        jmiAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAgregarMateria);

        jmiEditarMateria.setText("Editar Materia");
        jmiEditarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiEditarMateria);

        jmiEliminarMateria.setText("Eliminar Materia");
        jmiEliminarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiEliminarMateria);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Alumno y Materia");

        jmiAlumnosXMateria.setText("Ver los Alumnos de una Materia");
        jmiAlumnosXMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnosXMateriaActionPerformed(evt);
            }
        });
        jMenu8.add(jmiAlumnosXMateria);

        jmiMateriaXAlumno.setText("Ver las Materias de un Alumno");
        jmiMateriaXAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMateriaXAlumnoActionPerformed(evt);
            }
        });
        jMenu8.add(jmiMateriaXAlumno);

        jmiCalificaciones.setText("Calificaciones");
        jmiCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCalificacionesActionPerformed(evt);
            }
        });
        jMenu8.add(jmiCalificaciones);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Inscripciones");

        jmiInscripciones.setText("Inscripciones");
        jmiInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInscripcionesActionPerformed(evt);
            }
        });
        jMenu9.add(jmiInscripciones);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarAlumnoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        vistaAgregarAlumno vent = new vistaAgregarAlumno();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiAgregarAlumnoActionPerformed

    private void jmiEditarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarAlumnoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        editarAlumno vent = new editarAlumno();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiEditarAlumnoActionPerformed

    private void jmiEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarAlumnoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        eliminarAlumno vent = new eliminarAlumno();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiEliminarAlumnoActionPerformed

    private void jmiMateriaXAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMateriaXAlumnoActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        materiaPorAlumnos vent = new materiaPorAlumnos();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiMateriaXAlumnoActionPerformed

    private void jmiEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarMateriaActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        eliminarMateria vent = new eliminarMateria();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiEliminarMateriaActionPerformed

    private void jmiAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarMateriaActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        agregarMateria vent = new agregarMateria();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiAgregarMateriaActionPerformed

    private void jmiEditarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarMateriaActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        editarMateria vent = new editarMateria();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiEditarMateriaActionPerformed

    private void jmiAlumnosXMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnosXMateriaActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        alumnosPorMateria vent = new alumnosPorMateria();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiAlumnosXMateriaActionPerformed

    private void jmiCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCalificacionesActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        Calificaciones vent = new Calificaciones();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiCalificacionesActionPerformed

    private void jmiInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInscripcionesActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
        inscripciones vent = new inscripciones();
        vent.setVisible(true);
        panelPrincipal.add(vent);
        centrarVentanaInterna(vent);
    }//GEN-LAST:event_jmiInscripcionesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem jmiAgregarAlumno;
    private javax.swing.JMenuItem jmiAgregarMateria;
    private javax.swing.JMenuItem jmiAlumnosXMateria;
    private javax.swing.JMenuItem jmiCalificaciones;
    private javax.swing.JMenuItem jmiEditarAlumno;
    private javax.swing.JMenuItem jmiEditarMateria;
    private javax.swing.JMenuItem jmiEliminarAlumno;
    private javax.swing.JMenuItem jmiEliminarMateria;
    private javax.swing.JMenuItem jmiInscripciones;
    private javax.swing.JMenuItem jmiMateriaXAlumno;
    private javax.swing.JDesktopPane panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
