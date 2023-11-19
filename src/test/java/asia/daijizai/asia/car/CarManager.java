package asia.daijizai.asia.car;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/11/19 22:24
 * @description
 */

public class CarManager {

    @Resource
    private CarDao carDao;

    @Transactional
    public void saveCar(String name){

        carDao.save();

        TransactionUtil.doAfterCompletion(new DoTransactionCompletion(this::refreshCache));
    }

    private void refreshCache(){

    }


}
