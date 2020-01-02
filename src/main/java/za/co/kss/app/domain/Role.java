package za.co.kss.app.domain;


import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "roleID")
    private long roleID;
    @Column(name = "roleName")
    private String roleName;
    @Column(name ="roleType")
    private String roleType;
}
