package org.emela.chautari.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "security_question")
@NoArgsConstructor
public class SecurityQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CredentialEntity credentialEntity;

    private String question;

    private String answer;

}
