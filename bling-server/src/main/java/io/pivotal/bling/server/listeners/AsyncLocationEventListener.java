package io.pivotal.bling.server.listeners;

import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sgupta
 * @since 2/6/15.
 */
@Component
public class AsyncLocationEventListener implements AsyncEventListener {

  @Override
  public void close() {

  }

  @Override
  public boolean processEvents(List<AsyncEvent> list) {
    return false;
  }
}
