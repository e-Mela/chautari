package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity(name = "feedback")
@NoArgsConstructor
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Star rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;
}
