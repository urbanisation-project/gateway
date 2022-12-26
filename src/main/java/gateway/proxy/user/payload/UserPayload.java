package gateway.proxy.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {
    private Long id;
    private String name;
    private String email;
    private String password;
}
