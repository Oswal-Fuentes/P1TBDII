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
public class Clase {
    private ArrayList <String> alumnos;
    private ArrayList <String> profesores;
    private ArrayList <String> vehiculos;
    private ArrayList <String> clase_practica;
    private ArrayList <String> tipo;

    public Clase(ArrayList<String> alumnos, ArrayList<String> profesores, ArrayList<String> vehiculos, ArrayList<String> clase_practica) {
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.vehiculos = vehiculos;
        this.clase_practica = clase_practica;
        this.tipo.add("Clase");
    }

    public void setAlumnos(ArrayList<String> alumnos) {
        this.alumnos = alumnos;
    }

    public void setProfesores(ArrayList<String> profesores) {
        this.profesores = profesores;
    }

    public void setVehiculos(ArrayList<String> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setClase_practica(ArrayList<String> clase_practica) {
        this.clase_practica = clase_practica;
    }
    
    public ArrayList<String> getAlumnos() {
        return alumnos;
    }

    public ArrayList<String> getProfesores() {
        return profesores;
    }

    public ArrayList<String> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<String> getClase_practica() {
        return clase_practica;
    }

    public ArrayList<String> getTipo() {
        return tipo;
    }
    
}
