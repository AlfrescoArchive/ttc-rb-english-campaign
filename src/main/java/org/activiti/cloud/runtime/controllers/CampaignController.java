package org.activiti.cloud.runtime.controllers;

import org.activiti.cloud.runtime.services.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.marker.Markers.append;

@RestController
public class CampaignController {

    private Logger logger = LoggerFactory.getLogger(CampaignController.class);

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private CampaignService campaignService;

    public CampaignController() {

    }

    @RequestMapping(path = "/")
    public String helloFromGateway() {
        return "Hello from the Trending Topic Campaign Named: " + appName + " with topic: " + campaignService.getCurrentTopic();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/topic")
    public String getCurrentTopic() {
        return campaignService.getCurrentTopic();
    }

    public boolean matchTopic(String text,
                              String author) {
        boolean match = text.toLowerCase().contains(campaignService.getCurrentTopic().toLowerCase());
        logger.info(append("service-name",
                           appName),
                    (match ? "Match " : "Non-match") + " for '" + campaignService.getCurrentTopic() + "' on Tweet by " + author);
        return match;
    }
}

