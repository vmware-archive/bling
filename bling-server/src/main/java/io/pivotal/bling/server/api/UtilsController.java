package io.pivotal.bling.server.api;

import io.pivotal.bling.core.BlingUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sgupta
 * @since 2/20/15.
 */
@Controller
@RequestMapping(value = "/api/util/**", produces = "application/json")
public class UtilsController {

  @RequestMapping(value = "newId", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Map<String,String>> getNewId() {
    Map<String,String> map = new HashMap<>();
    map.put("id", BlingUtils.createTimeBasedUid());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @RequestMapping(value = "newUUID", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Map<String,String>> getNewUUID() {
    Map<String,String> map = new HashMap<>();
    map.put("uuid", BlingUtils.createTimeBasedUid());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @RequestMapping(value = "uuid", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Map<String,String>> getUUID(@RequestParam(value = "appId", required = true)String appId) {

    Map<String,String> map = new HashMap<>();
    map.put("uuid", BlingUtils.createTimeBasedUid());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }


}
