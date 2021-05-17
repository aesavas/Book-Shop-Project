/*
   Author : aesavas
*/

package project;

public class Book extends Item {

    private int iSBN;
    private String publisher;
    private String author;


    public Book(int id, String name, String publishDate, int quantity, int iSBN, String publisher, String author){
        super(id, name, "Book", publishDate, quantity);
        this.setiSBN(iSBN);
        this.setAuthor(author);
        this.setPublisher(publisher);
    }


    @Override
    public int compareTo(Item other) {

        return this.getName().compareTo(other.getName());
    }

    public int getiSBN() {
        return iSBN;
    }

    public void setiSBN(int iSBN) {
        this.iSBN = iSBN;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return super.toString() + "\nISBN : "+this.iSBN+"\nPublisher : "+this.publisher+"\nAuthor : "+this.author + "\n"+"=============";
    }




}

