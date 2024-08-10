package io.github.hypirae.jfan;

import java.io.Serializable;

/**
 * A generic pair class that holds two values.
 *
 * @param <X> the type of the first value
 * @param <Y> the type of the second value
 */
public record Pair<X, Y>(X x, Y y) implements Serializable {

}