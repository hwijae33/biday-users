package shop.biday.users.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
