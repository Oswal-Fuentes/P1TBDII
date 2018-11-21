// clase Clase

package proyectortbdii;

public class Clase {

    // atributos
    protected String idProfesor; // El profesor que da la clase.
    protected String idAlumno; // El alumno que recibe la clase.
    
    // constructores
    public Clase() {}
    public Clase(String idProfesor, String idAlumno) {
        this.idProfesor = idProfesor;
        this.idAlumno = idAlumno;
    }
    
    // getters & setters
    public String getIdProfesor() {
        return idProfesor;
    }
    public String getIdAlumno() {
        return idAlumno;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    // métodos
    @Override
    public String toString() {
        return "Clase{" + "idProfesor=" + idProfesor + ", idAlumno=" + idAlumno + '}';
    }    
    
}
