// clase Clase
package proyectortbdii;

public class Clase_Practica {

    // atributos
    private String id;
    private String profesor_asignado; // El profesor que da la clase.
    private String alumno_asignado; // El alumno que recibe la clase.
    private String tipo_clase; // Depende del tipo de licencia.
    private String examenPractico;
    private String tipo;

    // constructores
    public Clase_Practica() {
    }

    public Clase_Practica(String ID, String idProfesor, String idAlumno,
            String tipo_clase, String examenPractico) {
        this.id = ID;
        this.profesor_asignado = idProfesor;
        this.alumno_asignado = idAlumno;
        this.tipo_clase = tipo_clase;
        this.examenPractico = examenPractico;
        this.tipo = "Clase_Practica";
    }

    // getters & setters
    public String getID() {
        return id;
    }

    public String getProfesor_asignado() {
        return profesor_asignado;
    }

    public String getAlumno_asignado() {
        return alumno_asignado;
    }

    public String getTipo_clase() {
        return tipo_clase;
    }

    public String getExamenPractico() {
        return examenPractico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setProfesor_asignado(String idProfesor) {
        this.profesor_asignado = idProfesor;
    }

    public void setAlumno_asignado(String idAlumno) {
        this.alumno_asignado = idAlumno;
    }

    public void setTipo_clase(String tipo_clase) {
        this.tipo_clase = tipo_clase;
    }

    public void setExamenPractico(String examenPractico) {
        this.examenPractico = examenPractico;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
