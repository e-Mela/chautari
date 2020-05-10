package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "user")
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID userId;

    private String title;

    private String firstName;

    private String lastName;

    private String middleName;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AddressEntity.class, mappedBy = "userEntity")
    private List<AddressEntity> addresses;

    private String userName;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CredentialEntity.class, mappedBy = "userEntity")
    private CredentialEntity credential;

    private String phone;

    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    private String createdUser;

    private String lastUpdatedUser;

}
