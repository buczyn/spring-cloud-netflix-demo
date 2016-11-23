package com.globallogic.samples.cloud.news.endpoints;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "articles-service", fallback = ArticlesClient.Fallback.class)
public interface ArticlesClient {

	@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article getArticle(@PathVariable("id") String id);

	@Component
	public static class Fallback implements ArticlesClient {

		@Override
		public Article getArticle(String id) {
			return new Article("FALLBACK", "Fallback title", "text");
		}

	}
}
