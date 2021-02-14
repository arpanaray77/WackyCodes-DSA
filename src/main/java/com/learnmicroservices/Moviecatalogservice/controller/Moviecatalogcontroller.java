package com.learnmicroservices.Moviecatalogservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnmicroservices.Moviecatalogservice.model.MovieCatalogItem;

@RestController
@RequestMapping("/catalog")
public class Moviecatalogcontroller {
	
	@RequestMapping("/{userid}")
	public List<MovieCatalogItem> getCatalog(@PathVariable("userid") String userid)
	{
		return Collections.singletonList(new MovieCatalogItem("Avengers","sci-fi",4));
	}

}