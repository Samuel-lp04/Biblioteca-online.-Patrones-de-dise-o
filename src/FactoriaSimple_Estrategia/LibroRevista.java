
package FactoriaSimple_Estrategia;

public class LibroRevista implements Estrategia {
    
    private String genero;
    private String tema;
    
    public LibroRevista(String tema) {
        setGenero();
        setTema(tema);
    }
    
    @Override
    public String mostrarInfo() {
        return getTema();
    }
    
    public void setGenero() {
        this.genero = "REVISTA";
    }
    
    @Override
    public String getGenero() {
        return genero;
    }
    
    public void setTema(String tema){
        this.tema =tema;
    }
    
    public String getTema(){
        return tema;
    }
    
}