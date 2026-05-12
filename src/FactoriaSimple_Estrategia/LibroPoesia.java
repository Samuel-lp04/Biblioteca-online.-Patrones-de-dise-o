
package FactoriaSimple_Estrategia;

public class LibroPoesia implements Estrategia{
    
    private String genero;
    private String temaPrincipal;
    
    public LibroPoesia(String temaPrincipal){
        setGenero();
        setTemaPrincipal(temaPrincipal);
    }
    
    @Override
    public String mostrarInfo() {
        return getTemaPrincipal();
    }
    
    @Override
    public void setGenero() {
        this.genero = "POESIA";
    }
    
    @Override
    public String getGenero() {
        return genero;
    }
    
    public void setTemaPrincipal(String temaPrincipal){
        this.temaPrincipal =temaPrincipal;
    }
    
    public String getTemaPrincipal(){
        return temaPrincipal;
    }
    
}