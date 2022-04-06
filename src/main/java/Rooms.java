import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomType;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "guestId")
    private Guest guest;

}
