package io.pivotal.bling.server.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sgupta
 * @since 2/15/15.
 */
@Controller
@RequestMapping(value = "/api/beacon/**", produces = "application/json")
public class BeaconController {
}
