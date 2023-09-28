// hecho por el equipo del "aleto buscador"

// Priorizaremos los siguientes requisitos funcionales:
// 1. El sistema debe permitir a los usuarios realizar búsquedas avanzadas utilizando múltiples criterios, como fecha, autor o tema.
// 2. El sistema debe permitir a los usuarios guardar sus preferencias, como temas de interés y configuraciones de idioma.
//3. El sistema debe ofrecer contenido multimedia, como videos y presentaciones, para mejorar la experiencia de aprendizaje

class SistemaAprendizaje {

    
    private String[] contenidoMultimedia;
    private String[] usuarios;
    private String[] temasDeInteres;
    private String[] idiomas;

    
    private int multimediaCount;
    private int usuarioCount;
    private int temaCount;
    private int idiomaCount;

    
    public SistemaAprendizaje() {
        contenidoMultimedia = new String[100]; 
        usuarios = new String[100];
        temasDeInteres = new String[100];
        idiomas = new String[100];
        multimediaCount = 0;
        usuarioCount = 0;
        temaCount = 0;
        idiomaCount = 0;
    }

    
    public void agregarContenidoMultimedia(String contenido) {
        contenidoMultimedia[multimediaCount++] = contenido;
        System.out.println("Contenido multimedia agregado: " + contenido);
    }

    
    public void guardarTemaDeInteres(String usuario, String tema) {
        usuarios[usuarioCount] = usuario;
        temasDeInteres[temaCount] = tema;
        System.out.println("Preferencia de tema de interés guardada para " + usuario + ": " + tema);
        usuarioCount++;
        temaCount++;
    }

    
    public void guardarIdioma(String usuario, String idioma) {
        usuarios[usuarioCount] = usuario;
        idiomas[idiomaCount] = idioma;
        System.out.println("Configuración de idioma guardada para " + usuario + ": " + idioma);
        usuarioCount++;
        idiomaCount++;
    }

    
    
    public void buscarAvanzado(String fecha, String autor, String tema) {
        System.out.println("Realizando búsqueda avanzada...");

    
        for (int i = 0; i < multimediaCount; i++) {
            String contenido = contenidoMultimedia[i];
            String[] partes = contenido.split(" - ");

        
            if (partes.length >= 4) {
                String contenidoFecha = partes[3];
                String contenidoAutor = partes[1];
                String contenidoTema = partes[2];

            
                boolean cumpleCriterios = true;
                if (fecha != null && !contenidoFecha.equals(fecha)) {
                    cumpleCriterios = false;
                }
                if (autor != null && !contenidoAutor.equals(autor)) {
                    cumpleCriterios = false;
                }
                if (tema != null && !contenidoTema.equals(tema)) {
                    cumpleCriterios = false;
                }

            
                if (cumpleCriterios) {
                    System.out.println("Resultado encontrado: " + contenido);
                }
            }
        }
    }

//EJEMPLOS

    public static void main(String[] args) {
        SistemaAprendizaje sistema = new SistemaAprendizaje();

        
        sistema.agregarContenidoMultimedia("Video1 - Introducción al tema");
        sistema.agregarContenidoMultimedia("Presentación1 - Tema importante");

        sistema.guardarTemaDeInteres("usuario1", "Ciencia");
        sistema.guardarIdioma("usuario1", "Español");

        
        sistema.buscarAvanzado("2023-09-02", "Autor1", "Tema1");
    }
}
