package com.pdai.javafx.app;

import com.pdai.javafx.app.fx.AbstractFxApplication;
import com.pdai.javafx.app.fx.FxmlView;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
public class SpringFxAppApplicationTests extends AbstractFxApplication {
	@Test
	public void testStart() {
		run(SpringFxAppApplication.class,
				Arrays.asList(new FxmlView[]{FxmlView.MODULE_DASHBOARD, FxmlView.MODULE_PROFILE, FxmlView.MAIN, FxmlView.Forum}),
				FxmlView.MAIN, null);
	}
}
