
package IntegerSet;


public class IntegerSet {

    private boolean[] set = new boolean[101];

    public IntegerSet() {
    }

    public void insertElement(int k) {

        if(k>=0 && k<=100)
            set[k]=true;
    }

    public void deleteElement(int m){

        if(m>=0 && m<=100)
            set[m]=false;
    }

    public static IntegerSet union(IntegerSet a,IntegerSet b){

        IntegerSet result=new IntegerSet();

        for(int i=0;i<=100;i++)
            result.set[i]=a.set[i]||b.set[i];

        return result;
    }

    public static IntegerSet intersection(IntegerSet a,IntegerSet b){

        IntegerSet result=new IntegerSet();

        for(int i=0;i<=100;i++)
            result.set[i]=a.set[i]&&b.set[i];

        return result;
    }

    public boolean isEqualTo(IntegerSet other){

        for(int i=0;i<=100;i++)
            if(set[i]!=other.set[i])
                return false;

        return true;
    }

    @Override
    public String toString(){

        String result="";

        for(int i=0;i<=100;i++)
            if(set[i])
                result+=i+" ";

        if(result.equals(""))
            return "---";

        return result;
    }

}
