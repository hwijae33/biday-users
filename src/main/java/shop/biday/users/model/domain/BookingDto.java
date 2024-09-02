package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Booking;
import shop.biday.users.model.entity.Payment;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private UserEntity users;
    private Room room;
    private Payment payment;
    private int person;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String status;

    public Booking toEntity() {
        return Booking.builder()
                .id(id)
                .users(users)
                .room(room)
                .payment(payment)
                .person(person)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .status(status)
                .build();
    }
}
