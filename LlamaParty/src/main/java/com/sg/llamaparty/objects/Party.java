package com.sg.llamaparty.objects;

import java.util.List;

public class Party {

    private int partyId;
    private RSVP host;
    private List<RSVP> attendees;

    public Party() {
    }

    public Party(int partyId, RSVP host, List<RSVP> attendees) {
        this.partyId = partyId;
        this.host = host;
        this.attendees = attendees;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public RSVP getHost() {
        return host;
    }

    public void setHost(RSVP host) {
        this.host = host;
    }

    public List<RSVP> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<RSVP> attendees) {
        this.attendees = attendees;
    }
    
    public void addAttendeee(RSVP attendee) {
        this.attendees.add(attendee);
    }
}
