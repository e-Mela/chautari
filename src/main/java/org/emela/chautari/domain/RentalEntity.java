package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "rental")
@NoArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private String title;

    private String rentOf;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AvailabilityEntity.class)
    @JoinColumn(name = "id" )
    private List<AvailabilityEntity> availabilityEntity;

    @Embedded
    private AddressEntity location;

    private BigDecimal price;

    private String priceType;

    @OneToMany(targetEntity = PreferenceEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id" )
    private List<PreferenceEntity> preferences;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FeatureEntity.class)
    @JoinColumn(name = "id" )
    private List<FeatureEntity> features;


    private ZonedDateTime postedOn;

    private String resourceIds;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    private String createdUser;

    private String lastUpdatedUser;

}
