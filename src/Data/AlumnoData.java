/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pruebaappulp.Alumno;

public class AlumnoData {
    private Connection con;
    
    public AlumnoData() {
        this.con = Conexion.getConexion();
    }

    
    
    public void guardarAlumno(Alumno a){
        String sql="INSERT INTO alumno(nombre, apellido, dni, fechNac, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getDni());
            ps.setDate(4, Date.valueOf(a.getFechNac()));
            ps.setBoolean(5, a.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();//guardar el alumno en la DB
            
        if (rs.next()) {
                a.setIdAlumno(rs.getInt(1));//completo el alumno en java
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, alumno no guardado");
        }
    }
    
    public Alumno buscarAlumno(int idAlumno) {
        Alumno a = null;

        String sql = "SELECT * FROM alumno WHERE idAlumno = ? AND estado = true";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                a = new Alumno();

                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setDni(rs.getInt("dni"));
                a.setFechNac(rs.getDate("fechNac").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "ERROR"+exception.getMessage());
        }
        return a;
    }
    
    public List<Alumno> listarAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumno WHERE estado = true";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setDni(rs.getInt("dni"));
                a.setFechNac(rs.getDate("fechNac").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));

                listaAlumnos.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumno");
        }
        return listaAlumnos;
    }
    
    public List<Alumno> listarTodosLosAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumno";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setDni(rs.getInt("dni"));
                a.setFechNac(rs.getDate("fechNac").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));

                listaAlumnos.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumno");
        }
        return listaAlumnos;
    }

    public void actualizarAlumno(Alumno a) {
        String sql = "UPDATE alumno SET nombre= ?, apellido= ?, dni= ?,fechNac= ?,estado= ? WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getDni());
            ps.setDate(4, Date.valueOf(a.getFechNac()));
            ps.setBoolean(5, a.isEstado());
            ps.setInt(6, a.getIdAlumno());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar alumno");
        }

    }

    public void borrarAlumno(int idAlumno) {
        String sql = "UPDATE alumno SET estado = false WHERE idAlumno = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno Eleminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se realizaron cambios");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desactivar alumno");
        }

    }
    
}
