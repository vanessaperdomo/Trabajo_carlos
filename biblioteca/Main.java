import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Reader> readers = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Registrar lector");
            System.out.println("4. Listar lectores");
            System.out.println("5. Registrar préstamo");
            System.out.println("6. Listar préstamos");
            System.out.println("7. Buscar préstamo por lector");
            System.out.println("8. Salir");
            System.out.println("9. Filtrar libros");
            System.out.println("10. Filtrar lectores");
            System.out.println("11. Filtrar préstamos");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: registerBook(); break;
                case 2: listBooks(); break;
                case 3: registerReader(); break;
                case 4: listReaders(); break;
                case 5: registerLoan(); break;
                case 6: listLoans(); break;
                case 7: searchLoanByReader(); break;
                case 8: System.out.println("Saliendo..."); break;
                case 9: filterBooks(); break;
                case 10: filterReaders(); break;
                case 11: filterLoans(); break;
                default: System.out.println("Opción inválida.");
            }
        } while (option != 8);
    }

    public static void registerBook() {
        System.out.println("ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Título:");
        String title = sc.nextLine();
        System.out.println("Autor:");
        String author = sc.nextLine();
        System.out.println("Género:");
        String genere = sc.nextLine();
        System.out.println("Fecha de publicación:");
        String pubDate = sc.nextLine();
        books.add(new Book(isbn, title, author, genere, pubDate));
    }

    public static void listBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void filterBooks() {
        System.out.println("Ingrese título o parte del título:");
        String filtro = sc.nextLine().toLowerCase();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(filtro)) {
                System.out.println(b);
            }
        }
    }

    public static void registerReader() {
        System.out.println("Nombre:");
        String name = sc.nextLine();
        System.out.println("Teléfono:");
        int tel = Integer.parseInt(sc.nextLine());
        System.out.println("Edad:");
        int age = Integer.parseInt(sc.nextLine());
        readers.add(new Reader(name, tel, age));
    }

    public static void listReaders() {
        for (Reader r : readers) {
            System.out.println(r);
        }
    }

    public static void filterReaders() {
        System.out.println("Ingrese nombre o parte del nombre:");
        String filtro = sc.nextLine().toLowerCase();
        for (Reader r : readers) {
            if (r.getName().toLowerCase().contains(filtro)) {
                System.out.println(r);
            }
        }
    }

    public static void registerLoan() {
        System.out.println("Nombre del lector:");
        String name = sc.nextLine();
        Reader reader = null;
        for (Reader r : readers) {
            if (r.getName().equalsIgnoreCase(name)) {
                reader = r;
                break;
            }
        }

        System.out.println("Título del libro:");
        String title = sc.nextLine();
        Book book = null;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                book = b;
                break;
            }
        }

        System.out.println("Fecha del préstamo:");
        String date = sc.nextLine();

        if (reader != null && book != null) {
            loans.add(new Loan(book, reader, date));
        } else {
            System.out.println("Error: libro o lector no encontrados.");
        }
    }

    public static void listLoans() {
        for (Loan l : loans) {
            System.out.println(l);
        }
    }

    public static void filterLoans() {
        System.out.println("Buscar por nombre del lector o título del libro:");
        String filtro = sc.nextLine().toLowerCase();
        for (Loan l : loans) {
            if (l.getReader().getName().toLowerCase().contains(filtro) ||
                l.getBook().getTitle().toLowerCase().contains(filtro)) {
                System.out.println(l);
            }
        }
    }

    public static void searchLoanByReader() {
        System.out.println("Nombre del lector:");
        String name = sc.nextLine();
        for (Loan l : loans) {
            if (l.getReader().getName().equalsIgnoreCase(name)) {
                System.out.println(l);
            }
        }
    }
}
