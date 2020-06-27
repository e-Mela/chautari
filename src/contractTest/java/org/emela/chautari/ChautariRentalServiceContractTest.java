package org.emela.chautari;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestPropertySource;

@Log4j2
@SpringBootTest(
        classes = {ChautariApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(PactRunner.class)
@Provider("ChautariRentalServiceProvider")
@PactFolder("contract")
@TestPropertySource(locations = "classpath:contract-test.properties")
public class ChautariRentalServiceContractTest {

    private static final String RENTAL_SERVICE_STATE_SUCCESS = "200 Success";

    @TestTarget
    public final Target target = new HttpTarget(9097);

    private TestContextManager testContextManager;


    @Before
    public void before() throws Exception {
        testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this);
    }

    @State(RENTAL_SERVICE_STATE_SUCCESS)
    public void testSuccess() {
        log.info("Now service in ::" + RENTAL_SERVICE_STATE_SUCCESS + ":: state");
    }


}
