package shop.biday.users.model.entity;



import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@Table(name = "d_amenitys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Damenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenity_id")
    private Amenity amenity; // 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorm_id")
    private Dorm dorm; // 판매자


    @Builder
    public Damenity(Long id , Amenity amenity, Dorm dorm){
        this.id = id;
        this.amenity = amenity;
        this.dorm = dorm;

    }
}
