// hecho por el equipo del "aleto buscador"

// Priorizaremos los siguientes requisitos funcionales:
// 1. El sistema debe permitir a los usuarios realizar búsquedas avanzadas utilizando múltiples criterios, como fecha, autor o tema.
// 2. El sistema debe permitir a los usuarios guardar sus preferencias, como temas de interés y configuraciones de idioma.
// 4. El sistema debe ofrecer contenido multimedia, como videos y presentaciones, para mejorar la experiencia de aprendizaje.
// 5. El sistema debe permitir a los usuarios realizar búsquedas avanzadas utilizando múltiples criterios, como fecha, autor o tema.
// 6. El sistema debe ser capaz de importar datos externos de fuentes web y convertirlos en un formato utilizable.
// 7. El sistema debe permitir a los usuarios realizar ejercicios de práctica y rastrear su progreso.
// 8. El sistema debe ofrecer contenido multimedia, como videos y presentaciones, para mejorar la experiencia de aprendizaje.
// 9. El sistema debe presentar resultados de búsqueda de manera clara y ordenada, con opciones de filtro y ordenamiento.
// 10. El sistema debe proporcionar recomendaciones de lugares para estudiar basadas en la ubicación y las preferencias del usuario.
// 11. El sistema debe ofrecer consejos y técnicas de estudio relevantes para el usuario, personalizados según su historial de uso.
// 12. Deberá llevar un registro de las consultas más frecuentes.
// 13. El sistema debe permitir a los usuarios guardar sus preferencias, como temas de interés y configuraciones de idioma.
// 14. Deberá ofrecer la capacidad de que los usuarios guarden recursos como favoritos o marquen elementos para su posterior revisión, asegurando que los usuarios puedan acceder fácilmente a contenido relevante en el futuro.


