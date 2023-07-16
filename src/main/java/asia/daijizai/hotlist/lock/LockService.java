package asia.daijizai.hotlist.lock;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/16 22:32
 * @description
 */

public interface LockService {

    public boolean lock(String key,int timeoutInSecs);
    public boolean isLocked(String key);
    public boolean unLock(String key);

}
