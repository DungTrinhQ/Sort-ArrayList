public class FictionBook extends Book {
    public FictionBook(int bookCode, String name, double price, String author) {
        super(bookCode, name, price, author);
    }
    public String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook(int bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }
}
