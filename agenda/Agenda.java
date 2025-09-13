import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Contacto[] contactos = new Contacto[10];
        int numContactos = 0;

    
        BuscarPorNombre buscadorNombre = new BuscarPorNombre();
        BuscarPorApellido buscadorApellido = new BuscarPorApellido();
        BuscarPorTelefono buscadorTelefono = new BuscarPorTelefono();
        BuscarPorDireccion buscadorDireccion = new BuscarPorDireccion();
        BuscarPorFechaDeNacimiento buscadorFecha = new BuscarPorFechaDeNacimiento();

        while (true) {
            System.out.println(" AGENDA AVANZADA");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Buscar por apellido");
            System.out.println("5. Buscar por teléfono");
            System.out.println("6. Buscar por dirección");
            System.out.println("7. Buscar por fecha nacimiento");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    if (numContactos >= contactos.length) {
                        System.out.println("Error: La agenda está llena (máximo 50 contactos).");
                        break;
                    }

                    System.out.print("Primer nombre: ");
                    String nombre = teclado.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacío.");
                        break;
                    }

                    System.out.print("Segundo nombre (Enter si no tiene): ");
                    String segundoNombre = teclado.nextLine().trim();

                    System.out.print("Primer apellido: ");
                    String apellido = teclado.nextLine().trim();
                    if (apellido.isEmpty()) {
                        System.out.println("Error: El apellido no puede estar vacío.");
                        break;
                    }

                    System.out.print("Segundo apellido (Enter si no tiene): ");
                    String segundoApellido = teclado.nextLine().trim();

                    System.out.print("Profesión: ");
                    String profesion = teclado.nextLine().trim();
                    if (profesion.isEmpty()) {
                        System.out.println("Error: La profesión no puede estar vacía.");
                        break;
                    }

                    System.out.print("RH (ej. A+, O-, etc.): ");
                    String rh = teclado.nextLine().trim();
                    if (!rh.matches("^(A|B|AB|O)[+-]$")) {
                        System.out.println("Error: RH inválido (ej. A+, O-, etc.).");
                        break;
                    }

                    System.out.print("Teléfono (7-15 dígitos): ");
                    String telefono = teclado.nextLine();
                    if (!telefono.matches("\\d{7,15}")) {
                        System.out.println("Error: El teléfono debe tener entre 7 y 15 dígitos.");
                        break;
                    }

                    System.out.print("Email: ");
                    String email = teclado.nextLine();
                    if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                        System.out.println("Error: El email no es válido.");
                        break;
                    }

                    System.out.print("Calle: ");
                    String calle = teclado.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = teclado.nextLine();
         

                    System.out.print("Año de nacimiento (1900-2025): ");
                    String añoInput = teclado.nextLine();
                    int añoNacimiento;
                    try {
                        añoNacimiento = Integer.parseInt(añoInput);
                        if (añoNacimiento < 1900 || añoNacimiento > 2025) {
                            System.out.println("Error: El año debe estar entre 1900 y 2025.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El año debe ser un número.");
                        break;
                    }

                    contactos[numContactos] = new Contacto(
                        nombre, segundoNombre, apellido, segundoApellido, profesion, rh,
                        telefono, email, calle, ciudad, añoNacimiento
                    );
                    numContactos++;
                    System.out.println("Contacto agregado con éxito.");
                    break;

                case 2:
                    System.out.println(" Lista de Contactos ");
                    if (numContactos == 0) {
                        System.out.println("No hay contactos en la agenda.");
                    } else {
                        for (int i = 0; i < numContactos; i++) {
                            System.out.println("Contacto " + (i + 1) + ":");
                            contactos[i].mostrarContacto();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String nombreBuscar = teclado.nextLine();
                    buscadorNombre.buscar(contactos, numContactos, nombreBuscar);
                    break;

                case 4:
                    System.out.print("Ingrese apellido a buscar: ");
                    String apellidoBuscar = teclado.nextLine();
                    buscadorApellido.buscar(contactos, numContactos, apellidoBuscar);
                    break;

                case 5:
                    System.out.print("Ingrese teléfono a buscar: ");
                    String telefonoBuscar = teclado.nextLine();
                    buscadorTelefono.buscar(contactos, numContactos, telefonoBuscar);
                    break;

                case 6:
                    System.out.print("Ingrese calle a buscar: ");
                    String calleBuscar = teclado.nextLine();
                    buscadorDireccion.buscar(contactos, numContactos, calleBuscar);
                    break;

                case 7:
                    System.out.print("Ingrese año de nacimiento a buscar: ");
                    String anioBuscarInput = teclado.nextLine();
                    try {
                        int anioBuscar = Integer.parseInt(anioBuscarInput);
                        buscadorFecha.buscar(contactos, numContactos, anioBuscar);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El año debe ser un número.");
                    }
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    teclado.close();
                    return;

                default:
                    System.out.println("Error: Opción no válida. Elija entre 1 y 8.");
            }
        }
    }
}

 /* Elemento	Función Principal
parseInt()	Validar y convertir datos numéricos (año de nacimiento).
trim() + isEmpty()	Limpiar y validar campos obligatorios (evitar datos vacíos).
matches()	Garantizar formatos específicos (RH, teléfono, email).
try-catch	Manejo seguro de errores (evitar crashes por inputs incorrectos).
switch-case	Controlar el flujo del menú de opciones.
Contacto[]	Almacenamiento estructurado de los contactos.
nextLine()	Capturar datos completos (ej. nombres compuestos: "María José")*/