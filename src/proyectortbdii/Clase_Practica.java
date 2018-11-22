package proyectortbdii;

public class Clase_Practica {
    private String id;
    private String id_profesor; 
    private String id_alumno;
    private String id_vehiculo;
    private String nota_practico;
    private String tipo;

    public Clase_Practica(String id, String id_profesor, String id_alumno, String id_vehiculo, String nota_practico) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_alumno = id_alumno;
        this.id_vehiculo = id_vehiculo;
        this.nota_practico = nota_practico;
        this.tipo = "Clase_Practica";
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

    public String getId_vehiculo() {
        return id_vehiculo;
    }

    public String getNota_practico() {
        return nota_practico;
    }

    public String getTipo() {
        return tipo;
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

    public void setId_vehiculo(String id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setNota_practico(String nota_practico) {
        this.nota_practico = nota_practico;
    }
    
}
