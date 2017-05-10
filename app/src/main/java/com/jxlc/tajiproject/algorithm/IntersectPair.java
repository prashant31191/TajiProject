package com.jxlc.tajiproject.algorithm;

/**
 * Created by randal on 2017/5/10.
 */

public class IntersectPair {
    int idOne;
    int idTwo;
    double distance;

    public IntersectPair(int o, int t, double d) {
        idOne = o;
        idTwo = t;
        distance = d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        IntersectPair other = (IntersectPair)obj;
        return ((this.idOne == other.idOne && this.idTwo == other.idTwo)
            || (this.idOne == other.idTwo && this.idTwo == other.idOne));
    }

    @Override
    public String toString() {
        return "IntersectPair{" +
                "idOne=" + idOne +
                ", idTwo=" + idTwo +
                ", distance=" + distance +
                '}';
    }
}
