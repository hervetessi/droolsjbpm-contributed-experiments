package org.drools.solver.examples.travelingtournament.solver.simple.move;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.drools.FactHandle;
import org.drools.WorkingMemory;
import org.drools.solver.core.localsearch.decider.accepter.tabu.TabuPropertyEnabled;
import org.drools.solver.core.move.Move;
import org.drools.solver.examples.travelingtournament.domain.Day;
import org.drools.solver.examples.travelingtournament.domain.Match;

/**
 * @author Geoffrey De Smet
 */
public class DayChangeMove implements Move, TabuPropertyEnabled {

    private Match match;
    private Day toDay;

    public DayChangeMove(Match match, Day toDay) {
        this.match = match;
        this.toDay = toDay;
    }

    public boolean isMoveDoable(WorkingMemory workingMemory) {
        return !ObjectUtils.equals(match.getDay(), toDay);
    }

    public Move createUndoMove(WorkingMemory workingMemory) {
        return new DayChangeMove(match, match.getDay());
    }

    public void doMove(WorkingMemory workingMemory) {
        FactHandle matchHandle = workingMemory.getFactHandle(match);
        workingMemory.modifyRetract(matchHandle);
        match.setDay(toDay);
        workingMemory.modifyInsert(matchHandle, match);
    }

    public Collection<? extends Object> getTabuProperties() {
        return Collections.singletonList(match);
    }

    public boolean equals(Object o) {        
        if (this == o) {
            return true;
        } else if (o instanceof DayChangeMove) {
            DayChangeMove other = (DayChangeMove) o;
            return new EqualsBuilder()
                    .append(match, other.match)
                    .append(toDay, other.toDay)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(match)
                .append(toDay)
                .toHashCode();
    }

    public String toString() {
        return match + " => " + toDay;
    }

}
