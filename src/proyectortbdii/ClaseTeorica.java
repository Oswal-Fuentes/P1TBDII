// clase Clase Teórica

package proyectortbdii;

public class ClaseTeorica extends Clase {
    
    private int examen;
    
    public ClaseTeorica() {}
    public ClaseTeorica(String idProfesor, String idAlumno, int examen) {
        super.idProfesor = idProfesor;
        super.idAlumno = idAlumno;        
        this.examen = examen;
    }
    
}
