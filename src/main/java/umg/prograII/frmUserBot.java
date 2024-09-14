package umg.prograII;

import DataBase.Model.Usuario;
import DataBase.Service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class frmUserBot extends JFrame {
    private UsuarioService usuarioService = new UsuarioService();

    private JTextField textFieldId;
    private JTextField textFieldCarne;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JTextField textFieldSeccion;
    private JTextField textFieldTelegramId;
    private JTextField textFieldActivo;
    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;

    public frmUserBot() {
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Inicializar componentes
        textFieldId = new JTextField();
        textFieldCarne = new JTextField();
        textFieldNombre = new JTextField();
        textFieldCorreo = new JTextField();
        textFieldSeccion = new JTextField();
        textFieldTelegramId = new JTextField();
        textFieldActivo = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        // Agregar componentes al frame
        add(new JLabel("ID Usuario:"));
        add(textFieldId);
        add(new JLabel("Carne:"));
        add(textFieldCarne);
        add(new JLabel("Nombre:"));
        add(textFieldNombre);
        add(new JLabel("Correo:"));
        add(textFieldCorreo);
        add(new JLabel("Sección:"));
        add(textFieldSeccion);
        add(new JLabel("Telegram ID:"));
        add(textFieldTelegramId);
        add(new JLabel("Activo:"));
        add(textFieldActivo);
        add(btnGuardar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnBuscar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = new Usuario(
                            0, // ID se establece en la base de datos automáticamente
                            textFieldCarne.getText(),
                            textFieldNombre.getText(),
                            textFieldCorreo.getText(),
                            textFieldSeccion.getText(),
                            Long.parseLong(textFieldTelegramId.getText()),
                            textFieldActivo.getText()
                    );
                    usuarioService.guardarUsuario(usuario);
                    JOptionPane.showMessageDialog(frmUserBot.this, "Usuario guardado exitosamente");
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error: el Telegram ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del botón Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = new Usuario(
                            Integer.parseInt(textFieldId.getText()),
                            textFieldCarne.getText(),
                            textFieldNombre.getText(),
                            textFieldCorreo.getText(),
                            textFieldSeccion.getText(),
                            Long.parseLong(textFieldTelegramId.getText()),
                            textFieldActivo.getText()
                    );
                    usuarioService.actualizarUsuario(usuario);
                    JOptionPane.showMessageDialog(frmUserBot.this, "Usuario actualizado exitosamente");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error: el ID y el Telegram ID deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del botón Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(textFieldId.getText());
                    usuarioService.eliminarUsuario(idUsuario);
                    JOptionPane.showMessageDialog(frmUserBot.this, "Usuario eliminado exitosamente");
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error: el ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(textFieldId.getText());
                    Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);

                    if (usuario != null) {
                        textFieldCarne.setText(usuario.getCarne());
                        textFieldNombre.setText(usuario.getNombre());
                        textFieldCorreo.setText(usuario.getCorreo());
                        textFieldSeccion.setText(usuario.getSeccion());
                        textFieldTelegramId.setText(String.valueOf(usuario.getTelegramId()));
                        textFieldActivo.setText(usuario.getActivo());
                    } else {
                        JOptionPane.showMessageDialog(frmUserBot.this, "Usuario no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error: el ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frmUserBot.this, "Error al buscar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        textFieldId.setText("");
        textFieldCarne.setText("");
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        textFieldSeccion.setText("");
        textFieldTelegramId.setText("");
        textFieldActivo.setText("");
    }
//    public static void main(String[] args) {
//        new frmUserBot();  // Crear y mostrar el formulario
//    }
}
