package com.pdai.javafx.app.fx;

import java.util.ResourceBundle;

/**
 * {@code FxmlView} is an enumeration of all fxml files with their corresponding titles.
 */
public enum FxmlView {
    MAIN {
        // title()是给窗口设置标题的
        @Override
		public String title() {
            return getStringFromResourceBundle("app.title");
        }

        @Override
		public String fxml() {
            return "/template/main/main.fxml";
        }

    }, 
    MODULE_DASHBOARD {
        @Override
		public String title() {
            return getStringFromResourceBundle("module.dashboard.title");
        }

        @Override
		public String fxml() {
            return "/template/module/dashboard.fxml";
        }


    },
    MODULE_PROFILE {
        @Override
		public String title() {
            return getStringFromResourceBundle("module.profile.title");
        }

        @Override
		public String fxml() {
            return "/template/module/profile.fxml";
        }

    },
    Forum {
        @Override
        public String title() {
            return getStringFromResourceBundle("module.Forum.title");
        }

        @Override
        public String fxml() {
            return "/template/module/Forum.fxml";
        }

    }

    ;
	
    
    public abstract String title();
    public abstract String fxml();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
