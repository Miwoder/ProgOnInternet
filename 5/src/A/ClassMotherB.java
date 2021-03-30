package A;

import A.AA.B.BClass1lv1A;

public class ClassMotherB extends BClass1lv1A {
    public ClassMotherB(int weight) {
        super(weight);
        System.out.println("Created ClassMotherB");
    }

    public void print(){
        System.out.println(super.weight);
    }
}
