package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonHooks {

    @Before("@conbeforehook")
    public void beforeHook() {
        System.out.println("*************Me ejecuto antes de cada escenario*************");
    }

    @After
    public void afterHook() {
        System.out.println("*************Me ejecuto despues de cada escenario*************");
    }
}
