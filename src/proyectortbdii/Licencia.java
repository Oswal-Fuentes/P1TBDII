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
    private String categoria;
    private String tipo_licencia;
    private String fotocopiaDNI;
    private String fotocopiaOtrasLicencias;
    private String certificadoMedico;
    private String tipo;

    // constructores
    public Licencia() {
    }

    public Licencia(String id, String categoria, String tipo_licencia, String fotocopiaDNI,
            String fotocopiaOtrasLicencias, String certificadoMedico) {
        this.id = id;
        this.categoria = categoria;
        this.tipo_licencia = tipo_licencia;
        this.fotocopiaDNI = fotocopiaDNI;
        this.fotocopiaOtrasLicencias = fotocopiaOtrasLicencias;
        this.certificadoMedico = certificadoMedico;
        this.tipo = "Licencia";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // getters & setters
    public String getCategoria() {
        return categoria;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public String getFotocopiaDNI() {
        return fotocopiaDNI;
    }

    public String getFotocopiaOtrasLicencias() {
        return fotocopiaOtrasLicencias;
    }

    public String getCertificadoMedico() {
        return certificadoMedico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public void setFotocopiaDNI(String fotocopiaDNI) {
        this.fotocopiaDNI = fotocopiaDNI;
    }

    public void setFotocopiaOtrasLicencias(String fotocopiaOtrasLicencias) {
        this.fotocopiaOtrasLicencias = fotocopiaOtrasLicencias;
    }

    public void setCertificadoMedico(String certificadoMedico) {
        this.certificadoMedico = certificadoMedico;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
