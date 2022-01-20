package models;

import java.util.Random;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Card {

	private static int pointCount = 0;
	private int point;
	

	private char[][] symbol= new char [4][4];

	private boolean faceUp;
	private Random random= new Random();
	
	
	public Card() {
		faceUp=true;
		symbol= new char[4][4];
		point= 2;
		equalsCard(this, this);
	}
	
	public Card(boolean faceUp,  int point) {
		setFaceUp(faceUp);
		setSymbol();
		setPoint(point);
		//equalsCard(firstCard, secondCard);
	}
	
	public char[][] getSymbol() {
		return symbol;
	}
	
	public void setSymbol() {
		
		int col=0;
		 for(int i=97; i<104; i++) { //iestata vçrtîbas òo a - d, e-h ,katrai rindai, kolonnai 
			if (col <4){
			 symbol[0][col]=(char)i;
			 col++;
			}
		 }
		 col=0;
		 for(int i=97; i<104; i++) {
			 if (col <4){
			 symbol[1][col]=(char)i;
			 col++;
			 }
		 }
		 col=0;
		 for(int i=101; i<=104; i++) {
			 if (col <4){
			 symbol[2][col]=(char)i;
			 col++;
			 }
		 }
		 col=0;
		 for(int i=101; i<=104; i++) {
			 if (col <4){
			 symbol[3][col]=(char)i;
			 col++;
			 }
		 }
		
			List<Character>symbols1d = new ArrayList<Character>(); //from 2d array to list 
			for (int row =0 ; row < symbol.length; row++) {
				for (int coll = 0 ; coll < symbol[row].length; coll++) {
					symbols1d.add(symbol[row][coll]);
				}
				
			}
			Collections.shuffle(symbols1d);
		
			 char[] arr= new char[symbols1d.size()];  //to 1d array from List
			 for (int i =0; i<symbols1d.size(); i++) {
				 arr[i] =symbols1d.get(i);
				
			 }
			 for (int row =0 ; row < symbol.length; row++) { //to 2d array from 1d array
					for (int coll = 0 ; coll < symbol[row].length; coll++) {
						symbol[row][coll]=arr[(coll*symbol.length)+row];
					}
					//System.out.println(Arrays.deepToString(symbol).replace("], ", "]\n"));
			 }
			
		
		
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		if (faceUp=true /*&& equalsCard(this, this)*/ ) {
			pointCount +=2;
			point=pointCount;
		}else {
			pointCount -=1;
			point=pointCount;
		}
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		
			
		this.faceUp = faceUp;
	
		
	}
	
	public boolean equalsCard(Card firstCard, Card secondCard) { //kâ pagaidu variants var palikt, kad taisîs fx , tur vairâk pielietos un tur var detalizçtâk uztaisît
		//ArrayList<Card> allSymbols= new ArrayList<Card>();
		//for (Card c:allSymbols ) {
			if(firstCard.getSymbol().equals(symbol) && secondCard.getSymbol().equals(symbol) && firstCard==secondCard && firstCard.faceUp==true && secondCard.faceUp==true) {
				return true;
			}
			
			//if(c.getSymbol().equals(symbol) && firstCard.getSymbol().equals(symbol) && faceUp==true) {
				//return true;
			//}
			
		//}
		return false;
		
		
		
		//if(anotherCard.getSymbol().equals(symbol) && faceUp==true) {
			//return true;
		//}else {
		//	return false;
		//}
	}

	@Override
	public String toString() {
		return "Card [point=" + point + ", symbol=" + Arrays.toString(symbol) + ", faceUp=" + faceUp + "]";
	}
}