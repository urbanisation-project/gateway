package gateway.proxy.advertiser.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignPayload {
    private Long id;
    private AdvertiserPayload owner;
    private String name;
    private String objective;
    private Double budget;
}
