package pack;

import java.io.Serializable;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryUpdatedListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingEntryListener<K,V>
    implements CacheEntryCreatedListener<K,V>, CacheEntryUpdatedListener<K,V>, Serializable {

  private static final long serialVersionUID = 1L;
  
  static final Logger logger = LoggerFactory.getLogger("listener");

  public void onUpdated(Iterable<CacheEntryEvent<? extends K, ? extends V>> events) {
    for (CacheEntryEvent<?,?> event:events)
      logger.info("onUpdated: event={} key={} value={}", event.getEventType(), event.getKey(), event.getValue());
  }

  public void onCreated(Iterable<CacheEntryEvent<? extends K, ? extends V>> events) {
    for (CacheEntryEvent<?,?> event:events)
      logger.info("onCreated: event={} key={} value={}", event.getEventType(), event.getKey(), event.getValue());
  }
}
