package za.co.kss.app.domain;


import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "AddressID")
    private long id;
    @Column(name = "UnitNumber")
    String unitNumber;
    @Column(name = "StreetName")
    String streetName;
    @Column(name = "ComplexName")
    String complexName;
    @Column(name = "City")
    String city;
    @Column(name = "Province")
    String province;
    @Column(name = "PostalCode")
    int postalCode;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "AppUserID")
    private AppUser appUser;

}
