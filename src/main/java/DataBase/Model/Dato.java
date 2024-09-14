package DataBase.Model;

import java.time.LocalDate;
import java.util.Date;

    public class Dato {
        private int codigo;
        private String nombre;
        private String apellido;
        private String departamento;
        private LocalDate fechaNacimiento;

        // Constructor
        public Dato(int codigo, String nombre, String apellido, String departamento, LocalDate fechaNacimiento) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.apellido = apellido;
            this.departamento = departamento;
            this.fechaNacimiento = fechaNacimiento;
        }
        // Constructor sin código (para inserción)
        public Dato(String nombre, String apellido, String departamento, LocalDate fechaNacimiento) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.departamento = departamento;
            this.fechaNacimiento = fechaNacimiento;
        }


        // Getters y setters
        public int getCodigo() { return codigo; }
        public void setCodigo(int codigo) { this.codigo = codigo; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }
        public String getDepartamento() { return departamento; }
        public void setDepartamento(String departamento) { this.departamento = departamento; }
        public LocalDate getFechaNacimiento() { return fechaNacimiento; }
        public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    }

