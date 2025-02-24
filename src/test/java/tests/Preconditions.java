package tests;

import entity.User;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;


@Data
@Builder
public class Preconditions extends BaseTest {

    public static User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    public static User userWithEmptyFields = User.builder()
            .username("")
            .password("")
            .build();

    public static User userWithEmptyIncorrect = User.builder()
            .username("sdfdsf")
            .password("dfdfd")
            .build();

    public static User userSuccess = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build();
}
