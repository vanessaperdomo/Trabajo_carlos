public class Loan {
    private Book book;
    private Reader reader;
    private String loanDate;

    public Loan(Book book, Reader reader, String loanDate) {
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public String getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return "Préstamo - Libro: " + book.getTitle() + " | Lector: " + reader.getName() + " | Fecha: " + loanDate;
    }
}
