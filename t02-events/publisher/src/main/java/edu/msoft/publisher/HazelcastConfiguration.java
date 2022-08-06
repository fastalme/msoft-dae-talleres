package edu.msoft.publisher;

import com.hazelcast.config.Config;
import com.hazelcast.config.TopicConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import edu.msoft.model.MyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config config() {
        Config config = new Config();
        config.setClusterName("data-grid");

        TopicConfig topicConfig = new TopicConfig();
        topicConfig.setName("events");

        config.addTopicConfig(topicConfig);
        return config;
    }

    @Bean
    public ITopic<MyEvent> topic(HazelcastInstance instance) {
        return instance.getTopic("events");
    }

}
