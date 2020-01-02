package za.co.kss.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

@Entity(name="payments")
public class Payment implements Serializable {



    @Id

    @GeneratedValue

    private int id;

    @Column

    private String name;

    @Column

    private String surname;

    @Column

    private Date paymentDate;

    @Column

    @JsonIgnore

    private Blob proofOfpayment;



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getSurname() {

        return surname;

    }



    public void setSurname(String surname) {

        this.surname = surname;

    }



    public Date getPaymentDate() {

        return paymentDate;

    }



    public void setPaymentDate(Date paymentDate) {

        this.paymentDate = paymentDate;

    }



    public Blob getProofOfpayment() {

        return proofOfpayment;

    }



    public void setProofOfpayment(Blob proofOfpayment) {

        this.proofOfpayment = proofOfpayment;

    }



    public int getId() {

        return id;

    }



    public void setId(int id) {

        this.id = id;

    }

}