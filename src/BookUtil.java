import java.util.Scanner;

public class BookUtil {
    public void searchBook(){
        System.out.println("1)Search by Book Name\n2)Search by Author Name\n3)Search by Publisher Name\n" +
                "4)Search by Year\n5)Search by Multiple Parameter\n6)Home Page");
        System.out.println("Enter your option");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        String s = scan.nextLine();
        switch(option)
        {
            case 1:
            {
                System.out.println("Enter the Book Name");
                String bookName = scan.nextLine();
                findBook(Main.book , bookName);
                break;
            }
            case 2:
            {
                System.out.println("Enter the Author Name");
                String bookName = scan.nextLine();
                findBook(Main.book , bookName);
                break;
            }
            case 3:
            {
                System.out.println("Enter the Publisher Name");
                String bookName = scan.nextLine();
                findBook(Main.book , bookName);
                break;
            }
            case 4:
            {
                System.out.println("Enter the Year of publish");
                String bookName = scan.nextLine();
                findBook(Main.book , bookName);
                break;
            }
            case 5:
            {
                //String arr[]  = findTwoParameter();
                searchMultipleParmeter();

                break;
            }
            case 6:
            {
                Main.homePage();
                break;
            }
            default:
            {
                System.out.println("Enter correct option");
                searchBook();
                break;
            }
        }
    }
    public void findBook(Book []book, String name){
        Scanner scan = new Scanner(System.in);
        boolean result = false;
        System.out.println("Book Name\t\t\t\tAuthor Name\t\t\t\t\tPublisher Name\t\t\t\t\tYear");
       for(int i =0; i < book.length; i++){
           if((book[i].bookName.equals(name)) || (book[i].authorName.equals(name)) ||
                   (book[i].publisherName.equals(name)) || (book[i].year.equals(name)) ){
               System.out.println(book[i].bookName+"\t\t\t\t"+book[i].authorName+"\t\t\t\t\t"+book[i].publisherName+"\t\t\t\t\t"+book[i].year);
               System.out.println("Book is found");
               result = true;
               searchBook();
               break;
           }
       }
       if(!result){
           System.out.println("Book is not found. ");
           System.out.println("If you search another book ?");
           System.out.println("1) Yes");
           System.out.println("2) No,thanks. I want to exit");
           int option = scan.nextInt();
           switch(option)
           {
               case 1:
               {
                   searchBook();
                   break;
               }
               case 2:
               {
                   System.exit(0);
                   break;
               }
           }
       }
    }

    public void searchMultipleParmeter(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1) Two parameter");
        System.out.println("2) Three Parameter");
        System.out.print("Enter your option");
        int option = scan.nextInt();
        switch(option)
        {
            case 1:
            {
                findTwoParameter(option+1);
                break;
            }
            case 2:
            {
                break;
            }
            case 3:
            {
                System.out.println("Please, Enter correct option");
                searchMultipleParmeter();
                break;
            }
        }
    }
    public void findTwoParameter(int number) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which two parameter you need");
        System.out.println("1) Book Name");
        System.out.println("2) Author Name");
        System.out.println("3) Publisher Name");
        System.out.println("4) year");
        int []option = new int[number];
        for (int i = 0; i < number; i++) {
            option[i] = scan.nextInt();
        }
        findBookMultipleParameter(option);
    }

    public void findBookMultipleParameter(int []option){
        Scanner scan = new Scanner(System.in);
        String []bookDetails = new String [option.length];
        for(int i = 0; i < option.length; i++){
            if(option[i] == 1){
                System.out.print("Enter your Book Name");
                String bookName = scan.nextLine();
                bookDetails [i] = bookName;
            }
            else if(option[i] == 2){
                System.out.print("Enter your Author Name");
                String authorName = scan.nextLine();
                bookDetails [i] = authorName;
            }
            else if(option[i] == 3){
                System.out.print("Enter your Publisher Name");
                String publisherName = scan.nextLine();
                bookDetails [i] =publisherName;
            }
            else if(option[i] == 4){
                System.out.print("Enter your Year");
                String year = scan.nextLine();
                bookDetails[i] = year;
            }
        }
        findBook(bookDetails,Main.book);
    }

    public void findBook(String []bookDetails, Book []book){
        int count = 0;
        for(int j = 0; j < bookDetails.length; j++){
           for(int i = 0; i < book.length; i++){
               if((book[i].bookName.equals(bookDetails[j])) || (book[i].authorName.equals(bookDetails[j])) ||
                       book[i].publisherName.equals(bookDetails[j]) || book[i].year.equals(bookDetails[j])){
                   count =  i;

               }
           }
        }
    }
    public void checkBook(int count){

    }
}
