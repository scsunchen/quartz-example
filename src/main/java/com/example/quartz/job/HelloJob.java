package com.example.quartz.job;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

@Log4j2
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HelloJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // get parameters
        context.getJobDetail().getJobDataMap().forEach(
                (k, v) -> log.info("param, key:{}, value:{}", k, v)
        );
        // your logics

        log.info("Hello Job执行时间: " + new Date());
        log.info("getJobInstance: " + context.getJobInstance());
        log.info("getFireInstanceId: " + context.getFireInstanceId());
        log.info("getNextFireTime: " + context.getNextFireTime());
        log.info("getNextFireTime: " + context.getCalendar());

        log.info("isConcurrentExectionDisallowed: " + context.getJobDetail().isConcurrentExectionDisallowed());
        log.info("isPersistJobDataAfterExecution: " + context.getJobDetail().isPersistJobDataAfterExecution());

        context.getJobDetail().getJobDataMap().put("test111", RandomStringUtils.random(4, false, true));
//        context.getJobDetail()
    }


}
