package Controller;

import Model.Model;
import View.View;
import Model.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    public Controller(Model model, View view){
        this.model=model;
        this.view=view;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addDerivListener(new DerivListener());
        view.addDivListener(new DivListener());
        view.addIntListener(new IntListener());
        view.addMulListener(new MulListener());

    }
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getFirstPoli();
            String p2=view.getSecondPoli();
            String s;
            if(p1.isEmpty()||p2.isEmpty())
                view.displayErrorMessage("This operation needs two polynomials!");
            else
            {
                view.resetMessage();
                view.setCat(model.addPolynomials(new Polynomial(p1),new Polynomial(p2)).toString());
                view.setRest("");
            }
        }
    }
    class SubListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getFirstPoli();
            String p2=view.getSecondPoli();
            if(p1.isEmpty()||p2.isEmpty())
                view.displayErrorMessage("This operation needs two polynomials!");
            else
            {
                view.resetMessage();
                view.setRest("");
                view.setCat(model.subPolynomials(new Polynomial(p1),new Polynomial(p2)).toString());
            }
        }
    }
    class DerivListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getDerivInt();
            if(p1.isEmpty()) {
                view.displayErrorMessageLbl();
                view.setRest("");
                view.setCat("");
            }
            else {
                view.resetMessageLbl();
                view.setDerivInt(model.derivatePolynomial(new Polynomial(p1)).toString());
                view.setRest("");
                view.setCat("");
            }
        }
    }
    class DivListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getFirstPoli();
            String p2=view.getSecondPoli();

            Polynomial first=new Polynomial(p1);
            Polynomial second= new Polynomial(p2);

            if(p1.isEmpty()||p2.isEmpty())
                view.displayErrorMessage("This operation needs two polynomials!");
            else {
                Polynomial cat = new Polynomial();
                Polynomial rest = new Polynomial();
                model.dividePolynomials(first, second, cat, rest);
                view.resetMessage();
                view.setCat(cat.toString());
                view.setRest(rest.toString());
            }
        }
    }
    class IntListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getDerivInt();
            if(p1.isEmpty()) {
                view.displayErrorMessageLbl();
                view.setRest("");
                view.setCat("");
            }
            else {
                view.resetMessageLbl();
                view.setDerivInt(model.integratePolynomial(new Polynomial(p1)).toString());
                view.setRest("");
                view.setCat("");
            }
        }
    }
    class MulListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String p1=view.getFirstPoli();
            String p2=view.getSecondPoli();
            if(p1.isEmpty()||p2.isEmpty())
                view.displayErrorMessage("This operation needs two polynomials!");
            else
            {
                view.resetMessage();
                view.setRest("");
                view.setCat(model.multiplyPolynomials(new Polynomial(p1),new Polynomial(p2)).toString());
            }

        }
    }
}
