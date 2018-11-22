package proyectortbdii;

public class Vehiculo {

    private String id;
    private String id_profesor;
    private String tipo_licencia;
    private String tamano; 
    private String tarifa; 
    private String consumo; 
    private String km_recorridos; 
    private String tipo_vehiculo;
    private String tipo;    

    public Vehiculo(String id, String id_profesor, String tipo_licencia, String tamano, String tarifa, String consumo, String km_recorridos, String tipo_vehiculo) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.tipo_licencia = tipo_licencia;
        this.tamano = tamano;
        this.tarifa = tarifa;
        this.consumo = consumo;
        this.km_recorridos = km_recorridos;
        this.tipo_vehiculo = tipo_vehiculo;
        this.tipo = "Vehiculo";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
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

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getId() {
        return id;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
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

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

}
