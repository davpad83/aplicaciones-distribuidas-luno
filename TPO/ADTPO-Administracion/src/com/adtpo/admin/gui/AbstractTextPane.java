package com.adtpo.admin.gui;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class AbstractTextPane{

	private String message;
	public StyleContext context = new StyleContext();
	public StyledDocument document = new DefaultStyledDocument(context);
	public Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	public JScrollPane scrollPane;
	private int maximumCharactersBeforeEnter = 30;

	public AbstractTextPane(String msg) {
		this.message =msg;
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(style, 12);
	}
	
	public void constructPane(){
		JTextPane textPane = new JTextPane(document);
		try {
		  document.insertString(document.getLength(), insertEntersOnString(message, maximumCharactersBeforeEnter), style);
		} catch (BadLocationException badLocationException) {
		  System.err.println("Oops");
	    }
		
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setMargin(new Insets(3,3,3,3));
		textPane.setEditable(false);
		scrollPane = new JScrollPane(textPane);
	}
	
	private String insertEntersOnString(String string, int max){
		StringBuilder sb = new StringBuilder(string);
		int i = 0;
		while ((i = sb.indexOf(" ", i + max)) != -1) {
		    sb.replace(i, i + 1, "\n");
		}	
		return sb.toString();
	}

	public void setMaximumCharactersBeforeEnter(int maximumCharactersBeforeEnter) {
		this.maximumCharactersBeforeEnter = maximumCharactersBeforeEnter;
	}
}

