package Guest;

public class  Guest implements GuestInterface {
    private String login;
    private String password;
    protected boolean read;
    protected boolean write;
    protected boolean edit;
    protected boolean delete;

    public Guest(String login, String password, boolean read, boolean write, boolean edit, boolean delete) {
        this.login = login;
        this.password = password;
        this.read = read;
        this.write = write;
        this.edit = edit;
        this.delete = delete;
    }

    @Override
    public String getLogin() {
        return login;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean[] getRights() {
        return new boolean[]{read, write, edit, delete};
    }
    @Override
    public void setLogin(String login) {
        this.login = login;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login: " + login + ", Rights: [Read: " + read + ", Write: " + write + ", Edit: " + edit + ", Delete: " + delete + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Guest other = (Guest) obj;
        return login.equals(other.login);
    }

}
