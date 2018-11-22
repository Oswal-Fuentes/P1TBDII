// clase Vehículo
package proyectortbdii;

public class Vehiculo {

    // atributos
    protected String id;
    protected String profesor_asignado;
    protected String categoria; // Tiene que ir de acuerdo a los tipos de licencias.
    protected String tamano; // En metros, o cualquier otra unidad de distancia.
    protected String tarifa; // En base a esto se saca el costo de enseñanza práctica.
    protected String consumo; // El consumo de un vehículo después de una clase práctica.
    protected String km_recorridos; // Se debe guardar después de cada clase práctica.
    protected String tipo_vehiculo;
    protected String tipo;

    // constructores
    public Vehiculo() {
    }

    public Vehiculo(String id, String profesor_asignado, String categoria, String tamano, String tarifa, String consumo, String km_recorridos, String tipo_vehiculo, String tipo) {
        this.id = id;
        this.profesor_asignado = "";
        this.categoria = categoria;
        this.tamano = tamano;
        this.tarifa = tarifa;
        this.consumo = consumo;
        this.km_recorridos = km_recorridos;
        this.tipo_vehiculo = tipo_vehiculo;
        this.tipo = tipo;
    }
    
    // getters & setters    
    public String getID() {
        return id;
    }

    public String getProfesor_asignado() {
        return profesor_asignado;
    }

    public String getCategoria() {
        return categoria;
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

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setProfesor_asignado(String idProfesor) {
        this.profesor_asignado = idProfesor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }
}
