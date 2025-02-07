package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Dcategory;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.entity.UserEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DormAddDTO {

    private String name;

    private String description;

    private String contactNum;

    private String city;

    private String town;

    private String address;

    private Dcategory dcategory; //카테고리

    private UserEntity user; // 판매자

    private Long categoryId;

    private Long usersId;

    private String status;

    public Dorm toEntity() {
        return Dorm.builder()
                .name(name)
                .description(description)
                .contactNum(contactNum)
                .city(city)
                .town(town)
                .address(address)
                .user(user)
                .dcategory(dcategory)
                .status(status)
                .build();
    }

}
