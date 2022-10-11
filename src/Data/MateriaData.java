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
import pruebaappulp.Materia;

/**
 *
 * @author Fermin
 */
public class MateriaData {
    //atributes
    private Connection con = null;

    //constructor

    public MateriaData() {
        this.con = Conexion.getConexion();
    }
    

    //methods
    public void guardarMateria(Materia m) {
        String query = "INSERT INTO materia(nombre,anio,estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                m.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, materia no guardada");
        }
    }

    public Materia buscarMateria(int idMateria) {
        Materia m = null;
        String query = "SELECT * FROM materia WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!!");
        }
        return m;
    }

    public List<Materia> listarMaterias() {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = true";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materia");
        }
        return listaMaterias;
    }
    
    public List<Materia> listarTodasLasMaterias() {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        String query = "SELECT * FROM materia";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materia");
        }
        return listaMaterias;
    }

    public void actualizarMateria(Materia m) {
        String query = "UPDATE materia SET nombre = ?, anio = ?, estado = ? WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(4, m.getIdMateria());
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isEstado());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Materia actualizada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el materia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Materia");
        }
    }

    public void borrarMateria(int m) {
        String sql = "UPDATE materia SET estado = false WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,m);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Materia Eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se realizaron cambios");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desactivar Materia");
        }
    }
}
