package proyectortbdii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class Redis {

    private static final String redisHost = "localhost";
    private static final int redisPort = 6379;
    Jedis jedis = null;
    private ArrayList <String> alumnos;
    private ArrayList <String> profesores;
    private ArrayList <String> vehiculos;
    private ArrayList <String> clase_practica;
    public Redis() {
        jedis = new Jedis(redisHost, redisPort);
        System.out.println("Connection Successful");
    }

    public ArrayList<String> getAllKeys() {
        ArrayList<String> keys = new ArrayList();
        for (String str : jedis.keys("*")) {
            keys.add(str);
            System.out.println("KEYS: " + str);
        }
        return keys;
    }
    
    public void initArrays(){
        ArrayList<String> keys = getAllKeys();
        for (int i = 0; i < keys.size(); i++) {
            String tipo = getTipo(keys.get(i));
            if(tipo.equals("Alumno"))
                alumnos.add(keys.get(i));
            else if(tipo.equals("Profesor"))
                profesores.add(keys.get(i));
            else if(tipo.equals("Vehiculo"))
                vehiculos.add(keys.get(i));
            else if(tipo.equals("Clase_Practica"))
                clase_practica.add(keys.get(i));
        }
    }
    
    public String getTipo(String id) {
        return jedis.hget(id, "tipo");
    }

    public String getAtributo(String id, String tipo) {
        return jedis.hget(id, tipo);
    }
    
    public ArrayList<String> getProfesorCategoria(String id_alumno){
        String tipo_licencia = getAtributo(id_alumno,"tipo_licencia");
        ArrayList<String> profesores_categoria = new ArrayList();
        for (int i = 0; i < profesores.size(); i++) {
            String categoria = getAtributo(profesores.get(i),"categoria");
            if(tipo_licencia.equals(categoria))
                profesores_categoria.add(profesores.get(i));
        }
        return profesores_categoria;
    }
    
    public ArrayList<String> getTipoVehiculo(String id_alumno){
        String tipo_licencia = getAtributo(id_alumno,"tipo_licencia");
        ArrayList<String> tipo_vehiculos = new ArrayList();
        for (int i = 0; i < vehiculos.size(); i++) {
            String tipo_vehiculo = getAtributo(vehiculos.get(i),"tipo_licencia");
            if(tipo_licencia.equals(tipo_vehiculo) && getAtributo(vehiculos.get(i),"id_profesor").equals(""))
                tipo_vehiculos.add(vehiculos.get(i));
        }
        return tipo_vehiculos;
    }
    
    public String createClase(String id_alumno){
        String uniqueID = UUID.randomUUID().toString(),uniqueID2 = UUID.randomUUID().toString(), uniqueID3 = UUID.randomUUID().toString();
        Clase clase = new Clase(uniqueID, uniqueID2, uniqueID3);
        createClase(clase);
        createClaseTeorica(uniqueID2, id_alumno);
        createClasePractica(uniqueID3, id_alumno);
        return uniqueID;
    }
    
    public void createClaseTeorica(String id, String id_alumno){
        Clase_Teorica ct = new Clase_Teorica(id, "", id_alumno, "0");
        createClaseTeorica(ct);
    }
    
    public void createClasePractica(String id, String id_alumno){
        Clase_Practica cp = new Clase_Practica(id, "", id_alumno, "", "0");
        createClasePractica(cp);
    }
    //retorna el auto disponible y de una vez asigna el id del profesor que solicita al auto (relacion uno a uno)
    /*public String getIdVehiculoDisponible(String id_profesor) {
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
    }*/

    public void setVehiculoAsignado(String id_vehiculo, String id_profesor) {
        jedis.hset(id_vehiculo, "profesor_asignado", id_profesor);
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
        userProperties.put("categoria", profesor.getCategoria());
        userProperties.put("tipo", profesor.getTipo());
        
        try {
            jedis.hmset(profesor.getId().toString(), userProperties);
            profesores.add(profesor.getId());
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
        userProperties.put("id_licencia", alumno.getId_licencia());
        userProperties.put("id_clase", alumno.getId_clase());
        userProperties.put("tipo", alumno.getTipo());
        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
            alumnos.add(alumno.getId());
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }

    public void createVehiculo(Vehiculo vehiculo) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", vehiculo.getId());
        userProperties.put("id_profesor", vehiculo.getId_profesor());
        userProperties.put("tipo_licencia", vehiculo.getTipo_licencia());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getId(), userProperties);
            vehiculos.add(vehiculo.getId());
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createClasePractica(Clase_Practica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_profesor", clase.getId_profesor());
        userProperties.put("id_alumno", clase.getId_alumno());
        userProperties.put("id_vehiculo", clase.getId_vehiculo());
        userProperties.put("nota_practico", clase.getNota_practico());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
            clase_practica.add(clase.getId());
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void createClaseTeorica(Clase_Teorica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_profesor", clase.getId_profesor());
        userProperties.put("id_alumno", clase.getId_alumno());
        userProperties.put("nota_teorica", clase.getNota_teorica());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
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
        userProperties.put("id_alumno", licencia.getId_alumno());
        userProperties.put("tipo_licencia", licencia.getTipo_licencia());
        userProperties.put("tipo", licencia.getTipo());
        try {
            jedis.hmset(licencia.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }
    
    public void createClase(Clase clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_clase_teorica", clase.getId_clase_teorica());
        userProperties.put("id_clase_practica", clase.getId_clase_teorica());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }
    
    public void updateClase(Clase clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_clase_teorica", clase.getId_clase_teorica());
        userProperties.put("id_clase_practica", clase.getId_clase_teorica());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
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
        userProperties.put("categoria", profesor.getCategoria());
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
        userProperties.put("id", vehiculo.getId());
        userProperties.put("id_profesor", vehiculo.getId_profesor());
        userProperties.put("tipo_licencia", vehiculo.getTipo_licencia());
        userProperties.put("tamano", vehiculo.getTamano());
        userProperties.put("tarifa", vehiculo.getTarifa());
        userProperties.put("consumo", vehiculo.getConsumo());
        userProperties.put("km_recorridos", vehiculo.getKm_recorridos());
        userProperties.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        userProperties.put("tipo", vehiculo.getTipo());
        try {
            jedis.hmset(vehiculo.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateClasePractica(Clase_Practica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_profesor", clase.getId_profesor());
        userProperties.put("id_alumno", clase.getId_alumno());
        userProperties.put("id_vehiculo", clase.getId_vehiculo());
        userProperties.put("nota_practico", clase.getNota_practico());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }
        jedis.close();
    }

    public void updateClaseTeorica(Clase_Teorica clase) {
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("id", clase.getId());
        userProperties.put("id_profesor", clase.getId_profesor());
        userProperties.put("id_alumno", clase.getId_alumno());
        userProperties.put("nota_teorica", clase.getNota_teorica());
        userProperties.put("tipo", clase.getTipo());
        try {
            jedis.hmset(clase.getId(), userProperties);
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
        userProperties.put("id_alumno", licencia.getId_alumno());
        userProperties.put("tipo_licencia", licencia.getTipo_licencia());
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
        userProperties.put("id_licencia", alumno.getId_licencia());
        userProperties.put("id_clase", alumno.getId_clase());
        userProperties.put("tipo", alumno.getTipo());
        try {
            jedis.hmset(alumno.getId().toString(), userProperties);
        } catch (JedisException e) {
            System.out.println("Error" + e);
        }

        jedis.close();
    }
    
    public void updateClaseTeorica(String id, String id_profesor) {
        jedis.hset(id, "id_profesor", id_profesor);
    }
    
    public void updateClasePractica(String id, String id_profesor, String id_vehiculo) {
        jedis.hset(id, "id_profesor", id_profesor);
        jedis.hset(id, "id_vehiculo", id_vehiculo);
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
