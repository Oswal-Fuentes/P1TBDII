// clase Pago

package proyectortbdii;

public class Pago {
    
    // atributos
    private String idAlumno;
    // Todos estos solo se cobran una vez
    private double costoMatriculaVL; // costo de matriculación para licencia de vehículo liviano
    private double costoMatriculaVP; // costo de matriculación para licencia de vehículo pesado
    private double costoMatriculaVB; // costo de matriculación para licencia de vehículo biciclo
    private double costoEnsenanzaTeorica; // costo de enseñanza teórica
    // Estos se cobran cada vez que se soliciten nuevamente
    private double costoTramitacionDocs; // costo de tramitación de documentos
    private double costoEnsenanzaPractica; // costo de enseñanza práctica
    
    // constructores
    public Pago() {}
    public Pago(String idAlumno, double costoMatriculaVL,
            double costoMatriculaVP, double costoMatriculaVB,
            double costoEnsenanzaTeorica, double costoTramitacionDocs,
            double costoEnsenanzaPractica) {
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
    public double getCostoMatriculaVL() {
        return costoMatriculaVL;
    }
    public double getCostoMatriculaVP() {
        return costoMatriculaVP;
    }
    public double getCostoMatriculaVB() {
        return costoMatriculaVB;
    }
    public double getCostoEnsenanzaTeorica() {
        return costoEnsenanzaTeorica;
    }
    public double getCostoTramitacionDocs() {
        return costoTramitacionDocs;
    }
    public double getCostoEnsenanzaPractica() {
        return costoEnsenanzaPractica;
    }
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    public void setCostoMatriculaVL(double costoMatriculaVL) {
        this.costoMatriculaVL = costoMatriculaVL;
    }
    public void setCostoMatriculaVP(double costoMatriculaVP) {
        this.costoMatriculaVP = costoMatriculaVP;
    }
    public void setCostoMatriculaVB(double costoMatriculaVB) {
        this.costoMatriculaVB = costoMatriculaVB;
    }
    public void setCostoEnsenanzaTeorica(double costoEnsenanzaTeorica) {
        this.costoEnsenanzaTeorica = costoEnsenanzaTeorica;
    }
    public void setCostoTramitacionDocs(double costoTramitacionDocs) {
        this.costoTramitacionDocs = costoTramitacionDocs;
    }
    public void setCostoEnsenanzaPractica(double costoEnsenanzaPractica) {
        this.costoEnsenanzaPractica = costoEnsenanzaPractica;
    }
    
    // métodos
    @Override
    public String toString() {
        return "Pago{" + "idAlumno=" + idAlumno + ", costoMatriculaVL=" + costoMatriculaVL + ", costoMatriculaVP=" + costoMatriculaVP + ", costoMatriculaVB=" + costoMatriculaVB + ", costoEnsenanzaTeorica=" + costoEnsenanzaTeorica + ", costoTramitacionDocs=" + costoTramitacionDocs + ", costoEnsenanzaPractica=" + costoEnsenanzaPractica + '}';
    }    
    
}
