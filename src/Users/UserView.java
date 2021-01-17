package Users;

import java.util.Scanner;

public class UserView {
    // Instiantiating User Handler to invoke its methords
    public UserHandler users = new UserHandler();

    // Defining Input Scanner
    Scanner input = new Scanner(System.in);

    public boolean loginView() {
        System.out.println("Enter User Name:");
        String userName = input.nextLine();
        System.out.println("Enter Password");
        String passWord = input.nextLine();
        return users.login(userName, passWord);
    }
}
