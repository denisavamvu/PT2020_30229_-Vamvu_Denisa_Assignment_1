package Model;

public class Model {
    public Polynomial addPolynomials(Polynomial a, Polynomial b){
        Polynomial c=new Polynomial();
        for(Monomial monomialA: a.getMonomials()){
            for(Monomial monomialB: b.getMonomials()) {
                if (monomialA.getPower() == monomialB.getPower())
                    c.addM(Monomial.addMonomial(monomialA, monomialB));
            }
        }
        for(Monomial monomialA: a.getMonomials()){
            int ok=0;
            for(Monomial monomialB: b.getMonomials())
                if(monomialB.getPower()==monomialA.getPower())
                    ok=1;
            if(ok==0)
                c.addM(monomialA);
        }
        for(Monomial monomialB: b.getMonomials()){
            int ok=0;
            for(Monomial monomialA: a.getMonomials())
                if(monomialA.getPower()==monomialB.getPower())
                    ok=1;
            if(ok==0)
                c.addM(monomialB);
        }
        return c;
    }
    public Polynomial subPolynomials(Polynomial a, Polynomial b){
        Polynomial c=new Polynomial();
        Polynomial result=new Polynomial();
        for(Monomial monomialA: a.getMonomials()){
            for(Monomial monomialB: b.getMonomials()) {
                if (monomialA.getPower() == monomialB.getPower())
                    c.addM(Monomial.subMonomial(monomialA, monomialB));
            }
        }
        for(Monomial monomialA: a.getMonomials()){
            int ok=0;
            for(Monomial monomialB: b.getMonomials())
                if(monomialB.getPower()==monomialA.getPower())
                    ok=1;
            if(ok==0)
                c.addM(monomialA);
        }
        for(Monomial monomialB: b.getMonomials()){
            int ok=0;
            for(Monomial monomialA: a.getMonomials())
                if(monomialA.getPower()==monomialB.getPower())
                    ok=1;
            if(ok==0)
            {
                Monomial monomialC=new Monomial();
                monomialC.setCoef(-1*monomialB.getCoef());
                monomialC.setPower(monomialB.getPower());
                c.addM(monomialC);
            }

        }
        for(Monomial monomialC: c.getMonomials()){
            if(monomialC.getCoef()!=0)
                result.addM(monomialC);
        }
        return result;
    }
    public Polynomial multiplyPolynomials(Polynomial a, Polynomial b){
        Polynomial c=new Polynomial();
        for(Monomial monomialA: a.getMonomials()){
            for(Monomial monomialB: b.getMonomials()){
                Monomial multiplyResult= Monomial.multiplyMonomial(monomialA,monomialB);
                int ok=0;
                int pow=multiplyResult.getPower();

                for(Monomial monomialC: c.getMonomials()){
                    if(pow==monomialC.getPower()) {
                        c.addSamePower(multiplyResult);
                        ok = 1;
                    }
                }
                if(ok==0)
                    c.addM(multiplyResult);
            }
        }
        return c;
    }
    public Polynomial derivatePolynomial(Polynomial p){
        Polynomial result= new Polynomial();
        for(Monomial m: p.getMonomials())
            result.addM(Monomial.derivateMonomial(m));
        return result;
    }
    public Polynomial integratePolynomial(Polynomial p){
        Polynomial result= new Polynomial();
        for(Monomial m: p.getMonomials())
            result.addM(Monomial.integrateMonomial(m));
        return result;
    }
    public void dividePolynomials(Polynomial first, Polynomial second, Polynomial cat, Polynomial rest){
        Polynomial p1=new Polynomial(first.toString());
        Polynomial aux=new Polynomial();
        try {

            while (p1.getMaximumDegree() >= second.getMaximumDegree()) {
                aux.addM(Monomial.divideMonomials(p1.getMonomials().first(), second.getMonomials().first()));
                cat.addM(aux.getMonomials().first());
                p1 = subPolynomials(p1, multiplyPolynomials(aux, second));
                aux.removeFirst();
            }
        }
        catch (Exception e){

        }
        for(Monomial m: p1.getMonomials())
            rest.addM(m);
    }
}
