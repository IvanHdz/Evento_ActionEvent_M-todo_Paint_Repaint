import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventoCarita extends Frame {
    private int tipoCara = 1;
    
    public EventoCarita(){
        super("Viruz Blog: Caritas con Eventos");
        setSize(300,300);
        setBackground(Color.cyan);
        setLayout(new FlowLayout());
        addComponentes();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void addComponentes(){
       //boton1 y 2 son objetos de origen de eventos
        Button boton1= new Button("Carita Feliz");
        Button boton2= new Button("Carita Triste");
        //aBoton1 y 2 son objetos oyentes de eventos
        AccionBoton aBoton1 = new AccionBoton(1);
        AccionBoton aBoton2 = new AccionBoton(2);
        //Registro de Oyentes
        boton1.addActionListener(aBoton1);
        boton2.addActionListener(aBoton2);
        //Usando clases internas Anonimas       
        addWindowListener(new WindowAdapter(){
            @Override
          public void windowClosing (WindowEvent e){
           System.exit(0);
        }
    });
        add(boton1);
        add(boton2);
        
    }
    
    @Override
    public void paint(Graphics g){
        if(tipoCara!=0){
           g.setColor(Color.YELLOW);
           g.fillOval(40, 60, 200, 200);
           g.setColor(Color.BLACK);
           g.fillOval(90, 120, 20, 20);
           g.fillOval(180-10, 130-10, 20, 20);
           g.setColor(Color.RED);
           
          if(tipoCara==1)
               g.drawArc(80, 100, 120, 120, 180, 180);
                //x ,y ,largo,ancho,angulo inicial, angulo final           
           else
               g.drawArc(80, 160, 120, 120, 0, 180);
               
           }      
    
    }
    
    class AccionBoton implements ActionListener{
       private final int valor;
        
         public AccionBoton(int valor){
              this.valor = valor;
         }        
         public void actionPerformed(ActionEvent e){
             tipoCara = valor;
             repaint();         
         }    
    }
    //Una clase adaptadora nos ahorra poner todos los metodos de WindowListener
}