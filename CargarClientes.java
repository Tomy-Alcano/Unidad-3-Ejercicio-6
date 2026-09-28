import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CargarClientes {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Clientes");
            ventana.setSize(700, 400);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);

            String[] columnas = {"Id", "Nombre", "Telefono", "Email"};

            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

            JTable tabla = new JTable(modelo);

            JScrollPane scroll = new JScrollPane(tabla);

            JButton btnCargar = new JButton("Cargar Clientes");

            JLabel lblCantidad = new JLabel("Registros cargados: 0");

            btnCargar.addActionListener(e -> {

                modelo.setRowCount(0);

                try (
                        Connection con = Conexion.conectar();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM clientes")
                ) {
                    int contador = 0;
                    while (rs.next()) {
                        modelo.addRow(
                                new Object[]{
                                        rs.getInt("id"),
                                        rs.getString("nombre"),
                                        rs.getString("email"),
                                        rs.getString("telefono")
                                });

                        contador++;
                    }
                    lblCantidad.setText("registros cargados: " + contador);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ventana, ex.getMessage());
                }
            });

            JPanel panelInferior = new JPanel();

            panelInferior.add(btnCargar);
            panelInferior.add(lblCantidad);

            ventana.add(scroll, BorderLayout.CENTER);

            ventana.add(panelInferior, BorderLayout.SOUTH);

            ventana.setVisible(true);

        });
    }
}
