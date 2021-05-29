package com.serverless;

import java.util.Collections;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.dtos.RequestDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		//This logs can be viewed on AWS cloudWatch
		LOG.info("received: {}", input);

		Response responseBody;
		int statusCoede;

		try {
			//deserialization the json body string into a dto
			RequestDto requestData = new ObjectMapper().readValue((String)input.get("body"),RequestDto.class);
			//building the response
			responseBody = new Response(requestData.getFirstName(), requestData.getLastName(), requestData.getYearOfBirth());
			statusCoede = 200;
		} catch (Exception e) {
			LOG.warn("Error", e);
			statusCoede = 500;
			responseBody = null;
		}

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}
}
