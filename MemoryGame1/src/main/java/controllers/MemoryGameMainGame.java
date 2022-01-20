package controllers;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Table;
import models.User;
import models.Card;
import controllers.MemoryGameLogin;

public class MemoryGameMainGame  {

	
@FXML
private StackPane st1;
@FXML
private StackPane st2;
@FXML
private StackPane st3;
@FXML
private StackPane st4;
@FXML
private StackPane st5;
@FXML
private StackPane st6;
@FXML
private StackPane st7;
@FXML
private StackPane st8;
@FXML
private StackPane st9;
@FXML
private StackPane st10;
@FXML
private StackPane st11;
@FXML
private StackPane st12;
@FXML
private StackPane st13;
@FXML
private StackPane st14;
@FXML
private StackPane st15;
@FXML
private StackPane st16;
	ArrayList<StackPane> allPanes= new ArrayList<StackPane>();
	ArrayList<Text> alltext= new ArrayList<Text>();
@FXML
private TilePane tilePane;

@FXML
private  Rectangle rectangle;

@FXML
private Text text;
Card karts= new Card(false,0);
ArrayList<Character> allSymbols= new ArrayList<Character>();
@FXML
public void initialize() {
	allPanes.add(st1);
	allPanes.add(st2);
	allPanes.add(st3);
	allPanes.add(st4);
	allPanes.add(st5);
	allPanes.add(st6);
	allPanes.add(st7);
	allPanes.add(st8);
	allPanes.add(st9);
	allPanes.add(st10);
	allPanes.add(st11);
	allPanes.add(st12);
	allPanes.add(st13);
	allPanes.add(st14);
	allPanes.add(st15);
	allPanes.add(st16);
	
	Card karts= new Card(false,0);
	
	for(int i=0 ;i < karts.getSymbol().length;i++) {
		for(int b=0 ;b < karts.getSymbol().length;b++) {
			allSymbols.add(karts.getSymbol()[i][b]);
		
		}
	}
}
Text firstCard;
Text secondCard;
int counter=0;
int points=0;
int counter2=0;
@FXML
public void cardSymbol(MouseEvent event) {
	for(int i=0; i<allPanes.size();i++) {
		
		Text symb= ((Text)(allPanes.get(i).getChildren().get(1)));
	
		if (symb.equals(event.getSource())) {
			
			symb.setText(""+allSymbols.get(i));
			
			
			if(counter==1) {
				secondCard=symb;
				secondCard.setText(symb.getText());
				counter=0;
				
				
				if(firstCard.getText().equals(secondCard.getText())){
					points+=2;
					counter2+=1;
					System.out.println(points);
					
					
				}else {
					
					Task<Void> sleeper = new Task<Void>() {
						@Override
						protected Void call() throws Exception {
						try {
						Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						return null;
						}
					};
					sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
						public void handle(WorkerStateEvent event) {
							firstCard.setText("GUESS");
							
							secondCard.setText("GUESS");
							points-=1;
						}
						
						});
						new Thread(sleeper).start();
					
				
				}
			}else {
				firstCard=symb;
				
				counter++;
				
			}
			
			if(counter2==8) {
				Task<Void> sleeper = new Task<Void>() {
					@Override
					protected Void call() throws Exception {
					try {
					Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					return null;
					}
				};
				sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
					public void handle(WorkerStateEvent event) {
						if(points<0 ) {
							points=0;
						JOptionPane.showMessageDialog(null, "End of game!\n You gained:"+points+" Points");
						}else {
							JOptionPane.showMessageDialog(null, "End of game!\n You gained:"+points+" Points");
							
						}
					}
					
					});
					new Thread(sleeper).start();
				
			}
			
			}
		}
	}
}

	
	
//}
