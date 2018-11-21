// clase Vehículo

package proyectortbdii;

public class Vehiculo {
    
    // atributos
    protected String uso; // Tiene que ir de acuerdo a los tipos de licencias.
    protected String tamano; // En metros, o cualquier otra unidad de distancia.
    protected String tarifa; // En base a esto se saca el costo de enseñanza práctica.
    protected String consumo; // El consumo de un vehículo después de una clase práctica.
    protected String km_recorridos; // Se debe guardar después de cada clase práctica.
    protected String tipo;
    
    // constructores
    public Vehiculo() {}
    public Vehiculo(String uso, String tamano, String tarifa, String consumo,
            String km_recorridos, String tipo) {
        this.uso = uso;
        this.tamano = tamano;
        this.tarifa = tarifa;
        this.consumo = consumo;
        this.km_recorridos = km_recorridos;
        this.tipo = tipo;
    }
    
    // getters & setters
    public String getUso() {
        return uso;
    }
    public String getTamano() {
        return tamano;
    }
    public String getTarifa() {
        return tarifa;
    }
    public String getConsumo() {
        return consumo;
    }
    public String getKm_recorridos() {
        return km_recorridos;
    }
    public String getTipo() {
        return tipo;
    }
    public void setUso(String uso) {
        this.uso = uso;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
    public void setKm_recorridos(String km_recorridos) {
        this.km_recorridos = km_recorridos;
    }    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
    
    // métodos
    @Override
    public String toString() {
        return "Vehiculo{" + "uso=" + uso + ", tamano=" + tamano + ", tarifa=" + tarifa + ", consumo=" + consumo + ", km_recorridos=" + km_recorridos + ", tipo=" + tipo + '}';
    }            
    
}
