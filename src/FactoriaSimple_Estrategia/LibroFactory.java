
package FactoriaSimple_Estrategia;

public class LibroFactory {
    
    public static Libro crearNovela(String titulo, String autor, String isbn, String descripcion){
        return new Libro(titulo, autor, isbn, new LibroNovela(descripcion));
    }
    public static Libro crearPoesia(String titulo, String autor, String isbn, String temaPrincipal){
        return new Libro(titulo, autor, isbn, new LibroPoesia(temaPrincipal));
    }
    public static Libro crearRevista(String titulo, String autor, String isbn, String tema){
        return new Libro(titulo, autor, isbn, new LibroRevista(tema));
    }
   
}
