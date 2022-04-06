import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestId;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;

//    @ManyToOne
//    @JoinColumn(name = "hotelId")
//    private Hotel hotel;
//    @ManyToOne
//    @JoinColumn(name = "roomId")
//    private Rooms room;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guest")
    private List<Rooms> rooms;

    @ManyToMany(mappedBy = "guests")
    private Set<Hotel> hotels;



}
