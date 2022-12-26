package gateway.proxy.advertiser.payload;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdPayload {
    private Long id;
    private String name;
    //private Resource resource;
    private String resource;
    private Date startDate;
    private Date endDate;
    private String description;
    private AdSetPayload adSet;
}
