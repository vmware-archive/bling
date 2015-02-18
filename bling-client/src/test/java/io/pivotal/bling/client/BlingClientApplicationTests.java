package test.java.io.pivotal.bling.client;

import io.pivotal.bling.client.BlingClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlingClientApplication.class)
@WebAppConfiguration
public class BlingClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
