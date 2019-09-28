import java.util.Scanner;

public class UserUtil {
    static String newpassword[] = new String[3];
    public void creatAccount(){
        System.out.println("1)SignUp\n2)SignIn");
        System.out.print("Enter your option");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option)
        {
            case 1:
            {
                signUp(Main.user);
                break;
            }
            case 2:
            {
                signIn();
                break;
            }
            default :
            {
                System.out.println("Enter correct option");
                creatAccount();
                break;
            }
        }
    }
    public void signUp(User[]user){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < user.length; i++){
            if((user[i].userName.equals("")) && (user[i].userPassword.equals("")) ){
                System.out.println("Enter your name");
                String name = scan.nextLine();
                user[i].setUserName(name);
                System.out.println("Enter your password");
                String password = scan.nextLine();
                String password1 = Main.encryptedPassword(password);
                user[i].setUserPassword(password1);
                checkPasswordLimit(password1);
                System.out.println("Account successfully created");
                System.out.println("Your Id is "+user[i].getUserId());
                break;
            }
        }
        creatAccount();
    }

    public void signIn(){
        boolean result = false;
        System.out.println("SignIn account");
        System.out.println("Enter your User ID");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        String s = scan.nextLine();
        System.out.println("Enter your User Password");
        String password = scan.nextLine();
        String password1 = Main.encryptedPassword(password);
        for(int i = 0 ; i < Main.user.length ; i++){
            if((id == (Main.user[i].userId)) && (password1.equals(Main.user[i].userPassword))){
                System.out.println("LogIn successfully");
                result = true;
                showUserOption();
                break;
            }
        }
        if(!result){
            System.out.println("Invalid Used ID or user Password");
            signIn();
        }
    }
    public void showUserOption(){
        System.out.println("1)Search Book\n2)Change Password");
        System.out.println("Enter your option");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option)
        {
            case 1:
            {
                Main.bookUtil.searchBook();
                break;
            }
            case 2:
            {
                changePassword();
                break;
            }
            default :
            {
                System.out.println("Enter correct option");
                showUserOption();
                break;
            }
        }
    }
    public void changePassword(){
        boolean result = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your current password");
        String password = scan.nextLine();
        String password1 = Main.encryptedPassword(password);
        System.out.println("Enter the Id");
        int id = scan.nextInt();
        String s = scan.nextLine();
        for(int i = 0; i < Main.user.length; i++){
            if((Main.user[i].userPassword.equals(password1)) && User.userId == id){
                System.out.println("Enter your New Password");
                String newpwd = scan.nextLine();
                System.out.println("Re - Enter your New Password");
                String conformPassword = scan.nextLine();
                if((newpwd.equals(conformPassword))){
                    String conformPassword1 = Main.encryptedPassword(conformPassword);
                    for(int j =0; j < newpassword.length; j++){
                        if(conformPassword1.equals(newpassword[j])){
                            System.out.println("Password must be don't have last three change");
                            changePassword();
                            break;
                        }
                    }
                    Main.user[i].setUserPassword(conformPassword1);
                    checkPasswordLimit(conformPassword1);
                    System.out.println("Your Password changed Successfully");
                    System.out.println("Your New Password is - "+conformPassword1);
                    result = true;
                    break;
                }else{
                    System.out.println("Don't match New Password");
                    changePassword();
                }
            }
        }
        if(!result){
            System.out.println(" Invalid User Password or User ID ");
            changePassword();
        }else{
            System.out.println("Would you like to continue ?");
            System.out.println("1) Yes");
            System.out.println("2) I want to Home Page");
            System.out.println("3) I want to Exit");
            int option = scan.nextInt();
            switch(option)
            {
                case 1:
                {
                    creatAccount();
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
                default:
                {
                    System.out.println("Enter the correct option");
                    break;
                }
            }
        }
    }
    static int j = 0;
    public void checkPasswordLimit(String password){

            if( j < newpassword.length){
                newpassword[j++] = password;
            }else{
                newpassword[0] = newpassword[1];
                newpassword[1] = newpassword[2];
                newpassword[2] = password;
            }
    }
}
