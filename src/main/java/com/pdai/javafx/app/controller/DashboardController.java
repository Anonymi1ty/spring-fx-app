package com.pdai.javafx.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * {@code @description:} The controller for drawing the dashboard.
 */
@Component
public class DashboardController extends BaseController implements Initializable {

    @FXML private AreaChart<String, Number> areaChart;

    @FXML private PieChart pieChart;

    /**
     * Initializes the controller class.
     * @param location
     * The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Sun", Math.random()),
                new PieChart.Data("IBM", Math.random()),
                new PieChart.Data("HP", Math.random()),
                new PieChart.Data("Dell", Math.random()),
                new PieChart.Data("Apple", Math.random())
        );
        pieChart.setData(pieChartData);
        pieChart.setClockwise(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Test histogram data");
        series.getData().add(new XYChart.Data<>("0", 2D*Math.random()));
        series.getData().add(new XYChart.Data<>("1", 8D*Math.random()));
        series.getData().add(new XYChart.Data<>("2", 5D*Math.random()));
        series.getData().add(new XYChart.Data<>("3", 3D*Math.random()));
        series.getData().add(new XYChart.Data<>("4", 6D*Math.random()));
        series.getData().add(new XYChart.Data<>("5", 8D*Math.random()));
        series.getData().add(new XYChart.Data<>("6", 5D*Math.random()));
        series.getData().add(new XYChart.Data<>("7", 6D*Math.random()));
        series.getData().add(new XYChart.Data<>("8", 5D*Math.random()));

        areaChart.getData().setAll(series);
        areaChart.setCreateSymbols(true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
