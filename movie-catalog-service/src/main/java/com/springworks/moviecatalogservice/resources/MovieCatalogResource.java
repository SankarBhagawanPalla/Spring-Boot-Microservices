package com.springworks.moviecatalogservice.resources;

import com.springworks.moviecatalogservice.models.CatalogItem;
import com.springworks.moviecatalogservice.models.Movie;
import com.springworks.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("679", 4),
                new Rating("998", 3)
        );

        return ratings.stream().map(rating -> {

            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            return  new CatalogItem(movie.getName(), "Test Desc", rating.getRating());

        }).collect(Collectors.toList());

    }
}
