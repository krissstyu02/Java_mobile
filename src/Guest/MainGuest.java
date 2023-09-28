package Guest;

import java.util.ArrayList;
import java.util.List;

public class MainGuest {
    public static void main(String[] args) {

        Guest admin1 = new Admin("admin1", "adminPass", true, true, true, true, "admin123");
        Guest admin2 = new Admin("admin1", "adminPass", true, true, true, true, "admin123");
        Guest admin3 = new Admin("admin3", "adminPass", true, true, true, true, "admin789");
        Guest admin4 = new Admin("admin4", "adminPass", true, true, true, true, "admin101");
        Guest admin5 = new Admin("admin5", "adminPass", true, true, true, true, "admin202");

        Guest user1 = new User("user1", "userPass", true, true, true, false, "Smith", "Manager");
        Guest user2 = new User("user1", "userPass", true, true, true, false, "Smith", "Manager");
        Guest user3 = new User("user3", "userPass", true, true, true, false, "Williams", "Supervisor");
        Guest user4 = new User("user4", "userPass", true, true, true, false, "Brown", "Analyst");
        Guest user5 = new User("user5", "userPass", true, true, true, false, "Davis", "Technician");


        Guest[] guests = {admin1, admin2, user1, user2, admin3, user3, admin4, admin5, user4, user5};
        //список для уникальных элементов
        List<Guest> uniqueGuestsList = new ArrayList<>();

        for (Guest guest : guests) {
            boolean isDuplicate = false;
            for (Guest uniqueGuest : uniqueGuestsList) {
                if (guest.equals(uniqueGuest)) {
                    System.out.println("Обнаружены одинаковые логины: " + guest.getLogin());
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueGuestsList.add(guest);
            }
        }

        // Преобразуем список обратно в массив
        Guest[] uniqueGuests = uniqueGuestsList.toArray(new Guest[0]);
        System.out.println("Получившийся массив уникальных значений");
        //вывод получившегося массива
        for (int i = 0; i < uniqueGuests.length; i++) {
                System.out.println(uniqueGuests[i].toString());
       }
    }
}
            