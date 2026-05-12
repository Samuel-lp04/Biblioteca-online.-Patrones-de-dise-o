
package Main;

import Fachada.Fachada_Main_Usuario_Biblioteca;
import Fachada.UsEscritor;
import Fachada.UsLector;

public class Main {

    private static Fachada_Main_Usuario_Biblioteca fachada = new Fachada_Main_Usuario_Biblioteca();
    private static UsEscritor escritorPrueba;
    private static UsLector lectorPrueba;

    public static void main(String[] args) {

        // Creamos libros y usarios de prueba.
        fachada.creaUsuarioEscritor("Stephen King");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Stephen King"));
        fachada.createLibro(escritorPrueba, "IT", "SK001", "novela",
                "Siete amigos son perseguidos por una entidad sobrenatural.");
        fachada.createLibro(escritorPrueba, "El Resplandor", "SK002", "novela",
                "Un hotel manipula a vivos y muertos para sus propios fines.");
        fachada.createLibro(escritorPrueba, "Misery", "SK003", "novela",
                "Un escritor se despierta bajo los cuidados, una enfermera admiradora psicópata.");

        fachada.creaUsuarioEscritor("Laura Gallego");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Laura Gallego"));
        fachada.createLibro(escritorPrueba, "El valle de los lobos", "LG001", "novela",
                "A Dana, hija de una familia agricultora, le son develados los secretos de la magia ancestral.");
        fachada.createLibro(escritorPrueba, "Donde los arboles cantan", "LG002", "novela",
                "Viana, la única hija del duque de Rocagrís, está prometida al joven Robian de Castelmar desde que ambos eran niños.");
        fachada.createLibro(escritorPrueba, "La Emperatriz de los Etereos", "LG003", "novela",
                "Bipa busca a su amigo, arriesgando su propia vida en un mundo de hielo bañado por la luz de la estrella azul.");

        fachada.creaUsuarioEscritor("Brandom Sanderson");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Brandom Sanderson"));
        fachada.createLibro(escritorPrueba, "El ojo del mundo", "BS001", "novela",
                "Rand, Mat, Perrin y Egwene huyen para salvar a su pueblo de los ataques de los trollocs.");
        fachada.createLibro(escritorPrueba, "Estelar", "BS002", "novela",
                "Spensa esta segura de que la triste historia de su padre esconde mas secretos, viajara hasta el fin de la galaxia para desvelarlos y salvar a la humanidad.");
        fachada.createLibro(escritorPrueba, "La Tormenta", "BS003", "novela",
                "Rand al'Thor debe estar presente para que las fuerzas de la Luz tengan la oportunidad de ganar y detener el ser conocido como el Oscuro.");

        fachada.creaUsuarioEscritor("Agatha Christie");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Agatha Christie"));
        fachada.createLibro(escritorPrueba, "Asesinato en el Orient Express", "AC001", "novela",
                "El tren en el que viaja el detective privado Hercules Poirot es la escena de un asesinato.");
        fachada.createLibro(escritorPrueba, "Muerte en el Nilo", "AC002", "novela",
                "Linnet es encontrada con un disparo en la cabeza, una J pintada con sangre en la pared y muchas incongruencias.");
        fachada.createLibro(escritorPrueba, "La casa torcida", "AC003", "novela",
                "Sophia Leónides pide a su novio, el investigador Charles, que investigue el caso del asesinato de su abuelo en La Casa Torcida.");

        fachada.creaUsuarioEscritor("Gloria Fuertes");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Gloria Fuertes"));
        fachada.createLibro(escritorPrueba, "A veces quiero preguntarte cosas...", "GF001", "poesia", "Desamor");
        fachada.createLibro(escritorPrueba, "Parejas", "GF002", "poesia", "Amor");
        fachada.createLibro(escritorPrueba, "Oracion", "GF003", "poesia", "Religion");

        fachada.creaUsuarioEscritor("Antonio Machado");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Antonio Machado"));
        fachada.createLibro(escritorPrueba, "La Saeta", "AM001", "poesia", "Religion");
        fachada.createLibro(escritorPrueba, "A un olmo seco", "AM002", "poesia", "Perdida");
        fachada.createLibro(escritorPrueba, "Preludio", "AM003", "poesia", "Amor");

        fachada.creaUsuarioEscritor("William Shakespeare");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("William Shakespeare"));
        fachada.createLibro(escritorPrueba, "Sonet 116: Let me not to the marriage of true minds...", "WS001", "poesia",
                "Amor");
        fachada.createLibro(escritorPrueba, "Venus y Adonis", "WS002", "poesia", "Amor");
        fachada.createLibro(escritorPrueba, "La queja de una amante", "AM003", "poesia", "Desamor");

        fachada.creaUsuarioEscritor("Federico Garcia Lorca");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios()
                .get(fachada.buscaNombreUsuario("Federico Garcia Lorca"));
        fachada.createLibro(escritorPrueba, "Amor de mis entrañas, viva muerte...", "FGL001", "poesia", "Desamor");
        fachada.createLibro(escritorPrueba, "Agua, donde vas", "FGL002", "poesia", "Tiempo");
        fachada.createLibro(escritorPrueba, "Pueblo", "FGL003", "poesia", "Andalucia");

        fachada.creaUsuarioEscritor("Hip Hop Nation");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Hip Hop Nation"));
        fachada.createLibro(escritorPrueba, "Outkast, Arde Stankonia", "HHN001", "revista", "Musica");
        fachada.createLibro(escritorPrueba, "Ghostface Killah, manteniendo a Wu-Tang", "HHN002", "revista", "Musica");
        fachada.createLibro(escritorPrueba, "Kanye West, el primero de la clase", "HHN003", "revista", "Musica");

        fachada.creaUsuarioEscritor("Rolling Stone");
        escritorPrueba = (UsEscritor) fachada.getListaUsuarios().get(fachada.buscaNombreUsuario("Rolling Stone"));
        fachada.createLibro(escritorPrueba, "Michael Jackson, life as a man", "RS001", "revista", "Musica");
        fachada.createLibro(escritorPrueba, "Tupac Shakur, the strange and terrible saga", "RS002", "revista",
                "Musica");
        fachada.createLibro(escritorPrueba, "Hot throb: Bon Jovi", "RS003", "revista", "Musica");

        fachada.creaUsuarioLector("Samuel Lopez");
        fachada.creaUsuarioLector("Antonio Manuel Luque");

        fachada.showMRegistroInicioSesion();
    }

}
