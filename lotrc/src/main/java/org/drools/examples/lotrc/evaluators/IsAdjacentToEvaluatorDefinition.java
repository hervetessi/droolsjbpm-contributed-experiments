/*
 * Copyright 2008 Red Hat
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.drools.examples.lotrc.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.base.BaseEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorCache;
import org.drools.base.evaluators.EvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.examples.lotrc.model.Region;
import org.drools.rule.VariableRestriction.ObjectVariableContextEntry;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.Evaluator;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;

/**
 * The implementation of "isAdjacentTo" evaluator
 * 
 * @author etirelli
 */
public class IsAdjacentToEvaluatorDefinition
    implements
    EvaluatorDefinition {

    // ***********************
    // First we add the operators to the operator registry, so that the parser can automatically
    // understand them
    //
    public static final Operator  IS_ADJACENT_TO      = Operator.addOperatorToRegistry( "isAdjacentTo",
                                                                                          false );
    public static final Operator  IS_NOT_ADJACENT_TO  = Operator.addOperatorToRegistry( "isAdjacentTo",
                                                                                          true );

    // Just as a convenience, we create a cache of the String IDs for the operators
    private static final String[] SUPPORTED_IDS         = {IS_ADJACENT_TO.getOperatorString()};

    // And we cache the evaluators themselves, so that they can be reused.
    // NOTE: the evaluators implement the GoF "fly weight" pattern
    private EvaluatorCache        evaluators            = new EvaluatorCache() {
                                                            private static final long serialVersionUID = 4782368623L;
                                                            {
                                                                addEvaluator( ValueType.OBJECT_TYPE,
                                                                              IS_ADJACENT_TO,
                                                                              IsAdjacentToEvaluator.POSITIVE_INSTANCE );
                                                                addEvaluator( ValueType.OBJECT_TYPE,
                                                                              IS_NOT_ADJACENT_TO,
                                                                              IsAdjacentToEvaluator.NEGATIVE_INSTANCE );
                                                            }
                                                        };

    // ***************************************************************
    // The method implementations are all retrieval methods that read the cache
    //

    /**
     * The implementation must support serialization
     */
    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        evaluators = (EvaluatorCache) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject( evaluators );
    }

    /**
     * @inheridDoc
     */
    public Evaluator getEvaluator(ValueType type,
                                  Operator operator) {
        return this.evaluators.getEvaluator( type,
                                             operator );
    }

    /**
     * @inheridDoc
     */
    public Evaluator getEvaluator(ValueType type,
                                  Operator operator,
                                  String parameterText) {
        return this.evaluators.getEvaluator( type,
                                             operator );
    }

    public Evaluator getEvaluator(final ValueType type,
                                  final String operatorId,
                                  final boolean isNegated,
                                  final String parameterText) {
        return this.getEvaluator( type,
                                  operatorId,
                                  isNegated,
                                  parameterText,
                                  Target.FACT,
                                  Target.FACT );

    }

    /**
     * @inheritDoc
     */
    public Evaluator getEvaluator(final ValueType type,
                                  final String operatorId,
                                  final boolean isNegated,
                                  final String parameterText,
                                  final Target left,
                                  final Target right) {
        return this.evaluators.getEvaluator( type,
                                             Operator.determineOperator( operatorId,
                                                                         isNegated ) );
    }

    public String[] getEvaluatorIds() {
        return SUPPORTED_IDS;
    }

    public boolean isNegatable() {
        return true;
    }

    public Target getTarget() {
        return Target.FACT;
    }

    public boolean supportsType(ValueType type) {
        return this.evaluators.supportsType( type );
    }

    /*  *********************************************************
     *           Evaluator Implementations
     *  *********************************************************
     */
    public static class IsAdjacentToEvaluator extends BaseEvaluator {
        private static final long     serialVersionUID  = 500L;

        public final static Evaluator POSITIVE_INSTANCE = new IsAdjacentToEvaluator( IS_ADJACENT_TO );
        public final static Evaluator NEGATIVE_INSTANCE = new IsAdjacentToEvaluator( IS_NOT_ADJACENT_TO );

        private boolean               negated;

        public IsAdjacentToEvaluator(Operator operator) {
            super( ValueType.OBJECT_TYPE,
                   operator );
            this.negated = operator == IS_NOT_ADJACENT_TO;
        }

        public boolean evaluate(InternalWorkingMemory workingMemory,
                                final InternalReadAccessor extractor,
                                final Object object1,
                                final FieldValue object2) {
            // this is a beta operator, so no alpha calls supported
            throw new UnsupportedOperationException( getOperator() + " only supports beta constraints." );
        }

        public boolean evaluateCachedRight(InternalWorkingMemory workingMemory,
                                           final VariableContextEntry context,
                                           final Object left) {
            final Region toRegion = (Region) ((ObjectVariableContextEntry) context).right;
            final Region fromRegion = (Region) context.declaration.getExtractor().getValue( workingMemory,
                                                                                      left );
            if ( toRegion == null || fromRegion == null ) {
                return false;
            }

            return this.negated ^ toRegion.isAdjacentTo( fromRegion );
        }

        public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory,
                                          final VariableContextEntry context,
                                          final Object right) {
            final Region toRegion = (Region) context.extractor.getValue( workingMemory,
                                                                   right );
            final Region fromRegion = (Region) ((ObjectVariableContextEntry) context).left;

            if ( toRegion == null || fromRegion == null ) {
                return false;
            }
            return this.negated ^ toRegion.isAdjacentTo( fromRegion );
        }

        public boolean evaluate(InternalWorkingMemory workingMemory,
                                final InternalReadAccessor extractor1,
                                final Object object1,
                                final InternalReadAccessor extractor2,
                                final Object object2) {
            final Region toRegion = (Region) extractor1.getValue( workingMemory,
                                                            object1 );
            final Region fromRegion = (Region) extractor2.getValue( workingMemory,
                                                              object2 );

            if ( toRegion == null || fromRegion == null ) {
                return false;
            }
            return this.negated ^ toRegion.isAdjacentTo( fromRegion );
        }

        public String toString() {
            return getOperator().toString();
        }
    }
}
