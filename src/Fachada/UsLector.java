
package Fachada;

import Singleton.BibGuardada;
import Singleton.BibRecomendada;

public class UsLector extends Usuario {

    private BibRecomendada recomendados;
    private BibGuardada guardados;
    
    public UsLector(String nombre, String id) {
        super(nombre, id, 'L');
        recomendados = new BibRecomendada();
        guardados = new BibGuardada();
    }

    public BibRecomendada getRecomendados() {
        return recomendados;
    }

    public void setRecomendados(BibRecomendada recomendados) {
        this.recomendados = recomendados;
    }

    public BibGuardada getGuardados() {
        return guardados;
    }

    public void setGuardados(BibGuardada guardados) {
        this.guardados = guardados;
    }
    
}
