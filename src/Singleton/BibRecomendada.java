
package Singleton;

public class BibRecomendada extends BibliotecaGlobal {
    
    public BibRecomendada() {
        super();
    }
    
    @Override
    public String toString() {
        String str = "\n  RECOMENDADOS\n";
        str += super.toString();
        
        return str;
    }
}
