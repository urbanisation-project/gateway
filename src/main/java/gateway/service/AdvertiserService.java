package gateway.service;

import gateway.proxy.advertiser.payload.*;
import gateway.proxy.common.Credentials;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdvertiserService {
    AdvertiserPayload authenticate(Credentials credentials);

    Integer getAdVisitorsCount(Long adId);

    List<CampaignPayload> getAdvertiserCampaigns(Long advertiserId);

    List<AdSetPayload> getCampaignAdSets(Long campaignId);

    List<AdPayload> getAdSetAds(Long adSetId);

    AdvertiserPayload saveAdvertiser(AdvertiserPayload advertiser);

    CampaignPayload saveCampaign(CampaignPayload campaign);

    AdSetPayload saveAdSet(AdSetPayload adSet);

    AdPayload saveAd(AdPayload ad);

    List<AdPayload> getAdsByKeywords(List<String> keywords);

    void updateAdVisitorsCount(Long adId);

    void addImageToAd(Long adId, MultipartFile file);

    byte[] getImage(Long adId);
}
