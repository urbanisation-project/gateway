package gateway.controller;

import gateway.proxy.user.payload.VideoAdResponse;
import gateway.service.AdvertiserService;
import gateway.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/researches")
public class SearchController {
    private SearchService searchService;
    private AdvertiserService advertiserService;

    public SearchController(SearchService searchService, AdvertiserService advertiserService) {
        this.searchService = searchService;
        this.advertiserService = advertiserService;
    }

    @GetMapping("/youtube/{query}")
    public VideoAdResponse researchVideoYoutube(@PathVariable String query){
        return new VideoAdResponse(
                query,
                searchService.researchVideoYoutube(query),
                advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                        .collect(Collectors.toList()))
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
    @GetMapping("/dailymotion/{query}")
    public VideoAdResponse researchVideoDailyMotion(@PathVariable String query){
        return new VideoAdResponse(
                query,
                searchService.researchVideoDailyMotion(query),
                advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                        .collect(Collectors.toList()))
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
}
