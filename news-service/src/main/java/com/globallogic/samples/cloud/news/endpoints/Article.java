package com.globallogic.samples.cloud.news.endpoints;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	private String id;

	private String title;

	private String text;

}
