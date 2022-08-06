package edu.msoft.subscriber;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import edu.msoft.model.MyEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubscriberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SubscriberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setClusterName("data-grid");

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		ITopic<MyEvent> topic = client.getTopic("events");
		topic.addMessageListener(new MyEventListener());

		System.out.println("Cliente suscrito....");

	}

}
