package proyectortbdii;

import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
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
    
    public void insertProfesor(Profesor profesor) {
        //System.out.println("Server Ping: " + jedis.ping());

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
            System.out.println("ID: "+profesor.getId());
            
        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
           System.out.println("Error");
        } 

        jedis.close();
    }

    public void updateTelefono(Profesor profesor) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection Successful");
        System.out.println("Server Ping: " + jedis.ping());

        
        jedis.hset("profesor:" + profesor.getId(), "telefono", profesor.getTelefono());

        
        jedis.close();
    }

    public Map<String, String> loadProfesor(String id) {
        Map<String, String> properties = jedis.hgetAll(id);
        jedis.close();
        return properties;
    }
}
