package io.pivotal.bling.server.api;

import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.model.App;
import io.pivotal.bling.core.repositories.AppRepository;
import io.pivotal.bling.server.api.msg.AppCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GenericCreateUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sgupta
 * @since 2/20/15.
 */
@Controller
@RequestMapping(value = "/api/app/**", produces = "application/json")
public class AppController {

  @Autowired
  AppRepository appRepository;

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericCreateUpdateResponse> createUpdateDevice(AppCreateUpdateRequest request) {
    App app = request.getApp();
    String appId = app.getId() == null ? BlingUtils.createTimeBasedUid() : app.getId();
    String uuid = app.getUuid() == null ? BlingUtils.createUUID() : app.getUuid();
    app = new App(appId, app.getName(), app.getDescription(), uuid);

    appRepository.save(app);

    return new ResponseEntity<>(new GenericCreateUpdateResponse("App", app.getId()),
                                HttpStatus.OK);
  }

  @RequestMapping(value = "/{appId}", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<App> getApp(@PathVariable("appId")String appId) {
    App app = appRepository.findOne(appId);
    if(app == null) {
      return new ResponseEntity<App>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<App>(app, HttpStatus.OK);
  }


}
