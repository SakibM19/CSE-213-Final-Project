package com.example.cse213finalproject.alvee.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FeedbackPopUpController
{
    @javafx.fxml.FXML
    private Label commentLabel;
    @javafx.fxml.FXML
    private TextField replyTextField;
    @javafx.fxml.FXML
    private Text cleanlinessRatingText;
    @javafx.fxml.FXML
    private Text carRatingText;
    @javafx.fxml.FXML
    private Text comfortRatingText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSendButtonOnAction(ActionEvent actionEvent) {
    }
}