import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Guest aurimas = Guest.builder()
                .firstName("Aurimas")
                .lastName("Petrulenas")
                .phoneNo("370123456")
                .address("LT")
                .build();
        Guest jonas = Guest.builder()
                .firstName("Jonas")
                .lastName("Petrulenas")
                .phoneNo("321654987")
                .address("LT")
                .build();

        Rooms room1 = Rooms.builder()
                .roomType("single")
                .price(110)
                .guest(aurimas)
                .build();

        Rooms room2 = Rooms.builder()
                .roomType("single")
                .price(220)
                .guest(jonas)
                .build();

        List<Rooms> rooms = new ArrayList<>();
        rooms.add(room1);
        aurimas.setRooms(rooms);
        rooms.add(room2);
        jonas.setRooms(rooms);

        session.beginTransaction();
        session.persist(aurimas);
        session.persist(jonas);
        session.getTransaction().commit();

        Hotel kempinski = Hotel.builder()
                .name("Kempinski")
                .address("LT123")
                .countryLocated("LT")
                .guests(Set.of(aurimas))
                .build();
        Hotel grandSpa = Hotel.builder()
                .name("Grand Spa")
                .address("Druskininkai")
                .countryLocated("LT")
                .guests(Set.of(aurimas))
                .build();



        session.beginTransaction();
        session.persist(kempinski);
        session.persist(grandSpa);
        session.getTransaction().commit();

//        session.beginTransaction();
//        session.delete(grandSpa);
//        session.getTransaction().commit();


    }
}