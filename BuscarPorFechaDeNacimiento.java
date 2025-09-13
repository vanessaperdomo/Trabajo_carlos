public class BuscarPorFechaDeNacimiento extends BuscarContacto {
    @Override
    public void buscar(Contacto[] contactos, int numContactos, Object criterio) {
        int anio = (Integer) criterio;
        boolean encontrado = false;
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getAñoNacimiento() == anio) {
                mostrarResultado(contactos[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron resultados.");
        }
    }
}