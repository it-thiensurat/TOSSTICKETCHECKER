package com.tsr.tsrproblemreport_tossticket_checker.other_all.service;


import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by teerayut.k on 1/12/2018.
 */

public class MyJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
