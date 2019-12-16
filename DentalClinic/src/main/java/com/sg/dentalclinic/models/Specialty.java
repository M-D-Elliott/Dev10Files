package com.sg.dentalclinic.models;

public enum Specialty {
    DENTIST,
    HYGENIST,
    ORTHODONTIST,
    ORAL_SURGEON,
    NULL;
    
    
    public static Specialty parseSpecialty(String string){
        Specialty ret;
        switch(string){
            case "dentist":
            case "Dentist":
            case "DENTIST":
                ret = Specialty.DENTIST;
                break;
            case "hygenist":
            case "Hygenist":
            case "HYGENIST":
                ret = Specialty.HYGENIST;
                break;
            case "orthodontist":
            case "Orthodontist":
            case "ORTHODONTIST":
                ret = Specialty.ORTHODONTIST;
                break;
            case "oral surgeon":
            case "Oral Surgeon":
            case "ORAL SURGEON":
            case "oral_surgeon":
            case "Oral_Surgeon":
            case "ORAL_SURGEON":
                ret = Specialty.ORAL_SURGEON;
                break;
            default:
                ret = Specialty.NULL;
                break;
        }
        return ret;
    }

    @Override
    public String toString() {
        String ret;
        switch(this){
            case DENTIST:
                ret = "dentist";
                break;
            case HYGENIST:
                ret = "hygenist";
                break;
            case ORTHODONTIST:
                ret = "orthodontist";
                break;
            case ORAL_SURGEON:
                ret = "oral_surgeon";
                break;
            default:
                ret = "NULL";
                break;
        }
        return ret;
    }
    
    
}
