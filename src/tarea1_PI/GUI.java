package tarea1_PI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JTextArea textoExpectativa;
    private Titulos titulo;
    private ImageIcon imagen;
    private JLabel labelImagen;
    private Escucha escucha;
    public GUI() {
        initGUI();
        this.setTitle("Mi ventana");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI miGUI = new GUI();
            }
        });
    }

    private void initGUI(){
        titulo = new Titulos("Hola soy Robert", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);
        escucha = new Escucha();

        miFoto= new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);
        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "un poco más sobre mi",
                TitledBorder.CENTER,TitledBorder.CENTER, new Font("Calibri", Font.BOLD+Font.ITALIC,20), Color.BLUE));
        this.add(panelDatos,BorderLayout.CENTER);
        labelImagen= new JLabel();
        textoExpectativa = new JTextArea(15,20);
    }
    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            if(e.getSource()==miHobby){
                imagen = new ImageIcon(getClass().getResource("/Recursos/2.jpg"));
                labelImagen.setIcon(imagen);
                panelBotones.add(labelImagen);
            }else{
                if(e.getSource()==miFoto){
                    imagen = new ImageIcon(getClass().getResource("/Recursos/1.jpg"));
                    labelImagen.setIcon(imagen);
                    panelBotones.add(labelImagen);
                }else{
                    textoExpectativa.setText("Me gustaría poder aprovechar el curso al máximo y lograr sacar partido \n" +"a la construccion de interfacez graficas \n" +"y a su vez adquirir conocimiento en el lenguaje de programacion de JAVA \n");
                    panelDatos.add(textoExpectativa);

                }

            }
            revalidate();
            repaint();
        }
    }
}