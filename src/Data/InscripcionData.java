/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pruebaappulp.Alumno;
import pruebaappulp.Inscripcion;
import pruebaappulp.Materia;

/**
 *
 * @author Fermin
 */
public class InscripcionData {

    private Connection con;
    private AlumnoData ad;
    private MateriaData md;

    public InscripcionData() {
        this.con = Conexion.getConexion();
        ad = new AlumnoData();
        md = new MateriaData();
    }
    

    public void guardarInscripcion(Inscripcion i) {
        try {
            String sql = "INSERT INTO inscripcion(idAlumno, idMateria, nota, estado) VALUES ( ?, ?, ?, ?)                                                               ";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, i.getAlumno().getIdAlumno());
            ps.setInt(2, i.getMateria().getIdMateria());
            ps.setDouble(3, i.getNota());
            ps.setBoolean(4, i.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                i.setIdInscripcion(rs.getInt(1));
                
                JOptionPane.showMessageDialog(null, "Inscripcion agregada con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al realizar inscripcion" + ex);
        }
    }

    public void borrarInscripcion(int idAlumno,int idMateria) {
        try {
            String sql = "UPDATE inscripcion SET estado = false WHERE inscripcion.idAlumno = ? AND inscripcion.idMateria = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se desinscribio al Alumno de la Materia exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo desinscribir al Alumno");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR en Base de Datos" + ex);
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> listaInscripcion = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion WHERE estado = true";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno a = ad.buscarAlumno(rs.getInt("idAlumno"));
                i.setAlumno(a);
                Materia m = md.buscarMateria(rs.getInt("idMateria"));
                i.setMateria(m);
                i.setNota(rs.getDouble("nota"));
                i.setEstado(rs.getBoolean("estado"));

                listaInscripcion.add(i);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones" + ex);
        }
        return listaInscripcion;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> listaMaterias = new ArrayList<>();

        try {
            String sql = "SELECT materia.idMateria, materia.nombre, anio, materia.estado\n" +
"                     FROM materia, inscripcion\n" +
"                     WHERE materia.estado = true\n" +
"                     AND materia.idMateria = inscripcion.idMateria\n" +
"                     AND materia.estado = true \n" +
"                     AND inscripcion.idAlumno = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();

                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Materias Cursadas" + ex);
        }
        return listaMaterias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> listaMaterias = new ArrayList<>();

        try {
            String sql = "SELECT * \n"
                    + "FROM materia \n"
                    + "WHERE materia.estado = true\n"
                    + "AND idMateria NOT IN (SELECT materia.idMateria\n"
                    + "FROM materia, inscripcion\n"
                    + "WHERE materia.idMateria = inscripcion.idMateria\n"
                    + "AND inscripcion.estado = true\n"
                    + "AND inscripcion.idAlumno = ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();

                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Materias no Cursadas" + ex);
        }
        return listaMaterias;
    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try {

            String sql = "SELECT inscripcion.idAlumno FROM inscripcion WHERE inscripcion.estado = true AND inscripcion.idMateria = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();

                a = ad.buscarAlumno(rs.getInt(idMateria));

                listaAlumnos.add(a);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Alumnos" + ex);
        }

        return listaAlumnos;

    }

    public void actualizarNota(double nota,int idAlumno, int idMateria ) {
        try {
            String sql = "UPDATE inscripcion SET nota = ? WHERE inscripcion.idAlumno= ? AND inscripcion.idMateria = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede actualizar la Nota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la Nota" + ex);
        }
    }
}
