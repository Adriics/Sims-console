
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {

    public static Sim crearSim() {
        int year, month, dayMonth;
        System.out.println("Vas a crear un Sim, para empezar, elige el genero de tu Sim:   1)Hombre      2)Mujer");
        int generoSimNuevo = CLlegir.datoInt();
        Sim nuevoSim = null; // Variable para almacenar el nuevo Sim

        switch (generoSimNuevo) {
            case 1: {
                System.out.println("Escribe el nombre de tu Sim:");
                String nombreSim = CLlegir.dato();
                System.out.println("Escribe el primer apellido de tu Sim:");
                String primerApellidoSim = CLlegir.dato();
                System.out.println("Escribe el segundo apellido de tu Sim:");
                String segundoApellidoSim = CLlegir.dato();
                do {
                    System.out.println("Que anio nacio?");
                    year = CLlegir.datoInt();
                } while (year < 2030 && year > 2024);
                do {
                    System.out.println("Que mes nacio?");
                    month = CLlegir.datoInt();
                } while (month < 1 && month > 12);
                do {
                    System.out.println("Que dia del mes de " + month + " nacio?");
                    dayMonth = CLlegir.datoInt();
                } while (dayMonth < 1 && dayMonth > 31);
                GregorianCalendar nacimiento = new GregorianCalendar(year, month, dayMonth);
                boolean esMayorDeEdad = calcularEdad(nacimiento) >= 18;
                nuevoSim = new Hombre(nombreSim, primerApellidoSim, segundoApellidoSim, "Hombre", nacimiento);
                nuevoSim.setEsMayorDeEdad(esMayorDeEdad);

                break;
            }

            case 2: {
                System.out.println("Escribe el nombre de tu Sim:");
                String nombreSim = CLlegir.dato();
                System.out.println("Escribe el primer apellido de tu Sim:");
                String primerApellidoSim = CLlegir.dato();
                System.out.println("Escribe el segundo apellido de tu Sim:");
                String segundoApellidoSim = CLlegir.dato();
                do {
                    System.out.println("Que anio nacio?");
                    year = CLlegir.datoInt();
                } while (year < 2030 && year > 2024);
                do {
                    System.out.println("Que mes nacio?");
                    month = CLlegir.datoInt();
                } while (month < 1 && month > 12);
                do {
                    System.out.println("Que dia del mes de " + month + " nacio?");
                    dayMonth = CLlegir.datoInt();
                } while (dayMonth < 1 && dayMonth > 31);
                GregorianCalendar nacimiento = new GregorianCalendar(year, month, dayMonth);
                System.out.println("Esta embarada?   1) Si   2) No");
                int estaEmbarazada = CLlegir.datoInt();
                nuevoSim = new Mujer(nombreSim, primerApellidoSim, segundoApellidoSim, "Mujer", nacimiento);
                boolean esMayorDeEdad = calcularEdad(nacimiento) >= 18;
                nuevoSim.setEsMayorDeEdad(esMayorDeEdad);

                break;
            }

            default:
                System.out.println("Opcion no valida...");
        }

        return nuevoSim;
    }

    public static int calcularEdad(GregorianCalendar fechaNacimiento) {
        GregorianCalendar fechaActual = new GregorianCalendar();
        int anioActual = fechaActual.get(GregorianCalendar.YEAR);
        int mesActual = fechaActual.get(GregorianCalendar.MONTH) + 1; // Se suma 1 porque los meses en Java comienzan desde 0
        int diaActual = fechaActual.get(GregorianCalendar.DAY_OF_MONTH);

        int anioNacimiento = fechaNacimiento.get(GregorianCalendar.YEAR);
        int mesNacimiento = fechaNacimiento.get(GregorianCalendar.MONTH) + 1; // Se suma 1 por la misma razón que arriba
        int diaNacimiento = fechaNacimiento.get(GregorianCalendar.DAY_OF_MONTH);

        int edad = anioActual - anioNacimiento;
        // Ajuste para el mes de nacimiento
        if (mesNacimiento > mesActual || (mesNacimiento == mesActual && diaNacimiento > diaActual)) {
            edad--;
        }
        return edad;
    }

    public static void mostrarMenu() {
        System.out.println("1. Crear Sim");
        System.out.println("2. Crear historia del Sim");
        System.out.println("3. Guardar partida");
        System.out.println("4. Mostrar datos de los Sims creados");
        System.out.println("5. Jugar!");
        System.out.println("0. Salir del juego");
    }

    public static void guardarPartida(ArrayList<Sim> sims) {
        try {
            FileOutputStream fileOut = new FileOutputStream("partida.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sims);
            out.close();
            fileOut.close();
            System.out.println("Partida guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Sim> cargarPartida() {
        ArrayList<Sim> sims = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("partida.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sims = (ArrayList<Sim>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Partida cargada correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró ninguna partida guardada. Se creará una nueva.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sims;
    }

    public static void mostrarSims(ArrayList<Sim> listaSims) {
        for (int i = 0; i < listaSims.size(); i++) {
            System.out.println(listaSims.get(i).getNombre());
        }
    }

    public static void crearHistoria(ArrayList<Sim> listaSims) {
        System.out.println("De quien quieres crear la historia?");
        for (int i = 0; i < listaSims.size(); i++) {
            System.out.println(listaSims.get(i).nombre);
        }
        int opcionSim = CLlegir.datoInt();
        System.out.println("Vas a crear la historia de " + listaSims.get(opcionSim).nombre);
        System.out.println("Para empezar, dime como ha crecido " + listaSims.get(opcionSim).nombre + ".");
        System.out.println("1) Familia humilde   2) Familia media   3) Familia adinerada");
        int estiloPasadoSim = CLlegir.datoInt();
        switch (estiloPasadoSim) {
            case 1: {
                System.out.println("Vaya, asi que " + listaSims.get(opcionSim).nombre + " ha tenido una familia humilde...");
                System.out.println("En que barrio vive o vivia?");
                String barrioSim = CLlegir.dato();
                System.out.println("Vale, entiendo, " + listaSims.get(opcionSim).nombre + " vive en el barrio " + barrioSim + ".");
                if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) >= 18) {
                    System.out.println("Como " + listaSims.get(opcionSim).nombre + " es mayor de edad, puede trabajar o estudiar, incluso puede hacer las 2 cosas!");
                    System.out.println("Ahora mismo estas estudiando o trabajando?");
                    System.out.println("(RECUERDA QUE A MEDIDA QUE VAYAS JUGANDO ESTO PUEDE VARIAR, AHORA ES PARA LA HISTORIA)");
                    System.out.println("1. Estudio");
                    System.out.println("2. Trabajo");
                    int opcionEstudioTrabajo = CLlegir.datoInt();
                    if (opcionEstudioTrabajo == 1) {
                        if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 2 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 5) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion infantil");
                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 5 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 11) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion primaria");

                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 11 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 16) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la ESO");
                        }
                    } else if (opcionEstudioTrabajo == 2) {
                        System.out.println("Elige que tipo de trabajo tiene " + listaSims.get(opcionSim).nombre + ":");
                        System.out.println("1. Autonomo: Te permite trabajar por tu cuenta como artista, programador o emprendedor.");
                        System.out.println("2. Cajero: Horario laboral de 8:00h a 16:00h como cajero en Mercaduna");
                        System.out.println("3. Youtuber/Streamer: Quieres ser el tipico famoso youtuber como Ibai, aunque sea dificil, lo puedes llegar a conseguir.");
                        String estiloTrabajoSim = CLlegir.dato();
                        listaSims.get(opcionSim).trabajo = estiloTrabajoSim;
                        System.out.println("Perfecto! " + listaSims.get(opcionSim).nombre + " esta trabajando de " + listaSims.get(opcionSim).trabajo + "!");
                    }
                } else {
                    System.out.println("SIM MENOR DE EDAD");
                }
                /*PROGRAMAR ESTUDIOS Y OPCIONES DE ESTUDIOS PARA SIMS*/
                break;
            }
            case 2: {
                System.out.println("Perfecto, me lo anoto, " + listaSims.get(opcionSim).nombre + " ha vivido con una familia media.");
                System.out.println("En que barrio vive o vivia?");
                String barrioSim = CLlegir.dato();
                System.out.println("Vale, entiendo, " + listaSims.get(opcionSim).nombre + " vive en el barrio " + barrioSim + ".");
                if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) >= 18) {
                    System.out.println("Como " + listaSims.get(opcionSim).nombre + " es mayor de edad, puede trabajar o estudiar, incluso puede hacer las 2 cosas!");
                    System.out.println("Ahora mismo estas estudiando o trabajando?");
                    System.out.println("(RECUERDA QUE A MEDIDA QUE VAYAS JUGANDO ESTO PUEDE VARIAR, AHORA ES PARA LA HISTORIA)");
                    System.out.println("1. Estudio");
                    System.out.println("2. Trabajo");
                    int opcionEstudioTrabajo = CLlegir.datoInt();
                    if (opcionEstudioTrabajo == 1) {
                        if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 2 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 5) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion infantil");
                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 5 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 11) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion primaria");

                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 11 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 16) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la ESO");
                        }
                    } else if (opcionEstudioTrabajo == 2) {
                        System.out.println("Elige que tipo de trabajo tiene " + listaSims.get(opcionSim).nombre + ":");
                        System.out.println("1. Autonomo: Te permite trabajar por tu cuenta como artista, programador o emprendedor.");
                        System.out.println("2. Cajero: Horario laboral de 8:00h a 16:00h como cajero en Mercaduna");
                        System.out.println("3. Youtuber/Streamer: Quieres ser el tipico famoso youtuber como Ibai, aunque sea dificil, lo puedes llegar a conseguir.");
                        String estiloTrabajoSim = CLlegir.dato();
                        listaSims.get(opcionSim).trabajo = estiloTrabajoSim;
                        System.out.println("Perfecto! " + listaSims.get(opcionSim).nombre + " esta trabajando de " + listaSims.get(opcionSim).trabajo + "!");
                    }
                }

                /*PROGRAMAR ESTUDIOS Y OPCIONES DE ESTUDIOS PARA SIMS*/
                break;
            }
            case 3: {
                System.out.println("Vaya que suerte! " + listaSims.get(opcionSim).nombre + " ha vivido con una familia adinerada!");
                System.out.println("En que barrio vive o vivia?");
                String barrioSim = CLlegir.dato();
                System.out.println("Vale, entiendo, " + listaSims.get(opcionSim).nombre + " vive en el barrio " + barrioSim + ".");
                if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) >= 18) {
                    System.out.println("Como " + listaSims.get(opcionSim).nombre + " es mayor de edad, puede trabajar o estudiar, incluso puede hacer las 2 cosas!");
                    System.out.println("Ahora mismo estas estudiando o trabajando?");
                    System.out.println("(RECUERDA QUE A MEDIDA QUE VAYAS JUGANDO ESTO PUEDE VARIAR, AHORA ES PARA LA HISTORIA)");
                    System.out.println("1. Estudio");
                    System.out.println("2. Trabajo");
                    int opcionEstudioTrabajo = CLlegir.datoInt();
                    if (opcionEstudioTrabajo == 1) {
                        if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 2 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 5) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion infantil");
                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 5 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 11) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la educacion primaria");

                        } else if (calcularEdad(listaSims.get(opcionSim).fechaNacimiento) > 11 && calcularEdad(listaSims.get(opcionSim).fechaNacimiento) <= 16) {
                            System.out.println(listaSims.get(opcionSim).nombre + " va a la ESO");
                        }
                    } else if (opcionEstudioTrabajo == 2) {
                        System.out.println("Elige que tipo de trabajo tiene " + listaSims.get(opcionSim).nombre + ":");
                        System.out.println("1. Autonomo: Te permite trabajar por tu cuenta como artista, programador o emprendedor.");
                        System.out.println("2. Cajero: Horario laboral de 8:00h a 16:00h como cajero en Mercaduna");
                        System.out.println("3. Streamer: Quieres ser el tipico famoso youtuber como Ibai, aunque sea dificil, lo puedes llegar a conseguir.");
                        String estiloTrabajoSim = CLlegir.dato();
                        if (estiloTrabajoSim.equalsIgnoreCase("Autonomo") || estiloTrabajoSim.equalsIgnoreCase("Cajero") || estiloTrabajoSim.equalsIgnoreCase("Streamer")) {
                            listaSims.get(opcionSim).trabajo = estiloTrabajoSim;
                            System.out.println("Perfecto! " + listaSims.get(opcionSim).nombre + " esta trabajando de " + listaSims.get(opcionSim).trabajo + "!");

                        } else {
                            System.out.println("Trabajo no valido");
                        }
                    }
                }

                /*PROGRAMAR ESTUDIOS Y OPCIONES DE ESTUDIOS PARA SIMS*/
                break;
            }
            default: {
                System.out.println("Opcion no valida.");
            }
        }
    }

    public static void hablarAmistoso() {
        System.out.println("1. Como estas?");
        System.out.println("2. Conocer mejor");
        System.out.println("3. Mostrar fotos antiguas");
        System.out.println("4. Conversacion profunda");
        System.out.println("5. Hablar de la familia");
    }

    public static void hablarAmoroso() {
        System.out.println("1. Dar abrazo");
        System.out.println("2. Hablar de la pareja");
        System.out.println("3. Besar");
        System.out.println("4. Te quiero");
        System.out.println("5. Futuro");
    }

    public static void hablarDesahogarse() {
        System.out.println("1. Quejarse de problemas");
        System.out.println("2. ¿Me quieres?");
        System.out.println("3. ¡Me da rabia!");
        System.out.println("4. Te lo cuento todo");
        System.out.println("5. Hablar mal de la gente");
    }

    public static void hablarEnfadado() {
        System.out.println("1. No quiero estar con nadie");
        System.out.println("2. Hablar mal de la gente");
        System.out.println("3. Discutir");
        System.out.println("4. Quedarse callado");
        System.out.println("5. Insultar");
    }

    public static void hablarGracioso() {
        System.out.println("1. Contar chiste");
        System.out.println("2. Hacer tonterias");
        System.out.println("3. Reirse de anecdota");
        System.out.println("4. Conversar tonterias");
        System.out.println("5. Ponerse tonto");
    }

    public static void hablar() {
        int opcionAmistoso;
        int opcionAmoroso = 0;
        int opcionDesahogarse = 0;
        int opcionEnfadado = 0;
        int opcionGracioso = 0;
        System.out.println("En que estilo quieres hablar?");
        System.out.println("1. Amistoso");
        System.out.println("2. Amoroso");
        System.out.println("3. Desahogarse");
        System.out.println("4. Enfadado");
        System.out.println("5. Gracioso");
        int opcionHablar = CLlegir.datoInt();
        switch (opcionHablar) {
            case 1: {
                hablarAmistoso();
                System.out.println("ELIGE UNA OPCION");
                opcionAmistoso = CLlegir.datoInt();
                break;
            }
            case 2: {
                hablarAmoroso();
                opcionAmoroso = CLlegir.datoInt();
                break;
            }
            case 3: {
                hablarDesahogarse();
                opcionDesahogarse = CLlegir.datoInt();
                break;
            }
            case 4: {
                hablarEnfadado();
                opcionEnfadado = CLlegir.datoInt();
                break;
            }
            case 5: {
                hablarGracioso();
                opcionGracioso = CLlegir.datoInt();
                break;
            }
            default: {
                System.out.println("Opcion no valida");
                break;
            }
        }
    }

    public static void accionHablar(ArrayList<Sim> listaSims) {
        if (Sim.contSims >= 2) {
            System.out.println("Con quien quieres hablar?");
            for (int i = 0; i < listaSims.size(); i++) {
                System.out.println(listaSims.get(i).nombre);
            }
            int indexSim = CLlegir.datoInt();
            System.out.println("Quieres hablar con " + listaSims.get(indexSim).nombre + "?");
            System.out.println("1. SI    2. NO");
            int aceptar = CLlegir.datoInt();
            switch (aceptar) {
                case 1: {
                    hablar();
                    break;
                }
                case 2: {
                    System.out.println("De acuerdo, no quieres hablar");
                }
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void mostrarAcciones(ArrayList<Sim> listaSims) {
        System.out.println("1. Ir al lavabo");
        System.out.println("2. Comer");
        System.out.println("3. Ir a hacer footing");
        System.out.println("4. Echarse una siesta");
        System.out.println("5. Dormir");
        System.out.println("6. Hablar a: ");
        System.out.println("7. Darse una ducha");
        System.out.println("8. Consultar necesidades");
    }

    public static void jugar(ArrayList<Sim> listaSims) {
        int opcionAccion;
        Scanner neme = new Scanner(System.in);
        System.out.println("Hola, Bienvenido/a!");
        System.out.println("Estas jugando a los Sims ACS!");
        System.out.println("Por favor, elige con que personage quieres jugar!");
        mostrarSims(listaSims);
        int simJugar = CLlegir.datoInt();
        System.out.println("Antes de comenzar, elige en que tipo de ciudad quieres vivir:    1) Costa     2) Montania     3) Ciudad");
        String ciudadSim = CLlegir.dato();
        listaSims.get(simJugar).ciudad = ciudadSim;
        System.out.println("Perfecto! " + listaSims.get(simJugar).nombre + " vive en " + ciudadSim + ".");
        if (calcularEdad(listaSims.get(simJugar).fechaNacimiento) >= 18) {
            System.out.println("Tu sueldo principal es de 2000 euros! A medida que vayas trabajando tu sueldo ira incrementando o disminuyendo");
            System.out.println("Si estas mucho tiempo sin trabajar, tu sueldo se vera afectado ya que tienes que pagar la luz, el gas y todo lo de la casa que ahora vas a elegir, asi que elige con cuidado!");
            System.out.println("Pulsa ENTER para continuar...");
            neme.nextLine();
            System.out.println("Aqui tienes tus necesidades actuales:");
            System.out.println(listaSims.get(simJugar).mostrarNecesidades());
            System.out.println("En este juego puedes hacer diferentes acciones para las necesidades que le surgan a tu Sim, a medida que vayas jugando, las necesidades iran variando.");

        } else if (calcularEdad(listaSims.get(simJugar).fechaNacimiento) < 18) {
            System.out.println("Al ser menor, tienes que vivir con tus padres hasta que cumplas los 18 anios");
        }
        do {
            int indexSim;
            System.out.println("Salir : " + 0);
            mostrarAcciones(listaSims);
            opcionAccion = CLlegir.datoInt();
            switch (opcionAccion) {
                case 1: {
                    listaSims.get(simJugar).irAlLavabo();
                    System.out.println("Pulsa ENTER para continuar...");
                    neme.nextLine();
                    break;
                }
                case 2: {
                    listaSims.get(simJugar).comer();
                    System.out.println("Pulsa ENTER para continuar...");
                    neme.nextLine();
                    break;
                }
                case 3: {
                    listaSims.get(simJugar).hacerFooting();
                    break;
                }
                case 4: {
                    listaSims.get(simJugar).echarseSiesta();
                    break;
                }
                case 5: {
                    listaSims.get(simJugar).dormir();
                    break;
                }
                case 6: {
                    accionHablar(listaSims);
                    break;
                }
                case 7: {
                    listaSims.get(simJugar).darseUnaDucha();
                    break;
                }
                case 8: {
                    System.out.println("Que sim quieres consultar?");
                    mostrarSims(listaSims);
                    indexSim = CLlegir.datoInt();
                    System.out.println(listaSims.get(indexSim).mostrarNecesidades());
                    break;
                }
                case 0: {
                    System.out.println("No quieres hacer ninguna accion mas");
                    break;
                }
                default:
                    System.out.println("ERROR, opcion no valida");
                    break;
            }

        } while (opcionAccion != 0);

    }

    public static void main(String[] args) {

        ArrayList<Sim> listaSims = new ArrayList();
        ArrayList<String> estadoSim = new ArrayList();
        estadoSim.add("Feliz");
        estadoSim.add("Contento");
        estadoSim.add("Normal");
        estadoSim.add("Triste");
        estadoSim.add("Enfadado");

        int opcionMenu;

        System.out.println("BIENVENIDO AL JUEGO DE LOS SIMS, version ACS!, en este juego, pueden cambiar cosas a medida que lo vayamos jugando.\n Esta pensado para practicar, ya que es  un proyecto personal que hago con mucha ilusion. Dicho esto, te deseo mucha suerte con tu mundo Sim, ¡A disfrutar!");
// Intentar cargar partida guardada
        listaSims = cargarPartida();

        // Si no se ha cargado ninguna partida, crear un Sim nuevo
        listaSims.add(crearSim());
        Sim.contSims++;
        do {
            mostrarMenu();
            opcionMenu = CLlegir.datoInt();
            switch (opcionMenu) {
                case 1: {
                    listaSims.add(crearSim());
                    Sim.contSims++;
                    break;
                }
                case 2: {
                    crearHistoria(listaSims);
                    break;
                }
                case 3: {
                    guardarPartida(listaSims);
                    break;
                }
                case 4: {
                    mostrarSims(listaSims);
                    break;
                }
                case 5: {
                    jugar(listaSims);
                    break;
                }
                case 0: {
                    System.out.println("Saliendo del juego...");
                    break;
                }
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcionMenu != 0);
    }
}
