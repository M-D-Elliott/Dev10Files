package com.sg.llamaparty.objects;

public class RSVP {

    private String rsvpName;
    private int llamas;
    private boolean attending;

    public RSVP() {
    }

    public RSVP(String name, int llamas) {
    }

    public RSVP(String rsvpName, int llamas, boolean attending) {
        this.rsvpName = rsvpName;
        this.llamas = llamas;
        this.attending = attending;
    }

    public String getRsvpName() {
        return rsvpName;
    }

    public void setRsvpName(String rsvpName) {
        this.rsvpName = rsvpName;
    }

    public int getLlamas() {
        return llamas;
    }

    public void setLlamas(int llamas) {
        this.llamas = llamas;
    }

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }
}
