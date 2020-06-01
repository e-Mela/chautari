package org.emela.chautari.service;

import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserAccountDetail;
import org.springframework.stereotype.Service;

@Service
public interface SetupService {

    SetupResponse setupUser(UserAccountDetail userAccountDetail);
}
