import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Vault vault ;

    private Scanner sc;


    public Menu(Vault vault){
        this.vault = vault;

        sc = new Scanner(System.in);
    }

    public void userMenu() {
        boolean flag=true;
        String listOption="";
        String sortOption="";



        while (flag) {

            displayMenu(); //displaying options

            int option = Integer.parseInt(sc.nextLine());
            switch (option) {

                case 1:                 //printing lists
                    chooseTheList();
                    listOption = sc.nextLine();

                    switch (listOption) {
                        case "1":   //printing artists
                            choosePersonSortingMethod();
                            sortOption = sc.nextLine();
                            if (sortOption.equals("0")) {
                                break;
                            }
                            vault.artistArrayListSorter(Integer.parseInt( sortOption));
                            vault.artistArrayListPrinter();
                            break;

                        case "2":           //printing architects
                            choosePersonSortingMethod();
                            sortOption = sc.nextLine();
                            if (sortOption.equals("0")) {
                                break;
                            }
                            vault.architectArrayListSorter(Integer.parseInt(sortOption));
                            vault.architectArrayListPrinter();


                            break;

                        case "3":               //printing paintings
                            choosePaintingSortingMethod();
                            sortOption = sc.nextLine();
                            if (sortOption.equals("0")) {
                                break;
                            }
                            vault.paintingArrayListSorter(Integer.parseInt(sortOption));
                            vault.paintingArrayListPrinter();

                            break;

                        case "4":       //printing sculptures
                            chooseSculptureSortingMethod();
                            sortOption = sc.nextLine();
                            if (sortOption.equals("0")) {
                                break;
                            }
                            vault.sculptureArrayListSorter(Integer.parseInt( sortOption));
                            vault.sculptureArrayListPrinter();

                            break;

                        case "5":           //printing architectures
                            chooseArchitectureSortingMethod();
                            sortOption = sc.nextLine();
                            if (sortOption.equals("0")) {
                                break;
                            }
                            vault.architectureArrayListSorter(Integer.parseInt( sortOption));
                            vault.architectureArrayListPrinter();

                            break;

                        case "0":
                            break;
                        default:
                            System.out.println("*****Wrong option Entered*****\n");
                            break;
                    }


                    break; //case 1 break


                case 2:         //search in the vault
                    int DEFSORTBYNAME = 1;

                    System.out.println("Enter the keyword \n");
                    String keyword;

                    keyword = sc.nextLine();


                    vault.architectureArrayListSorter(DEFSORTBYNAME);
                    vault.artistArrayListSorter(DEFSORTBYNAME);
                    vault.architectArrayListSorter(DEFSORTBYNAME);
                    vault.paintingArrayListSorter(DEFSORTBYNAME);
                    vault.sculptureArrayListSorter(DEFSORTBYNAME);

                    vault.paintingArrayListSearcher(keyword);
                    vault.artistArrayListSearcher(keyword);
                    vault.sculptureArrayListSearcher(keyword);
                    vault.architectArrayListSearcher(keyword);
                    vault.architectureArrayListSearcher(keyword);


                    break;  // case 2 break

                case 3:         //trade
                    int customerCount = 4;
                    Trade t = new Trade();
                    t.tradeArtworkWithNCustomers(vault, customerCount);


                    break; //case 3 break

                case 0:
                    flag =false;
                    break;
                default:
                    System.out.println("*****Wrong option Entered*****\n");
                    break;
            }

        }
    }
    private void displayMenu(){
        System.out.println("Please enter the number of operation you want to perform");
        System.out.println("1) Print the lists");
        System.out.println("2) Search the vault");
        System.out.println("3)Trade");
        System.out.println("0) Exit");
    }
    private void chooseTheList(){
        System.out.println("Please choose the list");
        System.out.println("1) Print the list of artists");
        System.out.println("2) Print the list of architects");
        System.out.println("3) Print the list of paintings");
        System.out.println("4) Print the list of sculptures");
        System.out.println("5) Print the list of architectures");
        System.out.println("0) Exit");
    }
    private void choosePersonSortingMethod(){
        System.out.println("Please choose the sorting method");
        System.out.println("1) Sort by name");
        System.out.println("2) Sort by birthday");
        System.out.println("3) Sort by nationality");
        System.out.println("0) Exit");
    }

    private void choosePaintingSortingMethod(){
        System.out.println("Please choose the sorting method");
        System.out.println("1) Sort by name");
        System.out.println("2) Sort by style");
        System.out.println("3) Sort by artist");
        System.out.println("0) Exit");
    }
    private void chooseSculptureSortingMethod(){
        System.out.println("Please choose the sorting method");
        System.out.println("1) Sort by name");
        System.out.println("2) Sort by style");
        System.out.println("3) Sort by artist");
        System.out.println("4) Sort by material");
        System.out.println("0) Exit");
    }
    private void chooseArchitectureSortingMethod(){
        System.out.println("Please choose the sorting method");
        System.out.println("1) Sort by name");
        System.out.println("2) Sort by style");
        System.out.println("0) Exit");
    }
}
