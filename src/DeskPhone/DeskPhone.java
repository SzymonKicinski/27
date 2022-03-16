package DeskPhone;

import ITelephone.ITelephone;

public class DeskPhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("powerOn()");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("dial() -> " + phoneNumber + " on number");
    }

    @Override
    public void answer() {
        if (isRinging()) {
            System.out.println("Answer the desk phone");
            isRinging = false;
        }
        System.out.println("answer()");
    }

    @Override
    public boolean callPhone(int phoneNumber) {

        if(phoneNumber == myNumber) {
            isRinging = true;
            System.out.println("Ring ring");
         } else {
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
