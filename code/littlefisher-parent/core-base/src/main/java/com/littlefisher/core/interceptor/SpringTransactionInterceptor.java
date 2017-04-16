package com.littlefisher.core.interceptor;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.exception.BaseRuntimeException;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SpringTransactionInterceptor extends AbstractCommandInterceptor {

    /**
     * LOGGER
     */
    private static final LittleFisherLogger logger = LittleFisherLogger.getLogger(SpringTransactionInterceptor.class);

    /**
     * transactionManager
     */
    protected PlatformTransactionManager transactionManager;

    /**
     * SpringTransactionInterceptor
     * 
     * @param transactionManager <br>
     */
    public SpringTransactionInterceptor(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    private int getPropagation(CommandConfig config) throws BaseAppException {
        switch (config.getTransactionPropagation()) {
            case NOT_SUPPORTED:
                return TransactionTemplate.PROPAGATION_NOT_SUPPORTED;
            case REQUIRED:
                return TransactionTemplate.PROPAGATION_REQUIRED;
            case REQUIRES_NEW:
                return TransactionTemplate.PROPAGATION_REQUIRES_NEW;
            default:
                throw new BaseAppException("Unsupported transaction propagation: " + config.getTransactionPropagation());
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     */
    public <U> U execute(final CommandConfig config, final Command<U> command) {
        logger.debug("Running command with propagation {}", config.getTransactionPropagation());

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        try {
            transactionTemplate.setPropagationBehavior(getPropagation(config));
        }
        catch (Exception e) {
            transactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRED);
        }

        U result = transactionTemplate.execute(new TransactionCallback<U>() {
            public U doInTransaction(TransactionStatus status) {
                U result;
                try {
                    result = next.execute(config, command);
                }
                catch (Exception e) {
                    throw new BaseRuntimeException("inerror", e);
                }
                return result;

            }
        });

        return result;
    }
}
