//Ali Emre SAVAŞ
//13070001034
//Computer Engineering

package project;

public class Book extends Item {

    private int iSBN;
    private String publisher;
    private String author;


    public Book(int iD){
        this.setiD(iD);
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

