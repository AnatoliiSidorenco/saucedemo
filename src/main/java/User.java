import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class User {
    private String userName    ;
    private String password;

}

// здесь я описал поля для метода в LoginPage которые я могу заполнять любыми значениями с помощью lombok
