package org.jenkinsci.plugins.codescene.Domain;

import java.net.URL;

public class Configuration {

    private final URL url;
    private final CodeSceneUser user;
    private final Repository repo;
    private final int couplingThresholdPercent;
    private final boolean useBiomarkers;
    private final boolean letBuildPassOnFailedAnalysis;
    private final boolean failOnFailedGoal;
    private final boolean failOnDecliningCodeHealth;

    public Configuration(final URL codeSceneUrl, final CodeSceneUser user, final Repository gitRepositoryToAnalyze,
                         int couplingThresholdPercent, boolean useBiomarkers,
                         boolean letBuildPassOnFailedAnalysis,
                         boolean failOnFailedGoal,
                         boolean failOnDecliningCodeHealth) {
        this.url = codeSceneUrl;
        this.user = user;
        this.repo = gitRepositoryToAnalyze;
        this.couplingThresholdPercent = couplingThresholdPercent;
        this.useBiomarkers = useBiomarkers;
        this.letBuildPassOnFailedAnalysis = letBuildPassOnFailedAnalysis;
        this.failOnFailedGoal = failOnFailedGoal;
        this.failOnDecliningCodeHealth = failOnDecliningCodeHealth;
    }

    public URL codeSceneUrl() {
        return url;
    }

    public CodeSceneUser user() {
        return user;
    }

    public Repository gitRepositoryToAnalyze() {
        return repo;
    }

    public int couplingThresholdPercent() {
        return couplingThresholdPercent;
    }

    public boolean useBiomarkers() {
        return useBiomarkers;
    }

    public boolean letBuildPassOnFailedAnalysis() { return letBuildPassOnFailedAnalysis; }

    public boolean failOnFailedGoal() { return failOnFailedGoal; }

    public boolean failOnDecliningCodeHealth() { return failOnDecliningCodeHealth; }
}
