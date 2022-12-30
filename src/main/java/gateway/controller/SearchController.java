package gateway.controller;

import gateway.proxy.user.payload.VideoAdResponse;
import gateway.service.AdvertiserService;
import gateway.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Recherche sur youtube, retun vide Aucun video youtube trouvée
    @GetMapping("/youtube/{query}")
    public ResponseEntity<VideoAdResponse> researchVideoYoutube(@PathVariable String query){
        try {
            return new ResponseEntity(new VideoAdResponse(
                    query,
                    searchService.researchVideoYoutube(query),
                    advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                                    .collect(Collectors.toList()))
                            .stream()
                            .distinct()
                            .collect(Collectors.toList())),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity("Aucune video youtube trouvée !", HttpStatus.UNAUTHORIZED);
        }

    }

    // Recherche sur dailymotion, retun vide Aucun video youtube trouvée
    @GetMapping("/dailymotion/{query}")
    public ResponseEntity<VideoAdResponse> researchVideoDailyMotion(@PathVariable String query){
        try {
            return new ResponseEntity(new VideoAdResponse(
                    query,
                    searchService.researchVideoDailyMotion(query),
                    advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                                    .collect(Collectors.toList()))
                            .stream()
                            .distinct()
                            .collect(Collectors.toList())),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity("Aucune video dailymotion trouvée !", HttpStatus.UNAUTHORIZED);
        }
    }
}
