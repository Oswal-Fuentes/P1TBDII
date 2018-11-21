// clase Clase

package proyectortbdii;

public class Clase {

    // atributos
    protected String idProfesor; // El profesor que da la clase.
    protected String idAlumno; // El alumno que recibe la clase.
    protected String tipo; // Depende del tipo de licencia.
    protected String examenPractico;
    protected String examenTeorico;
    
    // constructores
    public Clase() {}
    public Clase(String idProfesor, String idAlumno, String tipo,
            String examenPractico, String examenTeorico) {
        this.idProfesor = idProfesor;
        this.idAlumno = idAlumno;
        this.tipo = tipo;
        this.examenPractico = examenPractico;
        this.examenTeorico = examenTeorico;
    }    
    
    // getters & setters
    public String getIdProfesor() {
        return idProfesor;
    }
    public String getIdAlumno() {
        return idAlumno;
    }
    public String getTipo() {
        return tipo;
    }
    public String getExamenPractico() {
        return examenPractico;
    }
    public String getExamenTeorico() {
        return examenTeorico;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setExamenPractico(String examenPractico) {
        this.examenPractico = examenPractico;
    }
    public void setExamenTeorico(String examenTeorico) {
        this.examenTeorico = examenTeorico;
    }    
    
    // métodos
    @Override
    public String toString() {
        return "Clase{" + "idProfesor=" + idProfesor + ", idAlumno=" + idAlumno + ", tipo=" + tipo + ", examenPractico=" + examenPractico + ", examenTeorico=" + examenTeorico + '}';
    }        
    
}
