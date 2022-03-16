package MobilePhone;

import ITelephone.ITelephone;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn()
    {
        isOn = true;
        System.out.println("Mobile phone powerOn()");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("MobilePhone.dial() -> " + phoneNumber + " on number");
        } else {
            System.out.println("MobilePhone is switched off");
        }
    }

    @Override
    public void answer() {
        if (isRinging() && isOn) {
            System.out.println("Answer the mobile phone");
            isRinging = false;
        }
        System.out.println("MobilePhone.answer()");
    }

    @Override
    public boolean callPhone(int phoneNumber) {

        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("MobilePhone.Ring ring");
        } else {
            System.out.println("MobilePhone.callPhone not on or number on");
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
