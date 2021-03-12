package test1;

class Base{
private void amethod(int iBase){
        System.out.println("Base.amethod");
        }
}

class Over extends Base{


public static void main(String argv[]){
        Over o = new Over();
        int iBase=0;
        o.amethod(iBase);
        }
        public void amethod(int iOver){
                System.out.println("Over.amethod");
        }

}
/*
1) Compile time error complaining that Base.amethod is private 
2) Runtime error complaining that Base.amethod is private 
3) Output of "Base.amethod"
4) Output of "Over.amethod" 
*/