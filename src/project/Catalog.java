/*
   Author : aesavas
*/

package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Catalog {

    static int id = 0;
    ArrayList<Item> items = new ArrayList<Item>();
    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    public void createId(){
        if ((id <= 99999)) {
            id++;
        } else {
            System.out.println("You have maximum item.");
        }
    }

    // Add Item Methods
    public void addBook(String name, String publishDate, int quantity, int iSBN, String author, String publisher){
        createId();
        Book b = new Book(id, name, publishDate, quantity, iSBN, author, publisher);
        items.add(b);
    }

    public void addMagazine(String name, String publishDate, int quantity, String content,String publisher){
        createId();
        Magazine m = new Magazine(id, name, publishDate, quantity, content, publisher);
        items.add(m);
    }

    public void addDVD(String name, String publishDate, int quantity, String producer,String duration){
        createId();
        Dvd d = new Dvd(id, name, publishDate, quantity, producer, duration);
        items.add(d);
    }

    // Delete Item Methods
    public boolean deleteOneItem(String name){
        for(int i=0;i<items.size();i++){
            if(items.get(i).getName().equalsIgnoreCase(name)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deletedAllItemInType(String type){
        boolean a=false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type)){
                items.remove(i);
                a=true;
            }
        }
        return a;
    }

    // Update Item Methods
    /*
    public boolean updateBookFunc(int iD, String name, String date,String type,
                                  String itemDetail,String status, int iSBN,String publisher,String author){
        boolean a = false;
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            if(it instanceof Book){
                Book updateBook = (Book)it;

                //Book updateBook = (Book) items.get(i);
                if(updateBook.getiD() == iD){
                    updateBook.setName(name);
                    updateBook.setDate(date);
                    updateBook.setType(type);
                    updateBook.setItemDetail(itemDetail);
                    updateBook.setStatus(status);
                    updateBook.setiSBN(iSBN);
                    updateBook.setPublisher(publisher);
                    updateBook.setAuthor(author);
                    a = true;
                }
            }
        }
        return a;
    }


    public boolean updateMagazineFunc(int iD, String name, String date,String type,
                                      String itemDetail,String status,String issue,String publisher){
        boolean a = false;

        for (int i = 0; i < items.size(); i++) {
            //Magazine updateMagazine = (Magazine) items.get(i);
            Item it = items.get(i);
            if(it instanceof Magazine){
                Magazine updateMagazine = (Magazine)it;
                if (updateMagazine.getiD() == iD) {
                    updateMagazine.setName(name);
                    updateMagazine.setDate(date);
                    updateMagazine.setType(type);
                    updateMagazine.setItemDetail(itemDetail);
                    updateMagazine.setStatus(status);
                    updateMagazine.setIssue(issue);
                    updateMagazine.setPublisher(publisher);
                    a = true;
                }
            }
        }
        return a;
    }

    public boolean updateDVDFunc(int iD, String name, String date,String type,
                                 String itemDetail,String status,String producer,String duration){
        boolean a = false;
        for (int i = 0; i < items.size(); i++) {
            //DVD updateDVD = (DVD) items.get(i);
            Item it = items.get(i);
            if(it instanceof Dvd){
                Dvd updateDVD = (Dvd)it;
                if (updateDVD.getiD() == iD) {
                    updateDVD.setName(name);
                    updateDVD.setDate(date);
                    updateDVD.setType(type);
                    updateDVD.setItemDetail(itemDetail);
                    updateDVD.setStatus(status);
                    updateDVD.setProducer(producer);
                    updateDVD.setDuration(duration);
                    a = true;
                }
            }
        }
        return a;
    }

    */
    public boolean updateItemWithID(int id){
        boolean a = false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == id){
                //int id, String name, String type, String publishDate, int quantity
                boolean done = false;
                do {
                    System.out.println("Your item is "+items.get(i).getType()+". Please, choose which information to change.");
                    System.out.println("1 - Name : ");
                    System.out.println("2 - Publish Date :");
                    System.out.println("3 - Stock Quantity :");
                    if(items.get(i).getType().equalsIgnoreCase("Book")){
                        System.out.println("4 - iSBN :");
                        System.out.println("5 - Publisher :");
                        System.out.println("6 - Author :");
                    }
                    else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                        System.out.println("4 - Content :");
                        System.out.println("5 - Publisher :");
                    }
                    else{ //Dvd
                        System.out.println("4 - Producer :");
                        System.out.println("5 - Duration :");
                    }
                    System.out.println("If you are done please enter '0'.");
                    System.out.print("Enter choice : ");
                    int choice = scan.nextInt();
                    switch (choice){
                        case 0:
                            System.out.println("Updating information completed... ");
                            done = true;
                            a = true; // TODO: buradaki mekanizma degistirilebilir, belki fonksiyon boolean dondurmeye gerek kalmaz.
                            break;
                        case 1:
                            // TODO : Burada input isleminde problem yasanabilir. Iki defa scan islemi gerekebilir. Notu dikkate al.
                            System.out.print("Please enter new name :");
                            items.get(i).setName(scan.nextLine());
                            break;
                        case 2:
                            System.out.print("Please enter new publish date (like that 00.00.0000) : ");
                            items.get(i).setPublishDate(scan.nextLine());
                            break;
                        case 3:
                            System.out.print("Please enter new stock quantity : ");
                            items.get(i).setQuantity(Integer.parseInt(scan.nextLine()));
                            break;
                        case 4:
                            if(items.get(i).getType().equalsIgnoreCase("Book")){
                                Book b = (Book) items.get(i);
                                b.setiSBN(random.nextInt(100000));
                            }
                            else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                                Magazine m = (Magazine) items.get(i);
                                System.out.print("Please enter new content for magazine : ");
                                m.setContent(scan.nextLine());
                            }
                            else{
                                Dvd d = (Dvd) items.get(i);
                                System.out.print("Please enter new producer for DVD : ");
                                d.setProducer(scan.nextLine());
                            }
                            break;
                        case 5:
                            if(items.get(i).getType().equalsIgnoreCase("Book")){
                                Book b = (Book) items.get(i);
                                System.out.print("Please enter new publisher for book : ");
                                b.setPublisher(scan.nextLine());
                            }
                            else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                                Magazine m = (Magazine) items.get(i);
                                System.out.print("Please enter new publisher for magazine : ");
                                m.setPublisher(scan.nextLine());
                            }
                            else{
                                Dvd d = (Dvd) items.get(i);
                                System.out.print("Please enter new duration for DVD (minute) : ");
                                d.setDuration(scan.nextLine());
                            }
                            break;
                        case 6:
                            Book b = (Book) items.get(i);
                            System.out.print("Please enter new author for book : ");
                            b.setAuthor(scan.nextLine());
                            break;
                        default:
                            System.out.println("Wrong enter. Please try again... ");
                            break;
                    }
                    System.out.println("Information updated.");
                }while(!done);


            }
        }
        return a;
    }


    public void searchWithName(String name){
        //boolean a = false;
        for(int i=0;i<items.size();i++){
            if(items.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(items.get(i));

            }
            else{
                System.out.println("There is no item with that name");
            }
        }

    }

    public void searchWithTypeandName(String type,String name){
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type)){
                if(items.get(i).getName().equalsIgnoreCase(name)){
                    System.out.println(items.get(i));
                }
                else{
                    System.out.println("There is no item with that name");
                }
            }
        }
    }

    public void searchWithThreeFeatures(String name,String date,String status){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equalsIgnoreCase(name) && items.get(i).getDate().equalsIgnoreCase(date) &&
                    items.get(i).getStatus().equalsIgnoreCase(status)){
                System.out.println(items.get(i));
            }
        }
    }


    public void searchByProducer(String producer){

        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            if(it instanceof Dvd){          // Because Only Dvd has producer
                Dvd searchDVD = (Dvd)it;
                if(searchDVD.getProducer().equalsIgnoreCase(producer)){
                    System.out.println(searchDVD);
                }
                else{
                    System.out.println("There is no DVD with that producer name!");
                }
            }
        }
    }

    public void printingAllItems(){
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    public void printingAllItemsInOneType(String type){
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type)){
                System.out.println(items.get(i));
            }
        }
    }

    public void printAscending(){
        Collections.sort(items);
        for(Item i:items){
            System.out.println(i);
        }
    }

    public void printDescending(){
        Collections.reverse(items);
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}

