public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genere;
    private String publicationDate;

    public Book(String isbn, String title, String author, String genere, String publicationDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Libro: " + title + ", Autor: " + author + ", Género: " + genere + ", ISBN: " + isbn + ", Publicación: " + publicationDate;
    }
}
