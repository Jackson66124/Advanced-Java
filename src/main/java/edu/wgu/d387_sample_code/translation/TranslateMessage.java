package edu.wgu.d387_sample_code.translation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class TranslateMessage {
    static ExecutorService messageExecutor=newFixedThreadPool(5);

    public static ArrayNode getWelcomeMessage() {
        Properties properties = new Properties();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        CountDownLatch latch = new CountDownLatch(2);

        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load((stream));
                arrayNode.add(properties.getProperty("welcome"));
            } catch (Exception e ) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load((stream));
                arrayNode.add(properties.getProperty("welcome"));
            } catch (Exception e ) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (Exception e ){
            e.printStackTrace();
        }


        return arrayNode;
    }

}
