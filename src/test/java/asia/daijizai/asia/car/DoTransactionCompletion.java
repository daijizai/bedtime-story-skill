package asia.daijizai.asia.car;

import org.springframework.transaction.support.TransactionSynchronization;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/11/19 22:31
 * @description
 */

public class DoTransactionCompletion implements TransactionSynchronization {

    private Runnable runnable;

    public DoTransactionCompletion(Runnable r){
        this.runnable=r;
    }

    @Override
    public void afterCompletion(int status) {
        if(status==TransactionSynchronization.STATUS_COMMITTED){
            //todo 定义回调函数，即事务执行之后我们要做什么
            this.runnable.run();
        }
    }
}
