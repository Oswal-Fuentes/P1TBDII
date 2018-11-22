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
public class Licencia {

    // atributos
    private String id;
    private String id_alumno;
    private String tipo_licencia;
    private String tipo;

    public Licencia(String id, String id_alumno, String tipo_licencia) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.tipo_licencia = tipo_licencia;
        this.tipo = "Licencia";
    }

    public String getId() {
        return id;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }
    
}
