package umg.prograII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenu extends JFrame {
    private JLabel lblBienvenida;
    private JTextField textFieldBienvenida;
    private JLabel lblOpcion;
    private JButton btnDatosUsuario;
    private JButton btnCatalogo;
    private JButton btnUsuariosBot;
    private JPanel frmMenu;

    public frmMenu() {
        // Configuración de la ventana
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // 4 filas, 1 columna

        // Inicializar componentes
        lblBienvenida = new JLabel("Bienvenido al sistema");
        textFieldBienvenida = new JTextField("Seleccione una opción:");
        textFieldBienvenida.setEditable(false); // Campo de solo lectura
        lblOpcion = new JLabel("Opciones:");
        btnDatosUsuario = new JButton("Gestionar Datos de Usuario");
        btnCatalogo = new JButton("Ver Catálogo");
        btnUsuariosBot = new JButton("Gestionar Usuarios del Bot");

        // Agregar componentes al frame
        add(lblBienvenida);
        add(textFieldBienvenida);
        add(lblOpcion);
        add(btnDatosUsuario);
        add(btnCatalogo);
        add(btnUsuariosBot);

        // Acción del botón "Datos de Usuario"
        btnDatosUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frmMenu.this, "Cargando Datos");
                new frmPrincipal().setVisible(true);  // Abrir la ventana de gestión de datos
                dispose();  // Cerrar la ventana actual (frmMenu)
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }
}
