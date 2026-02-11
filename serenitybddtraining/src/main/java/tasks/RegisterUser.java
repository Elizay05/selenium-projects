package tasks;

import interactions.Post;
import io.restassured.http.ContentType;
import models.users.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final RegisterUserInfo userInfo;

    public RegisterUser(RegisterUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static RegisterUserBuilder withName(String name) {
        return new RegisterUserBuilder(name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }

    public static class RegisterUserBuilder {
        private String name;
        private String email;
        private String password;
        private String job;

        public RegisterUserBuilder(String name) {
            this.name = name;
        }

        public RegisterUserBuilder andEmail(String email) {
            this.email = email;
            return this;
        }

        public RegisterUserBuilder andPassword(String password) {
            this.password = password;
            return this;
        }

        public RegisterUser andJob(String job) {
            this.job = job;
            return new RegisterUser(RegisterUserInfo.builder()
                    .name(this.name)
                    .email(this.email)
                    .password(this.password)
                    .job(this.job)
                    .build());
        }
    }
}
