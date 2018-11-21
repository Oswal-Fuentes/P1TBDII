// clase Clase

package proyectortbdii;

public class Clase {

    // atributos
    protected String ID;
    protected String idProfesor; // El profesor que da la clase.
    protected String idAlumno; // El alumno que recibe la clase.
    protected String tipo_clase; // Depende del tipo de licencia.
    protected String examenPractico;
    protected String examenTeorico;
    protected String tipo;
    
    // constructores
    public Clase() {}
    public Clase(String ID, String idProfesor, String idAlumno,
            String tipo_clase, String examenPractico, String examenTeorico) {
        this.ID = ID;
        this.idProfesor = idProfesor;
        this.idAlumno = idAlumno;
        this.tipo_clase = tipo_clase;
        this.examenPractico = examenPractico;
        this.examenTeorico = examenTeorico;
        this.tipo = "Clase";
    }    
    
    // getters & setters
    public String getID() {
        return ID;
    }
    public String getIdProfesor() {
        return idProfesor;
    }
    public String getIdAlumno() {
        return idAlumno;
    }
    public String getTipo_clase() {
        return tipo_clase;
    }    
    public String getExamenPractico() {
        return examenPractico;
    }
    public String getExamenTeorico() {
        return examenTeorico;
    }
    public String getTipo() {
        return tipo;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    public void setTipo_clase(String tipo_clase) {
        this.tipo_clase = tipo_clase;
    }
    public void setExamenPractico(String examenPractico) {
        this.examenPractico = examenPractico;
    }
    public void setExamenTeorico(String examenTeorico) {
        this.examenTeorico = examenTeorico;
    }    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    // métodos
    @Override
    public String toString() {
        return "Clase{" + "ID=" + ID + ", idProfesor=" + idProfesor + ", idAlumno=" + idAlumno + ", tipo_clase=" + tipo_clase + ", examenPractico=" + examenPractico + ", examenTeorico=" + examenTeorico + ", tipo=" + tipo + '}';
    }            
    
}
