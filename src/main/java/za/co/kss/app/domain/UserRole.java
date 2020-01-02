package za.co.kss.app.domain;


import javax.persistence.*;

@Entity
@Table(name = "MemberRole")
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "memberRoleID")
    private long memberRoleID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="RoleID", nullable = false)
    private Role role;
}
