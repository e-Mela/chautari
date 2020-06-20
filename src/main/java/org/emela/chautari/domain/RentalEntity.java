package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "rental")
@NoArgsConstructor
public class RentalEntity extends BaseEntity {

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

    private RentalItemStatus status;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AvailabilityEntity.class, mappedBy = "rentalEntity")
    private List<AvailabilityEntity> availabilityEntity;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AddressEntity.class, mappedBy = "rentalEntity")
    private List<AddressEntity> location;

    private BigDecimal price;

    private boolean negotiable;

    @OneToMany(targetEntity = PreferenceEntity.class, cascade = CascadeType.ALL, mappedBy = "rentalEntity")
    private List<PreferenceEntity> preferences;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FeatureEntity.class, mappedBy = "rentalEntity")
    private List<FeatureEntity> features;


    private ZonedDateTime postedOn;

    @OneToMany
    @JoinColumn(name = "resourceId")
    private List<ResourceEntity> resources;

}
