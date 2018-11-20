package proyectortbdii;

import redis.clients.jedis.Jedis;

public class MainTest {

    public static void main(String[] args) {
        Redis r = new Redis();
        Profesor pro = new Profesor("1", "Juan", "Perez", "Masculino", "1/2/3", "123", "123", "10");
        r.insertProfesor(pro);
        
        System.out.println(r.loadProfesor("1").getId()+" 1");
        System.out.println(r.loadProfesor("1").getTelefono()+" 2");
    }
}
