import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*  <applet code="traffic_signal"  width=600 height=500>
    </applet>
*/

public class traffic_signal extends JApplet implements ActionListener
{
    String flag="";
    JButton stop,wait,go;

    public void init()
    {
        stop = new JButton("STOP");
        wait = new JButton("WAIT");
        go = new JButton("GO");
        stop.setBounds(400,100,80,30);
        wait.setBounds(400,200,80,30);
        go.setBounds(400,300,80,30);
        add(stop);
        add(wait);
        add(go);
        stop.addActionListener(this);
        wait.addActionListener(this);
        go.addActionListener(this);
        setLayout(null);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        int x[]={100,200,200,100,100};                    // basic outline
        int y[]={100,100,400,400,100};
        g.drawPolygon(x,y,5);
        g.fillPolygon(x,y,5);
        int a[]={100,75,175,200,100};                     // upper shade
        int b[]={100,130,130,100,100};
        g.drawPolygon(a,b,5);
        Color ups=new Color(102,102,102);
        g.setColor(ups);
        g.fillPolygon(a,b,5);
        g.setColor(Color.black);
        int c[]={200,181,200,200};                        //right hand shade
        int d[]={100,125,200,100};
        g.drawPolygon(c,d,4);
        g.setColor(ups);
        g.fillPolygon(c,d,4);
        g.setColor(Color.black);
        int e[]={85,100,100,85};                          //left hand shade
        int f[]={130,130,200,130};
        g.drawPolygon(e,f,4);
        g.setColor(ups);
        g.fillPolygon(e,f,4);
        g.setColor(Color.black);
        int g1[]={120,120,130,130,120};                   //top rect 1
        int h[]={100,80,80,100,100};
        g.drawPolygon(g1,h,5);
        int i[]={170,170,180,180,170};                    //top rect 2
        int j[]={100,80,80,100,100};
        g.drawPolygon(i,j,5);
        g.setColor(Color.white);
        g.drawOval(115,136,60,60);                        //top light
        g.drawOval(115,226,60,60);                        //middle light
        g.drawOval(115,316,60,60);                        //last light
        Color cir=new Color(204,204,204);
        if(flag=="STOP")
        {
            g.setColor(Color.red);
            g.fillOval(116,137,59,59);
        }
        else
        {
            g.setColor(cir);
            g.fillOval(116,137,59,59);  
        }  
        if(flag=="WAIT")
        {
            g.setColor(Color.yellow);
            g.fillOval(116,227,59,59);                        
        }
        else
        {
            g.setColor(cir);
            g.fillOval(116,227,59,59);                        
        }
        if(flag=="GO")
        {
            g.setColor(Color.green);
            g.fillOval(116,317,59,59);
        }
        else
        {
            g.setColor(cir);
            g.fillOval(116,317,59,59);
        }                      
        g.setColor(Color.black);
        int k[]={135,135,175,175,135};
        int l[]={500,400,400,500,500};                    // stand
        g.drawPolygon(k,l,5);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand()=="STOP")
        {
            flag="STOP";
            repaint();
        }
        if(ae.getActionCommand()=="WAIT")
        {
            flag="WAIT";
            repaint();
        }
        if(ae.getActionCommand()=="GO")
        {
            flag="GO";
            repaint();
        }
    }
}