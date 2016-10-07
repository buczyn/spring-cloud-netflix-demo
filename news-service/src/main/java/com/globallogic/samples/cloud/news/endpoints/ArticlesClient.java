package com.globallogic.samples.cloud.news.endpoints;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "articles-service")
public interface ArticlesClient {

	@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article getArticle(@PathVariable("id") String id);
}
