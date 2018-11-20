package proyectortbdii;

public class Profesor {

    /*
    Atributos:
- ID
- Nombre
- Apellido
- Genero
- Fecha de Nacimiento
- Telefono
- Sueldo
- Años de Experiencia
- Fotografia (tal vez)
     */
    private String id;
    private String nombre;
    private String apellido;
    private String genero;
    private String fecha_nacimiento;
    private String telefono;
    private String sueldo;
    private String experiencia;

    public Profesor() {
    }

    
    
    public Profesor(String id, String nombre, String apellido, String genero, String fecha_nacimiento, String telefono, String sueldo, String experiencia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.experiencia = experiencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void toString(String experiencia) {
        this.experiencia = experiencia;
    }

}
