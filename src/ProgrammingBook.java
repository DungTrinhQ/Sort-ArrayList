public class ProgrammingBook extends Book {
    public ProgrammingBook(int bookCode, String name, double price, String author) {
        super(bookCode, name, price, author);
    }
    public String language;
    public String frameWork = null;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFrameWork() {
        return frameWork;
    }

    public void setFrameWork(String frameWork) {
        this.frameWork = frameWork;
    }

    public ProgrammingBook(int bookCode, String name, double price, String author, String language, String frameWork) {
        super(bookCode, name, price, author);
        this.language = language;
        this.frameWork = frameWork;
    }
}
