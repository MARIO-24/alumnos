package ejemplo1;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String curso;
    private String genero;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String telefono, String correo, String curso, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.curso = curso;
        this.genero = genero;
    }

    public Alumno(int id, String nombre, String apellido, String telefono, String correo, String curso, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.curso = curso;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return String.format("%-4d %-20s %-20s %-15s %-25s %-35s %-35s",
                id,
                nombre,
                apellido,
                telefono,
                correo,
                curso,
                genero);
    }
}