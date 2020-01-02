package za.co.kss.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.co.kss.app.domain.Payment;
import za.co.kss.app.repository.PaymentsRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PaymentRestController {

    @Autowired

    private PaymentsRepository paymentsRepository;



    /**

     * Web service for getting all the appUsers in the application.

     *

     * @return list of all payment

     */

    //@PreAuthorize("hasRole('ROLE_ADMIN')")

    @RequestMapping(value = "/payments", method = RequestMethod.GET)

    public List<Payment> users() {

        return paymentsRepository.findAll();

    }



    /**

     * Web service for getting a user by his ID

     *

     * @param id

     *            payment ID

     * @return payment

     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)

    public ResponseEntity<Payment> userById(@PathVariable Long id) {

        Payment payment = paymentsRepository.findOne(id);

        if (payment == null) {

            return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);

        } else {

            return new ResponseEntity<Payment>(payment, HttpStatus.OK);

        }

    }



    /**

     * Method for deleting a user by his ID

     *

     * @param id

     * @return

     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.DELETE)

    public ResponseEntity<Payment> deleteUser(@PathVariable Long id) {

        Payment payment = paymentsRepository.findOne(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String loggedUsername = auth.getName();

        if (payment == null) {

            return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);

        } else if (payment.getName().equalsIgnoreCase(loggedUsername)) {

            throw new RuntimeException("You cannot delete your account");

        } else {

            paymentsRepository.delete(payment);

            return new ResponseEntity<Payment>(payment, HttpStatus.OK);

        }



    }



    /**

     * Method for adding a appUser

     *

     * @param payment

     * @return

     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @RequestMapping(value = "/payments", method = RequestMethod.POST)

    public ResponseEntity<Payment> createUser(@RequestBody Payment payment) {

        if (paymentsRepository.findOneBySurname(payment.getSurname()) != null) {

            throw new RuntimeException("Username already exist");

        }

        return new ResponseEntity<Payment>(paymentsRepository.save(payment), HttpStatus.CREATED);

    }



    /**

     * Method for editing an user details

     *

     * @param payment

     * @return modified appUser

     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @RequestMapping(value = "/payments", method = RequestMethod.PUT)

    public Payment updateUser(@RequestBody Payment payment) {

        if (paymentsRepository.findOneBySurname(payment.getSurname()) != null

                && paymentsRepository.findOneBySurname(payment.getSurname()).getId() != payment.getId()) {

            throw new RuntimeException("Username already exist");

        }

        return paymentsRepository.save(payment);

    }



}
