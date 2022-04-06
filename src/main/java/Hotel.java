import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;
    private String name;
    private String address;
    private String countryLocated;

//    @ManyToOne
//    @JoinColumn(name = "guestId")
//    private Guest guest;
@ManyToMany(cascade = CascadeType.PERSIST)
@JoinTable(name = "guest_to_hotel")
private Set<Guest> guests;






}
