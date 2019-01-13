package code.little_knowledge;

public class IntegerTrap {
    public static void main(String[] args) {
        //-128--127之间
        Integer i1 = 100;
        Integer i2 = 100;

        if( i1 == i2){
            System.out.println("i1 == i2");
        }else{
            System.out.println("i1 != i2 ");
        }

        //大于127
        Integer i3 = 200;
        Integer i4 = 200;

        if( i3 == i4){
            System.out.println("i3 == i4");
        }else{
            System.out.println("i3 != i4 ");
        }

        if (i3.equals(i4)) {
            System.out.println("eeeee");
        }

    }

}
