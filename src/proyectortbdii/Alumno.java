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
public class Alumno {

    private String id, nombre, apellido, genero, fecha_nacimiento, telefono, tipo_licencia, id_licencia, id_clase, tipo;

    public Alumno(){
        this.tipo = "Alumno";
    }

    public Alumno(String id, String nombre, String apellido, String genero, String fecha_nacimiento, String telefono, String tipo_licencia, String id_licencia, String id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.tipo_licencia = tipo_licencia;
        this.id_licencia = id_licencia;
        this.id_clase = id_clase;
        this.tipo = "Alumno";
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public String getId_licencia() {
        return id_licencia;
    }

    public String getId_clase() {
        return id_clase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public void setId_licencia(String id_licencia) {
        this.id_licencia = id_licencia;
    }

    public void setId_clase(String id_clase) {
        this.id_clase = id_clase;
    }        
}
