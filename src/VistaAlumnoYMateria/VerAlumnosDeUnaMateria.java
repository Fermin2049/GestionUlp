/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaAlumnoYMateria;

import Data.AlumnoData;
import Data.InscripcionData;
import Data.MateriaData;
import pruebaappulp.Alumno;
import pruebaappulp.Inscripcion;
import pruebaappulp.Materia;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class VerAlumnosDeUnaMateria extends javax.swing.JInternalFrame {

    
    private DefaultTableModel modelo;
    private ArrayList<Inscripcion> listaInscripcion;
    private ArrayList<Materia> listaMateria;
    private ArrayList<Alumno> listaAlumno;

    public VerAlumnosDeUnaMateria() {
        initComponents();
        modelo = new DefaultTableModel();
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id = new InscripcionData();
        
        
        listaInscripcion = (ArrayList) id.obtenerInscripciones();
        listaMateria = (ArrayList) md.listarTodasLasMaterias();
        listaAlumno = (ArrayList) ad.listarTodosLosAlumnos();
        llenarComboMateria();
        cabezeraDeTabla();
        cargarDatosEnLaTabla();
    }

    public void llenarComboMateria() {
        for (Materia m : listaMateria) {
            jComboMateria.addItem(m);
        }
        //jComboMateria.setSelectedIndex(-1);
    }
    

    public void cabezeraDeTabla() {
        ArrayList<Object> columna = new ArrayList<Object>();
        columna.add("ID");
        columna.add("Nombre");
        columna.add("Apellido");
        columna.add("Nota");
        for (Object it : columna) {
            modelo.addColumn(it);
        }
        jTableAlumno.setModel(modelo);

    }

    public void borrarFilasTabla() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void cargarDatosEnLaTabla() {
        borrarFilasTabla();

        Materia mat = (Materia) jComboMateria.getSelectedItem();
        
        for (Inscripcion i : listaInscripcion) {
            if (i.getMateria().getIdMateria() == mat.getIdMateria()) {
                modelo.addRow(new Object[]{i.getAlumno().getIdAlumno(),
                    i.getAlumno().getNombre(),
                    i.getAlumno().getApellido(),
                    i.getNota()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboMateria = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumno = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listado de Alumnos por Materia");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Alumnos por Materia ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Materia:");

        jComboMateria.setToolTipText("Seleccionar Materia.");
        jComboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMateriaActionPerformed(evt);
            }
        });

        jTableAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableAlumno);

        jButtonSalir.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(jComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalir)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMateriaActionPerformed
        // TODO add your handling code here:
        cargarDatosEnLaTabla();
    }//GEN-LAST:event_jComboMateriaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:\
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<Materia> jComboMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableAlumno;
    // End of variables declaration//GEN-END:variables
}
