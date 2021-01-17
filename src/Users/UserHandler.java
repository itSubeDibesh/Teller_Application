package Users;

import java.util.ArrayList;

public class UserHandler {
    ArrayList<UsersClass> userList = new ArrayList<>();

    public boolean login(String userName, String passWord) {
        for (UsersClass user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassWord().equals(passWord))
                return true;
        }
        return userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin");
    }
}
