public class BuscarPorApellido extends BuscarContacto {
    @Override
    public void buscar(Contacto[] contactos, int numContactos, Object criterio) {
        String apellido = (String) criterio;
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                mostrarResultado(contactos[i]);
                return;
            }
        }
        mostrarResultado(null);
    }
}