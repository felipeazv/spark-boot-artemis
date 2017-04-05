package com.writer;

import java.io.Serializable;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Params;

@Component
public class ParamsWriter implements Serializable {
	
	private static final long serialVersionUID = 2394947058353468285L;

//	private static final Logger log = LoggerFactory.getLogger(ParamsWriter.class);
	
	@Bean
	public String write(Params params) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(params);
		//log.info("post to queue " + json);
//		new ArtemisProducer().send2Queue(json);
		return json;
	}
	
	
//	@Async
//    public Future<String> send2Queue(String params) {
//		RestTemplate restTemplate = new RestTemplate();
//		log.info("post to queue " + params);
//        String url = String.format("http://localhost/params");
//        String results = restTemplate.postForObject(url, params, String.class);
//        return new AsyncResult<>(results);
//    }
}
