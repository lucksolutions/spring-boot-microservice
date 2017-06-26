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
        sh './gradlew clean assemble'
      }
    }
    stage('Unit Test') {
      steps {
        sh './gradlew test'
        junit(testResults: '**/build/test-results/test/TEST-*.xml', allowEmptyResults: true)
      }
    }
    stage('Build Docker Image') {
      def dockImg = docker.build('lucksolutions/spring-boot-microservice:${env.BUILD_TAG}')
      steps {
        dockImg.push()
      }
    }
    stage('Deploy and Test Image') {
      steps {
        echo 'TODO: Run functional tests'
      }
    }
    stage('Approve Docker Image') {
      steps {
        dockImg.push 'latest'
      }
    }
  }
}