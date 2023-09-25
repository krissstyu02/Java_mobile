public class User extends Guest {
    private String surname;
    private String position;

    public User(String login, String password, boolean read, boolean write, boolean edit, boolean delete, String surname, String position) {
        super(login, password, true, true, true, false);
        this.surname = surname;
        this.position = position;
    }

    public String etSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public void setSurname(String surname) {
        this.surname=surname;
    }

    public void setPosition(String position) {
        this.position=position;
    }

    @Override
    public String toString() {
        return super.toString() + ", Surname: " + surname + ", Position: " + position;
    }
}
