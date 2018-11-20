package proyectortbdii;

import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;

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
    public Redis() {
    }

    public void insertProfesor(Profesor profesor) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection Successful");
        System.out.println("Server Ping: " + jedis.ping());

        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", profesor.getId());
        userProperties.put("nombre", profesor.getNombre());
        userProperties.put("apellido", profesor.getApellido());
        userProperties.put("genero", profesor.getGenero());
        userProperties.put("fecha_nacimiento", profesor.getFecha_nacimiento());
        userProperties.put("telefono", profesor.getTelefono());
        userProperties.put("sueldo", profesor.getSueldo());
        userProperties.put("experiencia", profesor.getExperiencia());
        
        jedis.hmset("profesor:" + profesor.getId(), userProperties);

        jedis.close();
    }

    public void updateTelefono(Profesor profesor) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection Successful");
        System.out.println("Server Ping: " + jedis.ping());

        
        jedis.hset("profesor:" + profesor.getId(), "telefono", profesor.getTelefono());

        
        jedis.close();
    }

    public Profesor loadProfesor(String id) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection Successful");
        System.out.println("Server Ping: " + jedis.ping());

        
        Map<String, String> properties = jedis.hgetAll("profesor:" + id);
        Profesor profesor = new Profesor();
        profesor.setId(id);
        profesor.setTelefono(properties.get("telefono"));
        //fill all attributes
        
        
        jedis.close();
        return profesor;
    }
}
