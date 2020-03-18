package Model;

import static java.lang.Integer.parseInt;

public class Monomial  implements Comparable {
    private double coef;
    private int power;

    public Monomial() {
    }
    public Monomial(double coef,int power){
        this.coef=coef;
        this.power=power;
    }
    public Monomial(String s) {
        if(s.length()>1) {
            String[] p = s.split("[X^]");
            this.coef = Double.parseDouble(p[0]);
            this.power = Integer.parseInt(p[2]);
        }
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int compareTo(Object obj){
        if(this.power==((Monomial)obj).power)
            return 0;
        if(this.power<((Monomial)obj).power)
            return 1;
        return -1;
    }
    public String toString(){
        String s="";
        if(coef > 0)
            s+="+"+Double.valueOf(this.coef).toString();
        else
        if(coef < 0)
            s+=Double.valueOf(this.coef).toString();
        s+="X^"+Integer.valueOf(this.power).toString();
        return s;
    }
    public static Monomial addMonomial(Monomial m1,Monomial m2){
        Monomial result=new Monomial();
        if(m1.power==m2.power)
        {
            result.setCoef(m1.coef+m2.coef);
            result.setPower(m1.power);
        }
        return result;

    }
    public static Monomial subMonomial(Monomial m1,Monomial m2){
        Monomial result=new Monomial();
        if(m1.power==m2.power)
        {
            result.setCoef(m1.coef-m2.coef);
            result.setPower(m1.power);
        }
        return result;
    }
    public static Monomial multiplyMonomial(Monomial m1,Monomial m2){
        Monomial result=new Monomial();
            result.setCoef(m1.coef*m2.coef);
            result.setPower(m1.power+m2.power);
        return result;
    }
    public static Monomial derivateMonomial(Monomial m){
        Monomial result=new Monomial();
        if(m.getPower()==0){
            result.setCoef(0);
            result.setPower(0);
        }
        else {
            result.setCoef(m.getPower() * m.getCoef());
            result.setPower(m.getPower() - 1);
        }
        return result;
    }
    public static Monomial integrateMonomial(Monomial m){
        Monomial result=new Monomial();
        result.setPower(m.getPower()+1);
        result.setCoef(m.getCoef()/(m.getPower()+1));
        return result;
    }
    public static Monomial divideMonomials(Monomial m1, Monomial m2){
        Monomial result=new Monomial();
        result.setPower(m1.getPower()-m2.getPower());
        result.setCoef(m1.getCoef()/m2.getCoef());
        return result;
    }
    public void addToCurrent(Monomial monomial){
        if(this.power==monomial.getPower())
            this.coef+=monomial.getCoef();
    }

}
