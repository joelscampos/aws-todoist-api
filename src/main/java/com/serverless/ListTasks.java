package com.serverless;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListTasks implements RequestHandler<Map<String,Object>, ApiGatewayResponse> {
  private static final Logger LOG = LogManager.getLogger(Handler.class);

  @Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

    try {
      List<Task> tasks = new Task().list();
      return ApiGatewayResponse.builder()
                              .setStatusCode(200)
                              .setObjectBody(tasks)
                              .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                              .build();
    } catch(Exception e) {
      LOG.error("Error in listing tasks: " + e);
      Response responseBody = new Response("Error in listing tasks: ", input);
      return ApiGatewayResponse.builder()
                      .setStatusCode(500)
                      .setObjectBody(responseBody)
                      .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                      .build();
    }
  }
}