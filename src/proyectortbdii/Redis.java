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
            System.out.println("KEYS: "+str);
        }
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
        userProperties.put("tipo",profesor.getTipo());
        try {
            jedis.hmset(profesor.getId().toString(), userProperties);
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
        userProperties.put("tipo",profesor.getTipo());
        try {
            jedis.hmset(profesor.getId().toString(), userProperties);
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

    public void createAlumno(Alumno alumno) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", alumno.getId());
        userProperties.put("nombre", alumno.getNombre());
        userProperties.put("apellido", alumno.getApellido());
        userProperties.put("genero", alumno.getGenero());
        userProperties.put("fecha_nacimiento", alumno.getFecha_nacimiento());
        userProperties.put("telefono", alumno.getTelefono());
        userProperties.put("tipo_licencia", alumno.getTipo_licencia());
        userProperties.put("tipo",alumno.getTipo());
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
        userProperties.put("tipo",alumno.getTipo());

        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }
    
    public String getTipo(String id){
        return jedis.hget(id, "tipo");
    }
}
