public class User {
        String userName;
        String userPassword;
        static int userId = 2000;

        public User(String name, String password){
              this.userName = name;
              this.userPassword = password;
              System.out.println();
        }
        public void setUserName(String name){
            this.userName = name;
        }
        public String getuserName(){
            return this.userName;
        }
        public void setUserPassword(String password){
            this.userPassword = password;
        }
        public String getuserPassword(){
            return this.userPassword;
        }
        public int getUserId(){
            return ++userId;
        }
}
