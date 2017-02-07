package expression;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dave on 06/02/17.
 */
public class ExpressionTest {

    private MyEvaluator myEvaluator = new MyEvaluator();

    private String expression = "3*x+2";
    private String expression2 = "3*x+2/x";

    @Test
    public void testEvaluator() throws Exception {
        Function <Double,Double> function = myEvaluator.getFunction(expression);
        Function <Double,Double> testFunction = x->3*x+2;
        List<Double> testPoints = IntStream.rangeClosed(0,100).asDoubleStream().map((i)-> i/100.).boxed().collect(Collectors.toList());
        testPoints.stream().allMatch(point->testFunction.apply(point).equals(function.apply(point)));
    }

    @Test
    public void testEvaluator2() throws Exception {
        Function <Double,Double> function = myEvaluator.getFunction(expression2);
        Function <Double,Double> testFunction = x->3*x+2./x;
        List<Double> testPoints = IntStream.rangeClosed(0,100).asDoubleStream().map((i)-> i/100.).boxed().collect(Collectors.toList());
        testPoints.stream().allMatch(point->testFunction.apply(point).equals(function.apply(point)));
    }
}
