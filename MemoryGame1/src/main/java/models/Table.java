package models;

import java.util.ArrayList;

public class Table extends Card{

	private int level;
	private int rowSize;
	private int columnSize;
	private Card[][] cards = new Card[4][4];
	private ArrayList<Card>cardsOnTable = new ArrayList<Card>();
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level >0 && level <6) {
		this.level = level;
		}
	}
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		if(rowSize > 0 && rowSize <11 && rowSize==columnSize)
		{
			this.rowSize = rowSize;
		}
	}
	public int getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(int columnSize) {
		if(columnSize > 0 && columnSize < 11 && columnSize==rowSize)
		{
			this.columnSize = columnSize;
		}
	}
	
	public Table() {
		super();
		this.level = 1;
		this.rowSize = 4;
		this.columnSize = 4;
	
	}
	
	public Table(boolean faceUp,  int point,int level, int rowSize, int columnSize) {
		super(faceUp,  point);
		this.level = level;
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		generateCards();

	}

	public void generateCards() {
	for (int i = 0; i<cards.length; i++)
	{
	    for (int o = 0; o<cards.length; o++)
	    {
	         
	         cardsOnTable.add(cards[i][o]);
	    }
	}
	}
}
