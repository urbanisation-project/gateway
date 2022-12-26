package gateway.proxy.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistPayload {
    private Long id;
    public String name;
    public UserPayload user;
}
