package builders;

import models.users.RegisterUserInfo;

public class RegisterUserInfoBuilder {
    private String name;
    private String email;
    private String password;
    private String job;

    public RegisterUserInfoBuilder(String name) {
        this.name = name;
        this.email = "default@gmail.com";
        this.password = "defaultPassword";
        this.job = "defaultJob";
    }

    public static RegisterUserInfoBuilder withName (String name) {
        return new RegisterUserInfoBuilder(name);
    }

    public RegisterUserInfoBuilder andEmail (String email) {
        this.email = email;
        return this;
    }

    public RegisterUserInfoBuilder andPassword (String password) {
        this.password = password;
        return this;
    }

    public RegisterUserInfoBuilder andJob (String job) {
        this.job = job;
        return this;
    }

    public RegisterUserInfo build(){
        return new RegisterUserInfo(name, email, password, job);
    }
}
