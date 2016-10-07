package com.globallogic.samples.cloud.news.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	private ArticlesClient articlesClient;
	private int defaultSize;

	@Autowired
	public NewsController(ArticlesClient articlesClient, @Value("${news.top.defaultSize}") int defaultSize) {
		this.articlesClient = articlesClient;
		this.defaultSize = defaultSize;
	}

	@RequestMapping(path = "/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public NewsList getTopNews(@RequestParam(name = "size", required = false) Integer size) {
		return generateTopNews(size == null ? defaultSize : size);

	}

	private NewsList generateTopNews(int size) {
		List<News> newsList = new ArrayList<News>();
		for (int i = 1; i <= size; i++) {
			Article article = articlesClient.getArticle(Integer.toString(i));
			newsList.add(new News(article.getTitle(), article.getText()));
		}
		return new NewsList(newsList);
	}

}
