package record_book;

public class User {
    private String login;
    private String codedPassword;

    public User(String login, String codedPassword) {
        this.login = login;
        this.codedPassword = codedPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setCodedPassword(String password) {
        this.codedPassword = codePassword(password);
    }

    public boolean isRightPassword(String password){
        return this.codedPassword.equals(
                codePassword(password)
        );
    }

    public static String codePassword(String password){
        return password;
    }
}
