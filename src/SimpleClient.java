import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;


public class SimpleClient {
        public static void main(String [] args){
            while (true) {
                try {
                    PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
                    Producer<String> stringProducer = client.newProducer(Schema.STRING).topic("one").create();
                    stringProducer.send("My message");
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Fail");
                }
            }

        }
    }

