package com.kveola13.springboot.topic;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring framework", "Spring framework description"),
            new Topic("Java", "Java core", "Java core description"),
            new Topic("JavaScript", "JavaScript framework", "Javascript description"))
    );

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic topic1 = topics.get(i);
            if (topic1.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }
}
