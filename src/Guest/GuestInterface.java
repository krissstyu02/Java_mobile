package Guest;

public interface GuestInterface {
    String getLogin();
    String getPassword();
    boolean[] getRights();
    void setLogin(String login);
    void setPassword(String password);
}
