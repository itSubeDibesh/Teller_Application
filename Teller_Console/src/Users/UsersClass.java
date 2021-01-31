package Users;

public class UsersClass {
    private String userName;
    private String passWord;

    public UsersClass(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

}
