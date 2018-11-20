package proyectortbdii;

import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        Redis r = new Redis();
        Profesor pro = new Profesor("2", "Pedro", "Perez", "Masculino", "7/2/13", "123", "123", "101");
        Profesor pro2 = new Profesor("3", "Camila", "Santos", "Femenino", "15/12/98", "235", "357", "301");
        r.createProfesor(pro);
        r.createProfesor(pro2);
        Map<String, String> retrieveMap = r.readProfesor("2");
        for (String keyMap : retrieveMap.keySet()) {
            System.out.println(keyMap + " " + retrieveMap.get(keyMap));
        }
        System.out.println("");
        Map<String, String> retrieveMap2 = r.readProfesor("3");
        for (String keyMap : retrieveMap2.keySet()) {
            System.out.println(keyMap + " " + retrieveMap2.get(keyMap));
        }
        System.out.println("");
        Profesor pro3 = new Profesor("3", "Camila", "Santos", "Femenino", "15/10/98", "235", "357", "301");
        r.updateProfesor(pro3);
        retrieveMap2 = r.readProfesor("3");
        for (String keyMap : retrieveMap2.keySet()) {
            System.out.println(keyMap + " " + retrieveMap2.get(keyMap));
        }
        r.deleteProfesor("2");

        /* System.out.println(r.loadProfesor("1").getId()+" 1");
        System.out.println(r.loadProfesor("1").getTelefono()+" 2");*/
    }
}
