
package FactoriaSimple_Estrategia;

import java.util.Date;
import java.util.GregorianCalendar;

public class Libro implements ILibro {
    
    private static GregorianCalendar calendar = new GregorianCalendar();
    
    private String titulo;
    private String autor;
    private String isbn;
    private Date año_publicacion;
    Estrategia estrategia;

    public Libro(String titulo, String autor, String isbn, Estrategia estrategia) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAño_publicacion();
        setEstrategia(estrategia);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public Date getAño_publicacion() {
        return año_publicacion;
    }

    @Override
    public void setAño_publicacion() {
        this.año_publicacion = calendar.getTime();
    }

    @Override
    public Estrategia getEstrategia() {
        return estrategia;
    }

    @Override
    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    
    @Override
    public String toString() {
        return "'" + titulo + "'" + "(" + isbn + ")" + " -" + autor + " " + año_publicacion + "- "
               + "\n   " + estrategia.mostrarInfo(); 
    }
}
