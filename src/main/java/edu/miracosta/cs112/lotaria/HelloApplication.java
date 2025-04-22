package edu.miracosta.cs112.lotaria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.control.ProgressBar;

import java.util.Random;

public class HelloApplication extends Application {
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };
    private final Random random = new Random();
    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("EChALE STEM Lotería!");
        titleLabel.setFont(new Font("Arial", 20));
        titleLabel.setTextFill(Color.DARKBLUE);

        ImageView cardImageView = new ImageView();
        cardImageView.setFitWidth(300);
        cardImageView.setFitHeight(300);
        cardImageView.setPreserveRatio(true);
        cardImageView.setImage(LOTERIA_CARDS[0].getImage());

        Label messageLabel = new Label("Press the button to draw a card!");
        messageLabel.setFont(new Font("Arial", 14));

        Button drawCardButton = new Button("Draw Random Card");

        ProgressBar gameProgressBar = new ProgressBar(0);
        gameProgressBar.setPrefWidth(300);

        // Layout
        VBox root = new VBox(10, titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 20;");

        Scene scene = new Scene(root, 350, 500);
        stage.setTitle("EChALE STEM Lotería!");
        stage.setScene(scene);
        stage.show();

        drawCardButton.setOnAction(e -> {
            int index = random.nextInt(LOTERIA_CARDS.length);
            LoteriaCard selectedCard = LOTERIA_CARDS[index];
            cardImageView.setImage(selectedCard.getImage());
            messageLabel.setText("Card drawn: " + selectedCard.getCardName());
        });


    }

    public static void main(String[] args) {
        launch();
    }
}