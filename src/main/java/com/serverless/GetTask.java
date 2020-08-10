package com.serverless;

import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetTask implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		
		try {
			// get the 'pathParameters' from input
			Map<String,String> pathParameters = (Map<String,String>)input.get("pathParameters");
			String taskId = pathParameters.get("id");

			Task task = new Task(taskId);
			return ApiGatewayResponse.builder()
					.setStatusCode(200)
					.setObjectBody(task)
					.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
					.build();

		} catch (Exception e) {
			LOG.error("Error in retriving task: " + e);

			// send the error response back
			Response responseBody = new Response("Error in retriving task: ", input);
			return ApiGatewayResponse.builder()
												.setStatusCode(500)
												.setObjectBody(responseBody)
												.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
												.build();
		}
	}
}
