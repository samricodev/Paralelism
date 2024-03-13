
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class CalculadoraGUI extends JFrame implements ActionListener {

    JTextField Numero;
    interfaceOperaciones servidor;
    JButton btnEnviar, btnSuma, btnResta, btnMulti, btnDiv,
            btnNum1, btnNum2, btnNum3, btnNum4, btnNum5,
            btnNum6, btnNum7, btnNum8, btnNum9, btnNum0,
            btnNumClear, btnNumPoint, btnEqual;

    public CalculadoraGUI(interfaceOperaciones servidor) {
        //Configuraciones del frame
        setLayout(null);
        setSize(500, 500);
        setResizable(false);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);

        this.servidor = servidor;

        //Diseno del layout
        Numero = new JTextField();
        Numero.setBounds(80, 50, 235, 40);
        add(Numero);

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(this);
        btnEnviar.setBounds(320, 50, 75, 40);
        btnEnviar.setBackground(Color.ORANGE);
        add(btnEnviar);

        btnNum1 = new JButton("1");
        btnNum2 = new JButton("2");
        btnNum3 = new JButton("3");
        btnNum4 = new JButton("4");
        btnNum5 = new JButton("5");
        btnNum6 = new JButton("6");
        btnNum7 = new JButton("7");
        btnNum8 = new JButton("8");
        btnNum9 = new JButton("9");
        btnNum0 = new JButton("0");
        btnEqual = new JButton("=");
        btnNumClear = new JButton("Clear");
        btnNumPoint = new JButton(".");

        btnNum1.setBounds(80, 150, 75, 65);
        btnNum1.setBackground(Color.LIGHT_GRAY);
        btnNum1.addActionListener(this);
        add(btnNum1);

        btnNum2.setBounds(160, 150, 75, 65);
        btnNum2.setBackground(Color.LIGHT_GRAY);
        btnNum2.addActionListener(this);
        add(btnNum2);

        btnNum3.setBounds(240, 150, 75, 65);
        btnNum3.setBackground(Color.LIGHT_GRAY);
        btnNum3.addActionListener(this);
        add(btnNum3);

        btnNum4.setBounds(80, 220, 75, 65);
        btnNum4.setBackground(Color.LIGHT_GRAY);
        btnNum4.addActionListener(this);
        add(btnNum4);

        btnNum5.setBounds(160, 220, 75, 65);
        btnNum5.setBackground(Color.LIGHT_GRAY);
        btnNum5.addActionListener(this);
        add(btnNum5);

        btnNum6.setBounds(240, 220, 75, 65);
        btnNum6.setBackground(Color.LIGHT_GRAY);
        btnNum6.addActionListener(this);
        add(btnNum6);

        btnNum7.setBounds(80, 290, 75, 65);
        btnNum7.setBackground(Color.LIGHT_GRAY);
        btnNum7.addActionListener(this);
        add(btnNum7);

        btnNum8.setBounds(160, 290, 75, 65);
        btnNum8.setBackground(Color.LIGHT_GRAY);
        btnNum8.addActionListener(this);
        add(btnNum8);

        btnNum9.setBounds(240, 290, 75, 65);
        btnNum9.setBackground(Color.LIGHT_GRAY);
        btnNum9.addActionListener(this);
        add(btnNum9);

        btnNumPoint.setBounds(80, 360, 75, 65);
        btnNumPoint.setBackground(Color.LIGHT_GRAY);
        btnNumPoint.addActionListener(this);
        add(btnNumPoint);

        btnNum0.setBounds(160, 360, 75, 65);
        btnNum0.setBackground(Color.LIGHT_GRAY);
        btnNum0.addActionListener(this);
        add(btnNum0);

        btnNumClear.setBounds(240, 360, 75, 65);
        btnNumClear.setBackground(Color.LIGHT_GRAY);
        btnNumClear.addActionListener(this);
        add(btnNumClear);

        btnEqual.setBounds(80, 100, 315, 40);
        btnEqual.setBackground(Color.LIGHT_GRAY);
        btnEqual.addActionListener(this);
        add(btnEqual);

        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMulti = new JButton("*");
        btnDiv = new JButton("/");

        btnSuma.setBounds(320, 150, 75, 65);
        btnSuma.setBackground(Color.ORANGE);
        btnSuma.addActionListener(this);
        add(btnSuma);

        btnResta.setBounds(320, 220, 75, 65);
        btnResta.setBackground(Color.ORANGE);
        btnResta.addActionListener(this);
        add(btnResta);

        btnMulti.setBounds(320, 290, 75, 65);
        btnMulti.setBackground(Color.ORANGE);
        btnMulti.addActionListener(this);
        add(btnMulti);

        btnDiv.setBounds(320, 360, 75, 65);
        btnDiv.setBackground(Color.ORANGE);
        btnDiv.addActionListener(this);
        add(btnDiv);

        setVisible(true);
    }

    //Logica de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (btnNum1 == e.getSource()) {
            Numero.setText(Numero.getText() + "1");
        } else if (btnNum2 == e.getSource()) {
            Numero.setText(Numero.getText() + "2");
        } else if (btnNum3 == e.getSource()) {
            Numero.setText(Numero.getText() + "3");
        } else if (btnNum4 == e.getSource()) {
            Numero.setText(Numero.getText() + "4");
        } else if (btnNum5 == e.getSource()) {
            Numero.setText(Numero.getText() + "5");
        } else if (btnNum6 == e.getSource()) {
            Numero.setText(Numero.getText() + "6");
        } else if (btnNum7 == e.getSource()) {
            Numero.setText(Numero.getText() + "7");
        } else if (btnNum8 == e.getSource()) {
            Numero.setText(Numero.getText() + "8");
        } else if (btnNum9 == e.getSource()) {
            Numero.setText(Numero.getText() + "9");
        } else if (btnNum0 == e.getSource()) {
            Numero.setText(Numero.getText() + "0");
        } else if (btnNumClear == e.getSource()) {
            Numero.setText(null);
        } else if (btnNumPoint == e.getSource()) {
            String a;
            a = Numero.getText();
            if (a.length() <= 0) {
                Numero.setText("0.");
            } else {
                if (!punto(Numero.getText())) {
                    Numero.setText(Numero.getText() + ".");
                }
            }
        } else if (btnEnviar == e.getSource()) {
            String txt = Numero.getText();
            String enviar = txt.replaceAll("[^0-9]", "");
            if (txt.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite un numero");
                return;
            }
            try {
                this.servidor.mandar(Double.parseDouble(enviar));
            } catch (RemoteException ex) {
                Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Enviado");
            Numero.setText("");
        } else if (btnSuma == e.getSource()) {
            Numero.setText(Numero.getText() + " +");
        } else if (btnResta == e.getSource()) {
            Numero.setText(Numero.getText() + " -");
        } else if (btnMulti == e.getSource()) {
            Numero.setText(Numero.getText() + " *");
        } else if (btnDiv == e.getSource()) {
            Numero.setText(Numero.getText() + " /");
        } else if (btnEqual == e.getSource()) {
            char op = Numero.getText().charAt(Numero.getText().length() - 1);
            switch (op) {
                case '+':
                    try {
                        if (this.servidor.verificar()) {
                            double r = this.servidor.suma(this.servidor.saberA(), this.servidor.saberB());
                            String res = Double.toString(r);
                            Numero.setText(this.servidor.saberA() + " + " + this.servidor.saberB() + " = " + res);
                            return;
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case '-':
                    try {
                        if (this.servidor.verificar()) {
                            double r = this.servidor.resta(this.servidor.saberA(), this.servidor.saberB());
                            String res = Double.toString(r);
                            Numero.setText(this.servidor.saberA() + " - " + this.servidor.saberB() + " = " + res);
                            return;
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }   JOptionPane.showMessageDialog(null, "Falta enviar cifras al servidor");
                    break;
                case '*':
                    try {
                        if (this.servidor.verificar()) {
                            double r = this.servidor.multiplicacion(this.servidor.saberA(), this.servidor.saberB());
                            String res = Double.toString(r);
                            Numero.setText(this.servidor.saberA() + " * " + this.servidor.saberB() + " = " + res);
                            return;
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }   JOptionPane.showMessageDialog(null, "Falta enviar cifras al servidor");
                    break;
                case '/':
                    try {
                        if (this.servidor.verificar()) {
                            double r = this.servidor.division(this.servidor.saberA(), this.servidor.saberB());
                            String res = Double.toString(r);
                            Numero.setText(this.servidor.saberA() + " / " + this.servidor.saberB() + " = " + res);
                            return;
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }   JOptionPane.showMessageDialog(null, "Falta enviar cifras al servidor");
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean punto(String a) {
        boolean res;
        res = false;

        for (int i = 0; i < a.length(); i++) {
            if (a.substring(i, i + 1).equals(".")) {
                res = true;
                break;
            }
        }
        return res;
    }
}
