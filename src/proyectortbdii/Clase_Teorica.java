/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectortbdii;

import java.util.ArrayList;

/**
 *
 * @author daniela
 */
public class Clase_Teorica {

    private String id;
    private String id_profesor;
    private String id_alumno;
    private String nota_teorica;
    private String tipo;

    public Clase_Teorica(String id, String id_profesor, String id_alumno, String nota_teorica) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_alumno = id_alumno;
        this.nota_teorica = nota_teorica;
        this.tipo = "Clase_Teorica";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public void setNota_teorica(String nota_teorica) {
        this.nota_teorica = nota_teorica;
    }

    public String getId() {
        return id;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public String getNota_teorica() {
        return nota_teorica;
    }

    public String getTipo() {
        return tipo;
    }

}
