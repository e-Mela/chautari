package org.emela.chautari.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "resource")
@ToString
@Builder
@NoArgsConstructor
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID resourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentalId")
    private RentalEntity rental;

    @NotNull
    private String resourceName;

    @Lob
    @NotNull
    private Blob resourceFile;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    private String createdUser;

    private String lastUpdatedUser;
}
