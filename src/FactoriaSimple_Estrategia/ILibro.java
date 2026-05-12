
package FactoriaSimple_Estrategia;

import java.util.Date;

public interface ILibro {
    
    String getTitulo();

    void setTitulo(String titulo);

    String getAutor();

    void setAutor(String autor);

    String getIsbn();

    void setIsbn(String isbn);

    Date getAño_publicacion();

    void setAño_publicacion();

    Estrategia getEstrategia();

    void setEstrategia(Estrategia estrategia);
    
}