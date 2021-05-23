/*
   Author : aesavas
*/

package project;

import java.util.Scanner;
import java.util.Random;
public class MainClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        Catalog catalog = new Catalog();
        int choice;
        do{
            System.out.println("1 - Add Item");
            System.out.println("2 - Delete Item");
            System.out.println("3 - Update Item");
            System.out.println("4 - Search Item");
            System.out.println("5 - Print");
            System.out.print("Enter choice : ");
            choice = scan.nextInt();



            switch (choice) {
                case 1://Adding
                    System.out.println("1 - Add Book");
                    System.out.println("2 - Add Magazine");
                    System.out.println("3 - Add DVD");
                    System.out.print("Enter choice : ");
                    choice = scan.nextInt();
                    String name, publishDate;
                    int quantity;
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Book Name : "); scan.nextLine();
                            name = scan.nextLine();
                            System.out.print("Enter Date (like that 00.00.0000) : ");
                            publishDate = scan.nextLine();
                            System.out.print("Enter Book's Stock Quantity : ");
                            quantity = Integer.parseInt((scan.nextLine()));
                            int iSBN = random.nextInt(100000);
                            System.out.print("Enter Book's Publisher : ");
                            String publisher = scan.nextLine();
                            System.out.print("Enter Book's Author : ");
                            String author = scan.nextLine();
                            catalog.addBook(name, publishDate, quantity, iSBN, author, publisher);
                            break;

                        case 2:
                            System.out.print("Enter Magazine's Name : "); scan.nextLine();
                            name = scan.nextLine();
                            System.out.print("Enter Date (like that 00.00.0000) : ");
                            publishDate = scan.nextLine();
                            System.out.print("Enter Magazine's Stock Quantity : ");
                            quantity = Integer.parseInt((scan.nextLine()));
                            System.out.print("Enter Magazine's Content : ");
                            String content = scan.nextLine();
                            System.out.print("Enter Magazine's Publisher : ");
                            publisher = scan.nextLine();
                            catalog.addMagazine(name, publishDate, quantity, content, publisher);
                            break;

                        case 3:
                            System.out.print("Enter DVD's Name : "); scan.nextLine();
                            name = scan.nextLine();
                            System.out.print("Enter Date (like that 00.00.0000) : ");
                            publishDate = scan.nextLine();
                            System.out.print("Enter DVD's Stock Quantity : ");
                            quantity = Integer.parseInt((scan.nextLine()));
                            System.out.print("Enter DVD's Producer : ");
                            String producer = scan.nextLine();
                            System.out.print("Enter DVD's Duration (as minute) : ");
                            String duration = scan.nextLine();
                            catalog.addDVD(name, publishDate, quantity, producer, duration);
                            break;

                        default:
                            break;
                    }
                    break;
                case 2://Delete
                    System.out.println("1 - Remove Just One Item(Search with name)");
                    System.out.println("2 - Remove All Item in One Type (as Book,Magazine,DVD)");
                    System.out.print("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Name to Remove Item : "); scan.nextLine();
                            name = scan.nextLine();
                            if(catalog.deleteOneItem(name)){
                                System.out.println("Your item is deleted successfully!");
                            }
                            else{
                                System.out.println("There is no item the name you looking for!");
                            }
                            break;
                        case 2:
                            System.out.print("Enter Name of Type to Remove Items : "); scan.nextLine();
                            String type = scan.nextLine();
                            if(catalog.deletedAllItemInType(type)){
                                System.out.println("Your items are deleted successfully!");
                            }
                            else{
                                System.out.println("You wrote wrong name of type!");
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                case 3://Updating
                    System.out.println("1 - Update With Unique ID");
                    System.out.print("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter unique ID to update the Item : ");
                            int id = scan.nextInt();

                            if(catalog.updateItemWithID(id)){
                                System.out.println("Item is updated successfully!");
                            }
                            else{
                                System.out.println("Item is not found!");
                            }
                            break;
                        default:
                            break;
                    }

                    break;
                case 4://Searcing
                    System.out.println("1 - Search by name");
                    System.out.println("2 - Choose type then search by name within that type of item");
                    System.out.println("3 - Search by producer");
                    System.out.print("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter name for searching : "); scan.nextLine();
                            name = scan.nextLine();
                            catalog.searchWithName(name);
                            break;
                        case 2:
                            System.out.println("Enter name of type : "); scan.nextLine();
                            String type = scan.nextLine();
                            System.out.println("Enter name of item : ");
                            name = scan.nextLine();
                            catalog.searchWithTypeAndName(type, name);
                            break;
                        case 3:
                            System.out.println("Enter producer name : "); scan.nextLine();
                            String producer = scan.nextLine();
                            catalog.searchByProducer(producer);
                            break;
                        default:
                            break;
                    }
                    break;

                case 5://Printing

                    System.out.println("1 - Print all items in alphabetical order");
                    System.out.println("2 - Choose type then print all item in that type");
                    System.out.println("3 - Choose order type");
                    System.out.println("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            catalog.printingAllItems();
                            break;
                        case 2:
                            System.out.println("Enter type to print all items within that type : ");
                            String type = scan.nextLine();
                            type = scan.nextLine();
                            catalog.printingAllItemsInOneType(type);
                            break;
                        case 3:
                            System.out.println("1 - Ascending Sort");
                            System.out.println("2 - Descending Sort");
                            System.out.println("Enter choice : ");
                            choice = scan.nextInt();
                            switch (choice) {
                                case 1:
                                    catalog.printAscending();
                                    break;
                                case 2:
                                    catalog.printDescending();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }


        }while(choice != -1);
    }

}
