package proyectortbdii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class Redis {

    private static final String redisHost = "localhost";
    private static final int redisPort = 6379;
    Jedis jedis = null;

    public Redis() {
        jedis = new Jedis(redisHost, redisPort);
        System.out.println("Connection Successful");
    }

    public ArrayList<String> getAllKeys() {
        ArrayList<String> keys = new ArrayList();
        for (String str : jedis.keys("*")) {
            keys.add(str);
        }
        return keys;
    }

    public String getTipo(String id) {
        return jedis.hget(id, "tipo");
    }

    public String getAtributo(String id, String tipo) {
        return jedis.hget(id, tipo);
    }

    //retorna el auto disponible y de una vez asigna el id del profesor que solicita al auto (relacion uno a uno)
    public String getIdVehiculoDisponible(String id_profesor) {
        ArrayList<String> keys = new ArrayList();
        keys = getAllKeys();
        for (int x = 0; x < keys.size(); x++) {
            if (getTipo(keys.get(x)).equals("Vehiculo")) {
                if (getAtributo(keys.get(x), "profesor_asignado").equals("")) {
                    setVehiculoAsignado(keys.get(x), id_profesor);
                    return keys.get(x);
                }
            }
        }
        return "";
    }
    
    public void setVehiculoAsignado(String id_vehiculo ,String id_profesor){
        jedis.hset(id_vehiculo, "profesor_asignado", id_profesor);
    }
    
    //categoria = tipo de licencia se usa en Alumno
    public String getIdProfesorCategoria(String tipo_licencia) {
        ArrayList<String> keys = new ArrayList();
        keys = getAllKeys();
        for (int x = 0; x < keys.size(); x++) {
            if (getTipo(keys.get(x)).equals("Profesor")) {
                if (getAtributo(keys.get(x), "categoria").equals(tipo_licencia)) {
                    return keys.get(x);
                }
            }
        }
        return "";
    }
    

    public void createProfesor(Profesor profesor) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", profesor.getId());
        userProperties.put("nombre", profesor.getNombre());
        userProperties.put("apellido", profesor.getApellido());
        userProperties.put("genero", profesor.getGenero());
        userProperties.put("fecha_nacimiento", profesor.getFecha_nacimiento());
        userProperties.put("telefono", profesor.getTelefono());
        userProperties.put("sueldo", profesor.getSueldo());
        userProperties.put("experiencia", profesor.getExperiencia());
        userProperties.put("categoria", profesor.getExperiencia());
        userProperties.put("vehiculo_asignado", profesor.getVehiculo_asignado());
        userProperties.put("tipo", profesor.getTipo());
        try {
            jedis.hmset(profesor.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public void createAlumno(Alumno alumno) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", alumno.getId());
        userProperties.put("nombre", alumno.getNombre());
        userProperties.put("apellido", alumno.getApellido());
        userProperties.put("genero", alumno.getGenero());
        userProperties.put("fecha_nacimiento", alumno.getFecha_nacimiento());
        userProperties.put("telefono", alumno.getTelefono());
        userProperties.put("tipo_licencia", alumno.getTipo_licencia());
        userProperties.put("profesor_asignado", alumno.getProfesor_asignado());
        userProperties.put("tipo", alumno.getTipo());
        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public void createVehiculo(Vehiculo vehiculo) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", vehiculo.getID());
        userProperties.put("profesor_asignado", vehiculo.getProfesor_asignado());
        userProperties.put("categoria", vehiculo.getCategoria());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createClasePractica(Clase_Practica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getID());
        userProperties.put("profesor_asignado", clase.getProfesor_asignado());
        userProperties.put("alumno_asignado", clase.getAlumno_asignado());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("examenPractico", clase.getExamenPractico());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createClaseTeorica(Clase_Teorica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getID());
        userProperties.put("profesor_asignado", clase.getProfesor_asignado());
        for (String str : clase.getAlumno_asignado()) {
            userProperties.put("alumno_asignado", str);
        }
        userProperties.put("examenTeorico", clase.getExamenTeorico());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createPago(Pago pago) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", pago.getID());
        userProperties.put("idAlumno", pago.getIdAlumno());
        userProperties.put("costoMatricula", pago.getCostoMatricula());
        userProperties.put("costoEnsenanzaTeorica", pago.getCostoEnsenanzaTeorica());
        userProperties.put("costoTramitacionDocs", pago.getCostoTramitacionDocs());
        userProperties.put("costoEnsenanzaPractica", pago.getCostoEnsenanzaPractica());
        userProperties.put("tipo", pago.getTipo());
        try {
            jedis.hmset(pago.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createLicencia(Licencia licencia) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", licencia.getId());
        userProperties.put("categoria", licencia.getCategoria());
        userProperties.put("tipo_licencia", licencia.getTipo_licencia());
        userProperties.put("fotocopiaDNI", licencia.getFotocopiaDNI());
        userProperties.put("fotocopiaOtrasLicencias", licencia.getFotocopiaOtrasLicencias());
        userProperties.put("certificadoMedico", licencia.getCertificadoMedico());
        userProperties.put("tipo", licencia.getTipo());
        try {
            jedis.hmset(licencia.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateProfesor(Profesor profesor) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", profesor.getId());
        userProperties.put("nombre", profesor.getNombre());
        userProperties.put("apellido", profesor.getApellido());
        userProperties.put("genero", profesor.getGenero());
        userProperties.put("fecha_nacimiento", profesor.getFecha_nacimiento());
        userProperties.put("telefono", profesor.getTelefono());
        userProperties.put("sueldo", profesor.getSueldo());
        userProperties.put("experiencia", profesor.getExperiencia());
        userProperties.put("categoria", profesor.getExperiencia());
        userProperties.put("vehiculo_asignado", profesor.getVehiculo_asignado());
        userProperties.put("tipo", profesor.getTipo());
        try {
            jedis.hmset(profesor.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public void updateVehiculo(Vehiculo vehiculo) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", vehiculo.getID());
        userProperties.put("profesor_asignado", vehiculo.getProfesor_asignado());
        userProperties.put("categoria", vehiculo.getCategoria());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateClasePractica(Clase_Practica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getID());
        userProperties.put("profesor_asignado", clase.getProfesor_asignado());
        userProperties.put("alumno_asignado", clase.getAlumno_asignado());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("examenPractico", clase.getExamenPractico());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateClaseTeorica(Clase_Teorica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getID());
        userProperties.put("profesor_asignado", clase.getProfesor_asignado());
        for (String str : clase.getAlumno_asignado()) {
            userProperties.put("alumno_asignado", str);
        }
        userProperties.put("examenTeorico", clase.getExamenTeorico());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updatePago(Pago pago) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", pago.getID());
        userProperties.put("idAlumno", pago.getIdAlumno());
        userProperties.put("costoMatricula", pago.getCostoMatricula());
        userProperties.put("costoEnsenanzaTeorica", pago.getCostoEnsenanzaTeorica());
        userProperties.put("costoTramitacionDocs", pago.getCostoTramitacionDocs());
        userProperties.put("costoEnsenanzaPractica", pago.getCostoEnsenanzaPractica());
        userProperties.put("tipo", pago.getTipo());
        try {
            jedis.hmset(pago.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateLicencia(Licencia licencia) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", licencia.getId());
        userProperties.put("categoria", licencia.getCategoria());
        userProperties.put("tipo_licencia", licencia.getTipo_licencia());
        userProperties.put("fotocopiaDNI", licencia.getFotocopiaDNI());
        userProperties.put("fotocopiaOtrasLicencias", licencia.getFotocopiaOtrasLicencias());
        userProperties.put("certificadoMedico", licencia.getCertificadoMedico());
        userProperties.put("tipo", licencia.getTipo());
        try {
            jedis.hmset(licencia.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateAlumno(Alumno alumno) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", alumno.getId());
        userProperties.put("nombre", alumno.getNombre());
        userProperties.put("apellido", alumno.getApellido());
        userProperties.put("genero", alumno.getGenero());
        userProperties.put("fecha_nacimiento", alumno.getFecha_nacimiento());
        userProperties.put("telefono", alumno.getTelefono());
        userProperties.put("tipo_licencia", alumno.getTipo_licencia());
        userProperties.put("profesor_asignado", alumno.getProfesor_asignado());
        userProperties.put("tipo", alumno.getTipo());

        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public Map<String, String> readObject(String id) {
        Map<String, String> properties = jedis.hgetAll(id);
        jedis.close();
        return properties;
    }

    public void deleteObject(String id) {
        jedis.del(id);
    }
}
