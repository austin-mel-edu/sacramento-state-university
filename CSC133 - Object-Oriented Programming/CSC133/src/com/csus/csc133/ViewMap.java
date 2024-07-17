//CSC 133 - Assignment 2
//Austin Melendez

//Package
package com.csus.csc133;

import java.util.Observer;
import java.util.Observable;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.plaf.Border;

//Importing Libraries

public class ViewMap extends Container implements Observer { 
	private GameModel gm;
	//TransformedShape[] obj;
	private int height = this.getHeight();
	private int width = this.getWidth();
	private boolean isPinched = false;
	private boolean isDragged = false;
	private int pPrevDragLocX = -1;
	private int pPrevDragLocY = -1;
	
	
	private Transform W2ND, ND2D, VTM, invVTM;
	//private double winLeft, winRight, winTop, winBot;
	
	private float winLeft = 0;
	private float winBot = 0;
	private float winRight = this.getWidth() / 2;
	private float winTop = this.getHeight() / 2;
	private float winHeight = winTop - winBot;
	private float winWidth = winRight - winLeft;
	
	public ViewMap(GameModel gm) {
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.rgb(255,0,0)));
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		this.gm = gm;
	}

	@Override
	public void update(Observable observable, Object data) {	
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
//		W2ND = buildWorldToNDXform(winWidth, winHeight, winLeft, winBot);
//		ND2D = buildNDToDisplayXform(this.getWidth(), this.getHeight());
//		VTM = ND2D.copy();
//		VTM.concatenate(W2ND); 
	
		Transform gXform = Transform.makeIdentity();
//		g.getTransform(gXform); 
//		gXform.translate(getAbsoluteX(), getAbsoluteY());
//		gXform.concatenate(VTM);
//		gXform.translate(-getAbsoluteX(), -getAbsoluteY());
//		g.setTransform(gXform);
		
		gXform.translate(0, getHeight());
		gXform.scale(1, -1);
		gXform.translate(-getAbsoluteX(), -getAbsoluteY());
		g.setTransform(gXform);
		
		IIterator iterator = gm.getIterator();
		
		while(iterator.hasNext()) {
			GameObject currentObject = iterator.getNext(); 
			currentObject.draw(g, this.getX(), this.getY());
		}
		
		g.resetAffine();
	}
	
	public void updateVTM() {
		Transform VTM = Transform.makeIdentity();
		Transform W2ND = Transform.makeScale(1.0f/winWidth, 1.0f/winHeight);
		W2ND.translate(-winLeft, -winBot);
		Transform ND2D = Transform.makeTranslation(0, height);
		ND2D.scale(width, -height);
		VTM.concatenate(ND2D);
		VTM.concatenate(W2ND);
	}
	
	private Transform buildWorldToNDXform(float winWidth, float winHeight, float winLeft, float winBot) {
		Transform tmpXform = Transform.makeIdentity();
		tmpXform.scale( (1/winWidth), (1/winHeight));
		tmpXform.translate(-winLeft, -winBot);
		return tmpXform;
	}
	
	private Transform buildNDToDisplayXform(float displayWidth, float displayHeight) {
		Transform tmpXform = Transform.makeIdentity();
		tmpXform.translate(0, displayHeight);
		tmpXform.scale(displayWidth, -displayHeight);
		return tmpXform;
	}
	
	public void zoom(float factor) {
		float newWidth = winWidth * factor;
		float newHeight = winHeight * factor;
		if (newWidth < 400 || newHeight < 200 || newWidth > 8192 || newHeight > 4320) {
			return;
		}
		winLeft += (winWidth - newWidth) / 2;
		winBot += (winHeight -newHeight) / 2;
		
		
//		float newWinLeft = winLeft + winWidth * factor;
//		float newWinRight = winRight - winWidth * factor;
//		float newWinTop = winTop - winHeight * factor;
//		float newWinBot = winBot + winHeight * factor;
//		float newWinHeight = newWinTop - newWinBot;
//		float newWinWidth = newWinRight - newWinLeft;
//		
//		if (newWinWidth <= 8192 && newWinHeight <= 4320 && newWinWidth > 400 && newWinHeight > 200) {
//			winLeft = newWinLeft;
//			winRight = newWinRight;
//			winTop = newWinTop;
//			winBot = newWinBot;
//		}
//		else {
//			//System.out.println("Cannot zoom further!");
//		}
		this.repaint();
	}
	
	public void panHorizontal(double delta) {
		winLeft += delta;
		winRight += delta;
		this.repaint();
	}
	
	public void panVertical(double delta) {
		winBot += delta;
		winTop += delta;
		this.repaint();
	}
	
	@Override
	public boolean pinch(float scale) {
		if(scale < 1.0) {
			zoom(-0.05f);
		}
		else if(scale > 1.0){
			zoom(0.05f);
		}
		return true;
	}
	
	@Override
	public void pointerDragged(int x, int y) {
		if (pPrevDragLocX != -1) {
			if(pPrevDragLocX < x) {
				panHorizontal(5);
			}
			else if(pPrevDragLocX > x) {
				panHorizontal(-5);
			}
			if(pPrevDragLocY < y) {
				panVertical(-5);
			}
			else if(pPrevDragLocY > y) {
				panVertical(5);
			}
		}
		
		pPrevDragLocX = x;
		pPrevDragLocY = y;
	}
	
	
	@Override
	public void pointerPressed(int xPointer, int yPointer) {
		if (gm.getPaused()) {
			int xCoord = xPointer - getParent().getAbsoluteX();
			int yCoord = yPointer - getParent().getAbsoluteY();
			
			int objX = getX();
			int objY = getY();
			
			IIterator iterator = gm.getIterator();
			
			while(iterator.hasNext()) {
				GameObject currentObject = iterator.getNext();
				
				if (currentObject instanceof GameObject) {
					if(currentObject.contains(xCoord, yCoord, objX, objY)) {
						currentObject.setSelected(true);
						gm.setMoveable(true);
					}
					else if(currentObject.isSelected()) {
						if(gm.getMoveable() == false) {
							double newX = xCoord - objX;
							double newY = yCoord - objY;
							
							currentObject.setX(newX);
							currentObject.setY(newY);
						}
						gm.setMoveable(true);
						currentObject.setSelected(false);
					}
				}
			}
			// Update the view on the screen
			revalidate();
			repaint();
		}
	}

}