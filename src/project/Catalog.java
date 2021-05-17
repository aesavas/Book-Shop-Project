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


    public boolean deleteOneItem(String name){
        boolean a=false;
        for(int i=0;i<items.size();i++){
            if(items.get(i).getName().equalsIgnoreCase(name)){
                items.remove(i);
                a=true;
            }
        }
        return a;
    }

    public boolean deletedAllItemInType(String type){
        //int a=0;
        boolean a=false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getType().equalsIgnoreCase(type)){
                items.remove(i);
                a=true;
            }
        }
        return a;
    }

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

    public boolean updateItemWithID(int iD){
        boolean a = false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getiD() == iD){
                if(items.get(i).getType().equalsIgnoreCase("Book")){
                    System.out.print("Enter Book Name : ");
                    String name = scan.nextLine();
                    //name = scan.nextLine();
                    System.out.print("Enter Date (like that 00.00.0000) : ");
                    String date = scan.nextLine();
                    String type = "Book";
                    System.out.print("Enter Book's Detail : ");
                    String itemDetail = scan.nextLine();
                    System.out.print("Enter Item's Status : ");
                    String status = scan.nextLine();
                    int iSBN = random.nextInt(100000);
                    System.out.print("Enter Book's Publisher : ");
                    String publisher = scan.nextLine();
                    System.out.print("Enter Book's Author : ");
                    String author = scan.nextLine();
                    //Book b = (Book) items.get(i);
                    a = updateBookFunc(iD,name,date,type,itemDetail,status,iSBN,publisher,author);
                }
                else if(items.get(i).getType().equalsIgnoreCase("Magazine")){
                    System.out.print("Enter Magazine's Name : ");
                    String name = scan.nextLine();
                    //name = scan.nextLine();
                    System.out.print("Enter Date (like that 00.00.0000) : ");
                    String date = scan.nextLine();
                    String type = "Magazine";
                    System.out.print("Enter Magazine's detail : ");
                    String itemDetail = scan.nextLine();
                    System.out.print("Enter Item's Status : ");
                    String status = scan.nextLine();
                    System.out.print("Enter Magazine's Issue : ");
                    String issue = scan.nextLine();
                    System.out.print("Enter Magazine's Publisher : ");
                    String publisher = scan.nextLine();
                    //Magazine m = (Magazine) items.get(i);
                    a = updateMagazineFunc(iD,name,date,type,itemDetail,status,issue,publisher);
                }
                else if(items.get(i).getType().equalsIgnoreCase("DVD")){
                    System.out.print("Enter DVD's Name : ");
                    String name = scan.nextLine();
                    //name = scan.nextLine();
                    System.out.print("Enter Date (like that 00.00.0000) : ");
                    String date = scan.nextLine();
                    String type = "DVD";
                    System.out.print("Enter DVD's detail : ");
                    String itemDetail = scan.nextLine();
                    System.out.print("Enter Item's Status : ");
                    String status = scan.nextLine();
                    System.out.print("Enter DVD's Producer : ");
                    String producer = scan.nextLine();
                    System.out.print("Enter DVD's Duration (as minute) : ");
                    String duration = scan.nextLine();
                    //DVD d = (DVD) items.get(i);
                    a = updateDVDFunc(iD,name,date,type,itemDetail,status,producer,duration);
                }
            }
        }
        return a;
    }
    public boolean updatetoAvailable(){
        boolean a = false;
        for(int i=0; i < items.size();i++){
            if(items.get(i).getStatus().equalsIgnoreCase("Available")){

            }
            else{
                items.get(i).setStatus("Available");
                a=true;
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
		/*for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}*/
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

