package shop.biday.users.service.imp;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shop.biday.users.model.entity.Booking;
import shop.biday.users.model.repository.BookingRepository;
import shop.biday.users.model.domain.PaymentRequestDTO;
import shop.biday.users.model.domain.PaymentResponseDTO;
import shop.biday.users.model.entity.Payment;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.repository.PaymentRepository;
import shop.biday.users.model.repository.RoomRepository;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.repository.UsersRepository;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final String TOSS_API_URL = "https://api.tosspayments.com/v1/payments/confirm";

    private final PaymentRepository paymentRepository;
    private final UsersRepository usersRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    @Value("${payments.toss.secret.key}")
    private String widgetSecretKey;



    private String getEncodedAuthHeader() {
        String auth = widgetSecretKey + ":";
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));

        return "Basic " + new String(encodedAuth);
    }

    public Payment confirmPayment(PaymentRequestDTO paymentRequestDTO) {
        return null;
    }
}
