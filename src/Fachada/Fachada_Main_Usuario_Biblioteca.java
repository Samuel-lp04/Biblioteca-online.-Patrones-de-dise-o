
package Fachada;

import FactoriaSimple_Estrategia.Libro;
import FactoriaSimple_Estrategia.LibroFactory;
import Singleton.BibRecomendada;
import Singleton.BibliotecaGlobal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fachada_Main_Usuario_Biblioteca {

    private static final int ID_SIZE = 10;
    private static final int NOM_SIZE = 3;
    private static final int MAX_RECOMENDADOS = 10;
    private static final Random rand = new Random();
    private static final Scanner input = new Scanner(System.in);
    
    private static BibliotecaGlobal BG;
    private static List<Usuario> listaUsuarios;
    
    public Fachada_Main_Usuario_Biblioteca() {
        BG = BibliotecaGlobal.getInstance();
        listaUsuarios = new ArrayList();
    }

        public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    //Registra usuario lector.
    public boolean creaUsuarioLector(String nombre) {
        boolean created = false;
        Usuario lector = null;
        String id;
        
        if(buscaNombreUsuario(nombre) < 0) {
            id = generaID(nombre, 'L');
            lector = new UsLector(nombre, id);
            listaUsuarios.add(lector);
            
            created = true;
        }
        
        return created;
    }
    
    //Registra usuario escritor.
    public boolean creaUsuarioEscritor(String nombre) {
        boolean created = false;
        Usuario escritor;
        String id;
        
        if(buscaNombreUsuario(nombre) < 0) {
            id = generaID(nombre, 'E');
            escritor = new UsEscritor(nombre, id);
            listaUsuarios.add(escritor);
            
            created = true;
        }
        
        return created;
    }
    
    public String generaID(String nombre, char type) {
        String id = "" + Character.toUpperCase(type);
        char[] nom = nombre.toCharArray();
        
        int i;
        for(i = 0; i < NOM_SIZE; i++) {
            id += Character.toUpperCase(nom[i]);
        }
        
        id += ("-" + Usuario.getCOUNT());
        
        for(i = i; i < ID_SIZE; i++) {
            id += "0";
        }
        
        return id;
    }
    
    public Usuario iniciaSesion(String nombre) {
        Usuario user = null;
        UsLector lector;
        UsEscritor escritor;
        int index = buscaNombreUsuario(nombre);
        
        if(index > -1) {
            user = listaUsuarios.get(index);
            System.out.println("\n   Iniciando sesion con: " + user.toString());
            
            if(user.getType() == 'L') {
                lector = (UsLector) user;
                
            
            } else {
                escritor = (UsEscritor) user;
                
            }
            
        } else {
            System.out.println("\n   NO SE PUDO INICIAR SESION\n\n");
            showMRegistroInicioSesion();
        }
        
        return user;
    }
    
    public int buscaNombreUsuario(String nombre) {
        int index;
        boolean found;
        Iterator<Usuario> it = listaUsuarios.iterator();
        
        index = -1;
        found = false;
        while(!found && it.hasNext()) {
            
            if(it.next().getNombre().equalsIgnoreCase(nombre)) {
                found = true;
            }
            
            index++;
        }
        
        if(!found) {
            index = -1;
        }
        
        return index;
    }
    
    public Libro buscaLibroRecomendado(UsLector lector, String isbn) {
        Libro libro = null;
        int index;
        boolean found;
        Iterator<Libro> it = lector.getRecomendados().getLibNovela().iterator();
        
        index = 0;
        found = false;
        while(!found && it.hasNext()) {
            
            if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                libro = lector.getRecomendados().getLibNovela().get(index);
                found = true;
            }
            
            index++;
        }
        
        if(!found) {
            it = lector.getRecomendados().getLibPoesia().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = lector.getRecomendados().getLibPoesia().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        if(!found) {
            it = lector.getRecomendados().getLibRevista().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = lector.getRecomendados().getLibRevista().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        return libro;
    }
    
    public Libro buscaLibroGuardado(UsLector lector, String isbn) {
        Libro libro = null;
        int index;
        boolean found;
        Iterator<Libro> it = lector.getGuardados().getLibNovela().iterator();
        
        index = 0;
        found = false;
        while(!found && it.hasNext()) {
            
            if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                libro = lector.getGuardados().getLibNovela().get(index);
                found = true;
            }
            
            index++;
        }
        
        if(!found) {
            it = lector.getGuardados().getLibPoesia().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = lector.getGuardados().getLibPoesia().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        if(!found) {
            it = lector.getGuardados().getLibRevista().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = lector.getGuardados().getLibRevista().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        return libro;
    }
    
    //Guardada en guardados.
    public void saveRecomendado(UsLector lector, Libro libro) {
        
        if(libro.getEstrategia().getGenero().equalsIgnoreCase("NOVELA")) {
            lector.getGuardados().addNovela(libro);
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("POESIA")) {
            lector.getGuardados().addPoesia(libro);
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("REVISTA")) {
            lector.getGuardados().addRevista(libro);
        }
    }
    
    //Quita de guardados.
    public void quitRecomendado(UsLector lector, Libro libro) {
        if(libro.getEstrategia().getGenero().equalsIgnoreCase("NOVELA")) {
            lector.getGuardados().remNovela(libro);
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("POESIA")) {
            lector.getGuardados().remPoesia(libro);
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("REVISTA")) {
            lector.getGuardados().remRevista(libro);
        }
    }
    
    //Muestra recomendados.
    public void showRecomendaciones(UsLector lector) {
        BibRecomendada disponibles = new BibRecomendada();
        int index;
        
        for(Libro n : BG.getLibNovela()) {
            if(!lector.getGuardados().getLibNovela().contains(n)) {
                disponibles.addNovela(n);
            }
        }
        while(lector.getRecomendados().getLibNovela().size() < MAX_RECOMENDADOS && disponibles.getLibNovela().size() !=0) {
            index = rand.nextInt(disponibles.getLibNovela().size());
            Libro novela = disponibles.getLibNovela().get(index);
            lector.getRecomendados().addNovela(novela);
            disponibles.remNovela(novela);
        }
        
        
        for(Libro p : BG.getLibPoesia()) {
            if(!lector.getGuardados().getLibPoesia().contains(p)) {
                disponibles.addPoesia(p);
            }
        }
        while(lector.getRecomendados().getLibPoesia().size() < MAX_RECOMENDADOS && disponibles.getLibPoesia().size() !=0) {
            index = rand.nextInt(disponibles.getLibPoesia().size());
            Libro poesia = disponibles.getLibPoesia().get(index);
            lector.getRecomendados().addPoesia(poesia);
            disponibles.remPoesia(poesia);
        }
        
        for(Libro r : BG.getLibRevista()) {
            if(!lector.getGuardados().getLibRevista().contains(r)) {
                disponibles.addRevista(r);
            }
        }
        while(lector.getRecomendados().getLibRevista().size() < MAX_RECOMENDADOS && disponibles.getLibRevista().size() !=0) {
            index = rand.nextInt(disponibles.getLibRevista().size());
            Libro revista = disponibles.getLibRevista().get(index);
            lector.getRecomendados().addRevista(revista);
            disponibles.remRevista(revista);
        }
        
        System.out.println(lector.getRecomendados().toString());
    }
    
    //Muestra guardados.
    public void showGuardados(UsLector lector) {
        System.out.println(lector.getGuardados().toString());
    }
    
    public Libro buscaLibroPublicado(UsEscritor escritor, String isbn) {
        Libro libro = null;
        int index;
        boolean found;
        Iterator<Libro> it = escritor.getPublicados().getLibNovela().iterator();
        
        index = 0;
        found = false;
        while(!found && it.hasNext()) {
            
            if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                libro = escritor.getPublicados().getLibNovela().get(index);
                found = true;
            }
            
            index++;
        }
        
        if(!found) {
            it = escritor.getPublicados().getLibPoesia().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = escritor.getPublicados().getLibPoesia().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        if(!found) {
            it = escritor.getPublicados().getLibRevista().iterator();
            
            index = 0;
            while(!found && it.hasNext()) {
                
                if(it.next().getIsbn().equalsIgnoreCase(isbn)) {
                    libro = escritor.getPublicados().getLibRevista().get(index);
                    found = true;
                }
                
                index++;
            }
        }
        
        return libro;
    }
    
    //Muestra publicados.
    public void showPublicados(UsEscritor escritor) {
        System.out.println(escritor.getPublicados().toString());
    }
    
    //Publica globalmente y guarda en publicados.
    public void publish(UsEscritor escritor, Libro libro) {
        
        if(libro.getEstrategia().getGenero().equalsIgnoreCase("NOVELA")) {
            
            if(!BG.getLibNovela().contains(libro)) {
                BG.addNovela(libro);
                escritor.getPublicados().addNovela(libro);
            }
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("POESIA")) {
            
            if(!BG.getLibPoesia().contains(libro)) {
                BG.addPoesia(libro);
                escritor.getPublicados().addPoesia(libro);
            }
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("REVISTA")) {
            
           if(!BG.getLibRevista().contains(libro)) {
                BG.addRevista(libro);
                escritor.getPublicados().addRevista(libro);
            } 
        }
        
        System.out.println("\n   Libro " + libro.toString() + " publicado correctamente.");
        System.out.println(escritor.getPublicados().toString());
    }
    
    //Quita globalmente y quita de publicados.
    public void delete(UsEscritor escritor, Libro libro) {
        
        if(libro.getEstrategia().getGenero().equalsIgnoreCase("NOVELA")) {
            
            if(BG.getLibNovela().contains(libro)) {
                BG.remNovela(libro);
                escritor.getPublicados().remNovela(libro);
            }
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("POESIA")) {
            
            if(BG.getLibPoesia().contains(libro)) {
                BG.remPoesia(libro);
                escritor.getPublicados().remPoesia(libro);
            }
            
        } else if(libro.getEstrategia().getGenero().equalsIgnoreCase("REVISTA")) {
            
           if(BG.getLibRevista().contains(libro)) {
                BG.remRevista(libro);
                escritor.getPublicados().remRevista(libro);
            } 
        }
        
    }

    public void showMRegistroInicioSesion() {
        int option;
        
        System.out.println("1- Registrarse");
        System.out.println("2- Iniciar Sesion");
        System.out.println("3- Salir");
        System.out.print("\n   Seleccione una opcion: ");
        option = input.nextInt();
        input.nextLine();
        
        if(option == 1) {
            showRegistro();
            
        } else if(option == 2) {
            showInicioSesion();
            
        } else if(option == 3){
            
        } else {
            System.out.println("\n   OPCION NO VALIDA\n\n");
            showMRegistroInicioSesion();
        }
    }
    
    public void showRegistro() {
        String nombre;
        char type;
        
        System.out.println("\n   Registrando nuevo Usuario:");
        
        System.out.print("Nombre: ");
        nombre = input.nextLine();
        
        System.out.print("Tipo de Usuario (E/L): ");
        type = input.nextLine().charAt(0);
        
        if((type == 'L') && (creaUsuarioLector(nombre))) {
            System.out.println("   Usurio Lector creado correctamente.");
            System.out.println(listaUsuarios.get(listaUsuarios.size() - 1).toString());
            iniciaSesion(nombre);
            
        } else if((type == 'E') && (creaUsuarioEscritor(nombre))) {
            System.out.println("   Usuario Escritor creado correctamente.");
            System.out.println(listaUsuarios.get(listaUsuarios.size() - 1).toString());
            iniciaSesion(nombre);
            
        } else if((creaUsuarioLector(nombre) || (creaUsuarioEscritor(nombre)))) {
            System.out.println("\n   USUARIO YA EXISTENTE\n\n");
            showMRegistroInicioSesion();
            
        } else {
            System.out.println("\n   TIPO DE USUARIO NO VALIDO\n\n");
            showMRegistroInicioSesion();
        }
    }
    
    public void showInicioSesion() {
        Usuario user;
        UsLector lector;
        UsEscritor escritor;
        String nombre;
        
        System.out.print("Nombre: ");
        nombre = input.nextLine();
        user = iniciaSesion(nombre);
        
        if(user.getType() == 'L') {
            lector = (UsLector) user;
            showRecomendaciones(lector);
            showGuardados(lector);
            showMGuardarQuitar(lector);
            
        } else {
            escritor = (UsEscritor) user;
            showPublicados(escritor);
            showMPublicarEliminar(escritor);
        }    
    }
    
    public void showMGuardarQuitar(UsLector lector) {
        int option;
        String isbn;
        Libro libro = null;
        
        System.out.println("1- Guardar");
        System.out.println("2- Quitar de Tus Guardados");
        System.out.println("3- Cerrar Sesion");
        System.out.print("\n   Seleccione una opcion: ");
        option = input.nextInt();
        input.nextLine();
        
        if(option == 1 ) {
            System.out.print("   Introduzca un ISBN: ");
            isbn = input.nextLine();
            libro = buscaLibroRecomendado(lector, isbn);
            
            if(libro == null) {
                System.out.println("\n   LIBRO NO ENCONTRADO\n\n");
                showRecomendaciones(lector);
                showGuardados(lector);
                showMGuardarQuitar(lector);
                
            } else {
                saveRecomendado(lector, libro);
                showRecomendaciones(lector);
                showGuardados(lector);
                showMGuardarQuitar(lector);
            }
            
        } else if(option == 2) {
            System.out.print("   Introduzca un ISBN: ");
            isbn = input.nextLine();
            libro = buscaLibroGuardado(lector, isbn);
            
            if(libro == null) {
                System.out.println("\n   LIBRO NO ENCONTRADO\n\n");
                showRecomendaciones(lector);
                showGuardados(lector);
                showMGuardarQuitar(lector);
                
            } else {
                quitRecomendado(lector, libro);
                showRecomendaciones(lector);
                showGuardados(lector);
                showMGuardarQuitar(lector);
            }
            
        } else if(option == 3) {
            System.out.println("\n   Cerrando sesion\n\n");
            showMRegistroInicioSesion();
            
        } else {
            System.out.println("\n   OPCION NO VALIDA\n\n");
            showRecomendaciones(lector);
            showGuardados(lector);
            showMGuardarQuitar(lector);
        }  
    }
    
    public void showMPublicarEliminar(UsEscritor escritor) {
        int option;
        String titulo, isbn, genero, desc;
        Libro libro = null;
        
        System.out.println("1- Publicar");
        System.out.println("2- Quitar de Tus Publicados");
        System.out.println("3- Cerrar sesion");
        System.out.print("\n   Seleccione una opcion: ");
        option = input.nextInt();
        input.nextLine();
        
        if(option == 1 ) {
            System.out.print("\n   Creando Libro:");
            System.out.print(" Introduzca titulo: ");
            titulo = input.nextLine();
            System.out.print(" Introduzca isbn: ");
            isbn = input.nextLine();
            System.out.print(" Introduzca genero: ");
            genero = input.nextLine();
            System.out.println(" Introduzca una descripcion/tema/tema principal: ");
            desc = input.nextLine();
            createLibro(escritor, titulo, isbn, genero, desc);
            showMPublicarEliminar(escritor);
            
            
        } else if(option == 2) {
            System.out.print("   Introduzca un ISBN: ");
            isbn = input.nextLine();
            libro = buscaLibroPublicado(escritor, isbn);
            
            if(libro == null) {
                System.out.println("\n   LIBRO NO ENCONTRADO\n\n");
                showPublicados(escritor);
                showMPublicarEliminar(escritor);
                
            } else {
                delete(escritor, libro);
                showPublicados(escritor);
                showMPublicarEliminar(escritor);
            }
            
        } else if(option == 3) {
            System.out.println("\n   Cerrando sesion\n\n");
            showMRegistroInicioSesion();
            
        } else {
            System.out.println("\n   OPCION NO VALIDA\n\n");
            showPublicados(escritor);
            showMPublicarEliminar(escritor);
        }  
    }
    
    public void createLibro(UsEscritor escritor, String titulo, String isbn, String genero, String desc) {
        Libro libro = null;
        
        if(genero.equalsIgnoreCase("NOVELA")) {
            libro = LibroFactory.crearNovela(titulo, escritor.getNombre(), isbn, desc);
            publish(escritor, libro);
            
        } else if(genero.equalsIgnoreCase("POESIA")) {
            libro = LibroFactory.crearPoesia(titulo, escritor.getNombre(), isbn, desc);
            publish(escritor, libro);
            
        } else if(genero.equalsIgnoreCase("REVISTA")) {
            libro = LibroFactory.crearRevista(titulo, escritor.getNombre(), isbn, desc);
            publish(escritor, libro);
        }
    }
    
}
