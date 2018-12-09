package pack;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseEhCache {
  static final Logger logger = LoggerFactory.getLogger("test");

  public static void main(String[] args) {

    CachingProvider provider = Caching.getCachingProvider();
    CacheManager cacheManager = provider.getCacheManager();
    MutableConfiguration<Long, String> configuration = new MutableConfiguration<Long, String>()
        .setTypes(Long.class, String.class).setStoreByValue(false);

    Cache<Long, String> cache = cacheManager.createCache("test-cache", configuration);
    
    LoggingEntryListener<Long,String> list = new LoggingEntryListener<>();
    
    MutableCacheEntryListenerConfiguration<Long, String> listConf = 
        new MutableCacheEntryListenerConfiguration<>(
            FactoryBuilder.factoryOf(list), null, false, false);

    cache.registerCacheEntryListener(listConf);

    cache.put(100L, "val100");
    cache.put(200L, "val200");
    
    cacheManager.close();
  }
}
