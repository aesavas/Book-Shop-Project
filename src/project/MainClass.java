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
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Book Name : ");
                            String name = scan.nextLine();
                            name = scan.nextLine();
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
                            catalog.addBook(name, date, type, itemDetail, status, iSBN, publisher, author);
                            break;

                        case 2:
                            System.out.print("Enter Magazine's Name : ");
                            name = scan.nextLine();
                            name = scan.nextLine();
                            System.out.print("Enter Date (like that 00.00.0000) : ");
                            date = scan.nextLine();
                            type = "Magazine";
                            System.out.print("Enter Magazine's detail : ");
                            itemDetail = scan.nextLine();
                            System.out.print("Enter Item's Status : ");
                            status = scan.nextLine();
                            System.out.print("Enter Magazine's Issue : ");
                            String issue = scan.nextLine();
                            System.out.print("Enter Magazine's Publisher : ");
                            publisher = scan.nextLine();
                            catalog.addMagazine(name, date, type, itemDetail, status, issue, publisher);
                            break;

                        case 3:
                            System.out.print("Enter DVD's Name : ");
                            name = scan.nextLine();
                            name = scan.nextLine();
                            System.out.print("Enter Date (like that 00.00.0000) : ");
                            date = scan.nextLine();
                            type = "DVD";
                            System.out.print("Enter DVD's detail : ");
                            itemDetail = scan.nextLine();
                            System.out.print("Enter Item's Status : ");
                            status = scan.nextLine();
                            System.out.print("Enter DVD's Producer : ");
                            String producer = scan.nextLine();
                            System.out.print("Enter DVD's Duration (as minute) : ");
                            String duration = scan.nextLine();
                            catalog.addDVD(name, date, type, itemDetail, status, producer, duration);
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
                            System.out.println("Enter Name to Remove Item : ");
                            String name = scan.nextLine();
                            name = scan.nextLine();
                            //boolean a=catalog.deleteOneItem(name);
                            if(catalog.deleteOneItem(name)){
                                System.out.println("Your item is deleted succesfully!");
                            }
                            else{
                                System.out.println("There is no item the name you looking for!");
                            }
                            break;
                        case 2:
                            System.out.println("Enter Name of Type to Remove Items : ");
                            String type = scan.nextLine();
                            type = scan.nextLine();
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
                    System.out.println("1 - Update With Uniqe ID");
                    System.out.println("2 - Update All Items status to 'Avaliable'");
                    System.out.print("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter uniqe ID to update the Item : ");
                            int iD = scan.nextInt();

                            if(catalog.updateItemWithID(iD)){
                                System.out.println("Item is updated successfully!");
                            }
                            else{
                                System.out.println("Item is not found!");
                            }
                            break;
                        case 2:
                            boolean updating = catalog.updatetoAvailable();
                            if(updating){
                                System.out.println("All Items are updated to available successfully!");
                            }
                            else{
                                System.out.println("There is no item!");
                            }
                            break;

                        default:
                            break;
                    }

                    break;
                case 4://Searcing
                    System.out.println("1 - Search by name");
                    System.out.println("2 - Choose type then search by name within that type of item");
                    System.out.println("3 - Search with name,date and item detail");
                    System.out.println("4 - Search by producer");
                    System.out.println("5 - Search a specific word in all items detail");
                    System.out.println("Enter choice : ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter name for searching : ");
                            String name = scan.nextLine();
                            catalog.searchWithName(name);
                            break;
                        case 2:
                            System.out.println("Enter name of type : ");
                            String type = scan.nextLine();
                            System.out.println("Enter name of item : ");
                            name = scan.nextLine();
                            catalog.searchWithTypeandName(type, name);
                            break;
                        case 3:
                            System.out.println("Enter name : ");
                            name = scan.nextLine();
                            System.out.println("Enter date : ");
                            String date = scan.nextLine();
                            System.out.println("Enter status : ");
                            String status = scan.nextLine();
                            catalog.searchWithThreeFeatures(name, date, status);
                            break;
                        case 4:
                            System.out.println("Enter producer name : ");
                            String producer = scan.nextLine();
                            catalog.searchByProducer(producer);
                            break;
                        case 5:// Yetiştiremediğim için yapamadıgım kısım
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
