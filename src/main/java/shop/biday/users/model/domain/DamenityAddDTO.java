package shop.biday.users.model.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Amenity;
import shop.biday.users.model.entity.Damenity;
import shop.biday.users.model.entity.Dorm;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DamenityAddDTO {

    private Amenity amenity; // 카테고리
    private List<Long> amenityId;

    private Dorm dorm; // 판매자
    private Long dormId;

    public Damenity toEntity(){
        return Damenity.builder()
                .amenity(amenity)
                .dorm(dorm)
                .build();
    }



}

