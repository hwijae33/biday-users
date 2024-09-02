package shop.biday.users.model.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import shop.biday.users.model.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private Long id;

    private UsersResponse users;

    private RoomResponse room;

    private DormResponse dorm;

    private PaymentResponse payment;

    private int person;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime checkIn;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime checkOut;

    private String status;

    public BookingResponse fromEntity(final Booking booking) {
        UsersResponse usersResponse = getUsersResponse(booking);
        RoomResponse roomResponse = getRoomResponse(booking);
        DormResponse dormResponse = getDormResponse(booking);
        PaymentResponse paymentResponse = getPaymentResponse(booking);

        return BookingResponse.builder()
                .id(booking.getId())
                .users(usersResponse)
                .room(roomResponse)
                .dorm(dormResponse)
                .payment(paymentResponse)
                .person(booking.getPerson())
                .checkIn(booking.getCheckIn())
                .checkOut(booking.getCheckOut())
                .status(booking.getStatus())
                .build();
    }

    private static PaymentResponse getPaymentResponse(Booking booking) {
        Payment findPayment = booking.getPayment();
        return PaymentResponse.builder()
                .id(findPayment.getId())
                .orderId(findPayment.getOrderId())
                .totalAmount(findPayment.getTotalAmount())
                .build();
    }

    private static DormResponse getDormResponse(Booking booking) {
        Dorm findDorm = booking.getRoom().getDorm();
        return DormResponse.builder()
                .id(findDorm.getId())
                .name(findDorm.getName())
                .build();
    }

    private static RoomResponse getRoomResponse(Booking booking) {
        Room findRoom = booking.getRoom();
        return RoomResponse.builder()
                .id(findRoom.getId())
                .name(findRoom.getName())
                .price(findRoom.getPrice())
                .build();
    }

    private static UsersResponse getUsersResponse(Booking booking) {
        UserEntity findUsers = booking.getUsers();
        return UsersResponse.builder()
                .id(findUsers.getId())
                .email(findUsers.getEmail())
                .name(findUsers.getName())
                .phoneNumber(findUsers.getPhoneNum())
                .build();
    }
}
