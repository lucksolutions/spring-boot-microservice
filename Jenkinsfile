pipeline {
  agent any
  tools {
    docker('latest')
  }
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
      steps {
        // environment { 
        //   DOCKER_REGISTRY = credentials('docker-registry') 
        // }
        sh 'docker build'
        //sh 'docker login -u $DOCKER_REGISTRY_USR -p $DOCKER_REGISTRY_PSW'
        sh 'docker push'
      }
    }
  }
}