package com.springworks.ratingsdataservice.resources;

import com.springworks.ratingsdataservice.models.Rating;
import com.springworks.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId")String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("678", 4),
                new Rating("988", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return  userRating;
    }

}

