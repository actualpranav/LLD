package Exceptions;

public class HandleException {

    static int count=0;
    static void divide(int a, int b) throws InvalidDivisorException, NegativeDivisorException, ClassNotFoundException {
        if(b==0){
            throw new InvalidDivisorException();
        }
        if(b<0){
            throw new NegativeDivisorException();
        }
        throw new ClassNotFoundException();
    }

    /*

    class A extends B
    class B extends C
    class C extends D

    catching order should be,
     catch A,
     catch B,
     catch C,
     catch D

     */

    public static void main(String[] args) throws NegativeDivisorException {
        try {
//            divide(10, 0);
            divide(10, -1);
        }
        catch (InvalidDivisorException e) {
            System.out.println("Dividing by zero happened, for  "+count+" times");
            count++;
        } catch (NegativeDivisorException e) {
            System.out.println("Dividing by negative number happened "+count);
            count++;
        } catch (Exception e){
            System.out.println("generic exception ");
        }
        try {
//            divide(10, 0);
            divide(10, -1);
        }
        catch (InvalidDivisorException e) {
            System.out.println("Dividing by zero happened, for  "+count+" times");
            count++;
        } catch (NegativeDivisorException e) {
            System.out.println("Dividing by negative number happened "+count);
            count++;
        } catch (Exception e){
            System.out.println("generic exception ");
        }
        System.out.println("Execution continued");
    }
}