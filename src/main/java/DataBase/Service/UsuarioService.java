package DataBase.Service;


import DataBase.Dao.UsuarioDao;
import DataBase.Model.Usuario;

import java.sql.SQLException;

public class UsuarioService {
    private UsuarioDao usuarioDAO = new UsuarioDao();

    public void guardarUsuario(Usuario usuario) throws SQLException {
        if (usuarioDAO.existeCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya existe");
        }
        usuarioDAO.insertar(usuario);
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.actualizar(usuario);
    }

    public void eliminarUsuario(int idUsuario) throws SQLException {
        usuarioDAO.eliminar(idUsuario);
    }

    public Usuario buscarUsuarioPorId(int idUsuario) throws SQLException {
        return usuarioDAO.buscarPorId(idUsuario);
    }
}
