public class BuscarPorNombre extends BuscarContacto {
    @Override
    public void buscar(Contacto[] contactos, int numContactos, Object criterio) {
        String nombre = (String) criterio;
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                mostrarResultado(contactos[i]);
                return;
            }
        }
        mostrarResultado(null);
    }
}