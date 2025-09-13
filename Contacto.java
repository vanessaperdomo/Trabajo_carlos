public class Contacto {
    private String nombre, segundoNombre, apellido, segundoApellido, profesion, rh, telefono, email, calle, ciudad;
    private int añoNacimiento;
  
    
    public Contacto(String nombre, String segundoNombre, String apellido, String segundoApellido, String profesion,
            String rh, String telefono, String email, String calle, String ciudad, 
            int añoNacimiento) {
   
       
        this.nombre = nombre; this.segundoNombre = segundoNombre; this.apellido = apellido; this.segundoApellido = segundoApellido;
        this.profesion = profesion; this.rh = rh; this.telefono = telefono; this.email = email; this.calle = calle;
        this.ciudad = ciudad; this.añoNacimiento = añoNacimiento;
    }



    public String getNombre() { return nombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getApellido() { return apellido; }
    public String getSegundoApellido() { return segundoApellido; }
    public String getProfesion() { return profesion; }
    public String getRh() { return rh; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public int getAñoNacimiento() { return añoNacimiento; }

    public void mostrarContacto() {
        System.out.println("Nombre: " + nombre + (segundoNombre.isEmpty() ? "" : " " + segundoNombre) + " " + apellido + (segundoApellido.isEmpty() ? "" : " " + segundoApellido) +
                           "Profesión: " + profesion + "RH: " + rh + "Teléfono: " + telefono + "Email: " + email +
                           "Dirección: " + calle + ", " + ciudad + ", "  + "Año de nacimiento: " + añoNacimiento  );
    }
}