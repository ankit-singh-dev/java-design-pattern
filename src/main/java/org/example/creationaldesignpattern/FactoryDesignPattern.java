package org.example.creationaldesignpattern;

/*
Base interface
 */
interface SendOtp{
    void sendOtp();
}

/*
First Implementation
 */
class MobileOtp implements SendOtp{

    @Override
    public void sendOtp() {
        System.out.println("Sending otp to mobile");
    }

    @Override
    public String toString() {
        return "MobileOtp{} class";
    }
}

/*
Second Implementation
 */
class EmailOtp implements SendOtp{

    @Override
    public void sendOtp() {
        System.out.println("Sending otp to Email");
    }

    @Override
    public String toString() {
        return "EmailOtp{}";
    }
}

/*
Factory Class
 */
class FactoryClass{

    public static SendOtp sendotp(String input){
        if(input.equalsIgnoreCase("mobile")){
            return new MobileOtp();
        }else if(input.equalsIgnoreCase("email")){
            return new EmailOtp();
        }
        return null;
    }
}

public class FactoryDesignPattern {

    public static void main(String[] args) {
        SendOtp otp1 = FactoryClass.sendotp("mobile");
        SendOtp otp2 = FactoryClass.sendotp("email");

        otp1.sendOtp();
        otp2.sendOtp();
    }
}
