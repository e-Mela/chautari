package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "rental")
@NoArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private String title;

    private String rentOf;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AvailabilityEntity.class, mappedBy = "rentalEntity")
    private List<AvailabilityEntity> availabilityEntity;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AddressEntity.class, mappedBy = "rentalEntity")
    private List<AddressEntity> location;

    private BigDecimal price;

    private String priceType;

    @OneToMany(targetEntity = PreferenceEntity.class, cascade = CascadeType.ALL, mappedBy = "rentalEntity")
    private List<PreferenceEntity> preferences;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FeatureEntity.class, mappedBy = "rentalEntity")
    private List<FeatureEntity> features;


    private ZonedDateTime postedOn;

    @OneToMany
    @JoinColumn(name = "resourceId")
    private List<ResourceEntity> resources;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    private String createdUser;

    private String lastUpdatedUser;

}
