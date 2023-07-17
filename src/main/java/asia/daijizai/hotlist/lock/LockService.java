package asia.daijizai.hotlist.lock;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/16 22:32
 * @description
 */

public interface LockService {
    /**
     * 加索
     * @param key
     * @param timeoutInSecs 过期时间
     * @return
     */
    public boolean lock(String key,int timeoutInSecs);

    /**
     * 判断锁状态
     * @param key
     * @return
     */
    public boolean isLocked(String key);

    /**
     * 解锁
     * @param key
     * @return
     */
    public boolean unLock(String key);

}
