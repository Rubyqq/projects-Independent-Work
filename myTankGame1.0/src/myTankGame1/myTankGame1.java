package myTankGame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myTankGame1 extends JFrame{
	
	myPanel mp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myTankGame1 mtg = new myTankGame1();
	}
	
	public myTankGame1(){
		mp = new myPanel();
		
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(800, 600);
		this.setVisible(true);
	}

}

class myPanel extends JPanel implements KeyListener{
	
	//define a tank
	myTank mTank;
//	enemyTank enT;
	Vector <enemyTank> et= new Vector <enemyTank>();
	int etSize  = 3;
	
	public myPanel(){
		mTank = new myTank(370, 500);
		for(int i = 0; i < etSize; i++){
			enemyTank enT =  new enemyTank(100 + 200*i , 30);
			et.add(enT);
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 800, 600);
		this.drawTank(mTank.getX(), mTank.getY(), g, mTank.getDirection(), 1);
		
		for(int i = 0; i < etSize; i++){
			this.drawTank(et.get(i).getX(), et.get(i).getY(), g, 1, 0);
		}
		
	}
	
	public void drawTank(int x, int y, Graphics g, int direction, int type){
		
		//define the type of the tank
		
		switch(type){
		case 0:
			g.setColor(Color.red);
			break;
		case 1:
			g.setColor(Color.white);
			break;
		}
		
		//define the direction of the tank
		
		switch(direction){
		//tank with Up direction
		case 0:
			g.fillRect(x-10, y-15, 5, 30);
			g.fillRect(x + 5, y-15, 5, 30);
			g.fill3DRect(x-5, y-10, 10, 20, false);
			g.fillOval(x-6, y-6, 10, 10);
			g.drawLine(x, y, x, y - 20);
			break;
		
		//tank with down direction
		case 1:
			g.fillRect(x-10, y-15, 5, 30);
			g.fillRect(x + 5, y-15, 5, 30);
			g.fill3DRect(x-5, y-10, 10, 20, false);
			g.fillOval(x-6, y-6, 10, 10);
			g.drawLine(x, y, x, y + 20);
			break;
		
		//tank with left direction
		case 2: 
			g.fillRect(x-15, y-10, 30, 5);
			g.fillRect(x - 15, y+5, 30, 5);
			g.fill3DRect(x-10, y-5, 20, 10, false);
			g.fillOval(x-6, y-6, 10, 10);
			g.drawLine(x, y, x - 20, y);
			break;
		//tank with right direction
		case 3:
			g.fillRect(x-15, y-10, 30, 5);
			g.fillRect(x - 15, y+5, 30, 5);
			g.fill3DRect(x-10, y-5, 20, 10, false);
			g.fillOval(x-6, y-6, 10, 10);
			g.drawLine(x, y, x + 20, y);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			mTank.setDrection(1);
			mTank.moveDown();
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			mTank.setDrection(0);
			mTank.moveUp();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			mTank.setDrection(2);
			mTank.moveLeft();
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			mTank.setDrection(3);
			mTank.moveRight();
		}
		
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

//tank class to be used in my tank and enemies tank
class Tank{
	
	//get the coordinate information of the tank
	int x = 0; 
	int y = 0;
	
	//set the speed of the tank
	int speed = 5;
	
	//set the color of the tank
	int color;

	//set the direction of the tank. 0 means up, 1 means down, 2 means left and 4 means right.
	int direction = 0;
	
	public Tank(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void setDrection(int direction){
		this.direction = direction;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}

//define enemy's tank

class enemyTank extends Tank{

	public enemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
}

//define my tank
class myTank extends Tank{
	
//	int speed = 5;
	
	public myTank(int x, int y){
		super(x, y);
	}
	
	//let the tank moves up
	public void moveUp(){
		y -= speed;
	}
	
	//let the tank moves down
	public void moveDown(){
		y += speed;
	}
	
	//let the tank moves left
	public int moveLeft(){
		return x -= speed;
	}
	
	//let the tank moves right
	public int moveRight(){
		return x += speed;
	}
	
}
