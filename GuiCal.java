import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GuiCal {
    public static void main(String args[])
    {
        JFrame fr = new JFrame("GUI Calculator");  
        fr.setSize(500,500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(5,4,10,10));

        JTextField t1=new JTextField();
        JTextField resf = new JTextField(); 
        resf.setEditable(false);

        ActionListener in=e-> {
            JButton btn =(JButton) e.getSource();
            t1.setText(t1.getText() + btn.getText());
        };

        JButton add=new JButton("+");
        JButton sub=new JButton("-");
        JButton mul=new JButton("*");
        JButton div=new JButton("/");
        JButton mod=new JButton("%");
        JButton dot=new JButton(".");
        JButton one=new JButton("1");
        JButton two=new JButton("2");
        JButton three=new JButton("3");     
        JButton four=new JButton("4");
        JButton five=new JButton("5");
        JButton six=new JButton("6");
        JButton seven=new JButton("7");
        JButton eight=new JButton("8");
        JButton nine=new JButton("9");          
        JButton zero=new JButton("0");
        JButton eq=new JButton("=");
        JButton c=new JButton("C");

       JButton[] but={one,two,three,four,five,six,seven,eight,nine,zero,add,mul,sub,div,mod,dot};
       for(JButton b:but)
       {
        b.addActionListener(in);
       }

       eq.addActionListener(e->{
        String ex=t1.getText().trim();
        if(ex.isEmpty()) {
            resf.setText("Please enter an expression");
            return;
        }
        else{
            double result = eval(ex);
;            resf.setText("="+result);
        }
       });

        c.addActionListener(e->{
            t1.setText("");
            resf.setText("");
        });
        fr.add(t1);
        fr.add(resf);fr.add(c);fr.add(mod);
        fr.add(one); fr.add(two); fr.add(three); fr.add(add);
        fr.add(four); fr.add(five); fr.add(six); fr.add(sub);
        fr.add(seven); fr.add(eight); fr.add(nine); fr.add(mul);
        fr.add(eq); fr.add(zero); fr.add(div);fr.add(dot);
        fr.setVisible(true);
       }
       public static double eval(String ex)
       {
        String[] tokens=ex.split("(?<=[-+*/])|(?=[-+*/])"); 
        double result=Double.parseDouble(tokens[0].trim());
        for(int i=1;i<tokens.length;i+=2)
        {
            String op=tokens[i].trim();
            double num=Double.parseDouble(tokens[i+1].trim());
            switch(op) {
                case"+":result+=num;break;
                case"-":result-=num;break;
                case"*":result*=num;break;
                case"/":result/=num;break;
                case"%":result%=num;break;
                case".":result+=num;break;
                default:result=0;System.out.println("error");break;
            }
            }
        return result;
        }
       }