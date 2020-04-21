package name.ealen.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    private Job job1;
    @Autowired
    private JobLauncher jobLauncher;

    @RequestMapping("excute")
    public void excuteJob() {

        JobParameters jobParameters = new JobParametersBuilder()
                                        .addLong("time", 1587285621174L)
                                        //.addLong("time", System.currentTimeMillis())
                                        .toJobParameters();
        try {
            jobLauncher.run(job1, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

}
