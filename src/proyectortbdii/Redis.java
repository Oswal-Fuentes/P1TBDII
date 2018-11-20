package proyectortbdii;

import java.util.HashMap;
import java.util.Map;
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
        try{
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
        try{
            jedis.hmset(profesor.getId().toString(), userProperties);
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
    
    public void deleteProfesor(String id){
        jedis.del(id);
    }
}
