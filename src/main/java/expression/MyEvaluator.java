package expression;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.util.function.Function;

/**
 * Created by dave on 06/02/17.
 */
public class MyEvaluator {
    public Function<Double, Double> getFunction(final String expression) {
            Evaluator evaluator = new Evaluator();
            String modifiedExpression = expression.replaceAll("x", "#{x}");
            return (Double x) -> {
                evaluator.putVariable("x", x.toString());
                try {
                    return Double.parseDouble(evaluator.evaluate(modifiedExpression));
                } catch (EvaluationException e) {
                    throw new RuntimeException(e);
                }
            };
    }
}
