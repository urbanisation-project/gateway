package gateway.controller;

import gateway.proxy.advertiser.payload.*;
import gateway.proxy.common.Credentials;
import gateway.service.AdvertiserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/api/advertisers")
public class AdvertiserController {
    private AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @PostMapping("/save")
    public AdvertiserPayload save(@RequestBody AdvertiserPayload advertiser) {
        return advertiserService.saveAdvertiser(advertiser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AdvertiserPayload> authenticate(@RequestBody Credentials credentials) {
        try {
            return new ResponseEntity(advertiserService.authenticate(credentials), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("message", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/campaigns/save")
    public CampaignPayload save(@RequestBody CampaignPayload campaign) {
        return advertiserService.saveCampaign(campaign);
    }

    @PostMapping("/campaigns/ad-sets/save")
    public AdSetPayload save(@RequestBody AdSetPayload adSet) {
        return advertiserService.saveAdSet(adSet);
    }

    @PostMapping("/campaigns/ad-sets/ads/save")
    public AdPayload save(@RequestBody AdPayload ad) {
        return advertiserService.saveAd(ad);
    }

    @GetMapping("/campaigns/ads/{adId}/visitors/count")
    public Integer getAdVisitorsCount(@PathVariable Long adId) {
        return advertiserService.getAdVisitorsCount(adId);
    }

    @GetMapping("/campaigns/ads/{adId}/visitors/count/update")
    public void updateAdVisitorsCount(@PathVariable Long adId) {
        advertiserService.updateAdVisitorsCount(adId);
    }

    @GetMapping("/{advertiserId}/campaigns")
    public List<CampaignPayload> getAdvertiserCampaigns(@PathVariable Long advertiserId) {
        return advertiserService.getAdvertiserCampaigns(advertiserId);
    }

    @GetMapping("/campaigns/{campaignId}/ad-sets")
    public List<AdSetPayload> getCampaignAdSets(@PathVariable Long campaignId) {
        return advertiserService.getCampaignAdSets(campaignId);
    }

    @GetMapping("/ad-sets/{adSetId}/ads")
    public List<AdPayload> getAdSetAds(@PathVariable Long adSetId) {
        return advertiserService.getAdSetAds(adSetId);
    }

    @PostMapping(value="/ads/{adId}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addImageToAd(@PathVariable Long adId , @RequestPart MultipartFile file){
        advertiserService.addImageToAd(adId,file);
    }
    @GetMapping("/{adId}/images")
    public byte[] getImage(@PathVariable Long adId) throws Exception {
        return advertiserService.getImage(adId);
    }
}
