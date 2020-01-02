package za.co.kss.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.kss.app.domain.Payment;

public interface PaymentsRepository  extends JpaRepository<Payment, Long> {

    public Payment findOneBySurname(String surname);

}
