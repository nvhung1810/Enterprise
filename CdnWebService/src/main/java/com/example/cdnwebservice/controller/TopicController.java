package com.example.cdnwebservice.controller;


import com.example.cdnwebservice.Service.TopicService;
import com.example.cdnwebservice.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @RequestMapping("topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
                new Topic(1, "Spring Framework", "Spring Description")
        );
    }
}
