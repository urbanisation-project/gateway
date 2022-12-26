package gateway.controller;

import gateway.proxy.advertiser.payload.AdPayload;
import gateway.proxy.advertiser.payload.AdSetPayload;
import gateway.proxy.advertiser.payload.AdvertiserPayload;
import gateway.proxy.advertiser.payload.CampaignPayload;
import gateway.proxy.common.Credentials;
import gateway.service.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/advertisers")
public class AdvertiserController {
    private AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }
    @PostMapping("/save")
    public AdvertiserPayload save(@RequestBody AdvertiserPayload advertiser){
        return advertiserService.saveAdvertiser(advertiser);
    }
    @PostMapping("/authenticate")
    public AdvertiserPayload authenticate(@RequestBody Credentials credentials){
        return advertiserService.authenticate(credentials);
    }
    @PostMapping("/campaigns/save")
    public CampaignPayload save(@RequestBody CampaignPayload campaign){
        return advertiserService.saveCampaign(campaign);
    }
    @PostMapping("/campaigns/ad-sets/save")
    public AdSetPayload save(@RequestBody AdSetPayload adSet){
        return advertiserService.saveAdSet(adSet);
    }
    @PostMapping("/campaigns/ad-sets/ads/save")
    public AdPayload save(@RequestBody AdPayload ad){
        return advertiserService.saveAd(ad);
    }
    @GetMapping("/campaigns/ads/{adId}/visitors/count")
    public Integer getAdVisitorsCount(@PathVariable Long adId){
        return advertiserService.getAdVisitorsCount(adId);
    }
    @GetMapping("/campaigns/ads/{adId}/visitors/count/update")
    public void updateAdVisitorsCount(@PathVariable Long adId){
        advertiserService.updateAdVisitorsCount(adId);
    }
    @GetMapping("/{advertiserId}/campaigns")
    public List<CampaignPayload> getAdvertiserCampaigns(@PathVariable Long advertiserId){
        return advertiserService.getAdvertiserCampaigns(advertiserId);
    }
    @GetMapping("/campaigns/{campaignId}/ad-sets")
    public List<AdSetPayload> getCampaignAdSets(@PathVariable Long campaignId){
        return advertiserService.getCampaignAdSets(campaignId);
    }
    @GetMapping("/ad-sets/{adSetId}/ads")
    public List<AdPayload> getAdSetAds(@PathVariable Long adSetId){
        return advertiserService.getAdSetAds(adSetId);
    }
}