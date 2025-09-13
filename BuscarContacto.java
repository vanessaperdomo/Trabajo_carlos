public abstract class BuscarContacto {
    public abstract void buscar(Contacto[] contactos, int numContactos, Object criterio);

    protected void mostrarResultado(Contacto contacto) {
        if (contacto != null) {
            System.out.println("se encontro contacto :");
            contacto.mostrarContacto();
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }
}