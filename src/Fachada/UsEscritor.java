
package Fachada;

import Singleton.BibPersonal;

public class UsEscritor extends Usuario {
    
    private BibPersonal publicados;
    
    public UsEscritor(String nombre, String id) {
        super(nombre, id, 'E');
        publicados = new BibPersonal();
    }

    public BibPersonal getPublicados() {
        return publicados;
    }

    public void setPublicados(BibPersonal publicados) {
        this.publicados = publicados;
    }
    
}