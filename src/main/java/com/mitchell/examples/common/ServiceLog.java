package com.mitchell.examples.common;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLog
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLog.class);

    @Around("execution(* com.mitchell.examples..*(..)) && !within(@org.springframework.context.annotation.Configuration *))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable
    {
        StopWatch stopWatch = null;
        if (LOGGER.isDebugEnabled())
        {
            stopWatch = new StopWatch();
            stopWatch.start();
        }
        Object retVal = joinPoint.proceed();
        try
        {
            if (LOGGER.isDebugEnabled())
            {
                stopWatch.stop();
                StringBuffer logMessage = new StringBuffer();
                logMessage.append(joinPoint.getTarget().getClass().getName());
                logMessage.append(".");
                logMessage.append(joinPoint.getSignature().getName());
                logMessage.append("(");
                // append args
                Object[] args = joinPoint.getArgs();
                for (int i = 0; i < args.length; i++)
                {
                    logMessage.append(args[i]).append(",");
                }
                if (args.length > 0)
                {
                    logMessage.deleteCharAt(logMessage.length() - 1);
                }
                logMessage.append(")");
                logMessage.append(" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>execution time: ");
                logMessage.append(stopWatch.getTime());
                logMessage.append(" ms");
                LOGGER.debug(logMessage.toString());
            }
        } catch (Exception ex)
        {
            LOGGER.error("Error in logTimeMethod", ex);
        }

        return retVal;
    }

    @Before("execution(* com.mitchell.examples..*(..)) && !within(@org.springframework.context.annotation.Configuration *))")
    public void logBeginExecution(JoinPoint joinPoint) throws Throwable
    {

        try
        {
            Object[] args = joinPoint.getArgs();
            Signature signature = joinPoint.getSignature();
            Object obj = args != null && args.length > 0 ? args[0] : "";
            LOGGER.debug(signature.getName() + obj.toString());

        } catch (Exception ex)
        {

            LOGGER.error(ex.getMessage(), ex);
        }

    }

    @AfterReturning("execution(* com.mitchell.examples..*(..))  && !within(@org.springframework.context.annotation.Configuration *)")
    public void logEndExecution(JoinPoint joinPoint) throws Throwable
    {

        try
        {
            Object[] args = joinPoint.getArgs();
            Signature signature = joinPoint.getSignature();
            Object obj = args != null && args.length > 0 ? args[0] : "";
            LOGGER.debug(signature.getName() + obj.toString());
        } catch (Exception ex)
        {

            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.mitchell.examples..*(..))  && !within(@org.springframework.context.annotation.Configuration *)",
            throwing = "ex")
    public void logExcpetion(JoinPoint joinPoint, Throwable ex) throws Throwable
    {

        try
        {

            Throwable causeEx = ExceptionUtils.getRootCause(ex);
            LOGGER.error(causeEx.getMessage(), causeEx);

        } catch (Exception e)
        {

            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
