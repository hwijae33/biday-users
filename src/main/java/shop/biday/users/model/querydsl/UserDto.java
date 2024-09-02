package shop.biday.users.model.querydsl;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Role;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Role role;

    @Builder
    public UserDto(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}
