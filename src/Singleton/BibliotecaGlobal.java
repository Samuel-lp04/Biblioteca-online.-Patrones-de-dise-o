
package Singleton;

import FactoriaSimple_Estrategia.Libro;
import java.util.List;
import java.util.ArrayList;

public class BibliotecaGlobal {
    
    private static BibliotecaGlobal instance = null;
    
    protected List<Libro> libNovela;
    protected List<Libro> libPoesia;
    protected List<Libro> libRevista;
    
    protected BibliotecaGlobal() {
        libNovela = new ArrayList();
        libPoesia = new ArrayList();
        libRevista = new ArrayList();
    }
    
    public static BibliotecaGlobal getInstance() {
        
        if(instance == null) {
            instance = new BibliotecaGlobal();
        }
        
        return instance;
    }

    public List<Libro> getLibNovela() {
        return libNovela;
    }

    public void setLibNovela(List<Libro> libNovela) {
        this.libNovela = libNovela;
    }

    public List<Libro> getLibPoesia() {
        return libPoesia;
    }

    public void setLibPoesia(List<Libro> libPoesia) {
        this.libPoesia = libPoesia;
    }

    public List<Libro> getLibRevista() {
        return libRevista;
    }

    public void setLibRevista(List<Libro> libRevista) {
        this.libRevista = libRevista;
    }

    public boolean addNovela(Libro novela) {
        boolean added = false;
        
        if(!libNovela.contains(novela)) {
            libNovela.add(novela);
            
            added = true;
        }
        
        return added;
    }
    
    public boolean remNovela(Libro novela) {
        boolean removed = false;
        
        if(libNovela.contains(novela)) {
            libNovela.remove(novela);
            
            removed = true;
        }
        
        return removed;
    }
    
    public boolean addPoesia(Libro poesia) {
        boolean added = false;
        
        if(!libPoesia.contains(poesia)) {
            libPoesia.add(poesia);
            
            added = true;
        }
        
        return added;
    }
    
    public boolean remPoesia(Libro poesia) {
        boolean removed = false;
        
        if(libPoesia.contains(poesia)) {
            libPoesia.remove(poesia);
            
            removed = true;
        }
        
        return removed;
    }
    
    public boolean addRevista(Libro revista) {
        boolean added = false;
        
        if(!libRevista.contains(revista)) {
            libRevista.add(revista);
            
            added = true;
        }
        
        return added;
    }
    
    public boolean remRevista(Libro revista) {
        boolean removed = false;
        
        if(libRevista.contains(revista)) {
            libRevista.remove(revista);
            
            removed = true;
        }
        
        return removed;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "\n\n  NOVELAS\n";
        for(int i = 0; i < libNovela.size(); i++) {
            str += ((i + 1) + "- " + libNovela.get(i).toString()+"\n");
        }
        
        str += "\n\n  POESIA\n";
        for(int i = 0; i < libPoesia.size(); i++) {
            str += ((i + 1) + "- " + libPoesia.get(i).toString()+"\n");
        }
        
        str += "\n\n  REVISTAS\n";
        for(int i = 0; i < libRevista.size(); i++) {
            str += ((i + 1) + "- " + libRevista.get(i).toString()+"\n");
        }
        
        str += "\n";
        
        return str;
    }
    
}