package Guest;

public class Admin extends Guest {
    private String additionalPassword;


    public Admin(String login, String password, boolean read, boolean write, boolean edit, boolean delete, String additionalPassword) {
        super(login, password, true, true, true, true);
        this.additionalPassword = additionalPassword;
    }


    public String getAdditionalPassword() {
        return additionalPassword;
    }

    public void setAdditionalPassword(String additionalPassword) {
        this.additionalPassword = additionalPassword;
    }

    public void setRights(boolean write, boolean edit, boolean delete) {
        this.read = read;
        this.write = write;
        this.edit = edit;
        this.delete = delete;
    }

    @Override
    public String toString() {
        return super.toString() + ", Additional Password: " + additionalPassword;
    }

}
