package shop.biday.users.model.querydsl;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.domain.RoomDTO;

@Data
@Builder
@NoArgsConstructor
public class DormBookingListDTO {

    private Long id;
    private String name;
    private String address;
    private String status;
    private RoomDTO room;
    private DormBookingDTO booking;

    @Builder
    public DormBookingListDTO(Long id, String name, String address, String status, RoomDTO room, DormBookingDTO booking) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.room = room;
        this.booking = booking;
    }


}
