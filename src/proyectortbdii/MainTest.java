package proyectortbdii;

import java.util.Map;


public class MainTest {

    public static void main(String[] args) {
        Redis r = new Redis();
        Profesor pro = new Profesor("2", "Pedro", "Perez", "Masculino", "7/2/13", "123", "123", "101");
        r.insertProfesor(pro);
        Map<String, String> retrieveMap = r.loadProfesor("1");
        for (String keyMap : retrieveMap.keySet()) {
            System.out.println(keyMap + " " + retrieveMap.get(keyMap));
        }
        
       /* System.out.println(r.loadProfesor("1").getId()+" 1");
        System.out.println(r.loadProfesor("1").getTelefono()+" 2");*/
    }
}
