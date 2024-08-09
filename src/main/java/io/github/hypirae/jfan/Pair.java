package io.github.hypirae.jfan;

import java.io.Serializable;

public record Pair<X, Y>(X x, Y y) implements Serializable {}
