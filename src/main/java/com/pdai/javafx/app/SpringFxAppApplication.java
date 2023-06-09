package com.pdai.javafx.app;

import com.pdai.javafx.app.fx.AbstractFxApplication;
import com.pdai.javafx.app.fx.FxmlView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * <b>ClassName</b>: SpringFxAppApplication
 *
 * <b>Description</b>: SpringFxAppApplication
 *
 */
@SpringBootApplication
public class SpringFxAppApplication extends AbstractFxApplication {

    public static void main(String[] args) {
        // Arrays.asList(new FxmlView[]{FxmlView.MODULE_DASHBOARD, FxmlView.MODULE_PROFILE, FxmlView.MAIN}),FxmlView.MAIN, args); 作用是：在启动时，加载这些FxmlView，然后显示FxmlView.MAIN
        run(SpringFxAppApplication.class,
                Arrays.asList(new FxmlView[]{FxmlView.MODULE_DASHBOARD, FxmlView.MODULE_PROFILE, FxmlView.MAIN, FxmlView.Forum}),
                FxmlView.MAIN, args);
    }
}
