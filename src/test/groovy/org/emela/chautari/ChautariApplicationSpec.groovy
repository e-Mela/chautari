package org.emela.chautari


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(webEnvironment = NONE)
class ChautariApplicationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "test context loads"() {
        expect:
        context != null
    }
}
