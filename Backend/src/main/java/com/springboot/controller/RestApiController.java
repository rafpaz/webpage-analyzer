package com.springboot.controller;

import com.analyzer.Analyzer;
import com.analyzer.data.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
	private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@RequestMapping(value = "/analyze", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> analyzeWebpage(@RequestParam("url") String url){
		logger.info("Analyzing url: {}", url);
		ResponseData result = Analyzer.analyze(url);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
