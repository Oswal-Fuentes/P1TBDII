package proyectortbdii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class Redis {

    /*
    Atributos:
- ID
- Nombre
- Apellido
- Genero
- Fecha de Nacimiento
- Telefono
- Sueldo
- Años de Experiencia
- Fotografia (tal vez)
     */
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
        //ArrayList<String> arrayList = new ArrayList<>(Set < String >);
        //Set<String> keys = jedis.keys("*");
        //System.out.println("KEYS: " + keys);
        
//for (String key : keys) {
          //  System.out.println(key);
        //}
        return keys;
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
        try {
            jedis.hmset(profesor.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }
    
    public void createVehiculo(Vehiculo vehiculo) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("ID", vehiculo.getID());
        userProperties.put("uso", vehiculo.getUso());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_Vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }
    
    public void createClase(Clase clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("ID", clase.getID());
        userProperties.put("idProfesor", clase.getIdProfesor());
        userProperties.put("idAlumno", clase.getIdAlumno());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("examenPractico", clase.getExamenPractico());
        userProperties.put("examenTeorico", clase.getExamenTeorico());
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
        userProperties.put("ID", pago.getID());
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
        try {
            jedis.hmset(profesor.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }
    
    public void updateVehiculo(Vehiculo vehiculo) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("ID", vehiculo.getID());
        userProperties.put("uso", vehiculo.getUso());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_Vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getID(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }
    
    public void updateClase(Clase clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("ID", clase.getID());
        userProperties.put("idProfesor", clase.getIdProfesor());
        userProperties.put("idAlumno", clase.getIdAlumno());
        userProperties.put("tipo_clase", clase.getTipo_clase());
        userProperties.put("examenPractico", clase.getExamenPractico());
        userProperties.put("examenTeorico", clase.getExamenTeorico());
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
        userProperties.put("ID", pago.getID());
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
    
    public Map<String, String> readProfesor(String id) {
        Map<String, String> properties = jedis.hgetAll(id);
        jedis.close();
        return properties;
    }

    public void deleteProfesor(String id) {
        jedis.del(id);
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
        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
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

        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public Map<String, String> readAlumno(String id) {
        Map<String, String> properties = jedis.hgetAll(id);
        jedis.close();
        return properties;
    }

    public void deleteAlumno(String id) {
        jedis.del(id);
    }
}
