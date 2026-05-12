
package Singleton;

public class BibGuardada extends BibliotecaGlobal {
    
    public BibGuardada() {
        super();
    }

    @Override
    public String toString() {
        String str = "\n  GUARDADOS\n";
        str += super.toString();
        
        return str;
    }
    
}
    

