package org.activiti.cloud.runtime;

import org.activiti.cloud.runtime.connectors.CampaignMessageChannels;
import org.activiti.cloud.runtime.connectors.RewardMessageChannels;
import org.activiti.cloud.services.events.ProcessEngineChannels;
import org.activiti.cloud.starter.rb.configuration.ActivitiRuntimeBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ActivitiRuntimeBundle
@EnableBinding({ProcessEngineChannels.class, CampaignMessageChannels.class, RewardMessageChannels.class})
@EnableDiscoveryClient
public class Application  {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,
                              args);
    }



}