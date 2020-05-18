package org.emela.chautari.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity(name = "credential")
public class CredentialEntity {
    @Id
    private long id;

    private String userName;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = SecurityQuestionEntity.class,
            mappedBy = "credentialEntity")
    private List<SecurityQuestionEntity> securityQuestions;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

}
