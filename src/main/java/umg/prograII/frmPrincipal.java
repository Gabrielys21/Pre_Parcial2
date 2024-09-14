package umg.prograII;

import java.time.LocalDate;
import DataBase.Model.Dato;
import DataBase.Service.DatoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;

public class frmPrincipal extends JFrame {
    private DatoService datoService = new DatoService();
    private JLabel lblCodigo;
    private JPanel frmPrincipal;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDepa;
    private JLabel lblFechaNac;
    private JTextField textFieldCodigo;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldDepa;
    private JTextField textFieldFehaNac;
    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;

    public frmPrincipal() {
        setTitle("Gestor de Datos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); lblCodigo = new JLabel("Código:");
        textFieldCodigo = new JTextField();
        lblNombre = new JLabel("Nombre:");
        textFieldNombre = new JTextField();
        lblApellido = new JLabel("Apellido:");
        textFieldApellido = new JTextField();
        lblDepa = new JLabel("Departamento:");
        textFieldDepa = new JTextField();
        lblFechaNac = new JLabel("Fecha de Nacimiento (yyyy-MM-dd):");
        textFieldFehaNac = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnListar = new JButton("Listar");

        // Agregar componentes al frame
        add(lblCodigo);
        add(textFieldCodigo);
        add(lblNombre);
        add(textFieldNombre);
        add(lblApellido);
        add(textFieldApellido);
        add(lblDepa);
        add(textFieldDepa);
        add(lblFechaNac);
        add(textFieldFehaNac);
        add(btnGuardar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnBuscar);
        add(btnListar);

        // Initialize components (you should add the actual component initialization and layout setup here)

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Convertir y obtener los datos del formulario
                    int codigo = Integer.parseInt(textFieldCodigo.getText());
                    String nombre = textFieldNombre.getText();
                    String apellido = textFieldApellido.getText();
                    String departamento = textFieldDepa.getText();

                    // Convertir la fecha usando LocalDate
                    String fechaTexto = textFieldFehaNac.getText();
                    LocalDate fechaNacimiento = LocalDate.parse(fechaTexto); // Asume formato yyyy-MM-dd

                    // Crear el objeto Dato
                    Dato dato = new Dato(codigo, nombre, apellido, departamento, fechaNacimiento);

                    // Guardar el dato usando DatoService
                    datoService.guardarDato(dato);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Dato guardado exitosamente");

                    // Limpiar los campos del formulario
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    // Manejar error en la conversión de código a int
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error: el código debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    // Manejar error en la conversión de la fecha
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error: la fecha debe estar en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    // Manejar otros errores generales
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to frame and set layout here
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los datos del formulario
                    String codigoText = textFieldCodigo.getText();
                    String nombre = textFieldNombre.getText();
                    String apellido = textFieldApellido.getText();
                    String departamento = textFieldDepa.getText();

                    // Convertir el código a int
                    int codigo = Integer.parseInt(codigoText);

                    // Convertir la fecha usando LocalDate
                    String fechaTexto = textFieldFehaNac.getText();
                    LocalDate fechaNacimiento = LocalDate.parse(fechaTexto); // Asume formato yyyy-MM-dd

                    // Crear el objeto Dato
                    Dato dato = new Dato(codigo, nombre, apellido, departamento, fechaNacimiento);

                    // Actualizar el dato usando DatoService
                    datoService.actualizarDato(dato);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(frmPrincipal, "Dato actualizado exitosamente");

                    // Limpiar los campos del formulario (opcional)
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    // Manejar error en la conversión de código a int
                    JOptionPane.showMessageDialog(frmPrincipal, "Error: el código debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    // Manejar error en la conversión de la fecha
                    JOptionPane.showMessageDialog(frmPrincipal, "Error: la fecha debe estar en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    // Manejar otros errores generales
                    JOptionPane.showMessageDialog(frmPrincipal, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el código desde el formulario
                    int codigo = Integer.parseInt(textFieldCodigo.getText());

                    // Eliminar el dato usando DatoService
                    datoService.eliminarDato(codigo);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Dato eliminado exitosamente");

                    // Limpiar los campos del formulario
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    // Manejar error en la conversión de código a int
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error: el código debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    // Manejar otros errores generales
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el código desde el formulario
                    int codigo = Integer.parseInt(textFieldCodigo.getText());

                    // Buscar el dato usando DatoService
                    Dato dato = datoService.buscarDatoPorCodigo(codigo);

                    if (dato != null) {
                        // Mostrar los datos en el formulario
                        textFieldNombre.setText(dato.getNombre());
                        textFieldApellido.setText(dato.getApellido());
                        textFieldDepa.setText(dato.getDepartamento());
                        textFieldFehaNac.setText(dato.getFechaNacimiento().toString());
                    } else {
                        // Mostrar mensaje de que no se encontró el dato
                        JOptionPane.showMessageDialog(frmPrincipal.this, "Dato no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    // Manejar error en la conversión de código a int
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error: el código debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    // Manejar otros errores generales
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error al buscar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener todos los datos usando DatoService
                    java.util.List<Dato> datos = datoService.listarTodosDatos();

                    // Crear un StringBuilder para mostrar los datos en un formato adecuado
                    StringBuilder sb = new StringBuilder();
                    for (Dato dato : datos) {
                        sb.append("Código: ").append(dato.getCodigo())
                                .append(", Nombre: ").append(dato.getNombre())
                                .append(", Apellido: ").append(dato.getApellido())
                                .append(", Departamento: ").append(dato.getDepartamento())
                                .append(", Fecha Nacimiento: ").append(dato.getFechaNacimiento())
                                .append("\n");
                    }

                    // Mostrar los datos en un cuadro de diálogo
                    JOptionPane.showMessageDialog(frmPrincipal.this, sb.toString(), "Listado de Datos", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    // Manejar errores generales
                    JOptionPane.showMessageDialog(frmPrincipal.this, "Error al listar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        textFieldCodigo.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldDepa.setText("");
        textFieldFehaNac.setText("");
    }
}

