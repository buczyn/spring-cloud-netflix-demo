package com.globallogic.samples.cloud.articles.endpoints;

import java.util.Date;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

@RestController
public class ArticlesController {

	private static final int LAST_3_MONTH_HOURS = 3 * 30 * 24;
	private static final int SECONDS_IN_HOUR = 60 * 60;

	private Lorem lorem = LoremIpsum.getInstance();
	private Random random = new Random();

	@RequestMapping(path = "/articles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article getArticle(@PathVariable String id) {
		String title = lorem.getTitle(5);
		String text = lorem.getParagraphs(1, 3);
		Author author = new Author(lorem.getFirstName(), lorem.getLastName());
		return new Article(id, title, text, author, randomDate());

	}

	private Date randomDate() {
		long pastDays = random.nextInt(LAST_3_MONTH_HOURS);
		long time = random.nextInt(SECONDS_IN_HOUR);
		return new Date(System.currentTimeMillis() - (pastDays * SECONDS_IN_HOUR + time) * 1000);
	}

}
