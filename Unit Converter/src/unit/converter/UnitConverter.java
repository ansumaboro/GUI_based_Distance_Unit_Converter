package unit.converter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UnitConverter {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Window();
            }
        });
    }   
}
class Window extends JFrame{
    JComboBox<String> comboOption1;
    JComboBox<String> comboOption2;
    String[] options = {"Kilometre(s)","Hectometre(s)","Decametre(s)","Metre(s)","Decimetre(s)","Centimetre(s)","Milimetre(s)"};
    JLabel to = new JLabel("To");
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JButton convertBtn = new JButton("Convert");
    Window(){
        setVisible(true);
        setSize(410, 400);
        setLayout(null);
        setTitle("Unit Converter");
        ImageIcon icon = new ImageIcon(UnitConverter.class.getResource("/convert.png"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboOption1 = new JComboBox<>(options);
        
        comboOption1.setBounds(50, 30,113,30);
        comboOption1.setFont(new Font("Segoe UI", 0, 14));
        add(comboOption1);
        
        field1.setBounds(180,30, 150, 30);
        field1.setFont(new Font("Segoe UI", 0, 16));
        add(field1);
        
        to.setFont(new Font("Segoe UI", 1, 16));
        to.setBounds(180,70,30,20);
        add(to);
        
        comboOption2 = new JComboBox<>(options);
        comboOption2.setBounds(50, 100,113,30);
        comboOption2.setFont(new Font("Segoe UI", 0, 14));
        add(comboOption2);
        
        field2.setBounds(180,100, 150, 30);
        field2.setFont(new Font("Segoe UI", 0, 16));
        field2.setEditable(false);
        field2.setBackground(Color.white);
        add(field2);
        
        convertBtn.setFont(new Font("Segoe UI", 1, 16));
        convertBtn.setBounds(170,170,100,30);
        add(convertBtn);
        
        convertBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String convertFrom = (String) comboOption1.getSelectedItem();
                String convertTo = (String) comboOption2.getSelectedItem();
                
                for(int j=0; j<7; j++){
                    if(convertFrom.equals(options[j])){
                        float value = Float.parseFloat(field1.getText());
                        for(int i=0; i<7; i++){
                            if(convertTo==options[i]){
                                float finalValue = (float) ((value * Math.pow(10,i))/(Math.pow(10,j)));
//                                String formatedValue = String.format("%.2f",finalValue);
                                field2.setText(finalValue +"");
                                
                            }
                        }
                    }
                }
            }
        });
        
        revalidate();
        repaint();
    }
}
