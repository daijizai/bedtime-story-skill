package asia.daijizai.asia.car;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/11/19 22:38
 * @description
 */
public class TransactionUtil {

    public static void doAfterCompletion(DoTransactionCompletion doTransactionCompletion){
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(doTransactionCompletion);
        }
    }
}
