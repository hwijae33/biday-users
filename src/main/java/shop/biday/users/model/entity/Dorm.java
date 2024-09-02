package shop.biday.users.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@Entity
@ToString
@Table(name = "dorms")
@DynamicInsert // default
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "contact_num", length = 13, nullable = true)
    private String contactNum;

    private String city;
    private String town;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Dcategory dcategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private UserEntity user;

    private String status;

    @OneToMany(mappedBy = "dorm", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms;

    @Builder
//    public Dorm(String name, String description, String contactNum, String city, String town, String address, Users user, Dcategory dcategory, String status) {
    public Dorm(Long id, String name, String description, String contactNum, String city, String town, String address, UserEntity user, Dcategory dcategory, String status, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contactNum = contactNum;
        this.city = city;
        this.town = town;
        this.address = address;
        this.user = user;
        this.dcategory = dcategory;
        this.status = status;
        this.rooms = rooms;
    }
}
