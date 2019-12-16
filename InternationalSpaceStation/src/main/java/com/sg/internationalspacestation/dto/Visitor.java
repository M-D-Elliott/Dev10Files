package com.sg.internationalspacestation.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Visitor {
    private LocalDate start;
    private LocalDate end;
    private VisitorType type;
    private String name;

    public Visitor() {
        this.type = VisitorType.ASTRONAUT;
        this.start = LocalDate.now();
        this.end = null;
    }

    public Visitor(LocalDate start, VisitorType type) {
        this.start = start;
        this.type = type;
        this.end = null;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public VisitorType getType() {
        return type;
    }

    public void setType(VisitorType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.start);
        hash = 13 * hash + Objects.hashCode(this.end);
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visitor other = (Visitor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
}
