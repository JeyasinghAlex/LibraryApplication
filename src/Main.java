import java.util.Scanner;

public class Main {
    static Librarians librarians[] = new Librarians[4];
    static Book book[] = new Book[20];
    static User user[] = new User[10];
    static LibrariansUtil libUtil = new LibrariansUtil();
    static BookUtil bookUtil = new BookUtil();
    static UserUtil userUtil = new UserUtil();

    public static void main(String[] args) {
        creatLibrarians();
        creatBook();
        creatUser();
        homePage();
    }

    public static void creatLibrarians(){
        librarians[0] = new Librarians("Alex");
        String password1 = encryptedPassword("1234");
        librarians[0].setLibrarianPassword(password1);
        librarians[1] = new Librarians("Jeyasingh");
        String password2 = encryptedPassword("2345");
        librarians[1].setLibrarianPassword(password2);
        librarians[2] = new Librarians("Punch");
        String password3 = encryptedPassword("3456");
        librarians[2].setLibrarianPassword(password3);
        librarians[3] = new Librarians("Bala");
        String password4 = encryptedPassword("4567");
        librarians[3].setLibrarianPassword(password4);
    }
    public static void creatBook(){
        for(int i = 0; i < book.length; i++){
            book[i] = new Book("","","","");
        }
    }

    public static void creatUser(){
        for(int i = 0; i < user.length; i++){
            user[i] = new User("","");
        }
    }
    public static void homePage(){
        System.out.println("1)Librarians\n2)User");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option)
        {
            case 1:
            {
                libUtil.checkLibrarians();
                break;
            }
            case 2:
            {
                userUtil.creatAccount();
                break;
            }
        }
    }

    public static String encryptedPassword(String pwd){
        String encryptedPassword = "";
        String password = pwd;
        char []arr = password.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int ch = (int)arr[i] + 2;
            char encryptedpwd  = (char)ch;
            encryptedPassword = encryptedPassword + encryptedpwd;
        }
        return encryptedPassword;
    }
}
