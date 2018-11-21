// clase Vehículo

package proyectortbdii;

public class Vehiculo {
    
    // atributos
    protected String uso; // Tiene que ir de acuerdo a los tipos de licencias.
    protected double tamano; // En metros, o cualquier otra unidad de distancia.
    protected double tarifa; // En base a esto se saca el costo de enseñanza práctica.
    protected double consumo; // El consumo de un vehículo después de una clase práctica.
    protected double km_recorridos; // Se debe guardar después de cada clase práctica.
    
    // constructores
    public Vehiculo() {}
    public Vehiculo(String uso, double tamano, double tarifa, double consumo,
            double km_recorridos) {
        this.uso = uso;
        this.tamano = tamano;
        this.tarifa = tarifa;
        this.consumo = consumo;
        this.km_recorridos = km_recorridos;
    }
    
    // getters & setters
    public String getUso() {
        return uso;
    }
    public double getTamano() {
        return tamano;
    }
    public double getTarifa() {
        return tarifa;
    }
    public double getConsumo() {
        return consumo;
    }
    public double getKm_recorridos() {
        return km_recorridos;
    }
    public void setUso(String uso) {
        this.uso = uso;
    }
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    public void setKm_recorridos(double km_recorridos) {
        this.km_recorridos = km_recorridos;
    }
    
    // métodos
    @Override
    public String toString() {
        return "Vehiculo{" + "uso=" + uso + ", tamano=" + tamano + ", tarifa=" + tarifa + ", consumo=" + consumo + ", km_recorridos=" + km_recorridos + '}';
    }        
    
}