import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaAprendizaje {
  private String[] contenidoMultimedia;
  private String[] usuarios;
  private String[] temasDeInteres;
  private String[] idiomas;
  private int multimediaCount;
  private int usuarioCount;
  private int temaCount;
  private int idiomaCount;
  private Scanner scanner;
  private String[] ejerciciosRealizados;
  private int cantidadEjercicios;
  private String consultaFrecuente;
  private List<String> recursosFavoritos;
  
  public SistemaAprendizaje() {
    contenidoMultimedia = new String[100];
    usuarios = new String[100];
    temasDeInteres = new String[100];
    idiomas = new String[100];
    multimediaCount = 0;
    usuarioCount = 0;
    temaCount = 0;
    idiomaCount = 0;
    scanner = new Scanner(System.in);
    ejerciciosRealizados = new String[100];  // Inicializar la matriz de ejerciciosRealizados
    cantidadEjercicios = 0;
    recursosFavoritos = new ArrayList<>();  // Inicializar la lista de recursosFavoritos
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
      
      if (partes.length >= 3) {
        String contenidoFecha = partes[0];
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

    // Nuevos métodos para los requisitos adicionales

  public void realizarEjerciciosPractica() {
    System.out.println("Realizando ejercicios de práctica y rastreando progreso...");
    
    // Verificar si no hay ejercicios realizados
    if (cantidadEjercicios == 0) {
        System.out.println("No hay ejercicios realizados.");
        return;
    }

    // Mostrar los ejercicios realizados
    System.out.println("Ejercicios Realizados: " + Arrays.toString(ejerciciosRealizados));


    
    // M
    
    // Solicitar al usuario que ingrese un nuevo ejercicio para realizar
    System.out.print("Ingrese el nombre del ejercicio que desea realizar: ");
    String nuevoEjercicio = scanner.nextLine();
    
    // Verificar si el ejercicio ya ha sido realizado
    boolean yaRealizado = false;
    for (int i = 0; i < cantidadEjercicios; i++) {
      if (ejerciciosRealizados[i].equals(nuevoEjercicio)) {
        yaRealizado = true;
        System.out.println("El ejercicio ya ha sido realizado. ¿Desea reiniciar su progreso? (S/N)");
        String opcion = scanner.nextLine().toUpperCase();
        if (opcion.equals("S")) {
          System.out.println("Progreso reiniciado para el ejercicio.");
        } else {
          System.out.println("Operación cancelada.");
          return; // Salir del método si no se reinicia el progreso
        }
      }
    }

    // Si el ejercicio no ha sido realizado previamente, agregarlo a la lista
    if (!yaRealizado) {
      ejerciciosRealizados[cantidadEjercicios++] = nuevoEjercicio;
      System.out.println("Ejercicio agregado al progreso.");
    }
    
    // Mostrar los ejercicios actualizados
    System.out.println("Ejercicios Actualizados: " + Arrays.toString(ejerciciosRealizados));
  }
  
  public void importarDatosExternos() {
    System.out.println("Importando datos externos y convirtiéndolos a un formato utilizable...");

    // Lógica para importar datos externos (ejemplo: desde el teclado)
    System.out.println("Ingrese los datos externos (escriba 'fin' para finalizar la entrada):");

    ArrayList<String> datosExternos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        String linea = scanner.nextLine();
        if (linea.equalsIgnoreCase("fin")) {
            break;
        }
        datosExternos.add(linea);
    }

    // Cerrar el escáner después de utilizarlo
    scanner.close();

    System.out.println("Datos externos importados correctamente:");
    for (String dato : datosExternos) {
        System.out.println(dato);
    }
}
  
  public void presentarResultados() {
    System.out.println("Presentando resultados de búsqueda...");
    
    // Lógica para presentar resultados de búsqueda de manera clara y ordenada,
    // con opciones de filtro y ordenamiento (ejemplo: mostrar contenido multimedia)
    if (multimediaCount == 0) {
      System.out.println("No hay contenido multimedia para mostrar.");
    } else {
      System.out.println("Contenido multimedia disponible:");
      for (int i = 0; i < multimediaCount; i++) {
        System.out.println((i + 1) + ". " + contenidoMultimedia[i]);
      }
    }
  }
  
  public void recomendacionesEstudio() {
    System.out.println("Proporcionando recomendaciones de lugares para estudiar...");
    
    // Lógica para proporcionar recomendaciones de lugares para estudiar basadas en la ubicación
    // y preferencias del usuario (ejemplo: sugerir una biblioteca cercana)
    System.out.print("Ingrese su ubicación actual: ");
    String ubicacionActual = scanner.nextLine();
    
    System.out.println("Recomendación de lugares para estudiar cerca de " + ubicacionActual + ":");
    System.out.println("1. Biblioteca Central");
    System.out.println("2. Centro de Estudio XYZ");
    System.out.println("3. Café Estudiantil");
    
    // Puedes agregar más lógica de recomendaciones según tus necesidades
  }
  
  public void consejosEstudio() {
    System.out.println("Ofreciendo consejos y técnicas de estudio personalizadas...");
    
    // Lógica para ofrecer consejos y técnicas de estudio personalizadas según el historial de uso del usuario
    System.out.print("Ingrese su nombre de usuario: ");
    String nombreUsuario = scanner.nextLine();
    
    // Puedes tener un sistema más sofisticado basado en el historial del usuario
    // Aquí, simplemente proporcionaremos consejos genéricos
    System.out.println("¡Hola, " + nombreUsuario + "! Aquí van algunos consejos de estudio:");
    System.out.println("1. Establece metas claras antes de cada sesión de estudio.");
    System.out.println("2. Divide el material en bloques más pequeños para facilitar la comprensión.");
    System.out.println("3. Toma descansos regulares para mantener la concentración.");
    
    // Puedes agregar más consejos según tus conocimientos específicos sobre el usuario
  }
  
  public void registroConsultasFrecuentes() {
    System.out.println("Registrando las consultas más frecuentes...");
    
    System.out.print("Ingrese su consulta: ");
    String nuevaConsulta = scanner.nextLine();
    
    if (nuevaConsulta.equals(consultaFrecuente)) {
      System.out.println("Consulta ya registrada como frecuente: " + nuevaConsulta);
    } else {
      consultaFrecuente = nuevaConsulta;
      System.out.println("Nueva consulta frecuente registrada: " + nuevaConsulta);
    }
  }
  
  
  public void gestionFavoritos() {
    System.out.println("Gestionando recursos favoritos...");
    System.out.println("Gestionando recursos favoritos...");
    
    // Mostrar los recursos actuales
    System.out.println("Recursos Actuales: " + recursosFavoritos);
    
    // Solicitar al usuario que ingrese un nuevo recurso para gestionar
    System.out.print("Ingrese el recurso que desea gestionar: ");
    String nuevoRecurso = scanner.nextLine();
    
    // Verificar si el recurso ya está en favoritos
    if (recursosFavoritos.contains(nuevoRecurso)) {
      System.out.println("El recurso ya está en favoritos. ¿Desea quitarlo? (S/N)");
      String opcion = scanner.nextLine().toUpperCase();
      if (opcion.equals("S")) {
        recursosFavoritos.remove(nuevoRecurso);
        System.out.println("Recurso eliminado de favoritos.");
      } else {
        System.out.println("Operación cancelada.");
      }
    } else {
      // Agregar el nuevo recurso a favoritos
      recursosFavoritos.add(nuevoRecurso);
      System.out.println("Recurso agregado a favoritos.");
    }
    
    // Mostrar los recursos actualizados
    System.out.println("Recursos Actualizados: " + recursosFavoritos);
  }


  public static void main(String[] args) {
    SistemaAprendizaje sistema = new SistemaAprendizaje();
    
    sistema.agregarContenidoMultimedia("2023-09-02 - Autor1 - Tema1");
    sistema.agregarContenidoMultimedia("2023-09-03 - Autor2 - Tema2");
    sistema.guardarTemaDeInteres("usuario1", "Ciencia");
    sistema.agregarContenidoMultimedia("2023-09-02 - Autor1 - Tema1");
    sistema.agregarContenidoMultimedia("2023-09-03 - Autor2 - Tema2");
    sistema.guardarTemaDeInteres("usuario1", "Ciencia");
    sistema.guardarIdioma("usuario1", "Español");
    sistema.buscarAvanzado("2023-09-02", "Autor1", "Tema1");
    sistema.realizarEjerciciosPractica();
    sistema.importarDatosExternos();
    sistema.presentarResultados();
    sistema.recomendacionesEstudio();
    sistema.consejosEstudio();
    sistema.registroConsultasFrecuentes();
    sistema.gestionFavoritos();
  }
}
