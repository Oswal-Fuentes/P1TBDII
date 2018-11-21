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

    // atributos
    private String id;
    private String profesor_asignado; // El profesor que da la clase.
    private ArrayList<String> alumno_asignado; // recibe una lista de alumnos.
    private String examenTeorico;
    private String tipo_clase; // Depende del tipo de licencia.
    private String tipo;

    public Clase_Teorica(String ID, String profesor_asignado, ArrayList<String> alumno_asignado, String examenTeorico, String tipo_clase) {
        this.id = ID;
        this.profesor_asignado = profesor_asignado;
        this.alumno_asignado = alumno_asignado;
        this.examenTeorico = examenTeorico;
        this.tipo_clase = tipo_clase;
        this.tipo = "Clase_Teorica";
    }

    public String getID() {
        return id;
    }

    public String getProfesor_asignado() {
        return profesor_asignado;
    }

    public ArrayList<String> getAlumno_asignado() {
        return alumno_asignado;
    }

    public String getExamenTeorico() {
        return examenTeorico;
    }

    public String getTipo_clase() {
        return tipo_clase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setProfesor_asignado(String profesor_asignado) {
        this.profesor_asignado = profesor_asignado;
    }

    public void setAlumno_asignado(ArrayList<String> alumno_asignado) {
        this.alumno_asignado = alumno_asignado;
    }

    public void setExamenTeorico(String examenTeorico) {
        this.examenTeorico = examenTeorico;
    }

    public void setTipo_clase(String tipo_clase) {
        this.tipo_clase = tipo_clase;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
