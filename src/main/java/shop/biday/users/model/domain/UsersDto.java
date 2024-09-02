package shop.biday.users.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.entity.Role;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private int phoneNum;
    private Role role;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Long toEntity() {
        return UserEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .phoneNum(phoneNum)
                .role(role)
                .status(status)
                .createAt(createAt)
                .updateAt(updateAt)
                .build().getId();
    }

    public static UsersDto fromEntity(final UserEntity user) {
        return UsersDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .phoneNum(user.getPhoneNum())
                .build();
    }
}
