package shop.biday.users.model.querydsl;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.domain.DcategoryListDTO;
import shop.biday.users.model.domain.UsersDto;

@Data
@Builder
@NoArgsConstructor
public class DormListDto {
    private Long id;
    private String name;
    private String address;
    private UsersDto usersDto;
    private DcategoryListDTO dcategoryListDto;

    @Builder
    public DormListDto(Long id, String name, String address, UsersDto usersDto, DcategoryListDTO dcategoryListDto) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.usersDto = usersDto;
        this.dcategoryListDto = dcategoryListDto;
    }
}
