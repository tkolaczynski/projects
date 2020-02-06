
package budynek2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class Budynek2 extends JFrame implements ActionListener{
    private JMenuBar MenuBar;
    private JMenu JMenuInfo;
    private JMenuItem JMenuItemAutor,JMenuItemInformacje;
    private JLabel tDrzwi,tDane,tTemp,tTempWody,tLudzie,tWlamania,tOsoby,tRaporty,tData,tPrad;
    private JRadioButton rbOtwarte,rbZamkniete,rbZasilanieON,rbZasilanieOFF;
    private ButtonGroup bgZamek,bgPrad;
    private JButton bTemperatura,bTemperaturaWody,bLiczbaLudzi,bLiczbaWlaman,bDodajOsobe,bUsunOsobe,bWyprosWszystkich,bZapiszRaport,bOtworzRaport,bData;
    private int liczbaludzi = 0;
    private int liczbawlaman = 0;
    private JTextArea textareaOsoby,textareaRaporty;
    private Osoba osoba;
    
    
            
    public Budynek2()
    {
        setTitle("Budynek");
        setSize(1000,400);
        setLayout(null);
        
        
        ////////MENU////////////
        MenuBar = new JMenuBar();
        JMenuInfo = new JMenu("Informacja");
        JMenuItemAutor = new JMenuItem("Autor");
        JMenuItemInformacje = new JMenuItem("O programie");
        setJMenuBar(MenuBar);
        MenuBar.add(JMenuInfo);
        JMenuInfo.add(JMenuItemAutor);
        JMenuInfo.add(JMenuItemInformacje);
        
        JMenuItemAutor.addActionListener(this);
        JMenuItemInformacje.addActionListener(this);
        
        /////////DRZWI////////////
        tDrzwi = new JLabel("Drzwi");
        tDrzwi.setBounds(0,0,50,20);
        add(tDrzwi);
        
        rbOtwarte = new JRadioButton("OTWARTE",false);
        rbOtwarte.setBounds(0,20,120,20);
        add(rbOtwarte);
        rbOtwarte.addActionListener(this);
        
        rbZamkniete = new JRadioButton("ZAMKNIETE",true);
        rbZamkniete.setBounds(0,40,120,20);
        add(rbZamkniete);
        rbZamkniete.addActionListener(this);
        
        bgZamek = new ButtonGroup();
        bgZamek.add(rbOtwarte);
        bgZamek.add(rbZamkniete);
        
        
        ////////////PRZYCISKI PANELU/////////
        tDane = new JLabel("Dane z budynku");
        tDane.setBounds(0,70,120,20);
        add(tDane);
        
        tTemp = new JLabel("");
        tTemp.setBounds(230,100,50,30);
        add(tTemp);
        
        tTempWody = new JLabel("");
        tTempWody.setBounds(230,140,80,30);
        add(tTempWody);
        
        tLudzie = new JLabel("");
        tLudzie.setBounds(230,180,80,30);
        add(tLudzie);
        
        tWlamania = new JLabel("");
        tWlamania.setBounds(230,220,80,30);
        add(tWlamania);
        
        tData = new JLabel("");
        tData.setBounds(130,260,190,30);
        add(tData);
                
        bTemperatura = new JButton("Temperatura powietrza");
        bTemperatura.setBounds(0,100,220,30);
        add(bTemperatura);
        bTemperatura.addActionListener(this);
        
        bTemperaturaWody = new JButton("Temperatura wody");
        bTemperaturaWody.setBounds(0,140,220,30);
        add(bTemperaturaWody);
        bTemperaturaWody.addActionListener(this);
        
        bLiczbaLudzi = new JButton("Liczba ludzi");
        bLiczbaLudzi.setBounds(0,180,220,30);
        add(bLiczbaLudzi);
        bLiczbaLudzi.addActionListener(this);
        
        bLiczbaWlaman = new JButton("Liczba wlaman");
        bLiczbaWlaman.setBounds(0,220,220,30);
        add(bLiczbaWlaman);
        bLiczbaWlaman.addActionListener(this);

        bData = new JButton("Data");
        bData.setBounds(0,260,110,30);
        add(bData);
        bData.addActionListener(this);
        
        ///////////ZASILANIE//////////
        
        tPrad = new JLabel("ZASILANIE :");
        tPrad.setBounds(0,300,80,30);
        add(tPrad);
        
        rbZasilanieON = new JRadioButton("ON",false);
        rbZasilanieON.setBounds(70,300,50,30);
        add(rbZasilanieON);
        
        rbZasilanieOFF = new JRadioButton("OFF",true);
        rbZasilanieOFF.setBounds(120,300,50,30);
        add(rbZasilanieOFF);
        
        bgPrad = new ButtonGroup();
        bgPrad.add(rbZasilanieON);
        bgPrad.add(rbZasilanieOFF);
        
        //////////PANEL OSOB//////////
        
        tOsoby = new JLabel("Zarządzanie ludzmi");
        tOsoby.setBounds(320,0,120,20);
        add(tOsoby);
        
        bDodajOsobe = new JButton("Dodaj osobe");
        bDodajOsobe.setBounds(320,25,120,30);
        add(bDodajOsobe);
        bDodajOsobe.addActionListener(this);
        
        bUsunOsobe = new JButton("Usun osobe");
        bUsunOsobe.setBounds(445,25,120,30);
        add(bUsunOsobe);
        bUsunOsobe.addActionListener(this);
        
        bWyprosWszystkich = new JButton("Wypros wszystkich");
        bWyprosWszystkich.setBounds(320,265,245,30);
        add(bWyprosWszystkich);
        bWyprosWszystkich.addActionListener(this);
        
        textareaOsoby = new JTextArea();
        //textareaOsoby.setBounds(320,60,245,200);
        JScrollPane scroll = new JScrollPane(textareaOsoby);
        scroll.setBounds(320,60,245,200);
        add(scroll);
        
        
        ////////////RAPORTY/////////////
        tRaporty = new JLabel("Raporty");
        tRaporty.setBounds(640,0,120,20);
        add(tRaporty);
        
        bZapiszRaport = new JButton("Zapisz raport");
        bZapiszRaport.setBounds(640,25,120,30);
        add(bZapiszRaport);
        bZapiszRaport.addActionListener(this);
        
        bOtworzRaport = new JButton("Otworz raport");
        bOtworzRaport.setBounds(765,25,120,30);
        add(bOtworzRaport);
        bOtworzRaport.addActionListener(this);
        
        textareaRaporty = new JTextArea();
        JScrollPane scroll2 = new JScrollPane(textareaRaporty);
        scroll2.setBounds(640,60,245,200);
        add(scroll2);
    }
  
    public static void main(String[] args) {
        Budynek2 budynek = new Budynek2();
        budynek.setDefaultCloseOperation(EXIT_ON_CLOSE);
        budynek.setVisible(true);
        
    }
///////////////AKCJA/////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        //////////MENU//////////
        if(z == JMenuItemAutor)
        {
            //System.out.println("Autor Tomasz Kolaczyczynski");
            JOptionPane.showMessageDialog(this,"Autor Tomasz Kolaczyczynski","",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(z == JMenuItemInformacje)
        {
            //System.out.println("Program do monitorowania budynku");
            JOptionPane.showMessageDialog(this,"Program do monitorowania budynku","",JOptionPane.INFORMATION_MESSAGE);
        }
        ///////////RADIOBUTTONY///////////////
        else if(z == rbOtwarte)
        {
            JOptionPane.showMessageDialog(this,"Drzwi zostaly otwarte","Otwarte",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(z == rbZamkniete)
        {
            JOptionPane.showMessageDialog(this,"Drzwi zostaly zamkniete","Zamkniete",JOptionPane.WARNING_MESSAGE);
        }
        ///////////PANEL///////////////////
        
        else if(z == bTemperatura)
        {
            if(rbZasilanieON.isSelected()){
            bTemperatura.isEnabled();
            
            LinkedList m = new LinkedList();
            Random generator = new Random();
            
            for(int i=0;i<1;i++)
            {
                int x=20;
                int y=25;
                m.add(generator.nextInt(y-x+1)+x);
                tTemp.setText(m+" °C".toString());
                tTemp.setForeground(Color.red);
                
            }
            }
            
            
        }
        else if(z == bTemperaturaWody)
        {
            if(rbZasilanieON.isSelected())
            {    
            bTemperaturaWody.isEnabled();
            LinkedList m = new LinkedList();
            Random generator = new Random();
            
            for(int i=0;i<1;i++)
            {
                int x=10;
                int y=15;
                m.add(generator.nextInt(y-x+1)+x);
                tTempWody.setText(m+" °C".toString());
                tTempWody.setForeground(Color.blue);
                
            }
        }
        }
        else if(z == bLiczbaLudzi)
        {
            if(rbZasilanieON.isSelected()){
            bLiczbaLudzi.isEnabled();
            
            if(liczbaludzi==1)
            {
                tLudzie.setText(liczbaludzi+" czlowiek".toString());
                tLudzie.setForeground(Color.orange);
            }else
                tLudzie.setText(liczbaludzi+" ludzi".toString());
                tLudzie.setForeground(Color.orange);
        }
        }
        else if(z == bLiczbaWlaman)
        {
            if(rbZasilanieON.isSelected()){
            bLiczbaWlaman.isSelected();
            
            tWlamania.setText(liczbawlaman+" wlaman".toString());
            tWlamania.setForeground(Color.magenta);
            }
        }
        else if(z == bData)
        {
            if(rbZasilanieON.isSelected()){
            bData.isSelected();
            
            tData.setText(new Date().toString());
            }
        }
        //////////////OSOBY DODAJ USUN//////////////////
        else if(z == bDodajOsobe)
        {
            if(liczbaludzi <10 && rbOtwarte.isSelected())
            {
                if(osoba==null)
                {
                    osoba = new Osoba(this);
                }
                osoba.setVisible(true);
                
                if(osoba.dodany())
                {
                    
                    textareaOsoby.append(osoba.getImie()+" ");
                    textareaOsoby.append(osoba.getNazwisko());
                    textareaOsoby.append("\n");
                    liczbaludzi++;
                }
            }
            else if(liczbaludzi >=10){
                JOptionPane.showMessageDialog(this,"Budynek przepelniony","UWAGA",JOptionPane.ERROR_MESSAGE);
                }
            else if(rbZamkniete.isSelected())
            {
                JOptionPane.showMessageDialog(this,"Drzwi sa zamkniete!","UWAGA",JOptionPane.ERROR_MESSAGE);
                liczbawlaman++;
            }
        }    
        else if(z == bUsunOsobe)
        {
            if(liczbaludzi != 0)
            {
            try {
                int end = textareaOsoby.getLineEndOffset(0);
                textareaOsoby.replaceRange("", 0, end);
                liczbaludzi--;
            } catch (BadLocationException x) {
                JOptionPane.showMessageDialog(this,"Blad","",JOptionPane.ERROR_MESSAGE);
            }
            }else
            {
                JOptionPane.showMessageDialog(this,"Blad","",JOptionPane.ERROR_MESSAGE);
            }
           
        }
        else if(z == bWyprosWszystkich)
        {   
            textareaOsoby.setText("");
            liczbaludzi=0;
        }
       
    
        
         ////////////////RAPORTY OTWORZ ZAPISZ///////////////
        if(z == bOtworzRaport)
        {
            JFileChooser filec = new JFileChooser();
            if(filec.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                File plik = filec.getSelectedFile();
                try {
                    Scanner skaner = new Scanner(plik);
                    while (skaner.hasNext())
                    {
                        textareaRaporty.append(skaner.nextLine()+"\n");
                    }
                   
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this,"Taki plik nie istnieje","",JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        }
        else if(z == bZapiszRaport)
        {
            JFileChooser file = new JFileChooser();
            if(file.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
            {
            File plik = file.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(plik);
                    Scanner skan2 = new Scanner(textareaRaporty.getText());
                    while(skan2.hasNext())
                    {
                        pw.println(skan2.nextLine()+"\n");
                    }
                    pw.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this,"Blad","",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
       
    }
    
}

class Osoba extends JDialog implements ActionListener
{
    private boolean dodany;
    private JLabel jImie,jNazwisko;
    private JTextField tImie,tNazwisko;
    private JButton bOK,bCancel;
    
    public Osoba(JFrame owner)
    {
       super(owner,"Dodawanie osoby",true);
       setSize(300,300);
       setLayout(null);
       setVisible(true);
       
       jImie = new JLabel("Imie :");
       jImie.setBounds(10,40,40,20);
       add(jImie);
       
       jNazwisko = new JLabel("Nazwisko :");
       jNazwisko.setBounds(10,90,80,20);
       add(jNazwisko);
       
       tImie = new JTextField(" ");
       tImie.setBounds(50,40,120,25);
       add(tImie);
       
       tNazwisko = new JTextField(" ");
       tNazwisko.setBounds(80,90,120,25);
       add(tNazwisko);
       
       bOK = new JButton("OK");
       bOK.setBounds(10,150,120,30);
       add(bOK);
       bOK.addActionListener(this);
       
       bCancel = new JButton("Cancel");
       bCancel.setBounds(140,150,120,30);
       add(bCancel);
       bCancel.addActionListener(this);
    }

    public String getImie()
    {
        return tImie.getText();
    }
    public String getNazwisko()
    {
        return tNazwisko.getText();
    }
    public boolean dodany()
    {
        return dodany;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        if(z == bOK)
        {
            setVisible(false);
            dodany = true;
            
            
        }
        else
        {
            dodany = false;
        }
        if(z == bCancel)
        {
            setVisible(false);
        }
        
    }
    
}
