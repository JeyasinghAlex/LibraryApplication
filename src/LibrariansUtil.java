
import java.util.Scanner;

public class LibrariansUtil {
        public void checkLibrarians(){
                boolean result = false;
                System.out.println("Enter your name");
                Scanner scan = new Scanner(System.in);
                String name = scan.nextLine();
                System.out.println("Enter your password");
                String password = scan.nextLine();
                String encryptedPassword = Main.encryptedPassword(password);
                for(int i =0; i < Main.librarians.length; i++){
                        if((name.equals(Main.librarians[i].librarianName)) &&
                                (encryptedPassword.equals(Main.librarians[i].LibrarianPassword))){
                                System.out.println("LogIn successfully");
                                result = true;
                                break;
                        }
                }
                if(!result){
                        System.out.println("Invalid Details. Please correct details");
                        checkLibrarians();
                }else{
                        showLibrariansOption();
                }
        }

        public void showLibrariansOption(){
                Scanner scan = new Scanner(System.in);
                System.out.println("1)Add Book");
                System.out.println("2)Remove Book");
                System.out.println("3)Show all Book");
                System.out.println("4)Home Page");
                System.out.print("Enter the option");
                int option = scan.nextInt();
                switch(option)
                {
                        case 1:
                        {
                                addBook();
                                break;
                        }
                        case 2:
                        {
                                removeBook();
                                break;
                        }
                        case 3:
                        {
                                showAllBook();
                                break;
                        }
                        case 4:
                        {
                                Main.homePage();
                                break;
                        }
                        default:
                        {
                                System.out.println("Please ,Enter the correct option");
                                showLibrariansOption();
                                break;
                        }
                }
        }

        public void addBook(){
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the Book Name");
                String bookName = scan.nextLine();
                System.out.println("Enter the Author Name");
                String authorName = scan.nextLine();
                System.out.println("Enter the Publisher Name");
                String publisherName = scan.nextLine();
                System.out.println("Enter the Year");
                String yr = scan.nextLine();
                boolean result = creatBook(bookName,authorName,publisherName,yr);
                if(result){
                        System.out.println("Book is added Successfully");
                        showLibrariansOption();
                }else{
                        System.out.println("Book is not added. Library may be full.");
                        System.out.println("Would you like View all Book ? ");
                        System.out.println("1) Yes");
                        System.out.println("2) No thanks. I want to Home page");
                        System.out.println("3) No thanks. I want to exit");
                        System.out.print("Enter your option");
                        int option = scan.nextInt();
                        switch(option)
                        {
                                case 1:
                                {
                                        showLibrariansOption();
                                        break;
                                }
                                case 2:
                                {
                                        Main.homePage();
                                        break;
                                }
                                case 3:
                                {
                                        System.exit(0);
                                        break;
                                }
                        }
                }
        }

        public boolean creatBook(String bookName, String authorName, String publisherName, String yr){
                boolean result = false;
                for(int i = 0; i < Main.book.length; i++){
                        if((Main.book[i].bookName.equals("")) && (Main.book[i].authorName.equals("")) &&
                                ((Main.book[i].publisherName.equals(""))) && (Main.book[i].year.equals(""))){
                                Main.book[i].bookName = bookName;
                                Main.book[i].authorName = authorName;
                                Main.book[i].publisherName = publisherName;
                                Main.book[i].year = yr;
                                result = true;
                                break;
                        }
                }
                return result;
        }

        public void removeBook(){
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the Book Name");
                String bookName = scan.nextLine();
                System.out.println("Enter the Author Name");
                String authorName = scan.nextLine();
                System.out.println("Enter the Publisher Name");
                String publisherName = scan.nextLine();
                System.out.println("Enter the Year");
                String yr = scan.nextLine();
                boolean result = deleteBook(bookName,authorName,publisherName,yr);
                if(result){
                        System.out.println("Book is removed successfully");
                        showLibrariansOption();
                }else{
                        System.out.println("Book is not removed. Details may be wrong");
                        System.out.println("If you want to try again ?");
                        System.out.println("1) Yes");
                        System.out.println("2) No, i want to Home Page");
                        System.out.println("3) No, i want exit");
                        System.out.print("Enter your option");
                        int option = scan.nextInt();
                        switch(option)
                        {
                                case 1:
                                {
                                        showLibrariansOption();
                                        break;
                                }
                                case 2:
                                {
                                        Main.homePage();
                                        break;
                                }
                                case 3:
                                {
                                        System.exit(0);
                                        break;
                                }
                        }
                }
        }

        public boolean deleteBook(String bookName, String authorName, String publishName, String yr){
                boolean result = false;
                for(int i = 0; i < Main.book.length; i++){
                        if((Main.book[i].bookName.equals(bookName)) && (Main.book[i].authorName.equals(authorName))
                                && (Main.book[i].publisherName.equals(publishName)) && (Main.book[i].year.equals(yr))){
                                Main.book[i].bookName = "";
                                Main.book[i].authorName = "";
                                Main.book[i].publisherName = "";
                                Main.book[i].year = "";
                                result = true;
                        }
                }
                return result;
        }

        public void showAllBook(){
                System.out.println("Book Name\t\t\tAuthor Name\t\t\t\tPublisher Name\t\t\t\tYear");
                for(int i = 0; i < Main.book.length; i++){
                        if(!(Main.book[i].bookName.equals("")) && !(Main.book[i].authorName.equals("")) &&
                                !(Main.book[i].publisherName.equals("")) && !(Main.book[i].year.equals(""))){
                                System.out.println(Main.book[i].bookName+"\t\t\t\t\t"+Main.book[i].authorName+"\t\t\t\t\t"
                                        +Main.book[i].publisherName+"\t\t\t\t\t"+Main.book[i].year);
                        }
                }
                System.out.println("What would you like to do next ?");
                showLibrariansOption();
        }

}
