package Model;

import Model.Monomial;

import java.util.TreeSet;
import java.lang.*;
public class Polynomial{
    private TreeSet<Monomial> monomials;
    public Polynomial(){
        monomials=new TreeSet<Monomial>();
    }
    public void addM(Monomial m){
        this.monomials.add(m);
    }
    public Polynomial(String s){
        monomials=new TreeSet<Monomial>();
        String replaceString=s.replace("-","+-");
        String a[]= replaceString.split("[+]");

        for (String b: a)
        {
            if(b.length()>0) {
                Monomial mon = new Monomial(b);
                this.monomials.add(mon);
            }
        }
    }
    public String toString(){
        String s="";
        for(Monomial monomial: monomials)
        {
            s+=monomial.toString();
        }
        return s;
    }
    public void addSamePower(Monomial monomial){
        for(Monomial mon: this.monomials)
            if(mon.getPower()==monomial.getPower())
                mon.addToCurrent(monomial);
    }
    public TreeSet<Monomial> getMonomials() {
        return monomials;
    }

    public int getMaximumDegree(){
        return monomials.first().getPower();
    }
    public void removeFirst(){
        monomials.remove(monomials.first());
    }
}
