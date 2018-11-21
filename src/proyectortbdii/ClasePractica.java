// clase Clase Práctica

package proyectortbdii;

public class ClasePractica extends Clase {
    
    private String tipo; // Depende del tipo de licencia.
    private int examen;
    
    public ClasePractica() {}
    public ClasePractica(String idProfesor, String idAlumno, String tipo,
            int examen) {
        super.idProfesor = idProfesor;
        super.idAlumno = idAlumno;
        this.tipo = tipo;
        this.examen = examen;
    }
    
}
