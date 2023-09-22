public class User extends Guest {
    private String surname;
    private String position;

    public User(String login, String password, boolean read, boolean write, boolean edit, boolean delete, String surname, String position) {
        super(login, password, true, true, true, false);
        this.surname = surname;
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return super.toString() + ", Surname: " + surname + ", Position: " + position;
    }
}
