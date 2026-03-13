package BookDemo;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;
    private String author;
    private int price;

    private Book( String bookName, String author, int price){
        this.bookName=bookName;
        this.author=author;
        this.price=price;

    }




    public static BookBuilder builder(){
        return new BookBuilder();
    }

    public String toString() {
        return "Book{  bookName = " + bookName + ", author = " + author + ", price = " + price + "}";
    }





    /**
     * 获取
     * @return bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }


    public static class BookBuilder{
        private String bookName;
        private String author;
        private int price;

        private BookBuilder() {}

        public BookBuilder bookName(String bookName){

            this.bookName = bookName;
            return this;
        }
        public BookBuilder author(String author){

            this.author = author;
            return this;
        }
        public BookBuilder price(int price){

            this.price = price;
            return this;
        }



        public Book build(){
            return new Book(bookName, author, price);
        }
    }

}
