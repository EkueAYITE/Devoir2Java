package sio.devoir2graphiques;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sio.devoir2graphiques.Tools.ConnexionBDD;
import sio.devoir2graphiques.Tools.GraphiqueController;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class Devoir2GraphiquesController implements Initializable
{
    HashMap<Integer,Double> datasGraphiqueMap1;
    HashMap<String,Double> datasGraphiqueMap2;
    ConnexionBDD maCnx;
    XYChart.Series<Integer,Double> serieGraph1;
    GraphiqueController graphiqueController;
    @FXML
    private Button btnGraph1;
    @FXML
    private Button btnGraph2;
    @FXML
    private Button btnGraph3;
    @FXML
    private AnchorPane apGraph1;
    @FXML
    private LineChart graph1;
    @FXML
    private Label lblTitre;
    @FXML
    private AnchorPane apGraph2;
    @FXML
    private AnchorPane apGraph3;
    @FXML
    private PieChart graph3;
    @FXML
    private BarChart graph2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTitre.setText("Devoir : Graphique n°1");
        apGraph1.toFront();

        // A vous de jouer

        try {
            maCnx = new ConnexionBDD();
            graphiqueController = new GraphiqueController();
            datasGraphiqueMap1 = graphiqueController.GetDataGraphique1();
            Set<Integer> ages = datasGraphiqueMap1.keySet();
            for (Integer age : ages) {
                serieGraph1.getData().add(new XYChart.Data(age, datasGraphiqueMap1.get(age)));
            }
            graph1.getData().add(serieGraph1);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
       

    @FXML
    public void menuClicked(Event event) throws SQLException {
        if(event.getSource() == btnGraph1)
        {
            lblTitre.setText("Devoir : Graphique n°1");
            apGraph1.toFront();

            // A vous de jouer
            try {
                maCnx = new ConnexionBDD();
                graphiqueController = new GraphiqueController();
                datasGraphiqueMap1 = graphiqueController.GetDataGraphique1();
                Set<Integer> ages = datasGraphiqueMap1.keySet();
                for (Integer age : ages) {
                    serieGraph1.getData().add(new XYChart.Data(age, datasGraphiqueMap1.get(age)));
                }
                graph1.getData().add(serieGraph1);


            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else if(event.getSource() == btnGraph2)
        {
            lblTitre.setText("Devoir : Graphique n°2");
            apGraph2.toFront();

            // A vous de jouer
            try {
                maCnx = new ConnexionBDD();
                graphiqueController = new GraphiqueController();
                graph2.getData().clear();
                ObservableList<PieChart.Data> observableListDataGraph2 = FXCollections.observableArrayList();
                datasGraphiqueMap2 = graphiqueController.GetDataGraphique2();
                Set<String> sexes = datasGraphiqueMap2.keySet();
                for (String sexe : sexes) {
                    observableListDataGraph2.add(new PieChart.Data(sexe, datasGraphiqueMap2.get(sexe)));
                }
                graph2.getData().add(serieGraph1);


            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else
        {
            lblTitre.setText("Devoir : Graphique n°3");
            apGraph3.toFront();

            // A vous de jouer

        }
    }
}