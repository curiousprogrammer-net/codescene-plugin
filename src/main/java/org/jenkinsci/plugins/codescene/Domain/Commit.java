package org.jenkinsci.plugins.codescene.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commit {
    private final String v;

    private final static Pattern hashPattern = Pattern.compile("[0-9a-f]+");

    public Commit(final String hash) {
        if (hash == null) {
            throw new IllegalArgumentException("A commit hash cannot be null!");
        }

        final Matcher m = hashPattern.matcher(hash);

        if (!m.matches()) {
            throw new IllegalArgumentException("The given commit '" + hash + "' does not represent a valid Git hash.");
        }

        v = hash;
    }

    public String value() {
        return v;
    }

    @Override
    public String toString() {
        return v;
    }
}
