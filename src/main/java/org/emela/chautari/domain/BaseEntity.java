package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;

    private String createdUser;

    private String lastUpdatedUser;
}
