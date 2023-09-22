public class Guest {
    private String login;
    private String password;
    private boolean read;
    private boolean write;
    private boolean edit;
    private boolean delete;

    public Guest(String login, String password, boolean read, boolean write, boolean edit, boolean delete) {
        this.login = login;
        this.password = password;
        this.read = read;
        this.write = write;
        this.edit = edit;
        this.delete = delete;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean[] getRights() {
        return new boolean[]{read, write, edit, delete};
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
    public void setRights(boolean read, boolean write, boolean edit, boolean delete) {
        this.read = read;
        this.write = write;
        this.edit = edit;
        this.delete = delete;
    }
}
