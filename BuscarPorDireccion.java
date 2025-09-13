public class BuscarPorDireccion extends BuscarContacto {
    @Override
    public void buscar(Contacto[] contactos, int numContactos, Object criterio) {
        String calle = (String) criterio;
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getCalle().equalsIgnoreCase(calle)) {
                mostrarResultado(contactos[i]);
                return;
            }
        }
        mostrarResultado(null);
    }
}