/*
 * This Java source file was auto generated by running 'gradle buildInit'
 * by 'Felipe' at '02/04/17 11:22' with Gradle 2.14.1
 *
 * @author Felipe, @date 02/04/17 11:22
 */
import javax.jms.Queue;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.reader.ParamsReader;

@SpringBootApplication
@ComponentScan({"com"})
public class SparkBoot {

	@Autowired
	public ParamsReader reader;
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("artemis-queue-test");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SparkBoot.class, args);
	}
	
}
