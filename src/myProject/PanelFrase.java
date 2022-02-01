package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {
    public static final int WIDTH = 350;
    public static final int HEIGHT = 350;

    private String letrasMalas, errores, clave;

    public PanelFrase(String clave){
        this.clave = clave;
        letrasMalas= " ";
        errores = " ";
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    public void pintarErro(String clave, char letra, int error){//este metodo lo llamo cuando haya una letra mala
        this.clave=clave;//trae la clave con ---
        letrasMalas+=" "+String.valueOf(letra); //pinta la letra mala
        errores+=" "+String.valueOf(error);//pinta el numero de erroes que los ocnvierte en string
        repaint();
    }
    public void setClave(String clave){//pinta la clave, con la letra correcta
        this.clave=clave;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) { //la clave, letras malas y erroes es lo que siempre estoy pintando, por eso no hay if's
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLACK);
        g.drawString("Frase a adivinar",4,20);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLACK);
        g.drawString(clave,4,55);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));

        g.setColor(Color.BLACK);
        g.drawString("Letras incorrectas",4,66);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.blue);
        g.drawString(letrasMalas,4,77);
        g.setColor(Color.BLACK);

        g.drawString("Errores",4,90);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLUE);
        g.drawString(letrasMalas,72,90);

    }
    public void reset(String clave){
        this.clave=clave;
        letrasMalas=" ";
        errores=" ";
        repaint();

    }
}

