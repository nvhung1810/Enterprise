package com.example.cdnwebservice.Service;

import com.example.cdnwebservice.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = Arrays.asList(
            new Topic(1, "Spring Security", "Spring Security")
    );
    public List<Topic> getAllTopics() {
        return topics;
    }
    public Topic getTopic(int id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
}
