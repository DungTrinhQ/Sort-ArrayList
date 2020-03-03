import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        ProgrammingBook book1 = new ProgrammingBook(1, "Lập trình hướng đối tượng JAVA core dành cho người mới bắt đầu học lập trình", 189.000, "Noname1", "Java", "null");
        ProgrammingBook book2 = new ProgrammingBook(2, "Bộ sách Thế giới Hacker và An Toàn Thông Tin Mạng", 735.425, "Noname2", "vietnamese", "null");
        ProgrammingBook book3 = new ProgrammingBook(3, "Giáo Trình C++ Và Lập Trình Hướng Đối Tượng", 97.150, "Noname3", "C++", "null");
        FictionBook book4 = new FictionBook(4, "Và Rồi, Tháng 9 Không Có Cậu Đã Tới", 74.200, "Natsuki Amasawa", "light novel");
        FictionBook book5 = new FictionBook(5, "Harry Potter Và Chiếc Cốc Lửa", 144.990, "J. K. Rowling", "tiểu thuyểt");
        FictionBook book6 = new FictionBook(6, "Án Mạng Trên Chuyến Tàu Tốc Hành Phương Đông", 64.480, "Agatha Christie", "truyện trinh thám");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        System.out.println(bookList);
        searchBook("Và Rồi, Tháng 9 Không Có Cậu Đã Tới",bookList);
        selectionSort(bookList);
        bubbleSort(bookList);
        insertionSort(bookList);
        insertionSortName(bookList);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a title to search: ");
        String title = input.nextLine();
        double result = binarySearch(bookList,title);
        if (result == -1){
            System.out.println("Not found!");
        }else{
            System.out.println(title + ": " + result);
        }
    }

    public static void searchBook(String name, ArrayList<Book> bookList) {
        for (Book book : bookList) {
            if (book.name.equals(name)) {
                System.out.println("Price is: " + book.price);
            }
        }
    }

    public static void selectionSort(ArrayList<Book> bookList) {
        for (int i = 0; i < bookList.size() - 1; i++) {
            Book currentBook = bookList.get(i);
            double currentMin = bookList.get(i).price;
            int currentMinIndex = i;
            for (int j = i + 1; j < bookList.size(); j++) {
                if (currentMin > bookList.get(j).price) {
                    currentBook = bookList.get(j);
                    currentMin = bookList.get(j).price;
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                bookList.set(currentMinIndex, bookList.get(i));
                bookList.set(i, currentBook);
            }
        }
        System.out.println("Selection sort: ");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static void bubbleSort(ArrayList<Book> bookList) {
        boolean needNextPass = true;

        for (int i = 1; i < bookList.size() && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < bookList.size() - i; j++) {
                if (bookList.get(j).price > bookList.get(j + 1).price) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);

                    needNextPass = true;
                }
            }
        }
        System.out.println("Bubble Sort:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static void insertionSort(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n; i++) {
            Book currentBook = bookList.get(i);
            double key = bookList.get(i).price;
            int j = i - 1;
            while (j >= 0 && bookList.get(j).price > key) {
                bookList.set(j + 1, bookList.get(j));
                j--;
            }
            bookList.set(j + 1, currentBook);
        }
        System.out.println("Insertion Sort:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static void insertionSortName(ArrayList<Book> bookList) {
        int n = bookList.size();
        for (int i = 0; i < n; i++) {
            Book currentBook = bookList.get(i);
            String key = bookList.get(i).name;
            int j = i - 1;
            while (j >= 0 && bookList.get(j).name.compareTo(key) > 0) {
                bookList.set(j + 1, bookList.get(j));
                j--;
            }
            bookList.set(j + 1, currentBook);
        }
        System.out.println("Insertion Sort by Name:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static double binarySearch(ArrayList<Book> bookList, String name){
        int low = 0;
        int hight = bookList.size() - 1;
        while (low <= hight){
            int mid = low + (hight - 1) / 2;
            int result = name.compareTo(bookList.get(mid).getName());
            if (result == 0){
                return bookList.get(mid).getPrice();
            }
            if (result > 0){
                low = mid + 1;
            }else
                hight = mid - 1;
        }
        return -1;
    }
}
