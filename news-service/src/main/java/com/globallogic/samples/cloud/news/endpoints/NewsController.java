package com.globallogic.samples.cloud.news.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	private static final String CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tincidunt tincidunt augue.";

	private int defaultSize;

	public NewsController(@Value("${news.top.defaultSize}") int defaultSize) {
		this.defaultSize = defaultSize;
	}

	@RequestMapping(path = "/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public NewsList getTopNews(@RequestParam(name = "size", required = false) Integer size) {
		return generateTopNews(size == null ? defaultSize : size);

	}

	private NewsList generateTopNews(int size) {
		List<News> newsList = new ArrayList<News>();
		for (int i = 1; i <= size; i++) {
			newsList.add(new News("Headline " + i, CONTENT));
		}
		return new NewsList(newsList);
	}
}
