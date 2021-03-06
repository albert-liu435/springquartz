package com.rookie.bigdata.learn10;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.util.Date;
import java.util.Set;

/**
 * @ClassName SimpleJob
 * @Description SimpleJob
 * @Author
 * @Date 2020/1/20 9:18
 * @Version 1.0
 */
public class SimpleJob  implements Job {
    public SimpleJob() {
    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("Executing job: " + jobKey + " executing at " + new Date() + ", fired by: " + context.getTrigger().getKey());

        if(context.getMergedJobDataMap().size() > 0) {
            Set<String> keys = context.getMergedJobDataMap().keySet();
            for(String key: keys) {
                String val = context.getMergedJobDataMap().getString(key);
                System.out.println(" - jobDataMap entry: " + key + " = " + val);
            }
        }

        context.setResult("hello");
    }
}
