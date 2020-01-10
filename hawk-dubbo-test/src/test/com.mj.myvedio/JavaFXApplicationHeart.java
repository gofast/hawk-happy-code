package com.mj.myvedio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXApplicationHeart extends Application {

    public void start1(Stage primaryStage) {
        int width, height;
        Canvas canvas = new Canvas(350, 350);
        width = (int) canvas.getWidth();
        height = (int) canvas.getHeight();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        double x, y, r;
        for (int i = 0; i <= 90; i++) {
            for (int j = 0; j <= 90; j++) {
                //转换为直角坐标系，设置偏移量，使图像居中
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 19;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + height / 4;

                gc.setFill(Color.RED);
                gc.fillOval(x, y, 2, 2);
                gc.fillOval(x, y, 1, 1);
            }
        }


        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, Color.WHITESMOKE);

        primaryStage.setTitle("小马哥送给小可爱的小心心");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    Label label =new Label("请输入最大值:");
    TextField TextField1=new TextField("100");
    javafx.scene.control.Button Button=new Button("生成");
    TextField TextField2=new TextField("精彩即将出现");

    @Override
    public void start(Stage primaryStage){//create a sence and place a button in the stage

        GridPane pane=new GridPane();
        Scene scene=new Scene(pane,250,50);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.add(label,0,0);
        pane.add(TextField1,1,0);
        pane.add(Button,0,1);
        pane.add(TextField2,1,1);

        Button.setOnAction (event->{

            int Max=100;
            int Min=1;
            int num=(int)Math.floor(Math.random()*(Max-Min+1))+Min;
            TextField2.setText(String.valueOf(num));

        });

    }


    public static void main(String[] args) {
        launch(args);
    }

}