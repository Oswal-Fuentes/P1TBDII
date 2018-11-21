// clase Vehículo Biciclo

package proyectortbdii;

public class VehiculoBiciclo extends Vehiculo {
    
    public VehiculoBiciclo() {}
    public VehiculoBiciclo(String uso, double tamano, double tarifa,
            double consumo, double km_recorridos) {
        super.uso = uso;
        super.tamano = tamano;
        super.tarifa = tarifa;
        super.consumo = consumo;
        super.km_recorridos = km_recorridos;
    }
    
}
