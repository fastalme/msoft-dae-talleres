package edu.msoft.subscriber;

import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import edu.msoft.model.MyEvent;

public class MyEventListener implements MessageListener<MyEvent> {

    @Override
    public void onMessage(Message<MyEvent> message) {
        MyEvent myEvent = message.getMessageObject();
        System.out.printf("Evento: %s Fecha: %s%n", myEvent.message(), myEvent.timestamp());
    }

}
