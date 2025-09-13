public class BuscarPorTelefono extends BuscarContacto {
    @Override
    public void buscar(Contacto[] contactos, int numContactos, Object criterio) {
        String telefono = (String) criterio;
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getTelefono().equals(telefono)) {
                mostrarResultado(contactos[i]);
                return;
            }
        }
        mostrarResultado(null);
    }
}