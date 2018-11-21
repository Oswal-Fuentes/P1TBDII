// clase Vehículo Liviano

package proyectortbdii;

public class VehiculoLiviano extends Vehiculo {
    
    public VehiculoLiviano() {}
    public VehiculoLiviano(String uso, double tamano, double tarifa,
            double consumo, double km_recorridos) {
        super.uso = uso;
        super.tamano = tamano;
        super.tarifa = tarifa;
        super.consumo = consumo;
        super.km_recorridos = km_recorridos;
    }
    
}
