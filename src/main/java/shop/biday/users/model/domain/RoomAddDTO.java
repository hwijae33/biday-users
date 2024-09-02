package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.entity.Room;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomAddDTO {

    private String name;

    private String description;

    private int person;

    private int price;

    private String type;

    private Dorm dorm;

    private Long dormId;

    public Room toEntity() {
        return Room.builder()
                .name(name)
                .description(description)
                .person(person)
                .price(price)
                .type(type)
                .dorm(dorm)
                .build();
    }

}
