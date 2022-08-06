package edu.msoft.publisher;

import com.hazelcast.topic.ITopic;
import edu.msoft.model.MyEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDateTime;

@RestController
public class TimestampController {

    private ITopic<MyEvent> topic;

    public TimestampController(ITopic<MyEvent> topic) {
        this.topic = topic;
    }

    @GetMapping("/timestamp")
    public ResponseEntity<LocalDateTime> getTimestamp() {

        LocalDateTime timestamp = LocalDateTime.now(Clock.systemDefaultZone());

        topic.publish(new MyEvent("Timestamp delivered", timestamp));

        return ResponseEntity.ok(timestamp);

    }

}
