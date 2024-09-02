package shop.biday.users.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@ToString
@Table(name = "amenitys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유

    private String name;

}
