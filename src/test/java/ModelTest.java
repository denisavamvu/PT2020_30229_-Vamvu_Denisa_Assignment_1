import Model.Model;
import org.junit.jupiter.api.Test;
import Model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {
    private Model model=new Model();
    @Test
    void addPolynomials() {
        Polynomial first=new Polynomial("2X^2+3X^1+5X^0");
        Polynomial second=new Polynomial("3X^2+4X^0");
        Polynomial result=model.addPolynomials(first,second);
        String res="+5.0X^2+3.0X^1+9.0X^0";
        assertEquals(result.toString(),res);
    }

    @Test
    void subPolynomials() {
        Polynomial first=new Polynomial("2X^2+3X^1+5X^0");
        Polynomial second=new Polynomial("3X^2+4X^0");
        Polynomial result=model.subPolynomials(first,second);
        String res="-1.0X^2+3.0X^1+1.0X^0";
        assertEquals(result.toString(),res);
    }

    @Test
    void multiplyPolynomials() {
        Polynomial first=new Polynomial("2X^2+3X^1+5X^0");
        Polynomial second=new Polynomial("3X^2+4X^0");
        Polynomial result=model.multiplyPolynomials(first,second);
        String res="+6.0X^4+9.0X^3+23.0X^2+12.0X^1+20.0X^0";
        assertEquals(result.toString(),res);
    }

    @Test
    void derivatePolynomial() {
        Polynomial p=new Polynomial("2X^2+3X^1+5X^0");
        Polynomial result=model.derivatePolynomial(p);
        String res="+4.0X^1+3.0X^0";
        assertEquals(result.toString(),res);
    }

    @Test
    void integratePolynomial() {
        Polynomial p=new Polynomial("3X^1+5X^0");
        Polynomial result=model.integratePolynomial(p);
        String res="+1.5X^2+5.0X^1";
        assertEquals(result.toString(),res);
    }

    @Test
    void dividePolynomials() {
        Polynomial first=new Polynomial("5X^2+3X^1+4X^0");
        Polynomial second=new Polynomial("1X^1+1X^0");
        Polynomial cat=new Polynomial();
        Polynomial rest=new Polynomial();
        model.dividePolynomials(first,second,cat,rest);
        assertEquals(cat.toString(),"+5.0X^1-2.0X^0");
        assertEquals(rest.toString(),"+6.0X^0");
    }
}