package gateway.proxy.advertiser.impl;

import gateway.proxy.advertiser.AdvertiserProxy;
import gateway.proxy.advertiser.payload.*;
import gateway.proxy.common.Credentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AdvertiserProxyImpl implements AdvertiserProxy {
    private RestTemplate restTemplate;
    @Value("${advertiser.url}")
    private String url;

    public AdvertiserProxyImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdvertiserPayload authenticate(Credentials credentials) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/advertisers/authenticate")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                credentials,
                AdvertiserPayload.class
        ).getBody();
    }

    @Override
    public Integer getAdVisitorsCount(Long adId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/ads/"+adId+"/counts")
                .build()
                .toUri();
        return restTemplate.getForEntity(
                uri,
                Integer.class
        ).getBody();
    }
    @Override
    public void updateAdVisitorsCount(Long adId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/ads/"+adId+"/update/counts")
                .build()
                .toUri();
        restTemplate.getForEntity(uri,void.class).getBody();
    }

    @Override
    public List<CampaignPayload> getAdvertiserCampaigns(Long advertiserId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/campaigns/advertisers/" + advertiserId)
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                CampaignPayload[].class
        ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<AdSetPayload> getCampaignAdSets(Long campaignId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/campaigns/"+campaignId+"/ad-sets")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(
                restTemplate.getForEntity(
                        uri,
                        AdSetPayload[].class
                ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<AdPayload> getAdSetAds(Long adSetId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/adSets/"+adSetId+"/ads")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(
                restTemplate.getForEntity(
                        uri,
                        AdPayload[].class
                ).getBody())).collect(Collectors.toList());
    }

    @Override
    public AdvertiserPayload saveAdvertiser(AdvertiserPayload advertiser) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/advertisers/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                advertiser,
                AdvertiserPayload.class
        ).getBody();
    }

    @Override
    public CampaignPayload saveCampaign(CampaignPayload campaign) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/campaigns/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                campaign,
                CampaignPayload.class
        ).getBody();
    }

    @Override
    public AdSetPayload saveAdSet(AdSetPayload saveAdSet) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/adSets/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                saveAdSet,
                AdSetPayload.class
        ).getBody();
    }

    @Override
    public AdPayload saveAd(AdPayload ad) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/ads/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                ad,
                AdPayload.class
        ).getBody();
    }

    @Override
    public List<KeywordPayload> getKeywordsByNames(List<String> keywords) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/keywords/keywords")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(
                restTemplate.postForEntity(
                        uri,
                        keywords,
                        KeywordPayload[].class
                ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<AdPayload> getAdsByKeywords(List<KeywordPayload> keywordList) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/ads/keywords")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(
                restTemplate.postForEntity(
                        uri,
                        keywordList,
                        AdPayload[].class
                ).getBody())).collect(Collectors.toList());
    }
}
