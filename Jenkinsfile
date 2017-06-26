pipeline {
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/lucksolutions/spring-boot-microservice', branch: 'master', changelog: true, poll: true)
      }
    }
  }
}