package com.zhaos.ehcache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * ClassName: ReactCache <br/>
 * Description: React自定义的Cache类。<br>
 * Cache作为一个外配置的组建，自行在指定的cache的配置文件中，使用xml配置cache，而各个应用使用@Resource注解，获取指定的Cache。 <br/>
 * 【注意】开发人员不得在本类上打@Service、@Component等标签。<br>
 * TODO 该缓存的设计思想，是源于0.9版本，虽然做了很多的规范和精细化的设计，但是现在看来，该缓存的设计思路从一开始就是错误的，
 * 因为索引缓存的功能应该是对象的天然属性。<br>
 * TODO 本缓存未来直接继承Cache类，而不应该作为封装设计。<br>
 * 
 */
public class MyCache<K, V> {

    @Autowired
    private CacheManager cacheManager;

    /**
     * 初始化后的Cache，真正的Cache。
     */
    private Cache cache;
    /**
     * Cache的名称，需要在Spring的xml配置文件中自行定义，要确保不同的cache有不同的名称。
     */
    private String cacheName;

    /**
     * 
     * init:ReactCache的初始化方法，在Bean构造完成后，init-method调用此方法进行初始化。 <br/>
     * 本初始化方法支持默认配置和自定义配置两种形式。<br>
     * 1、如果只是配置一个ehcache配置文件没有的cacheName，则会仿照defaultCache创建一个新的cache。<br>
     * 2、如果配置了一个ehcache配置文件配置过的cacheName，则会从CacheManager中直接获取已经存在的cache。<br>
     * 
     * @exception Spring的xml配置中缺少了相关的配置参数
     *                ，如cacheName.<br>
     */
    public void init() {
        if (this.cacheName == null) {
            System.err.println("Cache构造失败，可能Spring的配置文件中没有配置cacheName！");
        }
        if (this.cacheManager.cacheExists(this.cacheName)) {
            this.cache = this.cacheManager.getCache(this.cacheName);
            System.out.println("从ehcahce配置文件中获取已经存在的指定名称的cache。");
        } else {
        	System.out.println("ehcache中没有指定名称的cache，将会仿照defaultCache的配置自动生成一个新的cache。");
            this.cacheManager.addCache(this.cacheName);
            this.cache = this.cacheManager.getCache(this.cacheName);
        }
        System.out.println(String.format("React的缓存%s初始化完成。", this.cacheName));
    }

    /**
     * 
     * set:put the key-value pair into cache.<br/>
     * 
     * @param key
     *            key
     * @param value
     *            value corresponding to the key
     */
    public void set(String key, V value) {
        Element elem = new Element(key, value);
        this.cache.put(elem);
    }

    /**
     * 
     * @param key
     *            key
     * @return value specified by the given key, or else return null when the
     *         key not found in cache.
     */
    @SuppressWarnings("unchecked")
    public V get(String key) {
        Element elem = this.cache.get(key);
        if (elem == null) {
            return null;
        } else {
            return (V) elem.getObjectValue();
        }
    }

    /**
     * 
     * keys:list all the key in the cache <br/>
     * 
     * @return all the key in the cache
     */
    @SuppressWarnings("unchecked")
    public List<K> keys() {
        return this.cache.getKeys();
    }

    /**
     * 
     * size:get the size of the cache <br/>
     * 
     * @return the size of the cache
     */
    public int size() {
        return this.cache.getSize();
    }

    public void evictExpiredElements() {
        this.cache.evictExpiredElements();
    }

    /**
     * 
     * contains:whether the cache contains the specified key <br/>
     * 
     * @param key
     *            the input key
     * @return true or false
     */
    public boolean contains(String key) {
        List<?> keys = keys();
        return keys.contains(key);
    }

    /**
     * 
     * remove:remove the key-value pair form the cache by the specified key <br/>
     * 
     * @param key
     *            the input key
     */
    public void remove(String key) {
        this.cache.remove(key);
    }

    /**
     * 
     * removeAll:remove all the key-value pair in the cache <br/>
     */
    public void removeAll() {
        this.cache.removeAll();
    }

    /**
     * cacheName.<br/>
     * 
     * @return the cacheName <br/>
     * 
     */
    public String getCacheName() {
        return cacheName;
    }

    /**
     * cacheName.<br/>
     * 
     * @param cacheName
     *            the cacheName to set <br/>
     * 
     */
    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

}
