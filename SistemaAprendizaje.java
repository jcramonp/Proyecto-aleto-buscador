// hecho por el equipo del "aleto buscador"

// Priorizaremos los siguientes requisitos funcionales:
// 1. El sistema debe permitir a los usuarios realizar búsquedas avanzadas utilizando múltiples criterios, como fecha, autor o tema.
// 2. El sistema debe permitir a los usuarios guardar sus preferencias, como temas de interés y configuraciones de idioma.
// 3. El sistema debe ofrecer contenido multimedia, como videos y presentaciones, para mejorar la experiencia de aprendizaje.
// 4. El sistema debe ser capaz de importar datos externos de fuentes web y convertirlos en un formato utilizable.
// 5. El sistema debe permitir a los usuarios realizar ejercicios de práctica y rastrear su progreso.
// 6. El sistema debe presentar resultados de búsqueda de manera clara y ordenada, con opciones de filtro y ordenamiento.
// 7. El sistema debe proporcionar recomendaciones de lugares para estudiar basadas en la ubicación y las preferencias del usuario.
// 8. El sistema debe ofrecer consejos y técnicas de estudio relevantes para el usuario, personalizados según su historial de uso.
// 9. Deberá llevar un registro de las consultas más frecuentes.
// 10. Deberá ofrecer la capacidad de que los usuarios guarden recursos como favoritos o marquen elementos para su posterior revisión, asegurando que los usuarios puedan acceder fácilmente a contenido relevante en el futuro.
// 11. El sistema debe permitir al usuario buscar ejercicios y saber si ya los realizó o no.

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class SistemaAprendizaje {
   String[] contenidoMultimedia;
   String[] usuarios;
   String[] temasDeInteres;
   String[] idiomas;
   int multimediaCount;
   int usuarioCount;
   int temaCount;
   int idiomaCount;
   Scanner scanner;
   String[] ejerciciosRealizados;
   int cantidadEjercicios;
   String consultaFrecuente;
   List<String> recursosFavoritos;
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
    ejerciciosRealizados = new String[100];
    Arrays.fill(ejerciciosRealizados, "");
    cantidadEjercicios = 0;
    recursosFavoritos = new ArrayList<>();  
  }
  public void agregarContenidoMultimedia() {
    System.out.println("Como se llama el contenido que vas a agregar? ");
    String contenido = scanner.nextLine();

    System.out.println("Que tipo de contenido es? (Texto/Video/Audio) ");
    String tipoContenido = scanner.nextLine();

    contenidoMultimedia[multimediaCount++] = contenido + " - " + tipoContenido;

    System.out.println("El contenido de tipo " + tipoContenido + " ha sido agregado " + contenido);
  }

  public void guardarTemaDeInteres(){
    System.out.println("Cual es tu nombre? ");
    String usuario = scanner.nextLine();

    List<String> temasLista = new ArrayList<>();
    System.out.println("Introduce tus temas de interés, escribe 'fin' para terminar de agregar temas de interes ");
    while(true) {
      String tema = scanner.nextLine();
      if("fin".equalsIgnoreCase(tema)) {
        break;
      }

      temasLista.add(tema);
    }

    if(!temasLista.isEmpty()) {
      usuarios[usuarioCount++] = usuario;
      temasDeInteres[temaCount++] = String.join(", ", temasLista);
      System.out.println("Preferencia de tema(s) de interés guardada para " + usuario + ": " + String.join(", ", temasLista));
    }
  }

  public void guardarIdioma() {
    System.out.println("Introduce tu nombre del usuario ");
    String usuario = scanner.nextLine();

    System.out.println("Introduce el idioma de preferencia ");
    String idioma = scanner.nextLine();

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

  public void realizarEjerciciosPractica() {
    System.out.println("Realizando ejercicios de práctica y rastreando progreso...");
    if (cantidadEjercicios == 0) {
        System.out.println("No haz ejercicios realizados ");
        return;
    }
    System.out.println("Ejercicios Realizados: " + Arrays.toString(ejerciciosRealizados));
    System.out.print("Ingrese el nombre del ejercicio que desea realizar: ");
    String nuevoEjercicio = scanner.nextLine();
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
          return; 
        }
      }
    }
    if (!yaRealizado) {
      ejerciciosRealizados[cantidadEjercicios++] = nuevoEjercicio;
      System.out.println("Ejercicio agregado al progreso.");
    }
    System.out.println("Ejercicios Actualizados: " + Arrays.toString(ejerciciosRealizados));
  }
  public void importarDatosExternos() {
    System.out.println("Importando datos externos y convirtiéndolos a un formato utilizable...");
    System.out.println("Ingresa los datos que quieras proporcionarnos, escribe fin para termiinar de agregarlos ");
    ArrayList<String> datosExternos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
        String linea = scanner.nextLine();
        if (linea.equalsIgnoreCase("fin")) {
            break;
        }
        datosExternos.add(linea);
    }
    System.out.println("Los datos externos han sido importados correctamente ");
    for (String dato : datosExternos) {
        System.out.println(dato);
    }
  }
  public void presentarResultados() {
    System.out.println("Presentando resultados de búsqueda...");
    if (multimediaCount == 0) {
      System.out.println("No hay contenido multimedia para mostrar.");
    } else {
      System.out.println("El contenido multimedia disponible es ");
      for (int i = 0; i < multimediaCount; i++) {
        System.out.println((i + 1) + ". " + contenidoMultimedia[i]);
      }
    }
  }
  public void recomendacionesEstudio() {
    System.out.println("Proporcionando recomendaciones de lugares para estudiar...");
    System.out.print("Ingresa tu ubicación actual ");
    String ubicacionActual = scanner.nextLine();
    System.out.println("Recomendación de lugares para estudiar cerca de " + ubicacionActual + ":");
    System.out.println("1. Biblioteca Central Eafit");
    System.out.println("2. Centro de Estudio " + ubicacionActual);
    System.out.println("3. Café Estudiantil");
  }
  public void consejosEstudio() {
    System.out.println("Ofreciendo consejos y técnicas de estudio personalizadas...");
    System.out.print("Ingrese su nombre de usuario: ");
    String nombreUsuario = scanner.nextLine();
    System.out.println("¡Hola, " + nombreUsuario + "! Aquí van algunos consejos de estudio:");
    System.out.println("1. Establece metas claras antes de cada sesión de estudio.");
    System.out.println("2. Divide el material en bloques más pequeños para facilitar la comprensión.");
    System.out.println("3. Toma descansos regulares para mantener la concentración.");
  }
  public void registroConsultasFrecuentes() {
    System.out.println("Registrando las consultas más frecuentes...");
    System.out.print("Ingresa tu consulta frecuente ");
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
    System.out.println("Recursos Actuales: " + recursosFavoritos);
    System.out.print("Ingrese el recurso que desea gestionar: ");
    String nuevoRecurso = scanner.nextLine();
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
      recursosFavoritos.add(nuevoRecurso);
      System.out.println("Recurso agregado a favoritos.");
    }
    System.out.println("Recursos Actualizados: " + recursosFavoritos);
  }
}

class Main{
  public static void main(String[] args) {
    SistemaAprendizaje sistema = new SistemaAprendizaje();
    sistema.agregarContenidoMultimedia();
    sistema.agregarContenidoMultimedia();
    sistema.guardarTemaDeInteres();
    sistema.guardarIdioma();
    sistema.realizarEjerciciosPractica();
    sistema.importarDatosExternos();
    sistema.presentarResultados();
    sistema.recomendacionesEstudio();
    sistema.consejosEstudio();
    sistema.registroConsultasFrecuentes();
    sistema.gestionFavoritos();
  }
}
