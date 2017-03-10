package com.yc.room1000.core.interceptor;

import com.yc.room1000.core.engine.SystemEngineConfig;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.context.Context;
import com.yc.room1000.core.utils.Room1000Logger;

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
public class CommandContextInterceptor extends AbstractCommandInterceptor {

    /**
     * log
     */
    private static final Room1000Logger logger = Room1000Logger.getLogger(CommandContextInterceptor.class);

    /**
     * commandContextFactory
     */
    protected CommandContextFactory commandContextFactory;

    /**
     * systemEngineConfig
     */
    protected SystemEngineConfig systemEngineConfig;

    /**
     * CommandContextInterceptor
     */
    public CommandContextInterceptor() {
    }

    /**
     * CommandContextInterceptor
     * 
     * @param commandContextFactory <br>
     * @param systemEngineConfig <br>
     */
    public CommandContextInterceptor(CommandContextFactory commandContextFactory, SystemEngineConfig systemEngineConfig) {
        this.commandContextFactory = commandContextFactory;
        this.systemEngineConfig = systemEngineConfig;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     * @throws BaseAppException <br>
     */
    public <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        CommandContext context = Context.getCommandContext();

        boolean contextReused = false;
        if (!config.isContextReusePossible() || context == null || context.getException() != null) {
            context = commandContextFactory.createCommandContext(command);
        }
        else {
            logger.debug("Valid context found. Reusing it for the current command '{}'", command.getClass()
                .getCanonicalName());
            contextReused = true;
        }
        try {
            // Push on stack
            Context.setCommandContext(context);
            Context.setSystemEngineConfig(systemEngineConfig);

            return next.execute(config, command);

        }
        catch (BaseAppException e) {

            context.exception(e);
            throw e;

        }
        finally {
            try {
                if (!contextReused) {
                    context.close();
                }
            }
            finally {
                // Pop from stack
                Context.removeCommandContext();
                Context.removeEshopEngineConfig();
            }
        }

    }
}
