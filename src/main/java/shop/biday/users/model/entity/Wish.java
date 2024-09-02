package shop.biday.users.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "wishs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorm_id")
    private Dorm dorm;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Wish(long id, UserEntity users, Dorm dorm, LocalDateTime createdAt) {
        this.id = id;
        this.users = users;
        this.dorm = dorm;
        this.createdAt = createdAt;
    }
}
