package com.github.robfletcher.compass

import spock.lang.Ignore

class CompassDependencySpec extends CompassPluginSpec {

  @Ignore("compass version is probably more recent than expected")
  def "by default uses latest compass version"() {
    when:
    runTasks "compassVersion"

    then:
    standardOutput.readLines().contains "Compass 1.0.1 (Polaris)"
  }

  def "can specify compass version"() {
    given:
    buildFile << """
      dependencies {
        compass "rubygems:compass:$version"
      }
    """

    when:
    runTasks "compassVersion"

    then:
    standardOutput.readLines().contains "Compass 0.12.6 (Alnilam)"

    where:
    version = "0.12.6"
  }

}
