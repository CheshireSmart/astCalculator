package calculator.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import calculator.CounterAutomat;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.io.*;

public class UI implements ActionListener {
   
   private final JFrame frame;
   
   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   // private final JPanel panelSub6;
   // private final JPanel panelSub7;
   // private final JPanel panelSub8;
   
   private final JTextArea text;
   private final JButton button[], butAdd, butMinus, butMultiply, butDivide, butEqual, butCancel, butQL, butQR, butComma;//, butSquareRoot, butSquare, butOneDividedBy, butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary;
   private final CounterAutomat calc;
   
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
   
   private final Font font;
   private final Font textFont;
   //private BufferedImageCustom imageReturn;
   
   public UI(CounterAutomat calc) throws IOException {
      this.frame = new JFrame("Calculator PH");
      
      
      
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      // panelSub6 = new JPanel(new FlowLayout());
      // panelSub7 = new JPanel(new FlowLayout());
      // panelSub8 = new JPanel(new FlowLayout());
      
      font = new Font("Consolas",Font.PLAIN, 18);
      
      text = new JTextArea(1, 30);
      
      textFont = new Font("Consolas",Font.BOLD, 24);
      
      button = new JButton[10];      
      for (int i = 0; i < 10; i++) {
    		button[i] = new JButton(String.valueOf(i));
      }      
      butAdd = new JButton("+");      
      butMinus = new JButton("-");      
      butMultiply = new JButton("*");      
      butDivide = new JButton("/");      
      butEqual = new JButton("=");  
      butQR = new JButton(")");
      butQL = new JButton("(");
      butComma = new JButton(".");    
      // butSquareRoot = new JButton("sqrt");      
      // butSquare = new JButton("x^2");      
      // butOneDividedBy = new JButton("1/x");      
      // butCos = new JButton("Cos");      
      // butSin = new JButton("Sin");      
      // butTan = new JButton("Tan");      
      // butxpowerofy = new JButton("x^y");      
      // butlog = new JButton("log10(x)");      
      // butrate = new JButton("x%");      
      // butabs = new JButton("abs(x)");      
       butCancel = new JButton("C");      
      // butBinary = new JButton("Bin");      
      
      this.calc = calc;
   }
   
   public void init() {      
      frame.setSize(450, 450);
      frame.setLocationRelativeTo(null); 
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      text.setFont(textFont);
      text.setEditable(false);
      
      for (int i = 0; i < 10; i++) {
         button[i].setFont(font);
      }      
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butQL.setFont(font);
      butQR.setFont(font);
      butComma.setFont(font);
      // butSquareRoot.setFont(font);
      // butSquare.setFont(font);
      // butOneDividedBy.setFont(font);
      // butCos.setFont(font);
      // butSin.setFont(font);
      // butTan.setFont(font);
      // butxpowerofy.setFont(font);
      // butlog.setFont(font);
      // butrate.setFont(font);
      // butabs.setFont(font);
      butCancel.setFont(font);
     // butBinary.setFont(font); 
      
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);
      
      panelSub2.add(button[1]);
      panelSub2.add(button[2]);
      panelSub2.add(button[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      
      panelSub3.add(button[4]);
      panelSub3.add(button[5]);
      panelSub3.add(button[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);      
      panel.add(panelSub3);
      
      panelSub4.add(button[7]);
      panelSub4.add(button[8]);
      panelSub4.add(button[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      
      //panelSub5.add(Box.createHorizontalStrut(15));
      panelSub5.add(butQL);
      panelSub5.add(button[0]);
      panelSub5.add(butQR);
      panelSub5.add(Box.createHorizontalStrut(15));
      panelSub5.add(butComma);
      //panelSub5.add(butSquare);
      panel.add(panelSub5);
      
      // panelSub6.add(butSquare);
      // panelSub6.add(butSquareRoot);
      // panelSub6.add(butOneDividedBy);
      // panelSub6.add(butxpowerofy);
      // panel.add(panelSub6);
      
      // panelSub7.add(butCos);
      // panelSub7.add(butSin);
      // panelSub7.add(butTan);
      // panel.add(panelSub7);
      
      // panelSub8.add(butlog);
      // panelSub8.add(butrate);
      // panelSub8.add(butabs);
      // panelSub8.add(butBinary);
      // panel.add(panelSub8);
      
      for (int i = 0; i < 10; i++) {
         button[i].addActionListener(this);
      }      
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butComma.addActionListener(this);
      //butSquare.addActionListener(this);
      // butSquareRoot.addActionListener(this);
      // butOneDividedBy.addActionListener(this);
      // butCos.addActionListener(this);
      // butSin.addActionListener(this);
      // butTan.addActionListener(this);
      // butxpowerofy.addActionListener(this);
      // butlog.addActionListener(this);
      // butrate.addActionListener(this);
      // butabs.addActionListener(this);
      // butBinary.addActionListener(this);
      
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);
      butQL.addActionListener(this);
      butQR.addActionListener(this);
      
      frame.add(panel);
      frame.setVisible(true);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();

     for (int i = 0; i < 10; i++) {
         if (source == button[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         } else if (source == butAdd){
            text.replaceSelection(butAdd.getText());
            return;
         } else if (source == butMinus){
            text.replaceSelection(butMinus.getText());
            return;
         } else if (source == butDivide){
            text.replaceSelection(butDivide.getText());
            return;
         } else if (source == butMultiply){
            text.replaceSelection(butMultiply.getText());
            return;
         } else if (source == butCancel){
            text.setText("");
            return;
         } else if (source == butQL){
            text.replaceSelection(butQL.getText());
            return;
         } else if (source == butQR){
            text.replaceSelection(butQR.getText());
            return;
         } else if (source == butComma){
            text.replaceSelection(butComma.getText());
            return;
         }
     }
  


      try {
         writer(calc.calculateFromArithmeticString(text.getText()));
      } catch(Exception ex) {
         text.setText("error");
         ex.printStackTrace();
      }


      text.selectAll();
   }
   
   
   public String reader() {
      return text.getText();
   }
   
   public void writer(final Double num) {
      if(num %1 == 0){
         text.setText(String.valueOf(num.intValue()));
      } else {
         text.setText(String.valueOf(num));
      } 
   }
}
