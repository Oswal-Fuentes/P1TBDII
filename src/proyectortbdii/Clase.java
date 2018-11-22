/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectortbdii;


/**
 *
 * @author daniela
 */
public class Clase {
    private String id;
    private String id_clase_teorica;
    private String id_clase_practica;
    private String tipo;

    public Clase(String id, String id_clase_teorica, String id_clase_practica) {
        this.id = id;
        this.id_clase_teorica = id_clase_teorica;
        this.id_clase_practica = id_clase_practica;
        this.tipo = "Clase";
    }

    public String getId() {
        return id;
    }

    public String getId_clase_teorica() {
        return id_clase_teorica;
    }

    public String getId_clase_practica() {
        return id_clase_practica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_clase_teorica(String id_clase_teorica) {
        this.id_clase_teorica = id_clase_teorica;
    }

    public void setId_clase_practica(String id_clase_practica) {
        this.id_clase_practica = id_clase_practica;
    }
    
    
}
