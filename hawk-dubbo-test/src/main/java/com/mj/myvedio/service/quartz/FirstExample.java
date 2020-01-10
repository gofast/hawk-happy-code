package com.mj.myvedio.service.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Observable;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class FirstExample {
    public static void main(String[] args) {
        new FirstExample().initSchedule();
        System.out.println("-------------------------------------------;");
    }

    private void initSchedule(){
        SchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.start();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            // Trigger the job to run now, and then every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    class HelloJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println("job start;");
            int sum = 10;
            while (sum-- > 0){
                System.out.println("job :HelloJob is running ...");
                try {
                    Thread.sleep(1000L);
                }catch (Exception ex){

                }
            }
            System.out.println("job end;");
        }
    }
}
