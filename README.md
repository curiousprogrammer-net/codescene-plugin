# codescene-jenkins-plugin

[![Build Status](https://travis-ci.org/empear-analytics/codescene-jenkins-plugin.svg)](https://travis-ci.org/empear-analytics/codescene-jenkins-plugin)
[![Latest release](https://img.shields.io/github/release/empear-analytics/codescene-jenkins-plugin.svg)](https://github.com/empear-analytics/codescene-jenkins-plugin/releases/latest)

A jenkins plugin for
[CodeScene](http://www.empear.com/products/codescene-on-premise/) by Empear.


CodeScene detects potential maintenance problems and early warnings in your
codebase. The earlier you can react to those findings, the better. That’s why
CodeScene offers integration points that let you incorporate the analysis
results into your build pipeline.

This plugin lets you use CodeScene’s Delta Analysis to catch potential problems
before they are delivered to your main branch.

![Screenshot](screenshot.png)

In addition to the risk classification, CodeScene also runs its set of early warning analyses:

![EarlyWarning](earlywarning.png)

The early warnings and risk classification let you prioritize your code reviews and
focus your time where (and when) it’s likely to be needed the most.
Code reviewer fatigue is a real thing, so let’s use our review efforts wisely.

## Installation

This plugin can be downloaded as an `.hpi` file from one the [published
releases](https://github.com/empear-analytics/codescene-jenkins-plugin/releases). Then,
in the Jenkins configuration UI for plugins, upload the `.hpi` file to install
it.

### Configure Jenkins for CodeScene

Enable the CodeScene integration by adding a new build step in your Jenkins configuration. Select the option *Run CodeScene Delta Analysis*.

![Add Buildstep](add-buildstep.png)

Enter the required information in the CodeScene Jenkins configuration:

![Buildstep](buildstep.png)

CodeScene gives you a number of options that controls the scope of the delta analysis:

* *Individual Commits*: Check this option to run a delta analysis on each individual commit. When in doubt, make this your default setting.
* *By Branch*: With this option, CodeScene runs a delta analysis on the difference between the branch you build and the one you provide as reference. Use this option if you want to analyse a whole pull request.

You can also change the defaults for risk threshold and temporal coupling threshold

* *Risk Threshold*: commits with risk equal or higher than this value will make a build unstable
* *Temporal Coupling Threshold*: minimum temporal coupling for "Absence of Expected Change Pattern" warning

The CodeScene API configuration section has to match the information specified inside CodeScene itself and retrievable from the analysis configuration.

API Credentials should be added via [jenkins credentials plugin](https://wiki.jenkins-ci.org/display/JENKINS/Credentials+Plugin).
Check [Injecting Secrets into Jenkins Build Jobs](https://support.cloudbees.com/hc/en-us/articles/203802500-Injecting-Secrets-into-Jenkins-Build-Jobs) for more details.

## Changelog

* 1.1.0
  - Use [credentials plugin](https://wiki.jenkins-ci.org/display/JENKINS/Credentials+Plugin)
    for storing CodeScene API credentials instead of hardcoded username and password.
    Existing jobs will continue to work, but you won't be able to update job configuration
    (e.g. change username or password) until you switch to the credentials plugin.
    Check [Injecting Secrets into Jenkins Build Jobs](https://support.cloudbees.com/hc/en-us/articles/203802500-Injecting-Secrets-into-Jenkins-Build-Jobs)
    for more details.
  - Only required parameters are now set in constructor.
    Optional parameters are set with setters.
    Check https://github.com/jenkinsci/pipeline-plugin/blob/c84a9af/DEVGUIDE.md#constructor-vs-setters.
    **Original constructor has been removed**!
  - Specify mnemonic extension name "codescene" via `@Symbol` in `CodeSceneBuilder`.
    Check https://github.com/jenkinsci/pipeline-plugin/blob/c84a9af/DEVGUIDE.md#defining-symbols
    and https://wiki.jenkins-ci.org/display/JENKINS/Structs+plugin for more details.



* 1.0.1
  - Add checksums to built artifacts in GitHub releases
* 1.0.0
  - Delta analysis by branch, based on _base revision_
  - Delta analysis by individual commits (new commits not seen in previous jobs)
  - "Mark build as unstable" based on risk threshold

## Contributing

You're encouraged to submit [pull
requests](https://github.com/empear-analytics/codescene-jenkins-plugin/pulls),
and to [propose features and discuss
issues](https://github.com/empear-analytics/codescene-jenkins-plugin/issues).

## License

Licensed under the [MIT License](LICENSE).
