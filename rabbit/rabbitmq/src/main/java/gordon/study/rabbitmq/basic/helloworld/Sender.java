package gordon.study.rabbitmq.basic.helloworld;

import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import gordon.study.rabbitmq.util.ConnectionFactoryUtil;

public class Sender {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 10;) {
            String message = "NO. " + ++i;
            TimeUnit.MILLISECONDS.sleep(1000);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.printf("(%1$s)[===>%2$s    ] %3$s\n", "Sender", QUEUE_NAME, message);
        }

        channel.close();
        connection.close();
    }
}
