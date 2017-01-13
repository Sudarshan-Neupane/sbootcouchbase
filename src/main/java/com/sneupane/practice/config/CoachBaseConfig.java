package com.sneupane.practice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sudarshan on 1/12/17.
 */
@Configuration
public class CoachBaseConfig  extends AbstractCouchbaseConfiguration{

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("localhost");
    }

    @Override
    protected String getBucketName() {
        return "sudarshan";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }
}
