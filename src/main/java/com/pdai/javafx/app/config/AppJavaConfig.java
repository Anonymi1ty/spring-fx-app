package com.pdai.javafx.app.config;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.gn.decorator.GNDecorator;
import com.pdai.javafx.app.fx.SpringFXMLLoader;
import com.pdai.javafx.app.fx.StageManager;
import com.pdai.javafx.app.utils.ExceptionWriter;

import javafx.stage.Stage;

@Configuration
public class AppJavaConfig {
	
    @Autowired 
    SpringFXMLLoader springFXMLLoader;

    /**
     * Useful when dumping stack trace to a string for logging.
     * @return ExceptionWriter contains logging utility methods
     */
    @Bean
    @Scope("prototype")
    public ExceptionWriter exceptionWriter() {
        return new ExceptionWriter(new StringWriter());
    }

    /**
     * Manages the views to be displayed in the application primary stage
     * @return StageManager
     */
    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("Bundle");
    }

    /**
     * Manages the views to be displayed in the application primary stage
     * @param stage - The application primary stage
     * @param decorator - The application decorator
     * @return StageManager
     * @throws IOException - If the main view cannot be loaded
     */
    @Bean
    @Lazy(value = true) //Stage only created after Spring context bootstap
    public StageManager stageManager(Stage stage, GNDecorator decorator) throws IOException {
        return new StageManager(springFXMLLoader, stage, decorator);
    }
    
}
