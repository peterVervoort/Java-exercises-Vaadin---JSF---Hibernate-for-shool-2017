package be.mobyus.hibernate.exercise2.entities;

import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

/**
 * Created by java on 22.03.17.
 */
@Entity
@OptimisticLocking
public class SeatReservation {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String seatId;
    private String givenTO;

    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getGivenTO() {
        return givenTO;
    }

    public void setGivenTO(String givenTO) {
        this.givenTO = givenTO;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
