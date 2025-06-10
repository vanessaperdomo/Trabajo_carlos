public class Reader {
    private String name;
    private int telephone;
    private int age;

    public Reader(String name, int telephone, int age) {
        this.name = name;
        this.telephone = telephone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Lector: " + name + ", Teléfono: " + telephone + ", Edad: " + age;
    }
}
