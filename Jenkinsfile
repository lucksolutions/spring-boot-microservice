pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/lucksolutions/spring-boot-microservice', branch: 'master', changelog: true, poll: true)
      }
    }
    stage('Compile') {
      steps {
        sh './gradlew assemble'
      }
    }
    stage('Unit Test') {
      steps {
        sh './gradlew test'
        junit(testResults: 'build/reports/tests', allowEmptyResults: true)
      }
    }
  }
}