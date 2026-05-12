
package FactoriaSimple_Estrategia;

public class LibroNovela implements Estrategia {
    
    private String genero;
    private String descripcion;
    
    public LibroNovela(String descripcion){
        setGenero();
        setDescripcion(descripcion);
    }

    @Override
    public String mostrarInfo() {
        return getDescripcion();
    }
    
    @Override
    public void setGenero() {
        this.genero = "NOVELA";
    }
    
    @Override
    public String getGenero() {
        return genero;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion =descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
}