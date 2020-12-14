package com.tetratech.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import com.tetratech.restservice.util.FileUtil;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    private final Logger log = LoggerFactory.getLogger("REST");
    
    private static final String FILE_NAME = "tetraTechRest";
    
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
	}
 
    private void logResponse(ClientHttpResponse response) throws IOException {
    	
            log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            
        	FileUtil.getInstance().saveReportLine(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()), FILE_NAME);
    }

}
