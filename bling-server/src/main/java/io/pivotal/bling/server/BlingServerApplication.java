package io.pivotal.bling.server;

import io.pivotal.bling.server.api.DevicesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableGemfireRepositories
//@ImportResource("/bling-server-context.xml")
public class BlingServerApplication {

  public BlingServerApplication() {
    System.out.println(">>>>>>>>>\n>>>>>>>>\n>>>>> server app process!!");
  }

  public static void main(String[] args) {
        SpringApplication.run(BlingServerApplication.class, args);
    }


  @Bean
  public DevicesController getDevicesController() {
    return new DevicesController();
  }
}
