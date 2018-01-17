package com.greenfox.tamagochi.Model;

import javax.persistence.*;

@Entity
@Table(name = "FOX_TRICK")
@AssociationOverrides({
        @AssociationOverride(name ="pk.fox", joinColumns = @JoinColumn(name ="fox_id")),
        @AssociationOverride(name ="pk.trick", joinColumns = @JoinColumn(name ="trick_id"))
})
public class FoxTrickAssociation {
    private long foxIdAss;
    private long trickIdAss;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="FOXID", referencedColumnName="ID")
    private Fox foxAss;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="TRICKID", referencedColumnName="ID")
    private Trick trickAss;

    public long getFoxIdAss() {
        return foxIdAss;
    }

    public void setFoxIdAss(long foxIdAss) {
        this.foxIdAss = foxIdAss;
    }

    public void setFoxAss(Fox foxAss) {
        this.foxAss = foxAss;
    }

    public long getTrickIdAss() {
        return trickIdAss;
    }

    public void setTrickIdAss(long trickIdAss) {
        this.trickIdAss = trickIdAss;
    }

    public Trick getTrickAss() {
        return trickAss;
    }

    public void setTrickAss(Trick trickAss) {
        this.trickAss = trickAss;
    }

    public Fox getFoxAss() {
        return foxAss;
    }
}
