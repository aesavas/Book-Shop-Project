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
                            System.out.print("Please enter new name :"); scan.nextLine();
                            items.get(i).setName(scan.nextLine());
                            break;
                        case 2:
                            System.out.print("Please enter new publish date (like that 00.00.0000) : "); scan.nextLine(); // Dummy read
                            items.get(i).setPublishDate(scan.nextLine());
                            break;
                        case 3:
                            System.out.print("Please enter new stock quantity : ");
                            items.get(i).setQuantity(scan.nextInt());
                            break;
                        case 4:
                            if(items.get(i).getType().equalsIgnoreCase("Book")){
                                Book b = (Book) items.get(i);
                                b.setiSBN(random.nextInt(100000));
                            }
                            else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                                Magazine m = (Magazine) items.get(i);
                                System.out.print("Please enter new content for magazine : "); scan.nextLine(); // Dummy read
                                m.setContent(scan.nextLine());
                            }
                            else{
                                Dvd d = (Dvd) items.get(i);
                                System.out.print("Please enter new producer for DVD : "); scan.nextLine(); // Dummy read
                                d.setProducer(scan.nextLine());
                            }
                            break;
                        case 5:
                            if(items.get(i).getType().equalsIgnoreCase("Book")){
                                Book b = (Book) items.get(i);
                                System.out.print("Please enter new publisher for book : "); scan.nextLine(); // Dummy read
                                b.setPublisher(scan.nextLine());
                            }
                            else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                                Magazine m = (Magazine) items.get(i);
                                System.out.print("Please enter new publisher for magazine : "); scan.nextLine(); // Dummy read
                                m.setPublisher(scan.nextLine());
                            }
                            else{
                                Dvd d = (Dvd) items.get(i);
                                System.out.print("Please enter new duration for DVD (minute) : "); scan.nextLine(); // Dummy read
                                d.setDuration(scan.nextLine());
                            }
                            break;
                        case 6:
                            Book b = (Book) items.get(i);
                            System.out.print("Please enter new author for book : "); scan.nextLine(); // Dummy read
                            b.setAuthor(scan.nextLine());
                            break;
                        default:
                            System.out.println("Wrong enter. Please try again... ");
                            break;
                    }
                }while(!done);
            }
        }
        return a;
    }

    public void searchWithName(String name){
        for(int i=0;i<items.size();i++){
            if(items.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(items.get(i));
            }
            else{
                System.out.println("There is no item with that name");
            }
        }
    }

    public void searchWithTypeAndName(String type,String name){
        Collections.sort(items);
        boolean done = false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type) && items.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(items.get(i));
                done = true;
            }
        }
        if(!done) {
            System.out.println("There is no item within this type and name.");
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

    public void printingAllItems(int choice){
        Collections.sort(items);
        if(choice == 1){
            printAscending();
        }
        else{
            printDescending();
        }
    }

    public void printingAllItemsInOneType(String type){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type)){
                System.out.println(items.get(i));
            }
        }
    }

    public void printAscending(){
        for(Item i:items){
            System.out.println(i);
        }
    }

    public void printDescending(){
        for (int i = items.size()-1; i >= 0; i--) {
            System.out.println(items.get(i));
        }
    }
}

