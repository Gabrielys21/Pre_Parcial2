package DataBase.Service;

import DataBase.Dao.DatoDao;
import DataBase.Model.Dato;

import java.sql.SQLException;
import java.util.List;

public class DatoService {
    private DatoDao datoDAO = new DatoDao();

    public void guardarDato(Dato dato) throws SQLException {
        datoDAO.insertar(dato);
    }

    public void actualizarDato(Dato dato) throws SQLException {
        datoDAO.actualizar(dato);
    }

    public void eliminarDato(int codigo) throws SQLException {
        datoDAO.eliminar(codigo);
    }

    public Dato buscarDatoPorCodigo(int codigo) throws SQLException {
        return datoDAO.buscarPorCodigo(codigo);
    }

    public List<Dato> listarTodosDatos() throws SQLException {
        return datoDAO.listarTodos();
    }
}
