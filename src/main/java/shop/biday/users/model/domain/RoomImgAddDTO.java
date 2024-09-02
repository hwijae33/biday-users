package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.entity.RoomImg;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomImgAddDTO {

    private String name;

    private String nameOriginal;

    private String size;

    private String ext;

    private Room room;

    private Long roomId;



}
