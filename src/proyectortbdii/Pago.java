// clase Pago

package proyectortbdii;

public class Pago {
    
    // atributos
    private String idAlumno;
    // Todos estos solo se cobran una vez
    private String costoMatriculaVL; // costo de matriculación para licencia de vehículo liviano
    private String costoMatriculaVP; // costo de matriculación para licencia de vehículo pesado
    private String costoMatriculaVB; // costo de matriculación para licencia de vehículo biciclo
    private String costoEnsenanzaTeorica; // costo de enseñanza teórica
    // Estos se cobran cada vez que se soliciten nuevamente
    private String costoTramitacionDocs; // costo de tramitación de documentos
    private String costoEnsenanzaPractica; // costo de enseñanza práctica
    
    // constructores
    public Pago() {}

    public Pago(String idAlumno, String costoMatriculaVL,
            String costoMatriculaVP, String costoMatriculaVB,
            String costoEnsenanzaTeorica, String costoTramitacionDocs,
            String costoEnsenanzaPractica) {
        this.idAlumno = idAlumno;
        this.costoMatriculaVL = costoMatriculaVL;
        this.costoMatriculaVP = costoMatriculaVP;
        this.costoMatriculaVB = costoMatriculaVB;
        this.costoEnsenanzaTeorica = costoEnsenanzaTeorica;
        this.costoTramitacionDocs = costoTramitacionDocs;
        this.costoEnsenanzaPractica = costoEnsenanzaPractica;
    }    
    
    // getters & setters
    public String getIdAlumno() {
        return idAlumno;
    }
    public String getCostoMatriculaVL() {
        return costoMatriculaVL;
    }
    public String getCostoMatriculaVP() {
        return costoMatriculaVP;
    }
    public String getCostoMatriculaVB() {
        return costoMatriculaVB;
    }
    public String getCostoEnsenanzaTeorica() {
        return costoEnsenanzaTeorica;
    }
    public String getCostoTramitacionDocs() {
        return costoTramitacionDocs;
    }
    public String getCostoEnsenanzaPractica() {
        return costoEnsenanzaPractica;
    }
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    public void setCostoMatriculaVL(String costoMatriculaVL) {
        this.costoMatriculaVL = costoMatriculaVL;
    }
    public void setCostoMatriculaVP(String costoMatriculaVP) {
        this.costoMatriculaVP = costoMatriculaVP;
    }
    public void setCostoMatriculaVB(String costoMatriculaVB) {
        this.costoMatriculaVB = costoMatriculaVB;
    }
    public void setCostoEnsenanzaTeorica(String costoEnsenanzaTeorica) {
        this.costoEnsenanzaTeorica = costoEnsenanzaTeorica;
    }
    public void setCostoTramitacionDocs(String costoTramitacionDocs) {
        this.costoTramitacionDocs = costoTramitacionDocs;
    }
    public void setCostoEnsenanzaPractica(String costoEnsenanzaPractica) {
        this.costoEnsenanzaPractica = costoEnsenanzaPractica;
    }    
    
    // métodos
    @Override
    public String toString() {
        return "Pago{" + "idAlumno=" + idAlumno + ", costoMatriculaVL=" + costoMatriculaVL + ", costoMatriculaVP=" + costoMatriculaVP + ", costoMatriculaVB=" + costoMatriculaVB + ", costoEnsenanzaTeorica=" + costoEnsenanzaTeorica + ", costoTramitacionDocs=" + costoTramitacionDocs + ", costoEnsenanzaPractica=" + costoEnsenanzaPractica + '}';
    }    
    
}
