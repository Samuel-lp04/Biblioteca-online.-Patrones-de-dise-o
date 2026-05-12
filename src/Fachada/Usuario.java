
package Fachada;

public class Usuario {
    
    private static int COUNT = 1;
    
    private String nombre;
    private String id;
    private char type;
    
    public Usuario(String nombre, String id, char type) {
        this.nombre = nombre;
        this.id = id;
        this.type = type;
        COUNT++;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\tID: " + id;
    }
        
}
