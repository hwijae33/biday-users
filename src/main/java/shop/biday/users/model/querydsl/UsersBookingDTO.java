package shop.biday.users.model.querydsl;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
public class UsersBookingDTO {

    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String dormName;
    private int totalAmount;

    @Builder
    public UsersBookingDTO(Long id, LocalDate checkIn, LocalDate checkOut, String dormName, int totalAmount) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.dormName = dormName;
        this.totalAmount = totalAmount;

    }
}
