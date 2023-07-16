package asia.daijizai.hotlist.lock;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastClientFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/13 0:51
 * @description
 */

@Service
public class LockServiceHazelcastImpl {
    private HazelcastInstance client;
    private IMap map;

    public LockServiceHazelcastImpl(){
        this(null);
    }

    public LockServiceHazelcastImpl(List<String> addressList){
        ClientConfig clientConfig=new ClientConfig();
        HazelcastClientFactory factory = new HazelcastClientFactory(clientConfig);
        this.client = factory.getHazelcastInstance();
        this.map=this.client.getMap("lock");
    }

    public boolean lock(String key,int timeoutInSecs){
        Object value = this.map.put(key, "1", (long) timeoutInSecs, TimeUnit.SECONDS);
        return value==null;
    }

    public boolean isLocked(String key){
        Object value = this.map.get(key);
        return value!=null;
    }

    public boolean unLock(String key){
        Object value = this.map.remove(key);
        return value!=null;
    }

    public void shutdown(){
        this.client.shutdown();
    }
}
