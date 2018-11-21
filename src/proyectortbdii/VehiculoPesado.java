// clase Vehículo Pesado

package proyectortbdii;

public class VehiculoPesado extends Vehiculo {
    
    public VehiculoPesado() {}
    public VehiculoPesado(String uso, double tamano, double tarifa,
            double consumo, double km_recorridos) {
        super.uso = uso;
        super.tamano = tamano;
        super.tarifa = tarifa;
        super.consumo = consumo;
        super.km_recorridos = km_recorridos;
    }
    
}
