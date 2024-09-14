package umg.prograII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmUser extends JFrame {
    private JLabel lblUser;
    private JTextField textFieldUser;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JPasswordField passwordFieldPassword;
    private JPanel frmUser;

    public frmUser() {
        // Configuración de la ventana
        setTitle("Acceso al Sistema");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Inicializar componentes
        lblUser = new JLabel("Usuario:");
        textFieldUser = new JTextField();
        lblPassword = new JLabel("Contraseña:");
        passwordFieldPassword = new JPasswordField();
        btnLogin = new JButton("Login");

        // Añadir los componentes a la ventana
        add(lblUser);               // Etiqueta Usuario
        add(textFieldUser);          // Campo de texto para el usuario
        add(lblPassword);            // Etiqueta Contraseña
        add(passwordFieldPassword);  // Campo de contraseña
        add(new JLabel());           // Espacio vacío (para que el layout cuadre)
        add(btnLogin);               // Botón de Login

        // Acción al presionar el botón "Login"
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String User = textFieldUser.getText();
                String Password = new String(passwordFieldPassword.getPassword());

                if ("Chava".equals(User) && "2004".equals(Password)) {
                    JOptionPane.showMessageDialog(frmUser.this, "Acceso concedido");
                    frmMenu menu = new frmMenu();
                    menu.setVisible(true);
                    dispose();  // Cierra la ventana actual
                } else {
                    JOptionPane.showMessageDialog(frmUser.this, "Usuario o Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);  // Hacer visible la ventana
    }

    public static void main(String[] args) {
        new frmUser();  // Crear y mostrar el formulario
    }
}

