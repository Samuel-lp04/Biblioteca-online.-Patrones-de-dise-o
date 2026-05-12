
package Singleton;

public class BibPersonal extends BibliotecaGlobal {
    
    public BibPersonal() {
        super();
    }
    
    @Override
    public String toString() {
        String str = "\n  PUBLICADOS \n";
        str += super.toString();
        
        return str;
    }
    
}