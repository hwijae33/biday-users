package shop.biday.users.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import shop.biday.users.model.entity.Role;

import java.time.LocalDateTime;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {


    private Long id;

    private String email;


    private String password;

    private String name;


    private int phoneNum;

    private Role role;

    private LocalDateTime createAt;


    private LocalDateTime updateAt;

    private String status;
}
