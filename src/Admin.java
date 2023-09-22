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

    public void setRights(boolean read, boolean write, boolean edit, boolean delete) {
        super.setRights(read, write, edit, delete);
    }

    @Override
    public String toString() {
        return super.toString() + ", Additional Password: " + additionalPassword;
    }
}
