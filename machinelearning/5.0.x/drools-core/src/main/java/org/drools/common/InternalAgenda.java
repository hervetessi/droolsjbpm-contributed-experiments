package org.drools.common;

import org.drools.Agenda;
import org.drools.spi.Activation;
import org.drools.spi.ActivationGroup;
import org.drools.spi.AgendaFilter;
import org.drools.spi.AgendaGroup;
import org.drools.spi.ConsequenceException;
import org.drools.spi.RuleFlowGroup;

public interface InternalAgenda
    extends
    Agenda {

    public void fireActivation(final Activation activation) throws ConsequenceException;

    public void removeScheduleItem(final ScheduledAgendaItem item);
    
    public org.drools.util.LinkedList getScheduledActivationsLinkedList();

    public boolean fireNextItem(AgendaFilter filter) throws ConsequenceException;

    public void scheduleItem(final ScheduledAgendaItem item);
    
    /**
     * Adds the activation to the agenda. Depending on the mode the agenda is running,
     * the activation may be added to the agenda priority queue (synchronously or 
     * asynchronously) or be executed immediately.
     * 
     * @param activation
     * 
     * @return true if the activation was really added, and not ignored in cases of lock-on-active or no-loop
     */
    public boolean addActivation(final AgendaItem activation);

    public void addAgendaGroup(final AgendaGroup agendaGroup);

    public void increaseActiveActivations();

    public void decreaseActiveActivations();

    public void increaseDormantActivations();

    public void decreaseDormantActivations();

    public int getActiveActivations();

    public int getDormantActivations();

    /**
     * Returns true if there is at least one activation of the given rule name
     * in the given ruleflow group name
     * 
     * @param ruleflowGroupName
     * @param ruleName
     * 
     * @return 
     */
	public boolean isRuleActiveInRuleFlowGroup(String ruleflowGroupName, String ruleName);

	/**
	 * Adds a RuleFlowGroupListerner to the named RuleFlowGroup
	 * 
	 * @param ruleFlowGroup
	 * @param listener
	 */
    public void addRuleFlowGroupListener(String ruleFlowGroup,
                                         RuleFlowGroupListener listener);

    /**
     * Removes the given RuleFlowGroupListener from the list of listeners of the named RuleFlowGroup
     * 
     * @param ruleFlowGroup
     * @param listener
     */
    public void removeRuleFlowGroupListener(String ruleFlowGroup,
                                            RuleFlowGroupListener listener);

    public void clear();

    public void setWorkingMemory(final InternalWorkingMemory workingMemory);

    /**
     * Fires all activations currently in agenda that match the given agendaFilter
     * until the fireLimit is reached or no more activations exist.
     * 
     * @param agendaFilter the filter on which activations may fire.
     * @param fireLimit the maximum number of activations that may fire. If -1, then it will
     *                  fire until no more activations exist.
     *                  
     * @return the number of rules that were actually fired                 
     */
    public int fireAllRules(AgendaFilter agendaFilter,
                             int fireLimit);

    /**
     * Stop agenda from firing any other rule. It will finish the current rule
     * execution though.
     */
    public void halt();

    /**
     * Keeps firing activations until a halt is called. If in a given moment, there is 
     * no activation to fire, it will wait for an activation to be added to an active 
     * agenda group or rule flow group.
     */
    public void fireUntilHalt();
    
    /**
     * Keeps firing activations until a halt is called. If in a given moment, there is 
     * no activation to fire, it will wait for an activation to be added to an active 
     * agenda group or rule flow group.
     * 
     * @param agendaFilter filters the activations that may fire
     */
    public void fireUntilHalt(AgendaFilter agendaFilter);

    public AgendaGroup getAgendaGroup(String name);

    public ActivationGroup getActivationGroup(String name);

    public RuleFlowGroup getRuleFlowGroup(String name);
    
    
}
